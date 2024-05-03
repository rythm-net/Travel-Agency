create schema travel_agency

create table if not exists travel_agency.locations(
	id SERIAL,
	country varchar(255) ,
	city varchar(255),
	street varchar(255),
	imageUrl varchar(255),
	number integer,
	constraint locations_pkey PRIMARY KEY (id)
);
create table if not exists travel_agency.holidays(
	id SERIAL,
	title varchar(255) UNIQUE,
	duration integer ,
	free_slots integer ,
	price double ,
	location_id integer ,
	start_date DATE ,
	constraint transmissions_pkey PRIMARY KEY (id),
	constraint fk_holidays_location_id FOREIGN KEY (location_id)
    REFERENCES travel_agency.locations (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
create table if not exists travel_agency.reservations(
	id SERIAL,
	phoneNumber varchar(255) UNIQUE,
	contactNumber varchar(255) UNIQUE,
	holiday_id integer ,
	constraint fuel_types_pkey PRIMARY KEY (id),
	constraint fk_reservations_holiday_id FOREIGN KEY (holiday_id)
    REFERENCES travel_agency.holidays (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);