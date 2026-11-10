Atividade Avaliativa – Programação Orientada a Objetos em Java
Atividade prática avaliativa
Desenvolvimento em Java
1. Tema: Sistema de Gerenciamento de Funcionários e Folha de Pagamento
   Contextualização

Uma empresa deseja desenvolver um sistema para gerenciar seus funcionários e realizar o cálculo de suas respectivas remunerações.

Atualmente, a empresa possui diferentes categorias de funcionários, cada uma com suas próprias regras de remuneração. O sistema deverá permitir cadastrar funcionários, consultar informações, calcular salários e gerar relatórios com os dados dos colaboradores.

O desenvolvimento deverá utilizar os principais conceitos de Programação Orientada a Objetos, além de aplicar boas práticas de organização de código, tratamento de exceções e Desenvolvimento Orientado a Testes (TDD).
2. Requisitos funcionais

O sistema deverá implementar as seguintes funcionalidades:

    Cadastrar funcionários.

    Listar todos os funcionários cadastrados.

    Buscar um funcionário pelo seu identificador.

    Remover um funcionário cadastrado.

    Calcular a remuneração de cada funcionário.

    Exibir os dados completos de um funcionário.

    Gerar um relatório contendo todos os funcionários e seus respectivos salários.

    Calcular o total da folha de pagamento da empresa.

3. Requisitos de orientação a objetos

O sistema deverá obrigatoriamente contemplar os seguintes requisitos:
3.1. Encapsulamento

    Todos os atributos das classes deverão ser privados (private).

    Implementar métodos getters e setters quando necessário.

    Implementar validações nos métodos setters e construtores.

    Não permitir que os atributos sejam modificados diretamente de outras classes.

3.2. Herança e abstração

Criar uma classe abstrata denominada Funcionario, contendo:

    Código identificador.

    Nome.

    CPF.

    Salário-base.

A classe deverá possuir um método abstrato para calcular a remuneração do funcionário.

Criar pelo menos três subclasses:

    FuncionarioCLT: recebe salário-base e adicional de benefícios.

    FuncionarioPJ: recebe um valor por projeto e a quantidade de projetos realizados.

    FuncionarioComissionado: recebe salário-base e percentual de comissão sobre suas vendas.

Cada classe deverá implementar sua própria regra de cálculo de remuneração.
3.3. Interfaces

Criar uma interface denominada Tributavel, contendo um método para calcular os tributos ou descontos aplicáveis à remuneração.

Implementar essa interface nas classes em que fizer sentido, considerando as regras de cada categoria de funcionário.

Criar também uma interface denominada Identificavel, contendo um método para retornar o identificador do funcionário.

As classes concretas deverão implementar essa interface, diretamente ou por herança.
3.4. Polimorfismo por sobreposição (Override)

O método de cálculo de remuneração deverá ser declarado na classe abstrata Funcionario e sobrescrito nas subclasses.

Cada tipo de funcionário deverá apresentar um comportamento diferente ao executar o método.

Exemplo conceitual:

Funcionario funcionario1 = new FuncionarioCLT(...);
Funcionario funcionario2 = new FuncionarioPJ(...);
Funcionario funcionario3 = new FuncionarioComissionado(...);

System.out.println(funcionario1.calcularRemuneracao());
System.out.println(funcionario2.calcularRemuneracao());
System.out.println(funcionario3.calcularRemuneracao());

Mesmo utilizando uma referência do tipo Funcionario, o sistema deverá executar a implementação correspondente ao objeto instanciado.
3.5. Polimorfismo por sobrecarga (Overload)

Implementar sobrecarga de métodos em pelo menos uma classe.

Sugestão: na classe responsável pelo gerenciamento de funcionários, implementar métodos para buscar funcionários:

buscarFuncionario(int codigo);

buscarFuncionario(String cpf);

buscarFuncionario(String nome, boolean buscaExata);

Os métodos deverão possuir o mesmo nome, mas parâmetros diferentes.
4. Tratamento de exceções

