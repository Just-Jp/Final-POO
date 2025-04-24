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

	public static void LeitorCSV() {

		String path = ".\\src\\entrada_arquivos.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
	}
}