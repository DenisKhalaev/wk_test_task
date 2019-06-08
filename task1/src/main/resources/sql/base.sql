DROP DATABASE ctb;

CREATE DATABASE ctb
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

--
-- Установка базы данных по умолчанию
--
USE ctb;

--
-- Описание для таблицы balance
--
DROP TABLE IF EXISTS cash_flow;
CREATE TABLE cash_flow (
  id_cash_flow BIGINT(20) NOT NULL AUTO_INCREMENT,
  client_id BIGINT(20) NOT NULL,
  date DATETIME NOT NULL,
  pay DOUBLE NOT NULL DEFAULT 0,
  refill DOUBLE NOT NULL DEFAULT 0,
  PRIMARY KEY (id_cash_flow)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

--
-- Описание для таблицы client
--
DROP TABLE IF EXISTS client;
CREATE TABLE client (
  id_client BIGINT(20) NOT NULL AUTO_INCREMENT,
  name_client VARCHAR(50) NOT NULL,
  tariff_id BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (id_client)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

--
-- Описание для таблицы tariff
--
DROP TABLE IF EXISTS tariff;
CREATE TABLE tariff (
  id_tariff BIGINT(20) NOT NULL AUTO_INCREMENT,
  name_tariff VARCHAR(50) NOT NULL,
  charge DOUBLE NOT NULL,
  PRIMARY KEY (id_tariff)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

--
-- Вывод данных для таблицы balance
--
INSERT INTO cash_flow VALUES
                           (1, 1, '2019-06-06 01:16:58', 0, 35),
                           (2, 1, '2019-06-06 01:18:08', 15, 0),
                           (3, 1, '2019-06-06 01:18:35', 3, 0),
                           (4, 2, '2019-06-06 01:19:08', 0, 10),
                           (5, 2, '2019-06-06 01:19:27', 5.5, 0),
                           (6, 3, '2019-06-06 01:19:36', 0, 5),
                           (7, 3, '2019-06-06 01:20:09', 3, 0);

--
-- Вывод данных для таблицы client
--
INSERT INTO client VALUES
                          (1, 'Denis', 1),
                          (2, 'Maks', 2),
                          (3, 'Anton', 3);

--
-- Вывод данных для таблицы tariff
--
INSERT INTO tariff VALUES
                          (1, 'Super', 15),
                          (2, 'Econom', 5.5),
                          (3, 'Pensionary', 3);

