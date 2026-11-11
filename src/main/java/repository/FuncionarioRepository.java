package repository;

import exception.FuncionarioJaCadastradoException;
import exception.FuncionarioNaoEncontradoException;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionar(Funcionario funcionario){

        for (Funcionario f : funcionarios){
            if (f.getCodigo() == funcionario.getCodigo()){
                throw new FuncionarioJaCadastradoException("Funcionário já cadastrado com código: " + f.getCodigo());
            }

        }
        funcionarios.add(funcionario);

    }

    public Funcionario buscarPorCodigo(int codigo){
        for (Funcionario f : funcionarios){
            if (f.getCodigo() == codigo){
                return f;
            }
        }
        throw new FuncionarioNaoEncontradoException("Funcionário não encontrado com código: " + codigo);
    }

    public void remover(int codigo){
        Funcionario funcionarioParaRemover = buscarPorCodigo(codigo);
        funcionarios.remove(funcionarioParaRemover);
    }
}
