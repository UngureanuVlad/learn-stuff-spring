-- Artists DDL
-- Testesd on PostgreSQL 9.3 and 11
DROP TABLE IF EXISTS sbs_artist_genders;
DROP TABLE IF EXISTS sbs_albums;
DROP TABLE IF EXISTS sbs_genders;
DROP TABLE IF EXISTS sbs_artists;

DROP TABLE IF EXISTS sbs_users;
DROP TABLE IF EXISTS sbs_groups;

-- Lasteste change: added details column to "sbs_artists"
CREATE TABLE sbs_artists(
	id SERIAL UNIQUE NOT NULL,
	name VARCHAR(200),
	origin VARCHAR(200),
	details TEXT,
	launch_date DATE,
	PRIMARY KEY(id)
);

CREATE TABLE sbs_genders(
	id SERIAL UNIQUE NOT NULL,
	name VARCHAR(200),
	description TEXT,
	artist_origin VARCHAR(200),
	cultural_origin VARCHAR(200),
	first_appeared_in DATE,
	PRIMARY KEY(id)
);

CREATE TABLE sbs_albums(
	id SERIAL UNIQUE NOT NULL,
	title VARCHAR(200),
	details TEXT,
	release_date DATE,
	id_artist INTEGER REFERENCES sbs_artists(id) ON DELETE CASCADE,
	PRIMARY KEY(id)
);

CREATE TABLE sbs_artist_genders(
	id SERIAL UNIQUE NOT NULL,
	id_artist INTEGER REFERENCES sbs_artists(id) ON DELETE CASCADE,
	id_gender INTEGER REFERENCES sbs_genders(id) ON DELETE CASCADE,
	PRIMARY KEY(id)
);

-- User tables for Spring Security
CREATE TABLE IF NOT EXISTS sbs_groups (
  id SERIAL UNIQUE NOT NULL,
  group_name VARCHAR(100),
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS sbs_users (
  id SERIAL UNIQUE NOT NULL,
  user_name VARCHAR(100),
  user_email VARCHAR(100) UNIQUE,
  user_password VARCHAR(70),
  user_first_name VARCHAR(100),
  user_last_name VARCHAR(100),
  enabled BOOLEAN DEFAULT true,
  id_group INTEGER REFERENCES sbs_groups(id),
  PRIMARY KEY(id)
);

