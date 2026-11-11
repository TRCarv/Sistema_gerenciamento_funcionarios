package repository;

import exception.FuncionarioJaCadastradoException;
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
}
