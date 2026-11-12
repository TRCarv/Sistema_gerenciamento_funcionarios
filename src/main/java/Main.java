import model.FuncionarioCLT;
import model.FuncionarioComissionado;
import model.FuncionarioPJ;
import repository.FuncionarioRepository;
import service.FuncionarioService;
import utils.MenuPadrao;
import view.FuncionarioView;

public class Main {
    public static void main(String[] args) {
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService(repository);
        FuncionarioView view = new FuncionarioView(service);

        repository.adicionar(new FuncionarioCLT(1, "Thiago", "111.222.333-44", 4000.0, 500.0));
        repository.adicionar(new FuncionarioPJ(2, "Karine", "555.666.777-88", 1500.0, 4));
        repository.adicionar(new FuncionarioComissionado(3, "Murilo", "999.000.111-22", 2000.0, 10.0, 50000.0));

        String[] opcoes = {
                "Cadastrar novo Funcionário",
                "Buscar Funcionário por Código",
                "Remover Funcionário",
                "Exibir Relatório Geral da Folha"
        };

        boolean executando = true;

        while (executando) {
            int escolha = MenuPadrao.exibirMenu("SISTEMA DE RECURSOS HUMANOS", opcoes, true);

            switch (escolha) {
                case 1:
                    String[] opcoesCadastro = {
                            "CLT",
                            "PJ",
                            "Comissionado"
                    };

                    int tipo = MenuPadrao.exibirMenu("TIPO DE FUNCIONÁRIO", opcoesCadastro, false);

                    if (tipo >= 1 && tipo <= 3) {
                        System.out.println("\n--- Cadastro de Funcionário ---");
                        try {
                            System.out.print("Digite o código: ");
                            int cod = Integer.parseInt(MenuPadrao.sc.nextLine());

                            System.out.print("Digite o nome: ");
                            String nome = MenuPadrao.sc.nextLine();

                            System.out.print("Digite o CPF (XXX.XXX.XXX-XX): ");
                            String cpf = MenuPadrao.sc.nextLine();

                            switch (tipo) {
                                case 1:
                                    System.out.print("Digite o salário base: ");
                                    double salarioBaseCLT = Double.parseDouble(MenuPadrao.sc.nextLine());
                                    System.out.print("Digite os benefícios: ");
                                    double beneficios = Double.parseDouble(MenuPadrao.sc.nextLine());
                                    repository.adicionar(new FuncionarioCLT(cod, nome, cpf, salarioBaseCLT, beneficios));
                                    System.out.println("\nFuncionário CLT cadastrado com sucesso!");
                                    break;
                                case 2:
                                    System.out.print("Digite o valor por projeto: ");
                                    double valorPorProjeto = Double.parseDouble(MenuPadrao.sc.nextLine());
                                    System.out.print("Digite a quantidade de projetos realizados: ");
                                    int quantidadeProjetos = Integer.parseInt(MenuPadrao.sc.nextLine());
                                    repository.adicionar(new FuncionarioPJ(cod, nome, cpf, valorPorProjeto, quantidadeProjetos));
                                    System.out.println("\nFuncionário PJ cadastrado com sucesso!");
                                    break;
                                case 3:
                                    System.out.print("Digite o salário base: ");
                                    double salarioBaseCom = Double.parseDouble(MenuPadrao.sc.nextLine());
                                    System.out.print("Digite o percentual de comissão: ");
                                    double percentualComissao = Double.parseDouble(MenuPadrao.sc.nextLine());
                                    System.out.print("Digite o total de vendas: ");
                                    double totalVendas = Double.parseDouble(MenuPadrao.sc.nextLine());
                                    repository.adicionar(new FuncionarioComissionado(cod, nome, cpf, salarioBaseCom, percentualComissao, totalVendas));
                                    System.out.println("\nFuncionário Comissionado cadastrado com sucesso!");
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\nErro: Formato numérico inválido.");
                        } catch (Exception e) {
                            System.out.println("\nErro ao cadastrar: " + e.getMessage());
                        }
                    } else if (tipo != 0) {
                        System.out.println("\nOpção inválida.");
                    }
                    MenuPadrao.esperarEnter();
                    break;

                case 2:
                    System.out.println("\n--- Buscar Funcionário ---");
                    System.out.print("Digite o código do funcionário: ");
                    try {
                        int codigoBusca = Integer.parseInt(MenuPadrao.sc.nextLine());
                        view.exibirDetalhesFuncionario(codigoBusca);
                    } catch (NumberFormatException e) {
                        System.out.println("\nPor favor, digite um número válido.");
                    }
                    MenuPadrao.esperarEnter();
                    break;

                case 3:
                    System.out.println("\n--- Remover Funcionário ---");
                    System.out.print("Digite o código do funcionário a ser removido: ");
                    try {
                        int codigoRemover = Integer.parseInt(MenuPadrao.sc.nextLine());
                        repository.remover(codigoRemover);
                        System.out.println("\nFuncionário removido com sucesso!");
                    } catch (NumberFormatException e) {
                        System.out.println("\nPor favor, digite um número válido.");
                    } catch (RuntimeException e) {
                        System.out.println("\nErro: " + e.getMessage());
                    }
                    MenuPadrao.esperarEnter();
                    break;

                case 4:
                    view.gerarRelatorio();
                    MenuPadrao.esperarEnter();
                    break;

                case 0:
                    executando = false;
                    MenuPadrao.limparTela();
                    System.out.println("Encerrando o sistema. Até logo!\n");
                    break;

                default:
                    System.out.println("\nOpção inválida. Escolha um número de 1 a 4, ou * para sair.");
                    MenuPadrao.esperarEnter();
                    break;
            }
        }
    }
}