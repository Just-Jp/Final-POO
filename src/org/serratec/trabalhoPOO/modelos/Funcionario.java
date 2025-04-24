package org.serratec.trabalhoPOO.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.trabalhoPOO.calculos.CalculadoraINSS;
import org.serratec.trabalhoPOO.calculos.CalculadoraIR;
import org.serratec.trabalhoPOO.calculos.CalculadoraSalario;
import org.serratec.trabalhoPOO.excecao.DependenteException;
import org.serratec.trabalhoPOO.interfaces.CalculadorSalario;



public class Funcionario extends Pessoa implements CalculadorSalario {

    private double salarioBruto;
    private List<Dependente> dependentes;

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
        super(nome, cpf, dataNascimento);
        if (salarioBruto < 0) {
            throw new IllegalArgumentException("Salário bruto não pode ser negativo.");
        }
        this.salarioBruto = salarioBruto;
        this.dependentes = new ArrayList<>();
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public int getNumDependentes() {
        return dependentes.size();
    }

    @Override
    public double calcularINSS(double salarioBruto) {
        return CalculadoraINSS.calcular(salarioBruto);
    }

    @Override
    public double calcularIR(double salarioBruto, int numDependentes) {
        double descontoINSS = CalculadoraINSS.calcular(salarioBruto);
        return CalculadoraIR.calcular(salarioBruto, descontoINSS, numDependentes);
    }

    public double calcularSalarioLiquido() {
        double descontoINSS = CalculadoraINSS.calcular(salarioBruto);
        double descontoIR = CalculadoraIR.calcular(salarioBruto, descontoINSS, getNumDependentes());
        return salarioBruto - descontoINSS - descontoIR;
    }

    public void adicionarDependente(Dependente dependente) throws DependenteException {
        validarDependente(dependente);
        dependentes.add(dependente);
    }

    private void validarDependente(Dependente dependente) throws DependenteException {
        if (calcularIdade(dependente.getDataNascimento()) >= 18) {
            throw new DependenteException("Dependente deve ser menor que 18 anos.");
        }
        if (temCpfRepetido(dependente.getCpf())) {
            throw new DependenteException("Não pode existir dependentes com o mesmo CPF.");
        }
    }

    private static int calcularIdade(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        return hoje.getYear() - dataNascimento.getYear();
    }

    private boolean temCpfRepetido(String cpf) {
        for (Dependente dependente : dependentes) {
            if (dependente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}