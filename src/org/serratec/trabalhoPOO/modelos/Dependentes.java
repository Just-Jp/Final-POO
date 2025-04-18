package org.serratec.trabalhoPOO.modelos;

import java.time.LocalDate;

public class Dependentes extends Pessoa {
	public Parentesco parentesco;
	
	public Dependentes(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
		super(nome, cpf, dataNascimento);
		if (dataNascimento.plusYears(18).isAfter(LocalDate.now())); {
			this.parentesco = parentesco;
		}
	}
}