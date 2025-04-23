package org.serratec.trabalhoPOO.modelos;


import java.time.LocalDate;

public class FolhaPagamento {
	private int codigo;
	private Funcionario funcionario;
	private LocalDate dataPagamento;
	private double descontoINSS;
	private double descontoIR;
	private double salarioLiquido;
	private static int sequencia = 1;

	public FolhaPagamento(int codigo, Funcionario funcionario, LocalDate dataPagamento, double descontoINSS,
			double descontoIR, double salarioLiquido) {
		super();
		this.codigo = sequencia++;
		this.funcionario = funcionario;
		this.dataPagamento = LocalDate.now();
		this.descontoINSS = descontoINSS;
		this.descontoIR = descontoIR;
		this.salarioLiquido = salarioLiquido;
	}



}
