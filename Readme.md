Prerrequisitos
1. Tener instalado maven 3.9.x
2. Tener instalado java 17
3. Tener instalado mysql 8.x


Para la ejecucion

1. Ejecutar en el orden en el que estan colocados los siguientes comandos en el motor de BD MySql en cualquier distribucion de la version 8.

create database gestion_escolar;
-- drop database gestion_escolar;
use gestion_escolar;
show tables;
-- inserts para estudiante
INSERT INTO `estudiante` (`email`, `nombre`) VALUES ('juan.perez@gmail.com', 'Juan Perez');
INSERT INTO `estudiante` (`email`, `nombre`) VALUES ('maria.lopez@yahoo.com', 'Maria Lopez');
INSERT INTO `estudiante` (`email`, `nombre`) VALUES ('carlos.gomez@hotmail.com', 'Carlos Gomez');
INSERT INTO `estudiante` (`email`, `nombre`) VALUES ('ana.martinez@outlook.com', 'Ana Martinez');
INSERT INTO `estudiante` (`email`, `nombre`) VALUES ('pedro.sanchez@university.edu', 'Pedro Sanchez');

-- inserts para profesor
INSERT INTO `profesor` (`email`, `nombre`) VALUES ('jose.fernandez@school.edu', 'Jose Fernandez');
INSERT INTO `profesor` (`email`, `nombre`) VALUES ('lucia.castillo@school.edu', 'Lucia Castillo');
INSERT INTO `profesor` (`email`, `nombre`) VALUES ('martin.rodriguez@school.edu', 'Martin Rodriguez');

-- insertr para clase
INSERT INTO `clase` (`nombre`, `profesor_id`) VALUES ('Matemáticas', 1);
INSERT INTO `clase` (`nombre`, `profesor_id`) VALUES ('Historia', 2);
INSERT INTO `clase` (`nombre`, `profesor_id`) VALUES ('Ciencias', 3);
INSERT INTO `clase` (`nombre`, `profesor_id`) VALUES ('Lengua y Literatura', 1);
INSERT INTO `clase` (`nombre`, `profesor_id`) VALUES ('Física', 3);


-- inserts para clase estudiante
INSERT INTO `clase_estudiante` (`clase_id`, `estudiante_id`) VALUES (1, 1); -- Juan Perez en Matemáticas
INSERT INTO `clase_estudiante` (`clase_id`, `estudiante_id`) VALUES (1, 2); -- Maria Lopez en Matemáticas
INSERT INTO `clase_estudiante` (`clase_id`, `estudiante_id`) VALUES (2, 3); -- Carlos Gomez en Historia
INSERT INTO `clase_estudiante` (`clase_id`, `estudiante_id`) VALUES (3, 4); -- Ana Martinez en Ciencias
INSERT INTO `clase_estudiante` (`clase_id`, `estudiante_id`) VALUES (4, 5); -- Pedro Sanchez en Lengua y Literatura
INSERT INTO `clase_estudiante` (`clase_id`, `estudiante_id`) VALUES (5, 1); -- Juan Perez en Física



-- inserts para nota
INSERT INTO `nota` (`examen`, `promedio_final`, `proyecto`, `tarea`, `clase_id`, `estudiante_id`)
VALUES (85.5, 90.0, 88.0, 92.0, 1, 1); -- Juan Perez en Matemáticas

INSERT INTO `nota` (`examen`, `promedio_final`, `proyecto`, `tarea`, `clase_id`, `estudiante_id`)
VALUES (78.0, 80.5, 82.0, 85.0, 1, 2); -- Maria Lopez en Matemáticas

INSERT INTO `nota` (`examen`, `promedio_final`, `proyecto`, `tarea`, `clase_id`, `estudiante_id`)
VALUES (88.0, 86.5, 90.0, 89.0, 2, 3); -- Carlos Gomez en Historia

INSERT INTO `nota` (`examen`, `promedio_final`, `proyecto`, `tarea`, `clase_id`, `estudiante_id`)
VALUES (92.0, 94.0, 95.0, 90.0, 3, 4); -- Ana Martinez en Ciencias

INSERT INTO `nota` (`examen`, `promedio_final`, `proyecto`, `tarea`, `clase_id`, `estudiante_id`)
VALUES (80.0, 82.0, 84.0, 81.0, 4, 5); -- Pedro Sanchez en Lengua y Literatura


-- inserts para examen
INSERT INTO `examen` (`asistencia_requerida`, `fecha_examen`, `nombre`, `clase_id`)
VALUES (80.0, '2024-11-15', 'Examen Parcial de Matemáticas', 1); -- Examen para la clase de Matemáticas

INSERT INTO `examen` (`asistencia_requerida`, `fecha_examen`, `nombre`, `clase_id`)
VALUES (75.0, '2024-12-01', 'Examen Final de Historia', 2); -- Examen para la clase de Historia

INSERT INTO `examen` (`asistencia_requerida`, `fecha_examen`, `nombre`, `clase_id`)
VALUES (85.0, '2024-11-20', 'Examen de Ciencias', 3); -- Examen para la clase de Ciencias

INSERT INTO `examen` (`asistencia_requerida`, `fecha_examen`, `nombre`, `clase_id`)
VALUES (90.0, '2024-12-05', 'Examen Parcial de Lengua y Literatura', 4); -- Examen para la clase de Lengua y Literatura

INSERT INTO `examen` (`asistencia_requerida`, `fecha_examen`, `nombre`, `clase_id`)
VALUES (80.0, '2024-11-25', 'Examen de Física', 5); -- Examen para la clase de Física


2. Ejecutar desde el ide elegido el proyecto 

3. Dirigirse a http://localhost:8080/swagger-ui/index.html#/

4. Realizar las pruebas necesarias
