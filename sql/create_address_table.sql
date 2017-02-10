-- create schema ADMIN;

CREATE TABLE identities
	(identity_id INT NOT NULL GENERATED ALWAYS AS IDENTITY
	CONSTRAINT IDENTITY_PK PRIMARY KEY, 
	display_name VARCHAR(255),
	email VARCHAR(255),
	birthday Date
	);