CREATE TABLE pessoa (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL,
    endereco_logradouro VARCHAR(50) NOT NULL,
    endereco_numero VARCHAR(6) NOT NULL,
    endereco_complemento VARCHAR(20) NOT NULL,
    endereco_bairro VARCHAR(20) NOT NULL,
    endereco_cep VARCHAR(8) NOT NULL,
    endereco_cidade VARCHAR(20) NOT NULL,
    endereco_estado VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO pessoa (nome, ativo, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro,
endereco_cep, endereco_cidade, endereco_estado)
values ('fabio vasconcelos de aquino',true,'estrada dos guarantas','47','casa','chacara santa maria','06857810',
         'itapecerica da serra','sao paulo');