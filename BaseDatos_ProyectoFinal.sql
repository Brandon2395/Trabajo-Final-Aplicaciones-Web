/*Se crea la base de datos */
drop schema if exists TrabajoFinal;
CREATE SCHEMA TrabajoFinal;

USE TrabajoFinal;

/*Se crea un usuario para la base de datos"*/
CREATE USER 'admin01'@'%' IDENTIFIED BY 'admin01';

proyectos/*Se asignan los prvilegios sobre la base de datos al usuario creado */
GRANT ALL PRIVILEGES ON TrabajoFinal.* TO 'admin01'@'%';

/*Se crea la tabla proyectos*/
CREATE TABLE proyectos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50),
    descripcion VARCHAR(100),
    progreso int,
    comentarios VARCHAR(100),
    activo bool)
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8mb4;
    
    /*INSERT*/
INSERT INTO TrabajoFinal.proyectos(id,nombre,descripcion,progreso,comentarios,activo) VALUES 
('1', 'prueba1','prueba1', 40, 'prueba1', true), 
('2', 'prueba2','prueba2', 40, 'prueba2', true), 
('3', 'prueba3','prueba2', 40, 'prueba3', true);