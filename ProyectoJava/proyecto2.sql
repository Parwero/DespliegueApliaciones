CREATE DATABASE bbddpeliculas;
USE bbddpeliculas;

create table usuario(
  email VARCHAR(30) PRIMARY KEY,
  contrasenia VARCHAR(30)
);

CREATE TABLE pelicula (id_pelicula int PRIMARY KEY AUTO_INCREMENT,
						id_peliculaAPI VARCHAR(200),
                       email VARCHAR(30) NOT NULL, 
                       puntuacion int(2), 
                       titulo VARCHAR(255)NOT NULL,
                       foreign key (email) references usuario(email)
                       

);