package modelos;

import java.time.LocalDate;

import calculos.CalculoSalario;

public class FolhaPagamento {
    private int codigo;
    private Funcionario funcionario;
    private LocalDate dataPagamento;
    private double descontoINSS;
    private double descontoIR;
    private double salarioLiquido;

    public FolhaPagamento(int codigo, Funcionario funcionario, LocalDate dataPagamento) {
        this.codigo = codigo;
        this.funcionario = funcionario;
        this.dataPagamento = dataPagamento;
        this.descontoINSS = CalculoSalario.calcularINSS(funcionario.getSalarioBruto());
        this.descontoIR = CalculoSalario.calcularIR(funcionario.getSalarioBruto(), this.descontoINSS, funcionario.getNumDependentes());
        this.salarioLiquido = funcionario.calcularSalarioLiquido();
    }

    public int getCodigo() {
        return codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public double getDescontoINSS() {
        return descontoINSS;
    }

    public double getDescontoIR() {
        return descontoIR;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }
}