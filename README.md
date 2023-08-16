# ConsultaDolar - BackEnd

Este projeto foi desenvolvido para um processo seletivo utilizando Java 11 e o framework Quarkus, também como uma forma de aprender uma nova ferramenta para o desenvolvimento em Java para web.

O principal objetivo do projeto é implementar um microsserviço simples que recebe uma chamada REST, a processa, realiza uma consulta à [api pública de consulta do Banco Central](https://dadosabertos.bcb.gov.br/dataset/dolar-americano-usd-todos-os-boletins-diarios), salva no banco de dados e retorna o preço do dólar no dia especificado.

### Ideias para possíveis melhorias e continuações do projeto
- Adicionar mappers para exceptions e erros na api
- buscar as cotações salvas da api na camada do gateway diminuindo chamadas, possivelmente ganhando tempo.
- adicionar cache às buscas na camada do gateway.
- trabalhar melhor nas configurações da api, como por exemplo adicionar validações dos parametros da request.
- adicionar módulo de busca para outras moedas e outras consultas ao Dólar (períodos por exemplo).
- melhorar lógica de persistência das cotações evitando duplicações (seria necessária uma remodelagem da tabela para manter o registro das requisições).
- configurar health e métricas.
- request filters (logging por exemplo).