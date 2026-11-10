package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioCLTTest {

    @Test
    public void deveCalcularRemuneracaoCorretamente(){
        //Construtor recebendo código, nome, CPF, salário base e adicional
        FuncionarioCLT funcionario = new FuncionarioCLT(1, "Thiago","123.456.789-00", 4000.0, 500.0);

        double remuneracao = funcionario.calcularRemuneracao();

        // Verificação:
        // 4000.0 (base) + 500.0 (adicional) = 4500,00
        assertEquals(4500, remuneracao, "A remuneração deve ser a soma do adicional e do salário base");

        // Valores negativos de salário

    }

    public void naoDevePermitirSalarioBaseNegativo(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioCLT(2, "Thiago","123.456.789-00", -1000.0, 500.0);
        });

        assertEquals("O salario base não pode ser negativo", exception.getMessage());
    }
}
