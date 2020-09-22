SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS basic_charge;
DROP TABLE IF EXISTS benefits;
DROP TABLE IF EXISTS designs;
DROP TABLE IF EXISTS jewelries;
DROP TABLE IF EXISTS materials;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS quote_history;
DROP TABLE IF EXISTS stamps;
DROP TABLE IF EXISTS taxes;




/* Create Tables */

CREATE TABLE basic_charge
(
	price int unsigned NOT NULL,
	description text NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100)
);


CREATE TABLE benefits
(
	cd varchar(50) NOT NULL,
	name varchar(100) NOT NULL,
	unit_price int unsigned NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (cd)
);


CREATE TABLE designs
(
	cd varchar(100) NOT NULL,
	name varchar(100) NOT NULL,
	unit_price int unsigned NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (cd)
);


CREATE TABLE jewelries
(
	cd varchar(50) NOT NULL,
	name varchar(100) NOT NULL,
	unit_price int unsigned NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (cd)
);


CREATE TABLE materials
(
	cd varchar(100) NOT NULL,
	name varchar(100) NOT NULL,
	unit_price int unsigned NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (cd)
);


CREATE TABLE options
(
	cd varchar(50) NOT NULL,
	name varchar(100) NOT NULL,
	unit_price int unsigned NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (cd)
);


CREATE TABLE quote_history
(
	quote_date date NOT NULL,
	history_number int unsigned NOT NULL,
	customer_name varchar(200) NOT NULL,
	quote_data text NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (quote_date, history_number)
);


CREATE TABLE stamps
(
	cd varchar(50) NOT NULL,
	name varchar(100) NOT NULL,
	unit_price int unsigned NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (cd)
);


CREATE TABLE taxes
(
	cd int unsigned NOT NULL,
	name varchar(100) NOT NULL,
	tax_rate float unsigned NOT NULL,
	start_date date NOT NULL,
	end_date date NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (cd)
);



