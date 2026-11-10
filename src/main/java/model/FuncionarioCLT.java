package model;

public class FuncionarioCLT extends Funcionario{
    private double salarioBase;
    private double beneficios;

    public FuncionarioCLT(int codigo, String nome, String cpf, double salarioBase, double beneficios) {
        super(codigo, nome, cpf);
        this.salarioBase = salarioBase;
        this.beneficios = beneficios;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public double calcularRemuneracao(){
        return salarioBase + beneficios;
    }
}
