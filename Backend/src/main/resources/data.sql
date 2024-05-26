INSERT INTO students (name, user_type, grade, study_year, faculty_section)
VALUES
    ('Liam Thompson', 'student', 9, 1, 'Computer Science'),
    ('Benjamin Davis', 'student', 9, 2, 'Natural Science'),
    ('Sophia Rodriguez', 'student', 7, 3, 'Art');

INSERT INTO admin (name, user_type)
VALUES
    ('Emily Johnson', 'admin'),
    ('Olivia Martinez', 'admin');

INSERT INTO discipline (name, max_students, study_year, category, teacher)
VALUES
    ('Biology Basics', 40, 2, 'Natural Science', 'Dragomir Oana'),
    ('C++', 50, 1, 'Computer Science', 'Emily Johnson'),
    ('Chemical Reactions', 45, 2, 'Natural Science', 'Sophia Rodriguez'),
    ('Graphic Design Fundamentals', 30, 3, 'Art', 'Liam Thompson');

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
