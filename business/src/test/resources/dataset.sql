INSERT INTO client (id_card, email, full_name, password, state, birth_date, level)
VALUES
    ('1234567890', 'juan.lopez@example.com', 'Juan Lopez', 'password123', 'ACTIVE', '1990-05-14', 1),
    ('0987654321', 'maria.gomez@example.com', 'Maria Gomez', 'password456', 'ACTIVE', '1985-08-21', 2),
    ('1122334455', 'pedro.ramirez@example.com', 'Pedro Ramirez', 'password789', 'ACTIVE', '1992-01-30', 1),
    ('2233445566', 'ana.sanchez@example.com', 'Ana Sanchez', 'password012', 'ACTIVE', '1988-11-15', 3),
    ('3344556677', 'laura.martinez@example.com', 'Laura Martinez', 'password345', 'ACTIVE', '1995-07-09', 1);

INSERT INTO city (city_name, department)
VALUES
    ('Bogotá', 'NORTE_DE_SANTANDER'),
    ('Medellín', 'ANTIOQUIA'),
    ('Cali', 'VALLE_DEL_CAUCA'),
    ('Barranquilla', 'ATLANTICO'),
    ('Cartagena', 'BOLIVAR');

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