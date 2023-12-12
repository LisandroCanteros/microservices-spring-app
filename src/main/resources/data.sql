INSERT INTO question (id, category, difficulty_level, title, option1, option2, option3, option4, correct_option)
VALUES
(1, 'math', '1', 'what is 2+2?', '1', '2', '3', '4', 'option4'),
(2, 'math', '1', 'what is 1+1?', '1', '2', '3', '4', 'option2'),
(3, 'math', '1', 'what is 5+5?', '1', '2', '10', '4', 'option3'),
(4, 'programming', '1', 'What does HTML stand for?', 'HyperText Markup Language', 'High-Level Text Machine Learning', 'Hyperlink and Text Markup Language', 'Home Tool Markup Language', 'option1'),
(5, 'programming', '1', 'Which of the following is not a programming language?', 'Python', 'Java', 'Photoshop', 'C++', 'option3'),
(6, 'programming', '1', 'What does the acronym "CSS" stand for in web development?', 'Counter Style Sheets', 'Computer Style Sheets', 'Cascading Style Sheets', ' Creative Style Selector', 'option3')
ON CONFLICT (id) DO NOTHING;

