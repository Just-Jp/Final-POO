package org.serratec.trabalhoPOO.principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.serratec.trabalhoPOO.enums.Parentesco;
import org.serratec.trabalhoPOO.excecao.DependenteException;
import org.serratec.trabalhoPOO.modelos.Dependente;
import org.serratec.trabalhoPOO.modelos.Funcionario;

public class LeitorArquivo {

	private static final String CAMINHO_PADRAO = ".\\src\\entrada_arquivos.txt";

	public static List<Funcionario> lerArquivo() {
		return lerArquivo(CAMINHO_PADRAO);
	}

	public static List<Funcionario> lerArquivo(String caminhoArquivo) {
		List<Funcionario> funcionarios = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
			String linha;
			Funcionario funcionarioAtual = null;

			while ((linha = br.readLine()) != null) {
				linha = linha.trim();
				if (linha.isEmpty()) {
					funcionarioAtual = null;
					continue;
				}

				String[] partes = linha.split(";");
				if (partes.length == 4 && funcionarioAtual == null) {
					String nome = partes[0];
					String cpf = partes[1];
					LocalDate nascimento = LocalDate.parse(partes[2], formatter);
					double salario = Double.parseDouble(partes[3]);

					funcionarioAtual = new Funcionario(nome, cpf, nascimento, salario);
					funcionarios.add(funcionarioAtual);

				} else if (partes.length == 4 && funcionarioAtual != null) {
					String nome = partes[0];
					String cpf = partes[1];
					LocalDate nascimento = LocalDate.parse(partes[2], formatter);
					Parentesco parentesco = Parentesco.valueOf(partes[3].toUpperCase());

					try {
						Dependente dependente = new Dependente(nome, cpf, nascimento, parentesco);
						funcionarioAtual.adicionarDependente(dependente);
					} catch (DependenteException e) {
						System.err.println("Erro ao adicionar dependente: " + e.getMessage());
					}
				}
			}

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		}

		return funcionarios;
	}
}