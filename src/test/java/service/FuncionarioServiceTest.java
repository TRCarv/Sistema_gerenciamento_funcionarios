package service;

import exception.FuncionarioNaoEncontradoException;
import model.FuncionarioCLT;
import model.FuncionarioComissionado;
import model.FuncionarioPJ;
import org.junit.jupiter.api.Test;
import repository.FuncionarioRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioServiceTest {

    @Test
    public void deveBuscarFuncionarioPorCpfComSucesso(){
        FuncionarioRepository repository = new FuncionarioRepository();

        FuncionarioService service = new FuncionarioService(repository);

        FuncionarioCLT funcionario = new FuncionarioCLT(10, "Murilo", "123.456.789-01", 5000.0, 500);
        repository.adicionar(funcionario);

        model.Funcionario encontrado = service.buscarFuncionario("123.456.789-01");

        assertEquals("Murilo", encontrado.getNome());
    }

    @Test
    public void deveLancarExcecaoAoBuscarCpfInexistente(){
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService(repository);

        Exception exception = assertThrows(FuncionarioNaoEncontradoException.class, () ->{
            service.buscarFuncionario("000.000.000-00");
        });

        assertEquals("Funcionário não encontrado com o CPF: 000.000.000-00", exception.getMessage());
    }

    @Test
    public void deveBuscarFuncionarioPorCodigoComSucesso(){
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService(repository);
        repository.adicionar(new FuncionarioCLT(11, "Thiago", "111.111.111-11", 5000.0, 2000.0));

        model.Funcionario encontrado = service.buscarFuncionario(11);
        assertEquals("Thiago", encontrado.getNome());
    }

    @Test
    public void deveBuscarFuncionarioPorNomeExato(){
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService(repository);
        repository.adicionar(new FuncionarioCLT(11, "Thiago Carvalho", "111.111.111-11", 5000.0, 2000.0));

        model.Funcionario encontrado = service.buscarFuncionario("Thiago Carvalho", true);

        assertEquals(11, encontrado.getCodigo());
    }

    @Test
    public void deveBuscarFuncionarioPorNomeParcial(){
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService(repository);
        repository.adicionar(new FuncionarioCLT(11, "Thiago Carvalho", "111.111.111-11", 5000.0, 2000.0));

        model.Funcionario encontrado = service.buscarFuncionario("Thiago", false);
        assertEquals(11, encontrado.getCodigo());
    }

    @Test
    public void deveCalcularTotalDaFolhaDePagamentoCorretamente(){
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService(repository);

        repository.adicionar(new FuncionarioCLT(1, "Ana", "111.111.111-11", 2000.0, 500.0));
        repository.adicionar(new FuncionarioPJ(2, "Bia", "222.222.222-22", 1000.0, 3));
        repository.adicionar(new FuncionarioComissionado(3, "Caio", "333.333.333-33", 1500.0, 10.0, 50000.0));

        double totalFolha = service.calcularTotalFolhaPagamento();
        // total aqui deve ser: 2500 + 3000 + 6500 = 12000
        assertEquals(12000, totalFolha, "O total da folha deve ser a soma exata das remunerações de todos os funcionários");

    }
}
