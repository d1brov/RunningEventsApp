-- creating permissions
INSERT INTO permissions (name) VALUES ('PERMISSION_ADMIN');
INSERT INTO permissions (name) VALUES ('PERMISSION_EVENT_ADMIN');
INSERT INTO permissions (name) VALUES ('PERMISSION_USER');

-- creating roles
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('EVENT_ADMIN');
INSERT INTO roles (name) VALUES ('USER');

-- setting permissions for roles
INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 1);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 2);
INSERT INTO roles_permissions (role_id, permission_id) VALUES (3, 3);

--------------- creating users ---------------
--admin
INSERT INTO user_credentials (username, password, is_email_confirmed) VALUES ('admin@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', TRUE);
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (1, 1);
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (1, 2);
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (1, 3);
INSERT INTO users (credentials_id, first_name, last_name, email, phone, emergency_phone) VALUES (1, 'Admin', 'Adminovych', 'admin@mail.com', '380000000000', '380000000001');


--INSERT INTO users (first_name, last_name, email, phone, emergency_phone) VALUES ('Leonid', 'Kadenyuk', 'user@mail.com', '380000000006', '380000000008');
--INSERT INTO user_credentials (user_id, username, password, is_enabled, is_email_confirmed) VALUES (2, 'user@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', FALSE, TRUE);
--INSERT INTO user_credentials_roles (username, role_id) VALUES ('user@mail.com', 3);