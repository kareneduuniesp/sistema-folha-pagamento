package modelo;

import contrato.Bonificavel;

public class Gerente  extends Funcionario implements Bonificavel{
    private int quantidadeSubordinados;

    public Gerente(String nome, String cpf, double salarioBase, int quantidadeSubordinados){
        super(nome, cpf, salarioBase);
        this.quantidadeSubordinados = quantidadeSubordinados;
    }

    public int getQuantidadeSubordinados() {
        return quantidadeSubordinados;
    }

    public void setQuantidadeSubordinados(int quantidadeSubordinados) {
        this.quantidadeSubordinados = quantidadeSubordinados;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + 1000;
    }

    @Override
    public double calcularBonus() {
        return salarioBase + 0.10 + 200 * quantidadeSubordinados;
    }
}
