package service;

import exception.FuncionarioNaoEncontradoException;
import model.Funcionario;
import repository.FuncionarioRepository;

public class FuncionarioService {
    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }


    public Funcionario buscarFuncionario(String cpf){
        for (Funcionario f : repository.listarTodos()){
            if (f.getCpf().equals(cpf)){
                return f;
            }
        }
        throw new FuncionarioNaoEncontradoException("Funcionário não encontrado com o CPF: " + cpf);
    }

    public Funcionario buscarFuncionario(int codigo){
        return repository.buscarPorCodigo(codigo);
    }

    public Funcionario buscarFuncionario(String nome, boolean buscaExata){
        if (buscaExata){
            for (Funcionario f : repository.listarTodos()){
                if (f.getNome().equals(nome)){
                    return f;
                }
            }
                }
        else {
            for (Funcionario f : repository.listarTodos()){
                if (f.getNome().contains(nome)){
                    return f;
                }
            }
        }
        throw new FuncionarioNaoEncontradoException("Funcionário não encontrado com o nome: " + nome);
    }

    public double calcularTotalFolhaPagamento(){
        double totalFolha = 0;
        for (Funcionario f : repository.listarTodos()){
            totalFolha += f.calcularRemuneracao();
        }
        return totalFolha;
    }
}
