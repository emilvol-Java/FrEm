--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
--insert into Member (id, fName, sName,  password, email, phone_number, startDate) values (0, 'John", "Smith','passwordet', 'john.smith@mailinator.com', '2125551212', "2017-01-01") 
insert into Member (id, fName,sName, PASSWORD, email, phone_number, STARTDATE) values (0, 'Darth', ' Vader', 'pw', 'darth@deathstar.com', '2125551212','1899-02-22')
insert into Member (id, fName,sName, PASSWORD, email, phone_number, STARTDATE) values (1, 'Emil', ' Voltaire', 'pw', 'emil@lexicon.com', '1112223334','1799-02-22') 
insert into Member (id, fName,sName, PASSWORD, email, phone_number, STARTDATE) values (2, 'Fredrik', ' Hansen', 'pw', 'fredrik@jedi.com', '323232','1399-02-22')

insert into Dog (id, dogname, breed, born, vaccinated, owner) values (0, 'Beni', 'Collie', '2007', true, 'darth@deathstar.com')
insert into Dog (id, dogname, breed, born, vaccinated, owner) values (1, 'Skallis', 'Dobberman', '2011', true, 'fredrik@jedi.com')
insert into Dog (id, dogname, breed, born, vaccinated, owner) values (2, 'Nicky', 'Softis', '2015', true, 'fredrik@jedi.com')

insert into Course (id, COURSENAME, coursePrice, MAXPARTICIPANTS, COURSEDESRCIPTION, STARTDATE, ENDDATE, PARTICIPANTS) values (0, 'Valpkurs', 300, 10, 'Kul kurs', '2017-09-09', '2017-10-10',0)
insert into Course (id, COURSENAME, coursePrice, MAXPARTICIPANTS, COURSEDESRCIPTION, STARTDATE, ENDDATE, PARTICIPANTS) values (1, 'Lydnad 1', 500, 8, 'Läskig kurs', '2017-08-11', '2017-10-22',0); 
insert into Course (id, COURSENAME, coursePrice, MAXPARTICIPANTS, COURSEDESRCIPTION, STARTDATE, ENDDATE, PARTICIPANTS) values (2, 'Bita husse', 500, 3, 'Tuff kurs', '2017-01-11', '2017-01-22',0);
insert into Course (id, COURSENAME, coursePrice, MAXPARTICIPANTS, COURSEDESRCIPTION, STARTDATE, ENDDATE, PARTICIPANTS) values (3, 'Bita elaking', 500, 8, 'Riktigt farlig kurs', '2017-06-11', '2017-10-22',0); 

