CREATE TABLE pessoa (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    is_ativo BOOLEAN NOT NULL,
    logradouro VARCHAR(50) NOT NULL,
    numero VARCHAR(6) NOT NULL,
    complemento VARCHAR(20) NOT NULL,
    bairro VARCHAR(20) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    cidade VARCHAR(20) NOT NULL,
    estado VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, is_ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values
 ('fabio vasconcelos de aquino',true,'estrada dos guarantas','47','casa','chacara santa maria','06857810',
 'itapecerica da serra','sao paulo');