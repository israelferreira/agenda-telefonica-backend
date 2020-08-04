CREATE DATABASE IF NOT EXISTS `agenda_telefonica`
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE `agenda_telefonica`;

CREATE TABLE `contato` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL,
    `num_telefone` VARCHAR(255),
    `email` VARCHAR(255),
    `data_nascimento` DATE,
    `informacoes_extras` TEXT,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
