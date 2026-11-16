package app;

import excecao.FuncionarioDuplicadoException;
import modelo.Desenvolvedor;
import modelo.Estagiario;
import modelo.Gerente;
import servico.FolhaPagamento;

public class Main {
    public static void main(String[] args) {
        FolhaPagamento folha = new FolhaPagamento();

        // 1. Criar os funcionários
        Gerente ana = new Gerente("Ana Souza", "111.111.111-11", 7000, 5);
        Desenvolvedor bruno = new Desenvolvedor("Bruno Lima", "222.222.222-22", 5000, "PLENO");
        Desenvolvedor carla = new Desenvolvedor("Carla Dias", "333.333.333-33", 4000, "JUNIOR");
        Estagiario diego = new Estagiario("Diego Alves", "444.444.444-44", 1500);

        // 2. Adicionar à folha
        try {
            folha.adicionar(ana);
            folha.adicionar(bruno);
            folha.adicionar(carla);
            folha.adicionar(diego);
        } catch (FuncionarioDuplicadoException e) {
            System.out.println("Erro ao adicionar: " + e.getMessage());
        }

        // 3. Testar salário negativo
        try {
            ana.setSalarioBase(-500);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir salário: " + e.getMessage());
        }

        // 4. Testar nível inválido
        try {
            bruno.setNivel("MASTER");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir nível: " + e.getMessage());
        }

        // 5 e 6. CPF repetido + finally
        try {
            Estagiario repetido = new Estagiario("Eva Costa", "111.111.111-11", 1200);
            folha.adicionar(repetido);
        } catch (FuncionarioDuplicadoException e) {
            System.out.println("Erro ao adicionar: " + e.getMessage());
        } finally {
            System.out.println("Fim do processamento da folha");
        }

        // 7. Relatório e totais
        folha.imprimirRelatorio();
        System.out.printf("Total de salários: R$ %.2f%n", folha.calcularTotalSalarios());
        System.out.printf("Total de bônus: R$ %.2f%n", folha.calcularTotalBonus());
    }
}