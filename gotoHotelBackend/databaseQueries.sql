CREATE TABLE categoryDto(
category_id IDENTITY,
name VARCHAR(50),
pId INTEGER,
price VARCHAR(50),
active BOOLEAN

CONSTRAINT pk_categoryDto_category_id PRIMARY KEY (category_id)

);

CREATE TABLE ServicesDto(
category_id IDENTITY,
pId INTEGER,
price INTEGER,
location VARCHAR(100)
description VARCHAR(255),
active BOOLEAN

CONSTRAINT pk_ServicesDto_category_id PRIMARY KEY (category_id)

);