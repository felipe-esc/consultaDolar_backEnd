CREATE TABLE cotacaoDolar (
    request_id          SERIAL PRIMARY KEY,
    timestamp           TEXT NOT NULL,
    data_cotacao        TEXT,
    cotacao_compra      TEXT,
    cotacao_venda       TEXT,
    data_hora_cotacao   TEXT
);