package view;

import model.Funcionario;
import service.FuncionarioService;

import java.util.List;

public class FuncionarioView {

    private FuncionarioService service;

    public FuncionarioView(FuncionarioService service) {
        this.service = service;
    }

    public void exibirDetalhesFuncionario(int codigo){
        try{
            Funcionario f = service.buscarFuncionario(codigo);
            System.out.println("\n--- Detalhes do Funcionário ---");
            System.out.println("Código: " + f.getCodigo());
            System.out.println("Nome: " + f.getNome());
            System.out.println("CPF: " + f.getCpf());
            System.out.println("Remuneração: R$ " + String.format("%.2f", f.calcularRemuneracao()));
            System.out.println("-------------------------------");
        } catch (RuntimeException e) {
            System.out.println("\nErro ao buscar funcionário: " + e.getMessage());
        }
    }

    public void gerarRelatorio(){
        List<Funcionario> funcionarios = service.listarTodos();
        System.out.println("\n========== RELATÓRIO DE FUNCIONÁRIOS ==========");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : funcionarios) {
                System.out.println(f.getCodigo() + " | " + f.getNome() + " | CPF: " + f.getCpf() + " | R$ " + String.format("%.2f", f.calcularRemuneracao()));
            }
        }
        System.out.println("===============================================");
        System.out.println("Total da Folha de Pagamento: R$ " + String.format("%.2f", service.calcularTotalFolhaPagamento()));
        System.out.println("===============================================");
    }
}
