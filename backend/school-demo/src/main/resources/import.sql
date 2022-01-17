-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into classroom(name, formteacher_id)
VALUES ('1AHIF', null);
insert into classroom(name, formteacher_id)
VALUES ('2AHIF', null);
insert into classroom(name, formteacher_id)
VALUES ('3AHIF', null);
insert into classroom(name, formteacher_id)
VALUES ('4AHIF', null);
insert into classroom(name, formteacher_id)
VALUES ('5AHIF', null);

insert into lesson(id, name)
VALUES (1, 'Mathematik');
insert into lesson(id, name)
VALUES (2, 'Deutsch');
insert into lesson(id, name)
VALUES (3, 'English');
insert into lesson(id, name)
VALUES (4, 'Programmieren');
insert into lesson(id, name)
VALUES (5, 'Datenbanken');

insert into classroomlesson(dayofweek, isheld, endtime, starttime, lesson_id, classroom_id, teacher_id)
values (1, true, '08:00', '08:50', 1, 1, null);
insert into classroomlesson(dayofweek, isheld, endtime, starttime, lesson_id, classroom_id, teacher_id)
values (1, true, '08:55', '09:45', 2, 1, null);
insert into classroomlesson(dayofweek, isheld, endtime, starttime, lesson_id, classroom_id, teacher_id)
values (1, true, '10:00', '10:50', 3, 1, null);
insert into classroomlesson(dayofweek, isheld, endtime, starttime, lesson_id, classroom_id, teacher_id)
values (1, true, '10:55', '11:45', 4, 1, null);
insert into classroomlesson(dayofweek, isheld, endtime, starttime, lesson_id, classroom_id, teacher_id)
values (1, true, '11:45', '12:35', 4, 1, null);