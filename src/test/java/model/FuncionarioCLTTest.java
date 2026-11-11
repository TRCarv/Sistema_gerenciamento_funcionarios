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

    @Test
    public void naoDevePermitirSalarioBaseNegativo(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioCLT(2, "Thiago","123.456.789-00", -1000.0, 500.0);
        });

        assertEquals("O salário base não pode ser negativo", exception.getMessage());
    }

    @Test
    public void naoDevePermitirBeneficioNegativo(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioCLT(3,"Robertinho","123.456.789-00", 5000.0, -1000.0);
        });
        assertEquals("Os benefícios não podem ser negativos",exception.getMessage());
    }

    @Test
    public void deveCalcularTributosCorretamente(){
        FuncionarioCLT funcionario = new FuncionarioCLT(9,"Katia","123.456.789-00",4000.0, 500.0);

        double tributos = funcionario.calcularTributo();

        assertEquals(450, tributos, "Os tributos do CLT devem ser 10% da remuneração");
    }

    @Test
    public void naoDevePermitirCpfInvalido(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FuncionarioCLT(1, "João", "12345678900", 2000.0, 500.0);
        });
        assertEquals("CPF inválido. O formato deve ser XXX.XXX.XXX-XX", exception.getMessage());
    }


    }

