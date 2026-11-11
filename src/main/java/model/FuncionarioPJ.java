package model;

public class FuncionarioPJ extends Funcionario{
    private double valorPorProjeto;
    private int quantidadeDeProjetosRealizados;

    public FuncionarioPJ(int codigo, String nome, String cpf, double valorPorProjeto, int quantidadeDeProjetosRealizados) {
        super(codigo, nome, cpf, 0.0);
        setValorPorProjeto(valorPorProjeto);
        setQuantidadeDeProjetosRealizados(quantidadeDeProjetosRealizados);
        }

    public double getValorPorProjeto() {
        return valorPorProjeto;
    }

    public void setValorPorProjeto(double valorPorProjeto) {
        if (valorPorProjeto < 0){
            throw new IllegalArgumentException("Valor por projeto deve ser maior que zero");
        } else {
            this.valorPorProjeto = valorPorProjeto;
        }
    }

    public int getQuantidadeDeProjetosRealizados() {
        return quantidadeDeProjetosRealizados;
    }

    public void setQuantidadeDeProjetosRealizados(int quantidadeDeProjetosRealizados) {
        this.quantidadeDeProjetosRealizados = quantidadeDeProjetosRealizados;
    }

    @Override
    public double calcularRemuneracao() {
        return valorPorProjeto * quantidadeDeProjetosRealizados;
    }
}
