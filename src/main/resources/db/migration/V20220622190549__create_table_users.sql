CREATE TABLE "user_credentials"
(
    "id"                 SERIAL,
    "username"           VARCHAR(64) NOT NULL UNIQUE,
    "password"           VARCHAR(1024) NOT NULL,
    "is_email_confirmed" BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE "users"
(
    "id"                SERIAL,
    "first_name"        VARCHAR(64),
    "last_name"         VARCHAR(64),
    "email"             VARCHAR(64) NOT NULL UNIQUE,
    "phone"             VARCHAR(64) UNIQUE,
    "emergency_phone"   VARCHAR(64),
    "credentials_id"    INTEGER NOT NULL UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (credentials_id) REFERENCES user_credentials(id) ON DELETE CASCADE
);

CREATE TABLE "permissions"
(
    "id"       SERIAL,
    "name"     VARCHAR(64)   NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE "roles"
(
    "id"        SERIAL,
    "name"      VARCHAR(64)   NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE "roles_permissions"
(
    "role_id"        INTEGER,
    "permission_id"  INTEGER,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (permission_id) REFERENCES permissions(id)
);

CREATE TABLE "user_credentials_roles"
(
    "user_credential_id"  INTEGER NOT NULL,
    "role_id"   INTEGER NOT NULL,
    PRIMARY KEY (user_credential_id, role_id),
    FOREIGN KEY (user_credential_id) REFERENCES user_credentials(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
)