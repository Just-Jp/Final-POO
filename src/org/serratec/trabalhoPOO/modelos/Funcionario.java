package org.serratec.trabalhoPOO.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Funcionario extends Pessoa implements Calculavel {
    private double salarioBruto;
    private double descontoInss;
    private double descontoIR;
    private List<Dependentes> dependentes;

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
        this.dependentes = new ArrayList<>();
        this.descontoInss = calcularINSS();
        this.descontoIR = calcularIR();
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getDescontoInss() {
        return descontoInss;
    }

    public double getDescontoIR() {
        return descontoIR;
    }

    public List<Dependentes> getDependentes() {
        return dependentes;
    }

    public void adicionarDependente(Dependentes dependente) {
        this.dependentes.add(dependente);
    }

    private double calcularINSS() {
        double aliquotaINSS;
        double deducaoINSS = 0;
        double salarioBaseINSS = Math.min(salarioBruto, 8157.41);

        if (salarioBaseINSS <= 1320.00) {
            aliquotaINSS = 0.075;
            deducaoINSS = 0.00;
        } else if (salarioBaseINSS <= 2571.29) {
            aliquotaINSS = 0.09;
            deducaoINSS = 19.80;
        } else if (salarioBaseINSS <= 3856.94) {
            aliquotaINSS = 0.12;
            deducaoINSS = 96.66;
        } else {
            aliquotaINSS = 0.14;
            deducaoINSS = 174.08;
        }
        return (salarioBaseINSS * aliquotaINSS) - deducaoINSS;
    }

    private double calcularIR() {
        double baseCalculoIR = salarioBruto - descontoInss - (dependentes.size() * 189.59);
        double aliquotaIR = 0.0;
        double deducaoIR = 0.0;

        if (baseCalculoIR <= 2259.20) {
            aliquotaIR = 0.0;
            deducaoIR = 0.0;
        } else if (baseCalculoIR <= 2826.65) {
            aliquotaIR = 0.075;
            deducaoIR = 169.44;
        } else if (baseCalculoIR <= 3751.05) {
            aliquotaIR = 0.15;
            deducaoIR = 381.44;
        } else if (baseCalculoIR <= 4664.68) {
            aliquotaIR = 0.225;
            deducaoIR = 662.77;
        } else {
            aliquotaIR = 0.275;
            deducaoIR = 896.00;
        }
        return (baseCalculoIR * aliquotaIR) - deducaoIR;
    }

    @Override
    public double calcularSalarioLiquido() {
        return salarioBruto - descontoInss - descontoIR;
    }

    @Override
    public String toString() {
        return getNome() + ";" + getCpf() + ";" + FormatacaoUtil.formatarDecimal(descontoInss) + ";" + FormatacaoUtil.formatarDecimal(descontoIR) + ";" + FormatacaoUtil.formatarDecimal(calcularSalarioLiquido());
    }
}