-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-09-2021 a las 04:05:41
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `canguros_para_apuros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anunciocanguros`
--

CREATE TABLE `anunciocanguros` (
  `id` bigint(20) NOT NULL,
  `descripcion` text NOT NULL,
  `fecha_final` datetime NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `horario` varchar(150) NOT NULL,
  `tarifa` double NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `anunciante_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `anunciocanguros`
--

INSERT INTO `anunciocanguros` (`id`, `descripcion`, `fecha_final`, `fecha_inicio`, `horario`, `tarifa`, `titulo`, `anunciante_id`) VALUES
(5, 'weewsd dsds dd', '2021-08-22 00:00:00', '2021-08-06 00:00:00', 'sfdg', 9, 'weewew', 20),
(6, 'drt etrtthujhjhjjh', '2021-08-30 00:00:00', '2021-08-15 00:00:00', 'ds gdgghg', 9, 'Anuncio Juan', 20),
(10, 'dsa gghdty juyk yg', '2021-08-31 00:00:00', '2021-08-17 00:00:00', 'w rsrfd', 8, 'Anuncio Padre v2', 20),
(11, 'Esto es un anuncio', '2021-08-21 00:00:00', '2021-08-14 00:00:00', 'Flexibilidad por la tarde', 9, 'Anuncio de Canguro', 27),
(12, 'Prueba de anuncio canguro', '2021-09-19 00:00:00', '2021-08-18 00:00:00', 'Flexible por la mañana', 9, 'Prueba', 27),
(15, 'eertyui', '2021-10-23 00:00:00', '2021-10-14 00:00:00', 'De 18:00 a 22:00', 15, 'Nuevo', 31);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anuncioprogenitores`
--

CREATE TABLE `anuncioprogenitores` (
  `id` bigint(20) NOT NULL,
  `descripcion` text NOT NULL,
  `fecha_final` datetime NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `horario` varchar(150) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `anunciante_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `anuncioprogenitores`
--

INSERT INTO `anuncioprogenitores` (`id`, `descripcion`, `fecha_final`, `fecha_inicio`, `horario`, `titulo`, `anunciante_id`) VALUES
(5, 'Necesito a un canguro para mi hijo de 3 años en horario de tarde.', '2021-11-11 00:00:00', '2021-10-08 00:00:00', 'De 18:00 a 22:00', 'Niñera para horas de 18:00 a 22:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name_rol` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `name_rol`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_KANG'),
(3, 'ROLE_PROG');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `descripcion` text NOT NULL,
  `email` varchar(130) NOT NULL,
  `nombre` varchar(130) NOT NULL,
  `password` varchar(255) NOT NULL,
  `telefono` varchar(130) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `apellidos`, `descripcion`, `email`, `nombre`, `password`, `telefono`) VALUES
(1, 'Martos', 'Madre de Juanito y Rocío.', 'apolonia.martos@gmail.com', 'Apolonia', '$2a$10$Oma3pVy4WB2NUmfbHMe7COFK3./nZ.nqBKLtHduL2pztxrQzikaBC', '645326800'),
(2, 'admin', 'Admin del servidor.', 'admin@gmail.com', 'admin', '$2a$10$MjYLGP2EmmpAC.7Mw1uvFObKpDnbno/LM.roBo9PsOMFy33rtl5fC', '645326854'),
(20, 'Nuñez', 'ev 5vb tr ygd', 'juan.nunez@gmail.com', 'Juan', '$2a$10$eUW2FqRoWhjOU5aHOAaEteBCzNChCwwZoPWfqx3aSyXxmWdNHEmOK', '6745433'),
(27, 'Bartolomé', 'Soy un canguro :>', 'antonio.bartolo@gmail.com', 'Antonio', '$2a$10$bBFj7FzrgxIs8WWw7jUybuxC49E02pIwJd/JNnilv4mYb3qtZZ7KW', '654232345'),
(31, 'López', 'Soy un canguro muy bueno', 'anto@gmail.com', 'Anto', '$2a$10$G95Q2qxeKIBogw/hW.GpQ.EGZxRm4qaRY6tIctfZoUeBSZAFJma.y', '666666666');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `usuario_id` bigint(20) NOT NULL,
  `rol_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`usuario_id`, `rol_id`) VALUES
(1, 3),
(2, 1),
(20, 2),
(27, 2),
(31, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anunciocanguros`
--
ALTER TABLE `anunciocanguros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3qe29mm2na0qnq3cahva1tcrw` (`anunciante_id`);

--
-- Indices de la tabla `anuncioprogenitores`
--
ALTER TABLE `anuncioprogenitores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr274fp6lol0cbtnbcbcs15il5` (`anunciante_id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_fyudxc8d4jyr85si7akpeu678` (`name_rol`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`usuario_id`,`rol_id`),
  ADD KEY `FKe3kd49gu3mhj2ty5kl44qsytp` (`rol_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anunciocanguros`
--
ALTER TABLE `anunciocanguros`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `anuncioprogenitores`
--
ALTER TABLE `anuncioprogenitores`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `anunciocanguros`
--
ALTER TABLE `anunciocanguros`
  ADD CONSTRAINT `FK3qe29mm2na0qnq3cahva1tcrw` FOREIGN KEY (`anunciante_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `anuncioprogenitores`
--
ALTER TABLE `anuncioprogenitores`
  ADD CONSTRAINT `FKr274fp6lol0cbtnbcbcs15il5` FOREIGN KEY (`anunciante_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `FKe3kd49gu3mhj2ty5kl44qsytp` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKktsemf1f6awjww4da0ocv4n32` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
