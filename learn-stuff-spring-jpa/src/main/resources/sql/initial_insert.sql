INSERT INTO sbs_groups (id, group_name) VALUES (nextval('sbs_groups_id_seq'), 'ROLE_ADMIN');
INSERT INTO sbs_groups (id, group_name) VALUES (nextval('sbs_groups_id_seq'), 'ROLE_USER');
INSERT INTO sbs_groups (id, group_name) VALUES (nextval('sbs_groups_id_seq'), 'ROLE_GUEST');

-- password is: 123123
INSERT INTO sbs_users (id, user_name, user_email, user_password, user_first_name, user_last_name, enabled, id_group) 
	VALUES (nextval('sbs_users_id_seq'), 'Vlad', 'vlad@sbs.com', '4297f44b13955235245b2497399d7a93', 'Vlad', 'Ungureanu', '1', '1');