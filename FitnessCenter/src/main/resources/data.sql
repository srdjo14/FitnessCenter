INSERT INTO USER(role, username, password, first_name, last_name, phone, email, birth_date, active, type) VALUES('USER', 'srdjo14', 'fitness1', 'Srdjan', 'Protic', '0651384326', 'protic783@gmail.com', '2000-4-14', TRUE, 'MEMBER')
INSERT INTO USER(role, username, password, first_name, last_name, phone, email, birth_date, active, type) VALUES('USER', 'dejana11', 'fitness111', 'Dejana', 'Protic', '065138432644', 'dejana783@gmail.com', '2000-7-26', TRUE, 'ADMIN')

INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Ozzy','Heroja Pinkija 11', '06546254239', 'ozzy@gmail.com')
INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Gladiator','Cara Lazara 21', '06598754239', 'gladiator@gmail.com')
INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Hard','Stratimiroviceva 44', '06546345539', 'hard@gmail.com')

INSERT INTO USER(role, username, password, first_name, last_name, phone, email, birth_date, active, medium_rate, fitness_center_id, type) VALUES('USER', 'milos112', 'fitnedsfss1', 'Milos', 'Protic', '0653321384326', 'pro3mmm@gmail.com', '2003-4-14', TRUE, 4.0, 1, 'TRAINER')
INSERT INTO USER(role, username, password, first_name, last_name, phone, email, birth_date, active, medium_rate, fitness_center_id, type) VALUES('USER', 'markovic12', 'fitnes1sddd', 'Milos', 'Markovic', '0654324344326', 'markovic@gmail.com', '1999-8-14', TRUE, 3.0, 2, 'TRAINER')

INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Skok', 'Plyometric', 'Medium-Hard', 35, 1)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Kardio', 'HIIT', 'Medium', 45, 2)

INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, training_id) VALUES(4, 300, '2021-5-19', 2, 1)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, training_id) VALUES(9, 270, '2021-5-21', 1, 1)

INSERT INTO HALL(capacity, number_of_hall, fitness_center_id, terms_id) VALUES (12, 'h4', 1, 1)

INSERT INTO RATE_TRAINING(grade, members_id, trainings_id) VALUES (5, 1, 1)

INSERT INTO DONE_TRAINING(members_id, training_id) VALUES(1,1)

INSERT INTO CHECK_TRAINING(members_id, training_id) VALUES(1,1)


