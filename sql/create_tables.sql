-- drop table address_attribute;
-- drop table address;
-- drop table attribute;
-- drop table identities;
-- drop table attribute_type;

-- create table identities
CREATE TABLE identities
	(identity_id INT NOT NULL GENERATED ALWAYS AS IDENTITY
	CONSTRAINT IDENTITY_PK PRIMARY KEY, 
	display_name VARCHAR(255),
	email VARCHAR(255),
	password VARCHAR(255),
	birthday Date,
	isAdmin INT
	);
-- create table of identities attributes
create table attribute(
	identity_id int not null,
	name varchar(255) not null,
	value varchar(255) not null,
	constraint id_attribute_fk foreign key (identity_id) references identities(identity_id)
	);

-- Create table address
CREATE TABLE address
	(address_id INT NOT NULL GENERATED ALWAYS AS IDENTITY
	CONSTRAINT ADDRESS_PK PRIMARY KEY, 
	identity_id INT NOT NULL,
	street VARCHAR(255),
	city VARCHAR(255),
	zipCode VARCHAR(255),
	constraint IDENTITY_ADDRESS_FK foreign key (identity_id) 
	references identities(identity_id)
	);
	
-- create table of address attributes
create table address_attribute(
	address_id int not null,
	name varchar(255) not null,
	value varchar(255) not null,
	constraint ADDRESS_ID_FK foreign key (address_id) references address(address_id)
	);

	