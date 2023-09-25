-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-09-2023 a las 21:48:06
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidadulp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) VALUES
(1, 32665222, 'Perez', 'Raton', '2005-05-01', 1),
(2, 50452233, 'Rodriguez', 'Maria', '2004-06-01', 1),
(3, 45123568, 'Miranda', 'Juan Manuel', '2005-03-12', 1),
(4, 45178653, 'Molina', 'Héctor Ignacio', '2005-03-15', 1),
(5, 45986674, 'Aguero', 'Marcelo Uriel', '2005-04-29', 0),
(6, 42862145, 'Aguilera', 'Carlos Mariano', '2002-05-07', 1),
(7, 43974074, 'Bassi', 'María Florencia', '2003-12-29', 0),
(8, 40347965, 'Carrizo', 'Érica Vanesa', '2000-07-24', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `idInscripto` int(11) NOT NULL,
  `nota` double NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`idInscripto`, `nota`, `idAlumno`, `idMateria`) VALUES
(1, 0, 2, 3),
(3, 0, 3, 5),
(7, 0, 3, 4),
(9, 0, 4, 20),
(10, 0, 2, 6),
(11, 0, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `anio` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `anio`, `estado`) VALUES
(1, 'Lengua', 1, 1),
(2, 'Matemática', 1, 1),
(3, 'Teatro y Artes Visuales', 1, 1),
(4, 'Música', 1, 1),
(5, 'Educación Física', 1, 1),
(6, 'Formación Ética y Ciudadana', 1, 1),
(7, 'Lengua Extranjera:Inglés', 1, 1),
(8, 'Matemática Aplicada', 2, 1),
(9, 'Lengua', 2, 1),
(10, 'Física I', 2, 1),
(11, 'Química I', 2, 1),
(12, 'Educación Física', 2, 1),
(13, 'Taller:Carpintería', 2, 1),
(14, 'Historia I', 2, 1),
(15, 'Geografía', 2, 1),
(16, 'Lengua y Literatura', 3, 1),
(17, 'Matemática Aplicada II', 3, 1),
(18, 'Taller:Mecánica', 3, 1),
(19, 'Historia II', 3, 1),
(20, 'Dibujo Técnico Asistido', 4, 1),
(21, 'Máquinas y Herramientas', 4, 1),
(22, 'Procesos Productivos', 4, 1),
(23, 'Lengua Extranjera: Inglés', 4, 1),
(24, 'Marco Jurídico', 4, 1),
(25, 'Educación Física', 4, 1),
(26, 'Instalaciones Complementarias', 5, 1),
(27, 'Cómputo y Presupuesto', 5, 1),
(28, 'Diseño de Muebles', 5, 1),
(29, 'Diseño Edilicio', 6, 1),
(30, 'Práctica Profesionalizante', 6, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `test`
--

CREATE TABLE `test` (
  `idTest` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `test`
--

INSERT INTO `test` (`idTest`, `nombre`, `estado`) VALUES
(1, 'Juan Perez', 1),
(2, 'Pedro Miranda', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `dni_2` (`dni`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`idInscripto`),
  ADD KEY `idMateria` (`idMateria`) USING BTREE,
  ADD KEY `idAlumno` (`idAlumno`) USING BTREE;

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`);

--
-- Indices de la tabla `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`idTest`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `idInscripto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `test`
--
ALTER TABLE `test`
  MODIFY `idTest` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
