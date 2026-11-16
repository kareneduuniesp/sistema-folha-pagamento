package modelo;

public class Estagiario extends Funcionario {

    public Estagiario(String nome, String cpf, double salarioBase) {
        super(nome, cpf, salarioBase);
    }
    @Override
    public double calcularSalario() {
        return salarioBase;
    }

    @Override
    public String exibirResumo(){
        String resumo = super.exibirResumo();
        return getNome() + "(Estagiário)" + resumo.substring(getNome().length());
    }

    @Override
    public double calcularBonus() {
        return 0;
    }
}
