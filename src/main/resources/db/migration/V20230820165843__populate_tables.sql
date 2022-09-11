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
-- creating admin
INSERT INTO user_credentials (username, password, is_email_confirmed) VALUES ('admin@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', TRUE);
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (1, 1); -- add role ADMIN
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (1, 2); -- add role EVENT_ADMIN
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (1, 3); -- add role USER
INSERT INTO users (credentials_id, first_name, last_name, gender, birth_date, email, phone, emergency_phone) VALUES (1, 'Admin', 'Adminovych', 'FEMALE', '1989-09-01', 'admin@mail.com', '380000000000', '380000000003');

-- creating event admin
INSERT INTO user_credentials (username, password, is_email_confirmed) VALUES ('event_admin@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', TRUE);
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (2, 2); -- add role EVENT_ADMIN
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (2, 3); -- add role USER
INSERT INTO users (credentials_id, first_name, last_name, gender, birth_date, email, phone, emergency_phone) VALUES (2, 'Event', 'Admin', 'MALE', '1991-04-01', 'event_admin@mail.com', '380000000001', '380000000005');

-- creating user
INSERT INTO user_credentials (username, password, is_email_confirmed) VALUES ('user@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', TRUE);
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (3, 3); -- add role USER
INSERT INTO users (credentials_id, first_name, last_name, gender, birth_date, email, phone, emergency_phone) VALUES (3, 'Regular', 'User', 'MALE', '1996-12-01', 'user@mail.com', '380000000002', '380000000000');

-- creating uncompleted user
INSERT INTO user_credentials (username, password, is_email_confirmed) VALUES ('incompleted.user@mail.com', '$2a$10$uuo1DSvWHz87Ai2yWrpGI.UFFpvNIXCYrkzI9kwNQ5Le7d9S1hC/O', FALSE);
INSERT INTO user_credentials_roles (user_credential_id, role_id) VALUES (4, 3); -- add role USER
INSERT INTO users (credentials_id, email) VALUES (4, 'incompleted.user@mail.com');


--------------- creating events ---------------
INSERT INTO events (name, description) VALUES ('Fall Marathon 2022', 'Description: classic fall marathon');
INSERT INTO races (event_id, distance, name, description, "date") VALUES (1, 10000, '10k', 'Easy 10k', '2022-10-01');
INSERT INTO races (event_id, distance, name, description, "date") VALUES (1, 21087 ,'HALF MARATHON', 'Solid Half 21k', '2022-10-01');
INSERT INTO races (event_id, distance, name, description, "date") VALUES (1, 40195 ,'MARATHON', 'Classic marathon distance', '2022-10-01');

INSERT INTO events (name, description) VALUES ('ULTRA 2023', 'Description: annual ultra');
INSERT INTO races (event_id, distance, name, description, "date") VALUES (2, 50000, 'MEGA 50k', '50k for ultra running novice', '2023-07-01');
INSERT INTO races (event_id, distance, name, description, "date") VALUES (2, 100000, 'ULTRA 100k', '100k for pros', '2023-07-01');


--------------- signing up users for events ---------------
INSERT INTO records (race_id, user_id, bib_number) VALUES(3, 1, 42001); -- admin for marathon
INSERT INTO records (race_id, user_id, bib_number) VALUES(2, 2, 21001); -- event admin for 21k
INSERT INTO records (race_id, user_id, bib_number) VALUES(1, 3, 10001); -- user for 10k

INSERT INTO records (race_id, user_id, bib_number) VALUES(5, 1, 100001); -- admin for ultra
INSERT INTO records (race_id, user_id, bib_number) VALUES(4, 2, 500001); -- event admin for 50k
INSERT INTO records (race_id, user_id, bib_number) VALUES(4, 3, 500002); -- user for 50k