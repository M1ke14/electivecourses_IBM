INSERT INTO students (name, user_type, grade, study_year, faculty_section)
VALUES
    ('Liam Thompson', 'student', 9, 1, 'Computer Science'),
    ('Benjamin Davis', 'student', 9, 2, 'Biology'),
    ('Sophia Rodriguez', 'student', 7, 3, 'Design');

INSERT INTO admin (id, name, user_type)
VALUES
    (1, 'Emily Johnson', 'admin'),
    (2, 'Olivia Martinez', 'admin');

INSERT INTO discipline (id, name, max_students, study_year, category, teacher)
VALUES
    (1, 'C++', 50, 3, 'Oriented programming', 'Emily Johnson'),
    (2, 'Biology Basics', 40, 2, 'Life Sciences', 'Benjamin Davis'),
    (3, 'Chemical Reactions', 45, 2, 'Chemistry', 'Sophia Rodriguez'),
    (4, 'Graphic Design Fundamentals', 30, 1, 'Design', 'Liam Thompson');

INSERT INTO enrollment (id, priority, discipline_id)
VALUES
    (1, 'yes', 1),
    (2, 'yes', 1),
    (3, 'no', 1);

INSERT INTO timeslot (id, begin_time, end_time, week_day, discipline_id)
VALUES
    (1, 800, 930, 'Monday', 1),
    (2, 1000, 1130, 'Tuesday', 2),
    (3, 1300, 1430, 'Wednesday', 3);
