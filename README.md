# GCPF - Gerador e Validador de CPF

O GCPF é uma aplicação em Java que oferece a possibilidade de gerar CPF e validar se é verdadeiro ou não.

## Como usar o GCPF

### Requisitos

* Tenha Java 19 instalado

### Utilizando o GCPF

Aqui está um exemplo de como usar

- Gerar CPF aleatório:

  ```
  java -jar <nome do arquivo JAR> -g
  ```

- Checar se o CPF é válido:

  ```
  java -jar <nome do arquivo JAR> -v
  ```
  
- Exibir ajuda:

  ```
  java -jar <nome do arquivo JAR>
  ```
### Opções de Linha de Comando

- `-g` ou `--generate`: Gera um CPF aleatório.
- `-v` ou `--validate`: Valida um CPF.

### Observações

- Certifique-se de fornecer um CPF válido ao usar a opção `-v`.
- Será adicionado possibilidade de escolher qual estado o CPF será gerado futuramente.
- Ao gerar CPFs, a região é indicada na saída.

## Contribuindo

Se encontrar problemas ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_. Seu feedback é sempre bem-vindo!