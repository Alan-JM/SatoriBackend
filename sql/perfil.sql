CREATE DATABASE IF NOT EXISTS perfil_app;
USE perfil_app;

CREATE TABLE IF NOT EXISTS trabajadores (
  codigo VARCHAR(10) PRIMARY KEY,
  rol ENUM('1','2','3')
);

CREATE TABLE IF NOT EXISTS diosi (
  codigo VARCHAR(10) PRIMARY KEY,
  contrasena VARCHAR(10)
);

DROP TABLE IF EXISTS perfilRegistro;

CREATE TABLE perfilRegistro (
  telefono VARCHAR(10) PRIMARY KEY,
  nombre VARCHAR(100),
  imagen LONGBLOB,
  fecha_nacimiento DATE,
  curp VARCHAR(18),
  nss VARCHAR(11),
  correo VARCHAR(50),
  contrasena VARCHAR(20),
  codigo VARCHAR(10),
  FOREIGN KEY (codigo) REFERENCES trabajadores(codigo)
);

ALTER TABLE perfilregistro CHANGE fechaNacimiento fecha_nacimiento DATE;

CREATE TABLE IF NOT EXISTS historialRegistros (
  id INT AUTO_INCREMENT PRIMARY KEY,
  telefono VARCHAR(10),
  nombre VARCHAR(100),
  fechaRegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER $$

CREATE TRIGGER registrarHistorial
AFTER INSERT ON perfilRegistro
FOR EACH ROW
BEGIN
  INSERT INTO historialRegistros (telefono, nombre)
  VALUES (NEW.telefono, NEW.nombre);
END$$

DELIMITER ;

-- Fin del registro 

-- Bitacora

CREATE TABLE UnidadECO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    unidad VARCHAR(50) NOT NULL,
    placas VARCHAR(10) NOT NULL
);

CREATE TABLE Ayudantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Inicio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente VARCHAR(100) NOT NULL,
    destino VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    telefono_perfilregistro VARCHAR(20) NOT NULL, -- FK lógica hacia perfilregistro
    id_ayudantes INT,
    id_UnidadECO INT,
    FOREIGN KEY (id_ayudantes) REFERENCES Ayudantes(id),
    FOREIGN KEY (id_UnidadECO) REFERENCES UnidadECO(id)
);

CREATE TABLE Kilometraje (
    id INT AUTO_INCREMENT PRIMARY KEY,
    odometroInicial DECIMAL(10,2) NOT NULL,
    odometroFinal DECIMAL(10,2) NOT NULL,
    distanciaTotal DECIMAL(10,2) NOT NULL,
    combustibleConsumido DECIMAL(10,2),
    rendimiento DECIMAL(10,2)
);

CREATE TABLE Folio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    folio VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE GastosT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    combustible DECIMAL(10,2),
    casetas DECIMAL(10,2),
    totalT DECIMAL(12,2)
);

CREATE TABLE GastosE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    combustible DECIMAL(10,2),
    casetas DECIMAL(10,2),
    comidas DECIMAL(10,2),
    reparaciones DECIMAL(10,2),
    maniobras DECIMAL(10,2),
    transitofederal DECIMAL(10,2),
    totale DECIMAL(12,2),
    id_gasto INT
);

CREATE TABLE Otros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    gasto VARCHAR(100) NOT NULL,
    costo DECIMAL(10,2) NOT NULL,
    id_gastoE INT,
    FOREIGN KEY (id_gastoE) REFERENCES GastosE(id)
);

CREATE TABLE GastoTotal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_GastosT INT,
    id_GastosE INT,
    gastoTotal DECIMAL(12,2),
    FOREIGN KEY (id_GastosT) REFERENCES GastosT(id),
    FOREIGN KEY (id_GastosE) REFERENCES GastosE(id)
);

CREATE TABLE Bitacora (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_Inicio INT,
    id_kilometraje INT,
    id_gastototal INT,
    id_folio INT,
    FOREIGN KEY (id_Inicio) REFERENCES Inicio(id),
    FOREIGN KEY (id_kilometraje) REFERENCES Kilometraje(id),
    FOREIGN KEY (id_gastototal) REFERENCES GastoTotal(id),
    FOREIGN KEY (id_folio) REFERENCES Folio(id)
);

