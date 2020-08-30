SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;




/* Create Tables */

CREATE TABLE roles
(
	cd varchar(20) NOT NULL,
	name varchar(100) NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (cd)
);


CREATE TABLE users
(
	id varchar(100) NOT NULL,
	name varchar(100) NOT NULL,
	role_cd varchar(20) NOT NULL,
	created_at datetime NOT NULL,
	createt_user varchar(100) NOT NULL,
	updated_at datetime,
	updated_user varchar(100),
	deleted_at datetime,
	deleted_user varchar(100),
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE users
	ADD FOREIGN KEY (role_cd)
	REFERENCES roles (cd)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



