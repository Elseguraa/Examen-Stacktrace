-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-06-2023 a las 02:37:14
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `divisas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `billetera`
--

CREATE TABLE `billetera` (
  `id_billetera` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `billetera_moneda`
--

CREATE TABLE `billetera_moneda` (
  `id_billetera_moneda` int(11) NOT NULL,
  `id_billetera` int(11) NOT NULL,
  `id_moneda` int(11) NOT NULL,
  `balance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moneda`
--

CREATE TABLE `moneda` (
  `id_moneda` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `valor` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operaciones`
--

CREATE TABLE `operaciones` (
  `id_operaciones` int(11) NOT NULL,
  `id_de_billetera` int(11) NOT NULL,
  `id_para_billetera` int(11) NOT NULL,
  `id_de_moneda` int(11) NOT NULL,
  `id_para_moneda` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `tipo_operacion` varchar(30) NOT NULL,
  `fecha_operacion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `dni` varchar(30) NOT NULL,
  `sexo` varchar(30) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `email` varchar(70) NOT NULL,
  `numero` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `billetera`
--
ALTER TABLE `billetera`
  ADD PRIMARY KEY (`id_billetera`),
  ADD KEY `billetera_usuario` (`id_usuario`);

--
-- Indices de la tabla `billetera_moneda`
--
ALTER TABLE `billetera_moneda`
  ADD PRIMARY KEY (`id_billetera_moneda`),
  ADD KEY `billetera.moneda_billetera` (`id_billetera`),
  ADD KEY `billetera.moneda_moneda` (`id_moneda`);

--
-- Indices de la tabla `moneda`
--
ALTER TABLE `moneda`
  ADD PRIMARY KEY (`id_moneda`);

--
-- Indices de la tabla `operaciones`
--
ALTER TABLE `operaciones`
  ADD PRIMARY KEY (`id_operaciones`),
  ADD KEY `operaciones_billetera1` (`id_de_billetera`),
  ADD KEY `operaciones_billetera2` (`id_para_billetera`),
  ADD KEY `operaciones_moneda1` (`id_de_moneda`),
  ADD KEY `operaciones_moneda2` (`id_para_moneda`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `billetera`
--
ALTER TABLE `billetera`
  MODIFY `id_billetera` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `billetera_moneda`
--
ALTER TABLE `billetera_moneda`
  MODIFY `id_billetera_moneda` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `moneda`
--
ALTER TABLE `moneda`
  MODIFY `id_moneda` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `operaciones`
--
ALTER TABLE `operaciones`
  MODIFY `id_operaciones` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `billetera`
--
ALTER TABLE `billetera`
  ADD CONSTRAINT `billetera_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `billetera_moneda`
--
ALTER TABLE `billetera_moneda`
  ADD CONSTRAINT `billetera.moneda_billetera` FOREIGN KEY (`id_billetera`) REFERENCES `billetera` (`id_billetera`),
  ADD CONSTRAINT `billetera.moneda_moneda` FOREIGN KEY (`id_moneda`) REFERENCES `moneda` (`id_moneda`);

--
-- Filtros para la tabla `operaciones`
--
ALTER TABLE `operaciones`
  ADD CONSTRAINT `operaciones_billetera1` FOREIGN KEY (`id_de_billetera`) REFERENCES `billetera` (`id_billetera`),
  ADD CONSTRAINT `operaciones_billetera2` FOREIGN KEY (`id_para_billetera`) REFERENCES `billetera` (`id_billetera`),
  ADD CONSTRAINT `operaciones_moneda1` FOREIGN KEY (`id_de_moneda`) REFERENCES `moneda` (`id_moneda`),
  ADD CONSTRAINT `operaciones_moneda2` FOREIGN KEY (`id_para_moneda`) REFERENCES `moneda` (`id_moneda`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
