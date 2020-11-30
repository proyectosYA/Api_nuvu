-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2020 a las 02:21:21
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nuvu_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cedula` int(14) NOT NULL,
  `nombre` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `apellidos` varchar(40) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` int(15) DEFAULT NULL,
  `usuario` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `contrasena` varchar(250) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cedula`, `nombre`, `apellidos`, `telefono`, `usuario`, `contrasena`) VALUES
(24534023, 'leonel', 'messi', 23423423, 'messi10', '233334'),
(25987543, 'james', 'rodriguez', 318338732, 'james10', 'jamesR10'),
(32122012, 'ramon', 'valdez', 318338732, 'ramonV42', 'ramon_22'),
(32432343, 'cristiano', 'aveiro', 23323222, 'cr723', 'cr7123'),
(34543213, 'pedro', 'coral', 323098765, 'pedrinchi', 'qwerty1'),
(45876345, 'sofia', 'diaz granados', 310987654, 'sofi12', '1234sofi'),
(76534212, 'karmenza', 'espinoza', 350987324, 'Karmenzita098', 'colombaKarme231'),
(1062234543, 'radamel falcao', 'falcao garcia', 310987652, 'ramonV42', 'rada1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `IdTarjeta` int(16) NOT NULL,
  `fechaVencimiento` date NOT NULL,
  `numeroTargeta` bigint(18) NOT NULL,
  `cvv` int(5) DEFAULT NULL,
  `nombre` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `identificacion` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`IdTarjeta`, `fechaVencimiento`, `numeroTargeta`, `cvv`, `nombre`, `identificacion`) VALUES
(1, '2020-11-26', 2147483647, 3453, 'Pedro', 34543213),
(6, '2028-11-28', 3615535874488365, 5641, 'ramon', 32122012),
(11, '2028-11-29', 9415768333339893, 8522, 'cristiano', 32432343);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`IdTarjeta`),
  ADD KEY `identificacion` (`identificacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  MODIFY `IdTarjeta` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `tarjeta_ibfk_1` FOREIGN KEY (`identificacion`) REFERENCES `cliente` (`cedula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
