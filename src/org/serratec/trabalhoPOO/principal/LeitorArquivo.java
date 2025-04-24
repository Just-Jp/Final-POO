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
    	
    	public static void main(String[] args) {
			
    	
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

       /* public static List<Funcionario> lerArquivoDeEntrada(String nomeArquivo) throws IOException, DependenteException {
            List<Funcionario> funcionarios = new ArrayList<>();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

            try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
                String linha;
                Funcionario funcionarioAtual = null;  

                while ((linha = br.readLine()) != null) {
                    if (linha.trim().isEmpty()) {
                        funcionarioAtual = null; 
                        continue;
                    }

                    String[] dados = linha.split(";");
                    String nome = dados[0];
                    String cpf = dados[1];
                    LocalDate dataNascimento = LocalDate.parse(dados[2], dateFormatter);

                    if (dados.length == 4 && !dados[3].matches("[A-Za-z]+")) // verifica se o 4 item nao tem apenas letras
                    {                                                        //caso aconteça, ele presume q seja o salario
                        double salarioBruto = Double.parseDouble(dados[3].replace(",", "."));//troca os , por .
                        funcionarioAtual = new Funcionario(nome, cpf, dataNascimento, salarioBruto);//cria o funcionario
                        if (cpfNaoExiste(cpf, funcionarios)) { //verifica o cpf
                            funcionarios.add(funcionarioAtual);
                        } else {
                            throw new IllegalArgumentException("CPF já cadastrado: " + cpf);
                        }
                    } else if (dados.length == 4 && funcionarioAtual != null) { //se for falso entende q seja um dependente e verificando o 4 elemento e se tem funcionarioatual 
                        Parentesco parentesco = Parentesco.valueOf(dados[3]);   //verificando o 4 elemento e se tem funcionarioatual 
                        Dependente dependente = new Dependente(nome, cpf, dataNascimento, parentesco);
                        funcionarioAtual.adicionarDependente(dependente);
                    }
                }
            }
            return funcionarios;
        }

        private static boolean cpfNaoExiste(String cpf, List<Funcionario> funcionarios) {
            for (Funcionario f : funcionarios) {
                if (f.getCpf().equals(cpf)) {
                    return false;
                }
            }
            return true;
        }*/
    