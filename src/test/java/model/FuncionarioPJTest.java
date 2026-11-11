package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioPJTest {

    @Test
    public void deveCalcularRemuneracaoDoProjetoCorretamente() {

        FuncionarioPJ pj = new FuncionarioPJ(4, "Ana Maria", "123.456.789-0", 500.0, 5);

        double remuneracao = pj.calcularRemuneracao();
        assertEquals(2500.0, remuneracao, "A remuneração deve ser o valor do projeto multilicado pela quantidade de projetos realizados");
    }


    @Test
    public void naoDevePermitirValorNegativoParaValorPorProjeto() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        FuncionarioPJ pj = new FuncionarioPJ(5, "Joaquim", "123.456.789-0", -1500.0, 5);
        });
        assertEquals("Valor por projeto deve ser maior que zero", exception.getMessage());
    }

}
