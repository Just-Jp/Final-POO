package org.serratec.trabalhoPOO.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.trabalhoPOO.calculos.CalculadoraINSS;
import org.serratec.trabalhoPOO.calculos.CalculadoraIR;
import org.serratec.trabalhoPOO.interfaces.CalculadoraSalario;

public class Funcionario extends Pessoa implements CalculadoraSalario {
	private double salarioBruto;
	private List<Dependente> dependentes;
	private int numDependentes;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
		super(nome, cpf, dataNascimento);
		if (salarioBruto < 0) {
			 throw new IllegalArgumentException("Salário bruto não pode ser negativo.");
		}
		this.salarioBruto = salarioBruto;
		this.dependentes = new ArrayList<>();
		this.numDependentes = 0;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public int getNumDependentes() {
		return numDependentes;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
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

	

	public int calcularIdade(LocalDate dataNascimento) {
		LocalDate hoje = LocalDate.now();
		return hoje.getYear() - dataNascimento.getYear();

	}
	public boolean cpfRepetido(String cpf) {
		for(Dependente d : dependentes)
			if (d.getCpf().equals(cpf)) {
				return true;
			}
		return false;
	}


}

