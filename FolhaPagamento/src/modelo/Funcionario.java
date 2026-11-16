package modelo;

//Variáveis
public abstract class Funcionario {
    private String nome;
    private String cpf;
    protected double salarioBase;

    //Construtor
    public Funcionario(String nome, String cpf, double salarioBase){
        this.nome = nome;
        this.cpf = cpf;
        setSalarioBase(salarioBase);
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public double getSalarioBase(){
        return salarioBase;
    }

    //Setters
    public void setSalarioBase(double salarioBase){
        if (salarioBase < 0){
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    public  String exibirResumo(){
        return String.format("%s | CPF: %s | Salário: R$ %.2f", nome, cpf, calcularSalario());
    }

    public abstract double calcularBonus();
}



