package model;

public class FuncionarioCLT extends Funcionario{
    private double salarioBase;
    private double beneficios;

    public FuncionarioCLT(int codigo, String nome, String cpf, double salarioBase, double beneficios) {
        super(codigo, nome, cpf, salarioBase);
        setBeneficios(beneficios);
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
        if (beneficios < 0){
            throw new IllegalArgumentException("Os benefícios não podem ser negativos");
        } else{
            this.beneficios = beneficios;
        }
    }

    @Override
    public double calcularRemuneracao(){
        return salarioBase + beneficios;
    }

    public double calcularTributo(){
        return calcularRemuneracao()*0.1;
    }
}
