INSERT INTO students (name, user_type, grade, study_year, faculty_section)
VALUES
    ('Liam Thompson', 'student', 9, 1, 'Computer Science'),
    ('Benjamin Davis', 'student', 9, 2, 'Biology'),
    ('Sophia Rodriguez', 'student', 7, 3, 'Design');

INSERT INTO admin (name, user_type)
VALUES
    ('Emily Johnson', 'admin'),
    ('Olivia Martinez', 'admin');

INSERT INTO discipline (name, max_students, study_year, category, teacher)
VALUES
    ('Biology Basics', 40, 2, 'Life Sciences', 'Benjamin Davis'),
    ('C++', 50, 3, 'Oriented programming', 'Emily Johnson'),
    ('Chemical Reactions', 45, 2, 'Chemistry', 'Sophia Rodriguez'),
    ('Graphic Design Fundamentals', 30, 1, 'Design', 'Liam Thompson');

INSERT INTO enrollment (priority, student_id, discipline_id)
VALUES
    ('yes', 1, 1),
    ('yes', 2, 1),
    ('no', 3, 1);

INSERT INTO timeslot (begin_time, end_time, week_day, discipline_id)
VALUES
    (800, 930, 'Monday', 1),
    (1000, 1130, 'Tuesday', 2),
    (1300, 1430, 'Wednesday', 3);
