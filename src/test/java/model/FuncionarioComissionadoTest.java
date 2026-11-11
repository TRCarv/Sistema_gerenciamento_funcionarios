package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioComissionadoTest {

    @Test
    public void deveCalcularRemuneracaoComComissaoCorretamente(){
        FuncionarioComissionado fc = new FuncionarioComissionado(6,"Robertinho", "123.456.789-00", 2000.0, 10, 50000);

        double remuneracao = fc.calcularRemuneracao();

        // 2000.0 (salário base) + 10%(percentual) sobre 50000(vendas)
        assertEquals(7000.0, remuneracao, "A remuneração deve ser o salário base somado com a porcentagem sobre as vendas");

    }

    @Test
    public void percentualDeComissaoDeveSerMenorOuIgualACem(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        FuncionarioComissionado fc = new FuncionarioComissionado(8, "Carlinhos",  "123.456.789-00", 2000.0, 150.0, 100000.0);
        });

        assertEquals("Percentual deve ser entre 0 e 100",  exception.getMessage());
    }

    @Test
    public void percentualDeComissaoDeveSerMaiorouIgualaZero(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FuncionarioComissionado fc1 = new FuncionarioComissionado(9, "Jessica",  "123.456.789-00", 2000.0, -15.0, 100000.0);
        });
        assertEquals("Percentual deve ser entre 0 e 100",  exception.getMessage());
    }
}
