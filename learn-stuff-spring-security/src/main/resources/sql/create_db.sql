-- Artists DDL
-- Testesd on PostgreSQL 9.3 and 11
DROP TABLE IF EXISTS lsa_users_authority;
DROP TABLE IF EXISTS lsa_users;
DROP TABLE IF EXISTS lsa_authority;

CREATE TABLE lsa_users (
id SERIAL UNIQUE NOT NULL,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(50) UNIQUE,
  password VARCHAR(500),
  fullname VARCHAR(100),
  accept_terms boolean DEFAULT false,
  activated boolean DEFAULT true,
  PRIMARY KEY(id)
);

CREATE TABLE lsa_authority (
id SERIAL UNIQUE NOT NULL,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE lsa_users_authority (
  user_id INTEGER NOT NULL  REFERENCES lsa_users (id) ON DELETE CASCADE,
  authority_id INTEGER NOT NULL REFERENCES lsa_authority (id)  ON DELETE CASCADE
);

INSERT INTO lsa_authority (id,name) VALUES (nextval('lsa_authority_id_seq'), 'USER');
INSERT INTO lsa_authority (id,name) VALUES (nextval('lsa_authority_id_seq'), 'ADMIN');
INSERT INTO lsa_authority (id,name) VALUES (nextval('lsa_authority_id_seq'), 'GUEST');

INSERT INTO lsa_users (id,username, fullname, email, password, activated) VALUES (nextval('lsa_users_id_seq'),'vlad', 'Vlad Ungureanu' ,'vlad@yahoo.com', '$2a$10$WdkNALRQs5IRIZSteVmt6uqeCJlcffgKFf9gYD.Xo54WfH.dJ3Fq6', true);
INSERT INTO lsa_users_authority (user_id,authority_id) VALUES ((select id from lsa_users where username like 'vlad'), (select id from lsa_authority where name like 'ADMIN'));


