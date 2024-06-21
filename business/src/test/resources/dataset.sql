INSERT INTO client (id_card, email, full_name, password, state, birth_date, level)
VALUES
    ('1234567890', 'juan.lopez@example.com', 'Juan Lopez', 'password123', 'ACTIVE', '1990-05-14', 1),
    ('0987654321', 'maria.gomez@example.com', 'Maria Gomez', 'password456', 'ACTIVE', '1985-08-21', 2),
    ('1122334455', 'pedro.ramirez@example.com', 'Pedro Ramirez', 'password789', 'ACTIVE', '1992-01-30', 1),
    ('2233445566', 'ana.sanchez@example.com', 'Ana Sanchez', 'password012', 'ACTIVE', '1988-11-15', 3),
    ('3344556677', 'laura.martinez@example.com', 'Laura Martinez', 'password345', 'INACTIVE', '1995-07-09', 1),
    ('5543893065', 'pala.velez@example.com', 'Pala Velez', 'password100', 'INACTIVE', '2003-10-23', 5),
    ('1000000001', 'sr.user@example.com', 'Sr User', 'password111', 'ACTIVE', '2005-10-25', 3);

INSERT INTO city (id, city_name, department)
VALUES
    (1, 'Bogota', 'NORTE_DE_SANTANDER'),
    (2, 'Medellin', 'ANTIOQUIA'),
    (3, 'Cali', 'VALLE_DEL_CAUCA'),
    (4, 'Barranquilla', 'ATLANTICO'),
    (5, 'Cartagena', 'BOLIVAR');

INSERT INTO city_admin (id_card, email, full_name, password, state, city_id)
VALUES
    ('1234567892', 'admin1@example.com', 'Carlos Perez', 'securepassword1', 'ACTIVE', 1),
    ('0987654323', 'admin2@example.com', 'Lucia Rodriguez', 'securepassword2', 'ACTIVE', 2),
    ('1122334454', 'admin3@example.com', 'Miguel Torres', 'securepassword3', 'ACTIVE', 3),
    ('2233445568', 'admin4@example.com', 'Sofia Martinez', 'securepassword4', 'ACTIVE', 4),
    ('3344556673', 'admin5@example.com', 'Juan Gomez', 'securepassword5', 'ACTIVE', 5);

INSERT INTO phone_number (id, type)
VALUES
    (3007344065, 'HOME'),
    (3007344066, 'PERSONAL'),
    (3007344067, 'HOME'),
    (3007344068, 'PERSONAL'),
    (3007344069, 'HOME');

INSERT INTO coupon (id, description, discount, expire_date, name, state, type)
VALUES
    (1, '10% discount on selected products', 10.0, '2024-12-31', 'Discount10', 'AVAILABLE', 'BIENVENUE'),
    (2, '20% discount on selected products', 20.0, '2024-11-30', 'Discount20', 'EXPIRED', 'AUGUST20'),
    (3, '15% discount on selected products', 15.0, '2024-10-31', 'Discount15', 'AVAILABLE', 'FIRST_PURCHASE'),
    (4, '25% discount on selected products', 25.0, '2025-01-15', 'Discount25', 'EXPIRED', 'FIRST_YEAR'),
    (5, '5% discount on selected products', 15.0, '2024-09-30', 'Discount15', 'REDEEMED', 'HAPPY_BDAY');

INSERT INTO client_coupon (id, state, client_id_card, coupon_id)
VALUES
    (1, 'AVAILABLE', '0987654321', 1),
    (2, 'REDEEMED', '3344556677', 2),
    (3, 'REDEEMED', '1234567890', 3),
    (4, 'REDEEMED', '0987654321', 4),
    (5, 'EXPIRED', '3344556677', 5);

INSERT INTO food (id, amount, description, name, state, type)
VALUES
    (1, 100, 'Fresh apples from the farm', 'Apples', 'NOT_AVAILABLE', 'FRUITS'),
    (2, 50, 'Organic whole wheat bread with chicken', 'Whole Wheat Bread with Chicken', 'AVAILABLE', 'FAST_FOOD'),
    (3, 200, 'Free-range chicken breast', 'Chicken Breast', 'AVAILABLE', 'FAST_FOOD'),
    (4, 75, 'Homemade strawberry jam', 'Strawberry Jam', 'AVAILABLE', 'CANDY'),
    (5, 300, 'Locally grown carrots', 'Carrots', 'NOT_AVAILABLE', 'VEGETABLES');

