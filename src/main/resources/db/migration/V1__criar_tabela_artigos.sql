CREATE TABLE artigos (
  id SERIAL PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  texto TEXT NOT NULL
);

insert into artigos (titulo, texto) values ('teste titulo migration', 'esta eh uma migracao do flyway');

insert into artigos (titulo, texto) values ('como fazer um blog', 'esta eh um artigo que ira ensinar...');