O sistema deverá implementar tratamento de exceções para situações como:

    Cadastro de funcionário com CPF inválido.

    Cadastro de funcionário com identificador já existente.

    Tentativa de buscar funcionário inexistente.

    Tentativa de remover funcionário inexistente.

    Valores negativos para salários, comissões ou benefícios.

    Percentuais inválidos.

    Dados obrigatórios não informados.

Requisito obrigatório: criar pelo menos duas exceções personalizadas, por exemplo:

    FuncionarioNaoEncontradoException

    FuncionarioJaCadastradoException

As exceções deverão ser lançadas nas situações apropriadas e tratadas nas camadas responsáveis.
5. Organização do software em camadas ou MVC

O projeto deverá ser organizado utilizando arquitetura em camadas ou padrão MVC.

Sugestão de organização em camadas:

src/
├── model/
│    ├── Funcionario.java
│    ├── FuncionarioCLT.java
│    ├── FuncionarioPJ.java
│    ├── FuncionarioComissionado.java
│    ├── Tributavel.java
│    └── Identificavel.java
│
├── repository/
│    └── FuncionarioRepository.java
│
├── service/
│    └── FuncionarioService.java
│
├── exception/
│    ├── FuncionarioNaoEncontradoException.java
│    └── FuncionarioJaCadastradoException.java
│
├── view/
│    └── FuncionarioView.java
│
└── Main.java

test/
├── model/
├── repository/
├── service/
└── exception/

Responsabilidades esperadas:

Camada


Responsabilidade

Model


Representar as entidades e regras de negócio específicas dos funcionários.

Repository


Gerenciar o armazenamento e a recuperação dos funcionários.

Service


Implementar as regras de negócio e coordenar as operações.

View


Interagir com o usuário e apresentar os resultados.

Exception


Representar situações excepcionais do sistema.

O armazenamento poderá ser realizado em memória, utilizando coleções Java, como ArrayList ou HashMap. Não é necessário utilizar banco de dados.
6. Desenvolvimento Orientado a Testes (TDD)
   Requisito obrigatório

O desenvolvimento deverá utilizar a abordagem TDD (Test Driven Development).

Os alunos deverão utilizar JUnit 5 para desenvolver os testes automatizados.
Regras obrigatórias

    Criar uma classe de teste para cada classe de produção desenvolvida.

    Desenvolver os testes antes da implementação dos métodos.

    Seguir o ciclo Red, Green e Refactor.

    Testar cenários de sucesso e de falha.

    Testar o lançamento das exceções personalizadas.

    Testar os cálculos de remuneração de todas as categorias.

    Testar o comportamento polimórfico.

Exemplos de testes esperados

Classe


Cenários que devem ser testados

FuncionarioCLT


Cálculo de remuneração e validação de dados.

FuncionarioPJ


Cálculo por projetos e valores inválidos.

FuncionarioComissionado


Cálculo de comissão e remuneração.

FuncionarioService


Cadastro, consulta, remoção e duplicidade.

FuncionarioRepository


Armazenamento e recuperação de funcionários.

Exceções personalizadas


Criação e lançamento das exceções.

Interfaces e classes abstratas


Implementação e comportamento das classes concretas.

Atenção: cada classe de produção deverá possuir sua respectiva classe de teste. Por exemplo, FuncionarioService.java deverá possuir FuncionarioServiceTest.java.

A classe Main e classes exclusivamente de inicialização ou configuração não precisam necessariamente de testes unitários.
7. Requisitos técnicos

   Linguagem: Java.

   IDE: IntelliJ IDEA, Eclipse ou NetBeans.

   Gerenciador de dependências: Maven.

   Framework de testes: JUnit 5.

   Controle de versão: Git e GitHub.

   Código organizado, identado e documentado quando necessário.

8. Entregáveis

Cada aluno ou equipe deverá entregar:

    Projeto Java completo.

    Código-fonte organizado em camadas ou MVC.

    Classes de teste correspondentes às classes de produção.

    Testes automatizados executando com sucesso.

    Repositório GitHub público contendo o histórico de desenvolvimento.

    README.md explicando o funcionamento do sistema, como executar o projeto e como executar os testes.

O histórico do Git deverá demonstrar o desenvolvimento progressivo do projeto, preferencialmente com commits que evidenciem as etapas do TDD.