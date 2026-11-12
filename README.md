# Sistema de Gerenciamento de Funcionários e Folha de Pagamento

Este projeto é uma aplicação de linha de comando (CLI) em Java desenvolvida como atividade avaliativa da disciplina de orientação a objetos. O sistema gerencia o cadastro de diferentes tipos de funcionários e realiza o cálculo da folha de pagamento, aplicando rigorosamente os pilares da Orientação a Objetos e os princípios do Test-Driven Development (TDD).

## Tecnologias e Conceitos Utilizados
* **Linguagem:** Java
* **Testes:** JUnit 5 (Metodologia TDD - Red/Green/Refactor)
* **Gerenciamento de Dependências:** Maven
* **Arquitetura:** Padrão em camadas (`model`, `repository`, `service`, `view`, `exception`, `utils`)
* **Conceitos de POO:** Encapsulamento, Herança, Interfaces, Polimorfismo (Sobrecarga e Sobreposição) e Tratamento de Exceções.

## Observações Importantes sobre a Execução

### 1. Ambiente de Execução (Terminal Externo)
**Recomenda-se fortemente rodar este projeto em um terminal externo** nativo do sistema operacional (como o terminal do Linux, Windows Terminal, etc.) em vez de utilizar o console embutido de IDEs (como o do IntelliJ ou Eclipse).

**Motivo:** O sistema possui uma interface interativa que realiza a limpeza de tela a cada atualização do menu usando comandos nativos (`clear` ou `cls`). Consoles embutidos de IDEs funcionam apenas como saídas de texto simples e não emulam as variáveis de ambiente de um terminal real, o que pode gerar logs de erro na tela (como `TERM environment variable not set.`).

### 2. Massa de Dados Inicial
Para agilizar o processo de correção e facilitar os testes das funcionalidades de busca, remoção e geração de relatórios, o sistema já é inicializado com **três funcionários pré-cadastrados** na classe `Main`:
* 1 Funcionário CLT
* 1 Funcionário PJ
* 1 Funcionário Comissionado

### 3. Interface e Navegação
A navegação do sistema é feita através de um menu interativo criado na classe `utils.MenuPadrao`. Este menu é uma estrutura padrão que já utilizo em outros projetos pessoais para garantir uma interface de terminal limpa, com validação de entradas (evitando quebras do sistema ao digitar letras no lugar de números) e pausas de leitura.

## Como executar o projeto

Certifique-se de ter o **Java (JDK)** e o **Maven** instalados na sua máquina.

1. Clone este repositório:
```bash
git clone [https://github.com/TRCarv/sistema_gerenciamento_funcionarios](https://github.com/TRCarv/sistema_gerenciamento_funcionarios)
cd sistema_gerenciamento_funcionarios
```

2. Compile o projeto e baixe as dependências utilizando o Maven:
```bash
mvn clean install
```

3. Execute a classe principal através do terminal:
```bash
mvn exec:java -Dexec.mainClass="Main"
```
*(Alternativamente, você pode compilar via IDE e rodar o arquivo `.class` ou `.jar` gerado diretamente no seu terminal de preferência).*

## Como rodar os testes (TDD)
O projeto possui 100% de cobertura das regras de negócio. Para rodar a suíte de testes automatizados, execute:
```bash
mvn test
```