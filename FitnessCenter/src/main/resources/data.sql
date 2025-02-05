
INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Ozzy','Heroja Pinkija 11', '06546254239', 'ozzy@gmail.com')
INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Gladiator','Cara Lazara 21', '06598754239', 'gladiator@gmail.com')
INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Hard','Stratimiroviceva 44', '06546345539', 'hard@gmail.com')

INSERT INTO USER( type,  username, password, first_name, last_name, phone, email, birth_date, active, uloga )  VALUES('admin',  'srdjan11', 'Fitnes2!', 'Srdjan', 'Protic', '065344384326', 'pro3m@gmail.com', '2000-4-14', TRUE, 'admin')
INSERT INTO USER( type,  username, password, first_name, last_name, phone, email, birth_date, active, uloga )  VALUES('member',  'milos11', 'Fitnes0!', 'Milos', 'Protic', '0653321384326', 'pro3mmm@gmail.com', '2003-4-14', TRUE, 'member')
INSERT INTO USER( type,  username, password, first_name, last_name, phone, email, birth_date, active, uloga, medium_rate, fitness_center_id) VALUES('trainer',  'jovan11', 'Fitnes1!', 'Jovan', 'Jovanovic', '0654324344326', 'markovic@gmail.com', '1999-8-14', TRUE, 'trainer', 3.0, 1)
INSERT INTO USER( type, username, password, first_name, last_name, phone, email, birth_date, active, uloga, medium_rate, fitness_center_id) VALUES('trainer', 'markovic123', 'Fitnes12!', 'Milica', 'Markovic', '065423454326', 'markovi15c@gmail.com', '1999-8-14', TRUE, 'trainer', 3.0, 1)
INSERT INTO USER( type, username, password, first_name, last_name, phone, email, birth_date, active, uloga, medium_rate, fitness_center_id) VALUES('trainer', 'jokic121', 'Fitnes123!', 'Predrag', 'Jokic', '06543246326', 'markovichhhh @gmail.com', '1999-8-14', TRUE, 'trainer', 3.0, 2)
INSERT INTO USER( type, username, password, first_name, last_name, phone, email, birth_date, active, uloga, medium_rate, fitness_center_id) VALUES('trainer', 'dejana12', 'Fitnes1234!', 'Dejana', 'Ninkovic', '0634543246326', 'markovicashhhh @gmail.com', '1999-8-14', TRUE, 'trainer', 3.0, 2)
INSERT INTO USER( type,  username, password, first_name, last_name, phone, email, birth_date, active, uloga )  VALUES('member',  'mmilos11', 'Fitnes01!', 'Milosdds', 'Protixc', '065384326', 'pro2mm@gmail.com', '2013-4-14', TRUE, 'member')

INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Kardio', 'HIIT', 'Medium', 30, 6)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Skok', 'Plyometric', 'Medium-Hard', 20, 3)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Ledja', 'Back', 'Medium', 45, 4)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Ramena', 'Full-strength', 'Hard', 65, 3)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Ruke', 'Back', 'Medium', 30, 4)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Noge', 'Plyometric', 'Medium-Hard', 20, 6)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Stomak', 'Back', 'Medium', 45, 6)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Grudi', 'Full-strength', 'Hard', 65, 4)
INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('Grudi-Rame', 'Full-strength', 'Easy', 60, 5)

INSERT INTO HALL(capacity, number_of_hall, fitness_center_id) VALUES (12, 'h4', 1)
INSERT INTO HALL(capacity, number_of_hall, fitness_center_id) VALUES (13, 'h5', 2)

INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(4, 300, '2021-5-19', 2, 2, 1)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(9, 270, '2021-5-21', 1, 1, 2)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(9, 450, '2021-5-24', 1, 1, 3)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(9, 270, '2021-5-21', 1, 1, 4)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(9, 230, '2021-7-21', 1, 1, 5)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(4, 380, '2021-6-19', 2, 2, 5)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(4, 550, '2021-7-19', 2, 1, 6)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(4, 130, '2021-8-19', 2, 2, 7)
INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, hall_id, training_id) VALUES(4, 200, '2021-9-19', 2, 1, 6)

INSERT INTO RATE_TRAINING(members_id, terms_id, grade) VALUES (2,3,4)

INSERT INTO DONE_TRAINING(members_id, terms_id) VALUES(2,1)
INSERT INTO DONE_TRAINING(members_id, terms_id) VALUES(2,2)
INSERT INTO DONE_TRAINING(members_id, terms_id) VALUES(2,3)
INSERT INTO DONE_TRAINING(members_id, terms_id) VALUES(2,4)
INSERT INTO DONE_TRAINING(members_id, terms_id) VALUES(2,5)
INSERT INTO DONE_TRAINING(members_id, terms_id) VALUES(2,1)
INSERT INTO DONE_TRAINING(members_id, terms_id) VALUES(7,2)
INSERT INTO DONE_TRAINING(members_id, terms_id) VALUES(7,4)
INSERT INTO DONE_TRAINING(members_id, terms_id) VALUES(7,3)

INSERT INTO CHECK_TRAINING(members_id, terms_id) VALUES(2,1)
INSERT INTO CHECK_TRAINING(members_id, terms_id) VALUES(2,2)
INSERT INTO CHECK_TRAINING(members_id, terms_id) VALUES(2,5)
INSERT INTO CHECK_TRAINING(members_id, terms_id) VALUES(2,4)
INSERT INTO CHECK_TRAINING(members_id, terms_id) VALUES(2,3)

INSERT INTO CHECK_TRAINING(members_id, terms_id) VALUES(7,2)
INSERT INTO CHECK_TRAINING(members_id, terms_id) VALUES(7,3)
INSERT INTO CHECK_TRAINING(members_id, terms_id) VALUES(7,1)


