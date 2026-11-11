package repository;

import exception.FuncionarioJaCadastradoException;
import exception.FuncionarioNaoEncontradoException;
import model.FuncionarioCLT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioRepositoryTest {

    @Test
    public void deveLancarExcessaoAoCadastrarFuncionarioComMesmoCodigo(){
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioCLT funcionario1 = new FuncionarioCLT(1, "Carlos", "111.222.333-44", 2000.00, 500.00 );
        FuncionarioCLT funcionario2 = new FuncionarioCLT(1, "Ana","999.888.777-66", 3000.0,500.0);

        repository.adicionar(funcionario1);

        Exception exception = assertThrows(FuncionarioJaCadastradoException.class, () -> {
            repository.adicionar(funcionario2);
        } );

        assertEquals("Funcionário já cadastrado com código: 1", exception.getMessage());
    }

    @Test
    public void deveRemoverFuncionarioComSucesso(){
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioCLT funcionario = new FuncionarioCLT(3,"Alice", "333.444.555-66", 3000.0, 500.0);
        repository.adicionar(funcionario);

        repository.remover(3);

        Exception exception = assertThrows(FuncionarioNaoEncontradoException.class, () -> {
            repository.buscarPorCodigo(3);
        });
        assertEquals("Funcionário não encontrado com o código: 3", exception.getMessage());
    }

    @Test
    public void deveLancarExcecaoAoRemoverFuncionarioInexistente(){
        FuncionarioRepository repository = new FuncionarioRepository();

        Exception exception = assertThrows(exception.FuncionarioNaoEncontradoException.class, () -> {
            repository.remover(999);
        });
           assertEquals("Funcionário não encontrado com código: 999", exception.getMessage());
    }
}
