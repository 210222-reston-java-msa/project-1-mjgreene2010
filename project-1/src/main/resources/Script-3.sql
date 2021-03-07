DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	username VARCHAR(50),
	pass_word VARCHAR(50),
	is_manager BOOLEAN
);

INSERT INTO employee (first_name, last_name, username, pass_word, is_manager)
	VALUES ('Mike', 'Tyson', 'mtyson', '1234', false);
	
SELECT * FROM employee;