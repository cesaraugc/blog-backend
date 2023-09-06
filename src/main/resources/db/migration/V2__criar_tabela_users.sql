CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(30) UNIQUE NOT NULL,
  email VARCHAR(60) UNIQUE NOT NULL,
  password VARCHAR(60) NOT NULL,
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  role VARCHAR(20)
);

insert into users(username, email, password, role) values ('cesar', 'cesar@gmail.com', '$2a$10$2y0uo6uVKgWrJctZzINTKOMlcKD0geHBaANiDGi70UmxNq1HO1qHe', 'USER');