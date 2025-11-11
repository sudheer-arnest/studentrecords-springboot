CREATE TABLE students (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL COMMENT 'Full name of the student',
  age INT DEFAULT NULL COMMENT 'Age must be non negative',
  roll INT NOT NULL COMMENT 'Unique roll no for each student',
  email VARCHAR(100) DEFAULT NULL COMMENT 'Email Address',
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY roll (roll),
  UNIQUE KEY email (email),
  CONSTRAINT students_chk_1 CHECK ((age >= 0 AND age <= 25))
);

CREATE TABLE grades (
  id INT NOT NULL AUTO_INCREMENT,
  grade VARCHAR(40) DEFAULT NULL,
  remarks VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY code (grade)
);

CREATE TABLE course (
  id BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(60) NOT NULL,
  description VARCHAR(200) DEFAULT NULL,
  credits INT DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY title (title)
);

CREATE TABLE roles (
  id BIGINT NOT NULL AUTO_INCREMENT,
  role_type VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE enrollments (
  id INT NOT NULL AUTO_INCREMENT,
  student_id BIGINT NOT NULL,
  course_id BIGINT NOT NULL,
  enrolled_date DATE DEFAULT NULL,
  grade_id INT DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_student_course (student_id, course_id),
  KEY course_id (course_id),
  KEY fk_enrollments_grade (grade_id),
  CONSTRAINT enrollments_ibfk_1 FOREIGN KEY (student_id) REFERENCES students (id),
  CONSTRAINT enrollments_ibfk_2 FOREIGN KEY (course_id) REFERENCES course (id),
  CONSTRAINT fk_enrollments_grade FOREIGN KEY (grade_id) REFERENCES grades (id)
);

CREATE TABLE student_roles (
  student_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  PRIMARY KEY (student_id, role_id),
  KEY FKpbnuuf74xgon2g4op0198tlak (role_id),
  CONSTRAINT FK9pfce7au0mx2r0kuqbh0vmxg9 FOREIGN KEY (student_id) REFERENCES students (id),
  CONSTRAINT FKpbnuuf74xgon2g4op0198tlak FOREIGN KEY (role_id) REFERENCES roles (id)
);
