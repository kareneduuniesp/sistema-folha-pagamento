package modelo;

import contrato.Bonificavel;

public class Desenvolvedor extends Funcionario implements Bonificavel {
    private String nivel;

    public Desenvolvedor(String nome, String cpf, double salarioBase, String nivel) {
        super(nome, cpf, salarioBase);
        setNivel(nivel);
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        if (nivel == null ||
                !(nivel.equals("JUNIOR") || nivel.equals("PLENO") || nivel.equals("SENIOR"))) {
            throw new IllegalArgumentException("Nivel invalido: " + nivel);
        }
        this.nivel = nivel;
    }

    private double getMultiplicador() {
        switch (nivel) {
            case "PLENO":
                return 1.3;
            case "SENIOR":
                return 1.6;
            default:
                return 1.0;
        }
    }

    @Override
    public double calcularSalario() {
        return salarioBase * getMultiplicador();
    }

    @Override
    public double calcularBonus() {
        return calcularSalario() * 0.05;
    }
}
