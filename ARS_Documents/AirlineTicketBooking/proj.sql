create sequence Booking_Id_Seq1 start with 1 increment by 1;
Select Booking_Id_Seq1.NEXTVAL from dual;
INSERT INTO bookingInformation VALUES (1,'sdsa',3,'business',3000,11,'a232','pune','delhi');
desc bookingInformation;
select * from bookingInformation;
DELETE FROM bookingInformation WHERE booking_id='ARS2';
select * from users;
insert into users values('executive','executive','executive','9980765432');
insert into users values('admin','admin','admin','8898840172');
insert into users values('user1','user1','user','7797750324');

SELECT  booking_id, cust_email,no_of_passenger, class_type,  total_fare,seat_numbers, creditcard_info,  src_city,dest_city FROM bookingInformation WHERE booking_id='ARS3';

SELECT  booking_id, cust_email,no_of_passengers, class_type,  total_fare,seat_numbers, creditcard_info,  src_city,dest_city FROM bookingInformation WHERE booking_id='ARS3';

select * from users;

select * from FLIGHT_INFORMATION;

select * from BOOKINGINFORMATION;

Select Booking_Id_Seq1.NEXTVAL from dual;

ALTER TABLE users ADD MOBILE_NO varchar2(10);

ALTER TABLE users ADD FIRSTNAME varchar2(20);

ALTER TABLE users ADD LASTNAME varchar2(20);

ALTER TABLE users RENAME COLUMN USERFNAME TO ROLE;

ALTER TABLE users DROP COLUMN LASTNAME;

alter table bookingInformation add flightno references FLIGHT_INFORMATION(flightno);

alter table FLIGHT_INFORMATION add primary key(flightno);

select flightno from flight_information where dep_city='Mumbai' and arr_city='Guwahati';

INSERT INTO USERS VALUES ('ptatz','awr','user','9807678964');

Select * from FLIGHT_INFORMATION;

SELECT BUSSSEATSFARE FROM flight_information where flightno='A102';

SELECT FLIGHTNO,AIRLINE,DEP_DATE,ARR_DATE,DEP_TIME,ARR_TIME,FIRSTSEATS,FIRSTSEATFARE,BUSSSEATS,BUSSSEATSFARE FROM FLIGHT_INFORMATION WHERE DEP_CITY='Goa' AND ARR_CITY='Pune';

DELETE FROM FLIGHT_INFORMATION WHERE flightno='A104';

SELECT flightno,booking_id , cust_email,no_of_passengers, class_type FROM bookingInformation WHERE flightno='A104';