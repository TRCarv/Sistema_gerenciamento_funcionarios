package model;

public abstract class Funcionario implements Identificavel {
    private int codigo;
    private String nome;
    private String cpf;
    private double salarioBase;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if(salarioBase < 0){
            throw new IllegalArgumentException("O salário base não pode ser negativo");
        }
        this.salarioBase = salarioBase;
    }

    public Funcionario(int codigo, String nome, String cpf, double salarioBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        setSalarioBase(salarioBase);
    }

    public Funcionario (int codigo, String nome, String cpf){
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
    }


    public abstract double calcularRemuneracao();
}
