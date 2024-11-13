-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-10-2024 a las 21:47:51
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
-- Base de datos: `gym`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clase`
--

CREATE TABLE `clase` (
  `ID_Clase` int(11) NOT NULL,
  `Fecha_Reserva` date DEFAULT NULL,
  `Horario` datetime DEFAULT NULL,
  `Cupo` int(11) DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `DNI_Entrenador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `clase`
--

INSERT INTO `clase` (`ID_Clase`, `Fecha_Reserva`, `Horario`, `Cupo`, `Descripcion`, `DNI_Entrenador`) VALUES
(1, NULL, '2024-10-07 09:30:00', 15, 'Musculación libre', 12312239),
(2, NULL, '2024-10-07 17:00:00', 20, 'Clase funcional aeróbica', 43189959);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `DNI_cliente` int(11) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Direccion` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`DNI_cliente`, `Nombre`, `Apellido`, `FechaNacimiento`, `Direccion`, `Email`) VALUES
(12345678, 'Juan ', 'Lopez ', '2004-02-20', 'Av Alem 2020 ', 'Juan@gmail.com'),
(20258552, 'Tomas ', 'Garcia ', '2000-10-24', 'Castelli 120 ', 'Tomas@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `DNI_Entrenador` int(11) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `entrenador`
--

INSERT INTO `entrenador` (`DNI_Entrenador`, `Nombre`, `Apellido`, `FechaNacimiento`, `Email`) VALUES
(12312239, 'Nicolas', 'Martinez', '1990-01-23', 'coachnico@gmail.com'),
(43189959, 'Martin', 'Perez', '1995-05-30', 'profeperez@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_de_pago`
--

CREATE TABLE `historial_de_pago` (
  `ID_historial` int(11) NOT NULL,
  `FechaPago` date DEFAULT NULL,
  `Monto` decimal(10,2) DEFAULT NULL,
  `Duracion` datetime DEFAULT NULL,
  `ID_pago` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `historial_de_pago`
--

INSERT INTO `historial_de_pago` (`ID_historial`, `FechaPago`, `Monto`, `Duracion`, `ID_pago`) VALUES
(1, '2024-10-02', 30000.00, '0000-00-00 00:00:00', 1),
(2, '2024-10-03', 35000.00, '0000-00-00 00:00:00', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresia`
--

CREATE TABLE `membresia` (
  `ID_membresia` int(11) NOT NULL,
  `TipoMembresia` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Monto` decimal(10,2) DEFAULT NULL,
  `Duracion` int(11) DEFAULT NULL,
  `DNI_Cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `membresia`
--

INSERT INTO `membresia` (`ID_membresia`, `TipoMembresia`, `Descripcion`, `Monto`, `Duracion`, `DNI_Cliente`) VALUES
(1, 'musculación', 'tres entrenamientos libres a la semana ', 30000.00, 1, 12345678),
(2, 'funcional', 'tres clases funcionales a la semana ', 35000.00, 1, 20258552);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_de_pago`
--

CREATE TABLE `metodo_de_pago` (
  `ID_pago` int(11) NOT NULL,
  `MetodoPago` varchar(50) DEFAULT NULL,
  `NombreTitular` varchar(50) DEFAULT NULL,
  `NumeroTarjeta` varchar(50) DEFAULT NULL,
  `FechaVencimiento` date DEFAULT NULL,
  `CodigoSeguridad` int(11) DEFAULT NULL,
  `Monto` decimal(10,2) DEFAULT NULL,
  `ID_Membresia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `metodo_de_pago`
--

INSERT INTO `metodo_de_pago` (`ID_pago`, `MetodoPago`, `NombreTitular`, `NumeroTarjeta`, `FechaVencimiento`, `CodigoSeguridad`, `Monto`, `ID_Membresia`) VALUES
(1, 'Tarjeta Credito', 'Juan', '1234 5678 9101 1123', '2024-09-15', 123, 30000.00, 1),
(2, 'Tarjeta Credito', 'Tomas', '2524 3023 1111 2023', '2025-05-25', 220, 35000.00, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva_clases`
--

CREATE TABLE `reserva_clases` (
  `ID_Reserva` int(11) NOT NULL,
  `Fecha_Reserva` date DEFAULT NULL,
  `DNI_Cliente` int(11) DEFAULT NULL,
  `ID_Clase` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `reserva_clases`
--

INSERT INTO `reserva_clases` (`ID_Reserva`, `Fecha_Reserva`, `DNI_Cliente`, `ID_Clase`) VALUES
(1, '2024-10-07', 12345678, 1),
(2, '2024-10-09', 20258552, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clase`
--
ALTER TABLE `clase`
  ADD PRIMARY KEY (`ID_Clase`),
  ADD KEY `DNI_Entrenador` (`DNI_Entrenador`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`DNI_cliente`);

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`DNI_Entrenador`);

--
-- Indices de la tabla `historial_de_pago`
--
ALTER TABLE `historial_de_pago`
  ADD PRIMARY KEY (`ID_historial`),
  ADD KEY `ID_pago` (`ID_pago`);

--
-- Indices de la tabla `membresia`
--
ALTER TABLE `membresia`
  ADD PRIMARY KEY (`ID_membresia`),
  ADD KEY `DNI_Cliente` (`DNI_Cliente`);

--
-- Indices de la tabla `metodo_de_pago`
--
ALTER TABLE `metodo_de_pago`
  ADD PRIMARY KEY (`ID_pago`),
  ADD KEY `ID_Membresia` (`ID_Membresia`);

--
-- Indices de la tabla `reserva_clases`
--
ALTER TABLE `reserva_clases`
  ADD PRIMARY KEY (`ID_Reserva`),
  ADD KEY `DNI_Cliente` (`DNI_Cliente`),
  ADD KEY `ID_Clase` (`ID_Clase`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clase`
--
ALTER TABLE `clase`
  ADD CONSTRAINT `clase_ibfk_1` FOREIGN KEY (`DNI_Entrenador`) REFERENCES `entrenador` (`DNI_Entrenador`);

--
-- Filtros para la tabla `historial_de_pago`
--
ALTER TABLE `historial_de_pago`
  ADD CONSTRAINT `historial_de_pago_ibfk_1` FOREIGN KEY (`ID_pago`) REFERENCES `metodo_de_pago` (`ID_pago`);

--
-- Filtros para la tabla `membresia`
--
ALTER TABLE `membresia`
  ADD CONSTRAINT `membresia_ibfk_1` FOREIGN KEY (`DNI_Cliente`) REFERENCES `cliente` (`DNI_cliente`);

--
-- Filtros para la tabla `metodo_de_pago`
--
ALTER TABLE `metodo_de_pago`
  ADD CONSTRAINT `metodo_de_pago_ibfk_1` FOREIGN KEY (`ID_Membresia`) REFERENCES `membresia` (`ID_membresia`);

--
-- Filtros para la tabla `reserva_clases`
--
ALTER TABLE `reserva_clases`
  ADD CONSTRAINT `reserva_clases_ibfk_1` FOREIGN KEY (`DNI_Cliente`) REFERENCES `cliente` (`DNI_cliente`),
  ADD CONSTRAINT `reserva_clases_ibfk_2` FOREIGN KEY (`ID_Clase`) REFERENCES `clase` (`ID_Clase`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
