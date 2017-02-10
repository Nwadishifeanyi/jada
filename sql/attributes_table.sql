
-- Create a table to store predefined types of an attribute

create table attribute_type(
	id int not null generated always as identity
	constraint attribute_pk primary key,
	a_type varchar(50) not null
);
insert into attribute_type(a_type)
	values ('interger'),
	('Decimal'), 
	('Boolean'), 
	('Text');
	

-- create a table holding
-- a  relationship between an identity and its attributes

--drop table  attribute;
create table attribute(
	identity_id int not null,
	name varchar(255) not null,
	value varchar(255) not null,
	constraint id_attribute_fk foreign key (identity_id) references identities(identity_id)
);

