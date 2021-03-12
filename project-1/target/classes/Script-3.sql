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
	amount MONEY NOT NULL,
	reimbursement_type VARCHAR(50),
	description VARCHAR(100),
	status VARCHAR(50) DEFAULT 'pending',
	employee_id INTEGER NOT NULL,
	 	 
	 CONSTRAINT employee_id_fk FOREIGN KEY(employee_id) REFERENCES employee(id) 
	); 
	
INSERT INTO reimbursement (amount, reimbursement_type, description, employee_id)
VALUES (234.43, 'Food', 'Company New Year Party', 2), (393.63, 'Food', 'Clients was in town', 1),
(119.93, 'Travel', 'Flight to LA', 1);


SELECT * FROM reimbursement;

DROP TABLE IF EXISTS manager;

CREATE TABLE manager (
	id SERIAL PRIMARY KEY,
	resolved_date DATE DEFAULT CURRENT_DATE,
	resolved_manager INTEGER ,
	reimbursement_id INTEGER NOT NULL,
	

	CONSTRAINT reimbursement_id_fk FOREIGN KEY(reimbursement_id) REFERENCES reimbursement(id)
)

SELECT * FROM manager;
