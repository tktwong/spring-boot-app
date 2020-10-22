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
INSERT INTO book (id, title, author) VALUES (100, 'Uma Breve História do Tempo', 'Stephen Hawking');
INSERT INTO book (id, title, author) VALUES (101, 'Uma Comovente Obra de Espantoso Talento', 'Dave Eggers');
INSERT INTO book (id, title, author) VALUES (102, 'Muito Longe de Casa', 'Ishmael Beah');
INSERT INTO book (id, title, author) VALUES (103, 'Uma Dobra no Tempo', 'Madeleine L’Engle');
INSERT INTO book (id, title, author) VALUES (104, 'Selected Stories, 1968-1994', 'Alice Munro');
INSERT INTO book (id, title, author) VALUES (105, 'Abundância - o Futuro É Melhor do Que Você Imagina ', 'Kotler,Steven / Diamandis,Peter H.');

INSERT INTO HOUSE (ID) VALUES (1);
INSERT INTO DOOR (ID, HOUSE_ID) VALUES (1, 1);
INSERT INTO DOOR (ID, HOUSE_ID) VALUES (2, 1);
INSERT INTO DOOR (ID, HOUSE_ID) VALUES (3, 1);
INSERT INTO ROOM (ID, ROOM_NUM, HOUSE_ID) VALUES (1, 101, 1);
INSERT INTO ROOM (ID, ROOM_NUM, HOUSE_ID) VALUES (2, 102, 1);
INSERT INTO ROOM (ID, ROOM_NUM, HOUSE_ID) VALUES (3, 103, 1);

-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM BOOK;