INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10001L , 'Math', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10002L , 'chemistry', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10003L , 'dummy1', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10004L , 'dummy2', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10005L , 'dummy3', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10006L , 'dummy4', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10007L , 'dummy5', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10008L , 'dummy6', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10009L , 'dummy7', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10010L , 'dummy8', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10011L , 'dummy9', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10012L , 'dummy10', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10013L , 'dummy11', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 
INSERT INTO COURSE( ID , NAME , created_date , last_updated_date ) VALUES ( 10014L , 'dummy12', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP()); 

INSERT INTO PASSPORT( ID , NUMBER ) VALUES (30001, 'AD12431');
INSERT INTO PASSPORT( ID , NUMBER ) VALUES (30002, 'DDJ1038');
INSERT INTO PASSPORT( ID , NUMBER ) VALUES (30003, 'P148JD8');
INSERT INTO PASSPORT( ID , NUMBER ) VALUES (30004, 'R0828NH');

INSERT INTO STUDENT( ID , NAME , PASSPORT_ID ) VALUES (20001, 'Ricardo',30001);
INSERT INTO STUDENT( ID , NAME , PASSPORT_ID ) VALUES (20002, 'Manuel',30002);
INSERT INTO STUDENT( ID , NAME , PASSPORT_ID ) VALUES (20003, 'Erick',30003);
INSERT INTO STUDENT( ID , NAME , PASSPORT_ID ) VALUES (20004, 'Kevin',30004);

INSERT INTO REVIEW( ID , RATING ,DESCRIPTION ,  COURSE_ID) VALUES( 40001, '1', 'BAD COURSE' ,10001L);
INSERT INTO REVIEW( ID , RATING ,DESCRIPTION ,  COURSE_ID) VALUES( 40002, '5', 'GREAT COURSE',10001L);
INSERT INTO REVIEW( ID , RATING ,DESCRIPTION ,  COURSE_ID) VALUES( 40003, '3', 'MEHH',10001L);
INSERT INTO REVIEW( ID , RATING ,DESCRIPTION ,  COURSE_ID) VALUES( 40004, '1', 'BAD COURSE',10002L);

INSERT INTO STUDENT_COURSE(STUDENT_ID , COURSE_ID) VALUES (20001, 10001 );
INSERT INTO STUDENT_COURSE(STUDENT_ID , COURSE_ID) VALUES (20002, 10001 );
INSERT INTO STUDENT_COURSE(STUDENT_ID , COURSE_ID) VALUES (20003, 10001 );
INSERT INTO STUDENT_COURSE(STUDENT_ID , COURSE_ID) VALUES (20004, 10001 );
INSERT INTO STUDENT_COURSE(STUDENT_ID , COURSE_ID) VALUES (20001, 10002 );


-- -- SELECT * FROM STUDENT_COURSE , STUDENT, COURSE
-- -- WHERE STUDENT_COURSE.STUDENT_ID = STUDENT.ID 
-- -- AND STUDENT_COURSE.COURSE_ID = COURSE.ID

-- SELECT * FROM COURSE
-- WHERE COURSE.ID NOT IN ( SELECT COURSE_ID FROM STUDENT_COURSE )

-- insert into course(id, name, created_date, last_updated_date) 
-- values(10001,'JPA in 50 Steps', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
-- insert into course(id, name, created_date, last_updated_date) 
-- values(10002,'Spring in 50 Steps', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
-- insert into course(id, name, created_date, last_updated_date) 
-- values(10003,'Spring Boot in 100 Steps', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- insert into passport(id,number)
-- values(40001,'E123456');
-- insert into passport(id,number)
-- values(40002,'N123457');
-- insert into passport(id,number)
-- values(40003,'L123890');

-- insert into student(id,name,passport_id)
-- values(20001,'Ranga',40001);
-- insert into student(id,name,passport_id)
-- values(20002,'Adam',40002);
-- insert into student(id,name,passport_id)
-- values(20003,'Jane',40003);

-- insert into review(id,rating,description,course_id)
-- values(50001,'5', 'Great Course',10001);
-- insert into review(id,rating,description,course_id)
-- values(50002,'4', 'Wonderful Course',10001);
-- insert into review(id,rating,description,course_id)
-- values(50003,'5', 'Awesome Course',10003);

-- insert into student_course(student_id,course_id)
-- values(20001,10001);
-- insert into student_course(student_id,course_id)
-- values(20002,10001);
-- insert into student_course(student_id,course_id)
-- values(20003,10001);
-- insert into student_course(student_id,course_id)
-- values(20001,10003);
