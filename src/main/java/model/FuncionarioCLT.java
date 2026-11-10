package model;

public class FuncionarioCLT extends Funcionario{
    private double salarioBase;
    private double beneficios;

    public FuncionarioCLT(int codigo, String nome, String cpf, double salarioBase, double beneficios) {
        super(codigo, nome, cpf);
        setSalarioBase(salarioBase);
        this.beneficios = beneficios;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if(salarioBase < 0){
            throw new IllegalArgumentException("O salário base não pode ser negativo");
        } else {
            this.salarioBase = salarioBase;
        }
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
