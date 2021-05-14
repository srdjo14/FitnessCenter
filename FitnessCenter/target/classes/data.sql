INSERT INTO USER(role, username, password, first_name, last_name, phone, email, birth_date, active, type) VALUES('USER', 'srdjo14', 'fitness1', 'Srdjan', 'Protic', '0651384326', 'protic783@gmail.com', '2000-4-14', TRUE, 'MEMBER')

INSERT INTO USER(role, username, password, first_name, last_name, phone, email, birth_date, active, type) VALUES('USER', 'srdjo114', 'fitne2ss1', 'Srdjadan', 'Proticdd', '065138432644', 'proticcds783@gmail.com', '2000-4-24', TRUE, 'ADMIN')

INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Teret','Aaaaa', '06546254239', 'protic@gmail.com')
INSERT INTO FITNESS_CENTER(naziv, address, contact_phone, email) VALUES ('Teretnn','Aaasdaaa', '04356546254239', 'prdsfotic@gmail.com')

INSERT INTO USER(role, username, password, first_name, last_name, phone, email, birth_date, active, medium_rate, fitness_center_id, type) VALUES('USER', 'srdjo3314', 'fitnedsfss1', 'Srdjasdsan', 'Protdsdic', '0653321384326', 'protfsadfic783@gmail.com', '2000-4-14', TRUE, 4.0, 1, 'TRAINER')

INSERT INTO TRAINING(training_name, type, about, length, fitness_trainer_id) VALUES('SKOCNI', 'Plyometric', 'Medium-Hard', 35, 1)

INSERT INTO TERMS(number_checked_user, price, training_day, fitness_Center_id, training_id) VALUES(4, 300, '2021-5-19', 2, 1)

INSERT INTO HALL(capacity, number_of_hall, fitness_center_id, terms_id) VALUES (12, 'h4', 1, 1)

INSERT INTO RATE_TRAINING(grade, members_id, trainings_id) VALUES (5, 1, 1)

INSERT INTO DONE_TRAINING(members_id, training_id) VALUES(1,1)
INSERT INTO CHECK_TRAINING(members_id, training_id) VALUES(1,1)


