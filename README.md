# Teste Prático de Programação

Considerando que uma indústria possui os seguintes funcionários, desenvolva um projeto em **Java** com os requisitos abaixo:

## Requisitos do Projeto

### 1. Classe Pessoa
- Atributos:
  - `nome` (String)
  - `dataNascimento` (LocalDate)

### 2. Classe Funcionário
- Deve **estender** a classe `Pessoa`.
- Atributos adicionais:
  - `salario` (BigDecimal)
  - `funcao` (String)

### 3. Classe Principal
Deve executar as seguintes ações:

1. Inserir todos os funcionários, na mesma ordem e informações da tabela fornecida.
2. Remover o funcionário **"João"** da lista.
3. Imprimir todos os funcionários com todas as suas informações, considerando:
   - Data exibida no formato **dd/MM/yyyy**.
   - Valores numéricos exibidos com **separador de milhar como ponto** e **decimal como vírgula**.
4. Aplicar **10% de aumento salarial** a todos os funcionários e atualizar a lista.
5. Agrupar os funcionários por **função** em um `Map`:
   - Chave → função  
   - Valor → lista de funcionários
6. Imprimir os funcionários agrupados por função.
7. Imprimir os funcionários que fazem aniversário nos meses **10** e **12**.
8. Imprimir o funcionário com a **maior idade**, exibindo os atributos:
   - Nome
   - Idade
9. Imprimir a lista de funcionários em **ordem alfabética**.
10. Imprimir o **total dos salários** de todos os funcionários.
11. Imprimir **quantos salários mínimos** cada funcionário recebe, considerando o salário mínimo de **R$ 1.212,00**.
