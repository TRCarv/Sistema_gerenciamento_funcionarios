package model;

public class FuncionarioComissionado extends Funcionario {
    private double percentualDeComissao;
    private double totalDeVendas;


    public FuncionarioComissionado(int codigo, String nome, String cpf, double salarioBase, double percentualDeComissao, double totalDeVendas) {
        super(codigo, nome, cpf, salarioBase);
        setPercentualDeComissao(percentualDeComissao);
        setTotalDeVendas(totalDeVendas);
    }

    public double getPercentualDeComissao() {
        return percentualDeComissao;
    }

    public void setPercentualDeComissao(double percentualDeComissao) {
        if (percentualDeComissao < 0 || percentualDeComissao > 100) {
            throw new IllegalArgumentException("Percentual deve ser entre 0 e 100");
        } else{
            this.percentualDeComissao = percentualDeComissao;
        }
    }

    public double getTotalDeVendas() {
        return totalDeVendas;
    }

    public void setTotalDeVendas(double totalDeVendas) {
        if (totalDeVendas < 0){
            throw new IllegalArgumentException("Total de vendas não pode ser negativo");
        } else{
            this.totalDeVendas = totalDeVendas;
        }
    }

    @Override
    public double calcularRemuneracao() {
        return getSalarioBase() + (this.totalDeVendas*this.percentualDeComissao/100);
    }
}
