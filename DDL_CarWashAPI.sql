CREATE DATABASE api_lavacao;
USE api_lavacao;

-- TABELA MARCA
CREATE TABLE marca (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

-- TABELA COR
CREATE TABLE cor (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

-- TABELA MODELO
CREATE TABLE modelo (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL,
    marca_id INT NOT NULL,
    tipo_combustivel ENUM('GASOLINA', 'ETANOL', 'FLEX', 'DIESEL', 'GNV', 'OUTROS') NOT NULL,
    potencia INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_modelo_marca FOREIGN KEY (marca_id) REFERENCES marca(id)
) ENGINE = InnoDB;


-- TABELA CLIENTE
CREATE TABLE cliente (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    celular VARCHAR(15) NOT NULL,
    email VARCHAR(150) NOT NULL,
    data_cadastro DATE NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

-- TABELA VEICULO
CREATE TABLE veiculo (
    id INT NOT NULL AUTO_INCREMENT,
    placa VARCHAR(255),
    observacao VARCHAR(255),
    cliente_id INT NOT NULL,
    cor_id INT NOT NULL,
    modelo_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_veiculo_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    CONSTRAINT fk_veiculo_cor FOREIGN KEY (cor_id) REFERENCES cor(id),
    CONSTRAINT fk_veiculo_modelo FOREIGN KEY (modelo_id) REFERENCES modelo(id)
) ENGINE = InnoDB;
