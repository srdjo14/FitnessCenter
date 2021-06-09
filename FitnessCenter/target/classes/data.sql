
INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Ozzy','Heroja Pinkija 11', '06546254239', 'ozzy@gmail.com')
INSERT INTO USER( type,  username, password, first_name, last_name, phone, email, birth_date, active, position )  VALUES('member',  'milos112', 'fitnedsfss1', 'Milos', 'Protic', '0653321384326', 'pro3mmm@gmail.com', '2003-4-14', TRUE, 'member')
INSERT INTO USER( type,  username, password, first_name, last_name, phone, email, birth_date, active, position, medium_rate, fitness_center_id) VALUES('trainer',  'markovic12', 'fitnes1sddd', 'Milos', 'Markovic', '0654324344326', 'markovic@gmail.com', '1999-8-14', FALSE, 'trainer', 3.0, 1)
INSERT INTO USER( type, username, password, first_name, last_name, phone, email, birth_date, active, position, medium_rate, fitness_center_id) VALUES('trainer', 'markovic123', 'fitnes1sdadd', 'Milofsads', 'Markovic', '065423454326', 'markovi15c@gmail.com', '1999-8-14', FALSE, 'trainer', 3.0, 1)
INSERT INTO USER( type, username, password, first_name, last_name, phone, email, birth_date, active, position, medium_rate, fitness_center_id) VALUES('trainer', 'markovic121', 'fitnes1sddssd', 'Milosadfs', 'Markovic', '06543246326', 'markovichhhh @gmail.com', '1999-8-14', FALSE, 'trainer', 3.0, 1)
INSERT INTO USER( type, username, password, first_name, last_name, phone, email, birth_date, active, position, medium_rate, fitness_center_id) VALUES('trainer', 'markovaic121', 'fitnes1saddssd', 'Milosasdfadfs', 'Markovidsac', '0634543246326', 'markovicashhhh @gmail.com', '1999-8-14', TRUE, 'trainer', 3.0, 1)

INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Gladiator','Cara Lazara 21', '06598754239', 'gladiator@gmail.com')
INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Hard','Stratimiroviceva 44', '06546345539', 'hard@gmail.com')

INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Kardio', 'HIIT', 'Medium', 30, 2)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Skok', 'Plyometric', 'Medium-Hard', 20, 2)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Ledja', 'Back', 'Medium', 45, 2)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Ramena', 'Full-strength', 'Hard', 65, 2)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Ruke', 'Back', 'Medium', 30, 2)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Noge', 'Plyometric', 'Medium-Hard', 20, 2)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Stomak', 'Back', 'Medium', 45, 2)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Grudi', 'Full-strength', 'Hard', 65, 2)

INSERT INTO HALL(capacity, number_of_hall, fitness_center_id) VALUES (12, 'h4', 1)
INSERT INTO HALL(capacity, number_of_hall, fitness_center_id) VALUES (13, 'h5', 2)

INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(4, 300, '2021-5-19', 2, 1, 1)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(9, 270, '2021-5-21', 1, 2, 2)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(9, 450, '2021-5-24', 1, 2, 3)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(9, 270, '2021-5-21', 1, 2, 1)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(9, 230, '2021-7-21', 1, 2, 4)

INSERT INTO RATE_TRAINING(grade, members_id, trainings_id) VALUES (5, 1, 1)

INSERT INTO DONE_TRAINING(members_id, training_id) VALUES(1,1)

INSERT INTO CHECK_TRAINING(members_id, training_id) VALUES(1,1)


