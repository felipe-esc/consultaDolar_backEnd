# ConsultaDolar - BackEnd

Este projeto foi desenvolvido para um processo seletivo utilizando o framework Quarkus, também como uma forma de aprender uma nova ferramenta.

O principal objetivo do projeto é implementar um microsserviço simples que recebe uma chamada REST, a processa, realiza uma consulta à [api pública de consulta do Banco Central](https://dadosabertos.bcb.gov.br/dataset/dolar-americano-usd-todos-os-boletins-diarios), salva no banco de dados e retorna o preço do dólar no dia especificado.