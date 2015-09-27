DELETE FROM student_2_score;
DELETE FROM student;
DELETE FROM score;

-- Students --
INSERT INTO student(id, first_name, last_name) VALUES (1, 'Admir', 'Memic');
INSERT INTO student(id, first_name, last_name) VALUES (2, 'Azer', 'Aljovic');
INSERT INTO student(id, first_name, last_name) VALUES (3, 'Muhamed', 'Kuric');
INSERT INTO student(id, first_name, last_name) VALUES (4, 'Mediha', 'Zukic');

-- Scores --
INSERT INTO score(id, name, value) VALUES (1, 'Challenges', '100');

-- student_2_score relations --
INSERT INTO student_2_score(id, student_id, score_id) VALUES (1, 1, 1);