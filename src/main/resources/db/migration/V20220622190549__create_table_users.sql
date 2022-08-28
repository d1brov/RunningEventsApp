CREATE TABLE "users"
(
    "id"                SERIAL,
    "first_name"        VARCHAR(64)   NOT NULL,
    "last_name"         VARCHAR(64)   NOT NULL,
    "email"             VARCHAR(64)   NOT NULL  UNIQUE,
    "phone"             VARCHAR(64)   NOT NULL  UNIQUE,
    "emergency_phone"   VARCHAR(64)   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE "user_credentials"
(
    "user_id"            INTEGER UNIQUE,
    "username"           VARCHAR(64) NOT NULL UNIQUE,
    "password"           VARCHAR(1024) NOT NULL,
    "is_enabled"         BOOLEAN NOT NULL,
    "is_email_confirmed" BOOLEAN NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES users(id)
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
    "user_id"   INTEGER NOT NULL,
    "role_id"   INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user_credentials(user_id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
)