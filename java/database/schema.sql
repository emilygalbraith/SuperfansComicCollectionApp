BEGIN TRANSACTION;

DROP TABLE IF EXISTS collection_comic;
DROP TABLE IF EXISTS collections;
DROP TABLE IF EXISTS comic_superheroes;
DROP TABLE IF EXISTS superheroes;
DROP TABLE IF EXISTS comics;
DROP TABLE IF EXISTS series;
DROP TABLE IF EXISTS publishers;
DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS seq_collection_comic_id;
DROP SEQUENCE IF EXISTS seq_collection_id;
DROP SEQUENCE IF EXISTS seq_comic_superhero_id;
DROP SEQUENCE IF EXISTS seq_superhero_id;
DROP SEQUENCE IF EXISTS seq_comic_id;
DROP SEQUENCE IF EXISTS seq_series_id;
DROP SEQUENCE IF EXISTS seq_publisher_id;
DROP SEQUENCE IF EXISTS seq_profile_id;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_profile_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_publisher_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_series_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_comic_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_superhero_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1; 
  
CREATE SEQUENCE seq_comic_superhero_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1; 
  
CREATE SEQUENCE seq_collection_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_collection_comic_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('testuser', '$2a$10$cuH2NhJ2x13whb5Y8r906..VXdoTPx3DD7289ebHmdCWV.GoCXx/m', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('DCFan', '$2a$10$e7zXAvQiGGIdrBShgWPiF.VsMPjA7Z36dROyg8LROa2qzA2J74Xf.', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('ImageFan', '$2a$10$lg8quqOIdsVdvw/emYadquBB5xEwaFK0u1GBsLGqpjZsr.K.IciEe', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('SuperFan100', '$2a$10$DuTMy41jqY7RR.M2GoxRBuYxznMfcOs93Pk7m6gppyFBGpNZAr1VO', 'ROLE_USER');

CREATE TABLE profiles (
        profile_id int DEFAULT nextval('seq_profile_id'::regclass) NOT NULL,
        profile_img varchar(400) NOT NULL,
        profile_img_name varchar(100) NOT NULL,
        CONSTRAINT PK_profile PRIMARY KEY (profile_id)
);

CREATE TABLE user_profile (
        user_id int REFERENCES users (user_id),
        profile_id int REFERENCES profiles (profile_id),
        CONSTRAINT PK_user_profile PRIMARY KEY (user_id, profile_id)
);

CREATE TABLE publishers (
        publisher_id int DEFAULT nextval('seq_publisher_id'::regclass) NOT NULL,
        publisher_name varchar(50) NOT NULL,
        CONSTRAINT PK_publisher PRIMARY KEY (publisher_id)
);

CREATE TABLE series (
        series_id int DEFAULT nextval('seq_series_id'::regclass) NOT NULL,
        series_name varchar(50) NOT NULL,
        CONSTRAINT PK_series PRIMARY KEY(series_id)
);

CREATE TABLE comics (
        comic_id int DEFAULT nextval('seq_comic_id'::regclass) NOT NULL,
        comic_name varchar(50) NOT NULL,
        author varchar(100) NOT NULL,
        image varchar(400) NOT NULL,
        release_date date DEFAULT CURRENT_DATE,
        publisher_id int REFERENCES publishers (publisher_id),
        series_id int REFERENCES series (series_id),
        CONSTRAINT PK_comic PRIMARY KEY (comic_id)
);

CREATE TABLE superheroes (
        superhero_id int DEFAULT nextval('seq_superhero_id'::regclass) NOT NULL,
        superhero varchar(100) NOT NULL,
        CONSTRAINT PK_superhero PRIMARY KEY (superhero_id)
);

CREATE TABLE comic_superheroes ( 
        comic_superhero_id int DEFAULT nextval('seq_comic_superhero_id'::regclass) NOT NULL,
        comic_id int REFERENCES comics (comic_id),
        superhero_id int REFERENCES superheroes (superhero_id),
        CONSTRAINT PK_comic_superhero PRIMARY KEY (comic_superhero_id)
);

CREATE TABLE collections (
        collection_id int DEFAULT nextval('seq_collection_id'::regclass) NOT NULL,
        collection_name varchar(50) NOT NULL,
        private boolean NOT NULL,
        user_id int REFERENCES users (user_id),
        CONSTRAINT PK_collection PRIMARY KEY (collection_id)
);

CREATE TABLE collection_comic (
        collection_comic_id int DEFAULT nextval('seq_collection_comic_id'::regclass) NOT NULL,
        comic_id int REFERENCES comics (comic_id),
        collection_id int REFERENCES collections (collection_id),
        CONSTRAINT PK_colleciton_comic PRIMARY KEY (collection_comic_id)
);

COMMIT TRANSACTION;
