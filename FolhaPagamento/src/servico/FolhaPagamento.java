package servico;

import contrato.Bonificavel;
import excecao.FuncionarioDuplicadoException;
import modelo.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FolhaPagamento {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionar(Funcionario f) throws FuncionarioDuplicadoException {
        for (Funcionario existente : funcionarios) {
            if (existente.getCpf().equals(f.getCpf())) {
                throw new FuncionarioDuplicadoException("CPF já cadastrado: " + f.getCpf());
            }
        }
        funcionarios.add(f);
    }

    public double calcularTotalSalarios() {
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalario();
        }
        return total;
    }

    public double calcularTotalBonus() {
        double total = 0;
        for (Funcionario f : funcionarios) {
            if (f instanceof Bonificavel) {          // só quem é Bonificavel
                total += ((Bonificavel) f).calcularBonus();
            }
        }
        return total;
    }

    public void imprimirRelatorio() {
        System.out.println("===== RELATÓRIO DA FOLHA =====");
        for (Funcionario f : funcionarios) {
            System.out.println(f.exibirResumo());
        }
    }
}
