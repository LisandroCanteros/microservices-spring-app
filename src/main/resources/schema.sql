CREATE TABLE IF NOT EXISTS question (
    id SERIAL PRIMARY KEY,
    category varchar(100) NOT NULL,
    difficulty_level varchar(20) NOT NULL,
    title varchar(100) NOT NULL,
    option1 varchar(100) NOT NULL,
    option2 varchar(100) NOT NULL,
    option3 varchar(100),
    option4 varchar(100),
    correct_option varchar(100) NOT NULL
);