# Desafio Itaú Backend

## Link desafio : https://github.com/feltex/desafio-itau-backend

## Resumo: 

Criação de uma API Rest, utilizando de Java e SpringBoot, que recebe Transações e retorna Estatísticas sob essas transações:

### **POST:/transacao**
* Recebe um `valor` e uma `dataHora` para criar uma transação em ** memória **
* A transação retorna 422 sem nenhum corpo caso:
* - Aconteça no futuro
  - Tenha valor negativo
* Retorna 201 sem nenhum corpo caso:
  - Aconteca em qualquer momento do passado
  - Possua valor igual ou maior que 0
  

### **DELETE:/transacao**
* Apaga todas as transações em memória

### **GET:/estatística**
* Retorna 200 com todas as estatísticas que aconteceram nos últimos 60 segundos.
  ```
  {
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
  }

  ```
