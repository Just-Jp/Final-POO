package org.serratec.trabalhoPOO.principal;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.serratec.trabalhoPOO.enums.Parentesco;
import org.serratec.trabalhoPOO.excecao.DependenteException;
import org.serratec.trabalhoPOO.modelos.Dependente;
import org.serratec.trabalhoPOO.modelos.FolhaPagamento;
import org.serratec.trabalhoPOO.modelos.Funcionario;

public class Principal {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<Funcionario> funcionarios = inicializarFuncionarios(); // Inicialização
        processarEntradaDeFuncionarios(scanner, funcionarios); // Entrada de dados
        gerarESalvarFolhaPagamento(scanner, funcionarios); // Geração e saída
        scanner.close();
    }

    private static List<Funcionario> inicializarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            Funcionario funcionario1 = new Funcionario("Daniel Lopes", "12345678901", LocalDate.of(2015, 5, 20), 5000.00);
            funcionario1.adicionarDependente(new Dependente("João Pedro", "02345678902", LocalDate.of(2015, 10, 15), Parentesco.FILHO));
            funcionario1.adicionarDependente(new Dependente("Iara", "03345678903", LocalDate.of(2009, 3, 22), Parentesco.FILHO));
            funcionarios.add(funcionario1);

            Funcionario funcionario2 = new Funcionario("Cauã pacheco", "23456789012", LocalDate.of(1990, 12, 10), 8000.00);
            funcionario2.adicionarDependente(new Dependente("Karen ", "13456789013", LocalDate.of(2010, 8, 1), Parentesco.SOBRINHO));
            funcionarios.add(funcionario2);

        } catch (DependenteException e) {
            System.err.println("Erro ao inicializar funcionário: " + e.getMessage());
        }
        return funcionarios;
    }

    private static void processarEntradaDeFuncionarios(Scanner scanner, List<Funcionario> funcionarios) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String continuar;
        do {
            try {
                System.out.println("\nDados do Novo Funcionário:");
                System.out.print("Nome: ");
                String nomeFuncionario = scanner.nextLine();
                System.out.print("CPF: ");
                String cpfFuncionario = scanner.nextLine();
                System.out.print("Data de Nascimento (yyyyMMdd): ");
                LocalDate dataNascimentoFuncionario = LocalDate.parse(scanner.nextLine(), dateFormatter);
                System.out.print("Salário Bruto: ");
                double salarioBruto = Double.parseDouble(scanner.nextLine().replace(",", "."));

                Funcionario novoFuncionario = new Funcionario(nomeFuncionario, cpfFuncionario, dataNascimentoFuncionario, salarioBruto);
                funcionarios.add(novoFuncionario);

                processarEntradaDeDependentes(scanner, novoFuncionario, dateFormatter);

            } catch (IllegalArgumentException e) {
                System.err.println("Entrada inválida: " + e.getMessage());
            }

            System.out.print("\nAdicionar outro funcionário? (sim/não): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("sim"));
    }

    private static void processarEntradaDeDependentes(Scanner scanner, Funcionario funcionario, DateTimeFormatter dateFormatter) {
        String continuarDependente;
        do {
            System.out.print("Nome do Dependente (ou deixe em branco para pular): ");
            String nomeDependente = scanner.nextLine();
            if (nomeDependente.isEmpty()) {
                break;
            }
            System.out.print("CPF do Dependente: ");
            String cpfDependente = scanner.nextLine();
            System.out.print("Data de Nascimento do Dependente (yyyyMMdd): ");
            LocalDate dataNascimentoDependente = LocalDate.parse(scanner.nextLine(), dateFormatter);
            System.out.print("Parentesco (FILHO, SOBRINHO, OUTROS): ");
            Parentesco parentesco = Parentesco.valueOf(scanner.nextLine().toUpperCase());

            try {
                Dependente dependente = new Dependente(nomeDependente, cpfDependente, dataNascimentoDependente, parentesco);
                funcionario.adicionarDependente(dependente);
            } catch (DependenteException e) {
                System.err.println("Erro ao adicionar dependente: " + e.getMessage());
            }

            System.out.print("Adicionar outro dependente? (sim/não): ");
            continuarDependente = scanner.nextLine();
        } while (continuarDependente.equalsIgnoreCase("sim"));
    }

    private static void gerarESalvarFolhaPagamento(Scanner scanner, List<Funcionario> funcionarios) {
        System.out.print("\nDigite o nome do arquivo de saída: ");
        String nomeArquivoSaida = scanner.nextLine();
        List<FolhaPagamento> folhasPagamento = GeradorFolhaPagamento.gerarFolhasPagamento(funcionarios);
        try {
            EscritorArquivo.escreverDadosDeFolhaPagamento(nomeArquivoSaida, folhasPagamento);
            System.out.println("Arquivo de saída gerado com sucesso: " + nomeArquivoSaida);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