INSERT INTO movie (id, cast, name, state, synopsis, trailer, type)
VALUES
    (1, 'Tom Holland, Zendaya, Benedict Cumberbatch', 'Spider-Man: No Way Home', 'EXHIBITED', 'With Spider-Mans identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man.', 'https://www.youtube.com/watch?v=JfVOs4VSpmA', 'PREMIERE'),
    (2, 'Chris Pratt, Zoe Saldana, Dave Bautista', 'Guardians of the Galaxy Vol. 2', 'NOT_EXHIBITED', 'The Guardians struggle to keep together as a team while dealing with their personal family issues, notably Star-Lords encounter with his father, the ambitious celestial being Ego.', 'https://www.youtube.com/watch?v=dW1BIid8Osg', 'PREMIERE'),
    (3, 'Ryan Reynolds, Morena Baccarin, Ed Skrein', 'Deadpool', 'NOT_EXHIBITED', 'A wisecracking mercenary gets experimented on and becomes immortal but ugly, and sets out to track down the man who ruined his looks.', 'https://www.youtube.com/watch?v=ONHBaC-pfsk', 'PREVIEW'),
    (4, 'Robert Downey Jr., Chris Evans, Mark Ruffalo', 'Avengers: Endgame', 'EXHIBITED', 'After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe.', 'https://www.youtube.com/watch?v=TcMBFSGVi1c', 'PREMIERE'),
    (5, 'Leonardo DiCaprio, Brad Pitt, Margot Robbie', 'Once Upon a Time in Hollywood', 'EXHIBITED', 'A faded television actor and his stunt double strive to achieve fame and success in the final years of Hollywoods Golden Age in 1969 Los Angeles.', 'https://www.youtube.com/watch?v=ELeMaP8EPAA', 'PREVIEW');

INSERT INTO theater (id, address, name, admin_id_card, city_id)
VALUES
    (1, '123 Main St', 'Cineplex Downtown', '1234567892', 1),
    (2, '456 Elm St', 'Regal Cinema', '1122334454', 2),
    (3, '789 Oak Ave', 'AMC Theaters', '3344556673', 3),
    (4, '321 Pine Blvd', 'Cinemark', '1234567892', 1),
    (5, '555 Cedar Rd', 'Vue Cinema', '1122334454', 2);

INSERT INTO movie_theater (id, pillars, seats, stripes, theater_id)
VALUES
    (1, 20, 200, 10, 1),
    (2, 15, 150, 10, 2),
    (3, 25, 250, 10, 3),
    (4, 18, 180, 10, 4),
    (5, 22, 242, 11, 5);

INSERT INTO schedule (id, date, hour)
VALUES
    (1, '2024-06-15', '10:00:00'),
    (2, '2024-06-15', '14:30:00'),
    (3, '2024-06-15', '18:00:00'),
    (4, '2024-06-16', '11:00:00'),
    (5, '2024-06-16', '15:15:00'),
    (6, '2024-07-16', '19:30:00'),
    (7, '2024-06-17', '12:00:00'),
    (8, '2024-06-17', '16:45:00'),
    (9, '2024-06-17', '20:00:00');

INSERT INTO performance (id, price, state, type, movie_id, movie_theater_id, schedule_id)
VALUES
    (1, 10.50, 'AVAILABLE', 'PERFORMANCE_2D', 1, 1, 1),
    (2, 12.00, 'AVAILABLE', 'PERFORMANCE_3D', 2, 2, 2),
    (3, 11.75, 'AVAILABLE', 'PERFORMANCE_XD', 3, 3, 3),
    (4, 9.99, 'NOT_AVAILABLE', 'PERFORMANCE_4D', 4, 4, 4),
    (5, 13.25, 'NOT_AVAILABLE', 'PERFORMANCE_3D', 5, 5, 5),
    (6, 13.25, 'NOT_AVAILABLE', 'PERFORMANCE_4D', 1, 5, 6),
    (7, 9.5, 'AVAILABLE', 'PERFORMANCE_XD', 5, 4, 6);

