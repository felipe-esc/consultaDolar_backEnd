CREATE TABLE [IF NOT EXISTS] cotacaoDolar (
    request_id          SERIAL PRIMARY KEY,
    request_timestamp   TIMESTAMP,
    data_cotacao        TEXT,
    cotacao_compra      FLOAT,
    cotacao_venda       FLOAT,
    data_hora_cotacao   TIMESTAMP
);