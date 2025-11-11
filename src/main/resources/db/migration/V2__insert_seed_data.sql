INSERT INTO grades VALUES
  (1, 'A', 'Excellent'),
  (2, 'B', 'Good'),
  (3, 'C', 'Average'),
  (4, 'D', 'Below Average'),
  (5, 'F', 'Fail');

INSERT INTO roles VALUES
  (1, 'ADMIN'),
  (2, 'STUDENT'),
  (3, 'TEACHER');

INSERT INTO course VALUES
  (1, 'science', 'learn', 4),
  (3, 'maths', 'Learn 2', 3),
  (4, 'English', 'Learn 3', 2),
  (5, 'java', 'Learn 4', 4),
  (6, 'phyton', 'Learn 5', 3),
  (7, 'dataScience', 'Learn 7', 4),
  (8, 'devops', 'Learn 9', 4),
  (16, 'aws', 'Learn 9', 4),
  (17, 'data structures', 'Learn 9', 2);

INSERT INTO students VALUES
  (1,'sudheer',21,18,'sudheerjanga9999@gmail.com',''),
  (3,'lokesh',22,21,'lokesh45@gmail.com',''),
  (5,'sai',23,35,'sai123@gmail.com',''),
  (8,'abhi',21,28,'abhi728@gmail.com',''),
  (9,'likky tum',12,2,'likky818@gmail.com',''),
  (10,'deekshi',11,17,'deekshi123@gmail.com',''),
  (11,'ganitha',22,43,'ganithareddychilukuri@gmail.com',''),
  (16,'Chandu',22,10,'chandu@98771.com',''),
  (17,'teju',22,11,'teju@98771.com','teju'),
  (18,'satwika',20,12,'stwika@98771.com','$2a$10$8R0knPrY5qjSeSzRfjm/hOTclXOoxkvSo.CWiPdj2HtO2yG/TyXSW'),
  (19,'surendra@98771.com',22,15,'surendra@98771.com','$2a$10$PfbigccB2ed5kBTQO1e9neRalkQqyZuIn/8siXWRVXIQpVqfCZ4yS'),
  (20,'sudhakar',12,39,'sudhakar@09771.com','$2a$10$W2OqO1JIsdjmnzN2I5WinOMHDTyxPLeTB4yuXWCApT.LMjnHq4k8i'),
  (22,'satya',18,45,'satys7866@gamil..com','$2a$10$Yau5iYXM0ka/q3UahYPWLOrcMZf6Tal/8c13IkaySLydsRSUnX0D2');

INSERT INTO enrollments VALUES
  (1,1,1,'2025-09-23',1),
  (3,3,3,'2025-09-23',1),
  (4,3,1,'2025-09-23',1),
  (6,3,5,'2025-09-23',2),
  (7,8,5,'2025-09-23',2),
  (8,11,5,'2025-09-24',2),
  (9,19,1,'2025-09-29',2),
  (10,19,4,'2025-09-29',2),
  (11,19,5,'2025-09-29',2),
  (12,19,7,'2025-09-29',2),
  (13,10,1,'2025-09-29',1),
  (14,10,8,'2025-09-29',2),
  (15,10,3,'2025-09-30',2),
  (16,10,5,'2025-09-30',2);

INSERT INTO student_roles VALUES
  (16,1),(17,1),(18,1),(20,1),(22,1),
  (16,2),(17,2),(18,2),(20,2),
  (19,3),(20,3);
