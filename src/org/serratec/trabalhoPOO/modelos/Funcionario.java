package org.serratec.trabalhoPOO.modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
	private double salarioBruto;
	private double descontoInss;
	private double descontoIR;
	private List<Dependentes> dependente;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto, double descontoInss, double descontoIR, Dependentes dependentes) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoInss = descontoInss;
		this.descontoIR = descontoIR;
		this.dependente = new ArrayList<>();
	}
}