--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // First migration.
-- Migration SQL that makes the change goes here.
CREATE TABLE BOOK (
	id NUMBER(19,0),
	title VARCHAR(64) NOT NULL,
	author VARCHAR(64) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE HOUSE (
    ID NUMBER(19,0),
    PRIMARY KEY (ID)
);

CREATE TABLE DOOR (
    ID NUMBER(19,0),
    HOUSE_ID NUMBER(19,0),
    FOREIGN KEY (HOUSE_ID) REFERENCES HOUSE(ID),
    PRIMARY KEY (ID)
);

CREATE TABLE ROOM (
    ID NUMBER(19,0),
    ROOM_NUM NUMBER(5,0),
    HOUSE_ID NUMBER(19,0),
    FOREIGN KEY (HOUSE_ID) REFERENCES HOUSE(ID),
    PRIMARY KEY (ID)
);

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE ROOM;
DROP TABLE DOOR;
DROP TABLE HOUSE;
DROP TABLE BOOK;
