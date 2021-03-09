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

DROP TABLE IF EXISTS reimbursement;

CREATE TABLE reimbursement (
	id SERIAL PRIMARY KEY,
	posting_date DATE NOT NULL DEFAULT CURRENT_DATE,
	date_of_expense DATE NOT NULL,
	amount MONEY NOT NULL,
	reimbursement_type VARCHAR(50),
	description VARCHAR(100),
	status VARCHAR(50),
	employee_id INTEGER NOT NULL,
	 	 
	 CONSTRAINT employee_id_fk FOREIGN KEY(employee_id) REFERENCES employee(id)
	 
	); 
	
INSERT INTO reimbursement (date_of_expense, amount, reimbursement_type, description, status, employee_id)
	VALUES ('2020-12-31', 234.43, 'Food', 'Company New Year Party', 'pending', 2 );

SELECT reimbursement.*, employee.first_name, employee.last_name FROM reimbursement JOIN employee USING(id);
	;
