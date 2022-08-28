-- creating permissions
--INSERT INTO permissions (name) VALUES ('PERMISSION_ADMIN');
--INSERT INTO permissions (name) VALUES ('PERMISSION_EVENT_ADMIN');
--INSERT INTO permissions (name) VALUES ('PERMISSION_USER');

-- creating roles
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('EVENT_ADMIN');
INSERT INTO roles (name) VALUES ('USER');

-- setting permissions for roles
--INSERT INTO roles_permissions (role_id, permission_id) VALUES (1, 1);
--INSERT INTO roles_permissions (role_id, permission_id) VALUES (2, 2);
--INSERT INTO roles_permissions (role_id, permission_id) VALUES (3, 3);

--------------- creating users ---------------
--admin
INSERT INTO users (first_name, last_name, email, phone, emergency_phone) VALUES ('Admin', 'Adminovych', 'admin@mail.com', '380000000000', '380000000001');
INSERT INTO user_credentials (user_id, username, password, is_enabled, is_email_confirmed) VALUES (1, 'admin@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', TRUE, TRUE);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (1, 3);

--coach
INSERT INTO users (first_name, last_name, email, phone, emergency_phone) VALUES ('Eliud', 'Kipchoge', 'mod@mail.com', '380000000001', '380000000000');
INSERT INTO user_credentials (user_id, username, password, is_enabled, is_email_confirmed) VALUES (2, 'mod@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', TRUE, TRUE);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (2, 2);

--users
INSERT INTO users (first_name, last_name, email, phone, emergency_phone) VALUES ('Leonid', 'Kadenyuk', 'user@mail.com', '380000000006', '380000000008');
INSERT INTO user_credentials (user_id, username, password, is_enabled, is_email_confirmed) VALUES (3, 'user@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', FALSE, TRUE);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (3, 3);

INSERT INTO users (first_name, last_name, email, phone, emergency_phone) VALUES ('Mykola', 'Khvulovyi', 'khvulovyi@mail.com', '380000000002', '380000000004');
INSERT INTO user_credentials (user_id, username, password, is_enabled, is_email_confirmed) VALUES (4, 'khvulovyi@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', TRUE, TRUE);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (4, 3);

INSERT INTO users (first_name, last_name, email, phone, emergency_phone) VALUES ('Ostap', 'Vyshnia', 'vyshnia@mail.com', '380000000003', '380000000002');
INSERT INTO user_credentials (user_id, username, password, is_enabled, is_email_confirmed) VALUES (5, 'vyshnia@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', FALSE, FALSE);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (5, 3);

INSERT INTO users (first_name, last_name, email, phone, emergency_phone) VALUES ('Ivan', 'Bahrianyu', 'bahrianyu@mail.com', '380000000004', '380000000004');
INSERT INTO user_credentials (user_id, username, password, is_enabled, is_email_confirmed) VALUES (6, 'bahrianyu@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', TRUE, TRUE);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (6, 3);

INSERT INTO users (first_name, last_name, email, phone, emergency_phone) VALUES ('Igor', 'Sikorsky', 'sikorsky@mail.com', '380000000005', '380000000007');
INSERT INTO user_credentials (user_id, username, password, is_enabled, is_email_confirmed) VALUES (7, 'sikorsky@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', TRUE, TRUE);
INSERT INTO user_credentials_roles (user_id, role_id) VALUES (7, 3);