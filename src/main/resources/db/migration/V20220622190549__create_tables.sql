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
    "gender"            VARCHAR(64),
    "birth_date"        DATE,
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
);

CREATE TABLE "events" (
	"id"            SERIAL NOT NULL,
	"name"          VARCHAR(64) NOT NULL UNIQUE,
	"description"   VARCHAR(2048) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE "races" (
	"id"            SERIAL NOT NULL,
	"event_id"      INTEGER NOT NULL,
	"date"          DATE NOT NULL,
	"distance"      INTEGER NOT NULL,
	"name"          VARCHAR(64) NOT NULL UNIQUE,
	"description"   VARCHAR(2048) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE "records" (
	"race_id"       INTEGER NOT NULL,
	"user_id"       INTEGER NOT NULL,
	"bib_number"    INTEGER NOT NULL UNIQUE, -- todo make it STRING. Unique?
	"start_time"    TIMESTAMP,
	"finish_time"   TIMESTAMP,
	PRIMARY KEY (race_id, user_id),
	FOREIGN KEY (race_id) REFERENCES races(id),
	FOREIGN KEY (user_id) REFERENCES users(id)
);