INSERT INTO payment_method (id, name)
VALUES
    (1, 'Credit Card'),
    (2, 'Debit Card'),
    (3, 'PayPal'),
    (4, 'Google Pay'),
    (5, 'Apple Pay');

INSERT INTO purchase (id, purchase_date, total, client_id_card, client_coupon_id, payment_method_id, performance_id)
VALUES
    (1, '2024-06-15 10:30:00', 25.50, '1234567890', 1, 1, 1),
    (2, '2024-06-16 14:00:00', 30.00, '2233445566', 2, 2, 2),
    (3, '2024-06-17 16:45:00', 20.75, '1234567890', 3, 3, 3),
    (4, '2024-06-18 12:00:00', 15.99, '2233445566', 4, 4, 4),
    (5, '2024-06-19 18:30:00', 35.25, '3344556677', 5, 5, 5),
    (6, '2025-06-19 18:30:00', 49.00, '1000000001', 1, 2, 7);

INSERT INTO review (id, description, rate, review_date, client_id_card, movie_id)
VALUES
    (1, 'Great movie, loved the plot!', 2.5, '2024-06-15 08:30:00', '3344556677', 1),
    (2, 'The acting was superb.', 3.0, '2024-06-16 10:00:00', '1234567890', 2),
    (3, 'Enjoyed every moment of it.', 4.2, '2024-06-17 12:15:00', '2233445566', 3),
    (4, 'Could have been better.', 3.5, '2024-06-18 14:30:00', '3344556677', 4),
    (5, 'Amazing visuals!', 4.8, '2024-06-19 16:45:00', '2233445566', 5);

INSERT INTO ticket (id, pillar, state, stripe, movie_theater_id, performance_id, purchase_id)
VALUES
    (1, 19, 'AVAILABLE', 10, 1, 1, 1),
    (2, 13, 'PURCHASED', 10, 2, 2, 2),
    (3, 3, 'USED', 10, 3, 3, 3),
    (4, 11, 'PURCHASED', 10, 4, 4, 4),
    (5, 21, 'EXPIRED', 11, 5, 5, 2),
    (6, 20, 'PURCHASED', 5, 4, 7, 6),
    (7, 13, 'PURCHASED', 6, 4, 7, 6);

INSERT INTO genre (id, name) VALUES
                             (1, 'Action'),
                             (2, 'Comedy'),
                             (3, 'Drama'),
                             (4, 'Horror'),
                             (5, 'Sci-Fi'),
                             (6, 'Adventure'),
                             (7, 'Romance'),
                             (8, 'Thriller'),
                             (9, 'Fantasy'),
                             (10, 'Animation');

INSERT INTO genre_movies (genres_id, movies_id) VALUES (1, 1);
INSERT INTO genre_movies (genres_id, movies_id) VALUES (1, 2);
INSERT INTO genre_movies (genres_id, movies_id) VALUES (2, 2);
INSERT INTO genre_movies (genres_id, movies_id) VALUES (2, 3);
INSERT INTO genre_movies (genres_id, movies_id) VALUES (3, 3);
INSERT INTO genre_movies (genres_id, movies_id) VALUES (3, 4);
INSERT INTO genre_movies (genres_id, movies_id) VALUES (4, 4);
INSERT INTO genre_movies (genres_id, movies_id) VALUES (4, 5);
INSERT INTO genre_movies (genres_id, movies_id) VALUES (5, 5);
INSERT INTO genre_movies (genres_id, movies_id) VALUES (5, 1);

INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (1, 5.99, 2, 1, 1);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (2, 4.50, 1, 2, 1);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (3, 3.75, 3, 3, 2);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (4, 7.00, 2, 4, 2);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (5, 2.99, 4, 5, 3);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (6, 6.50, 1, 1, 3);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (7, 5.75, 3, 2, 4);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (8, 4.20, 2, 3, 4);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (9, 3.60, 1, 4, 5);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (10, 2.50, 2, 5, 5);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (11, 10.00, 1, 4, 6);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (12, 10.00, 1, 5, 6);
INSERT INTO purchase_food (id, price, purchased_units, food_id, purchase_id) VALUES (13, 10.00, 1, 3, 6);










