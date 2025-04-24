package org.serratec.trabalhoPOO.principal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.serratec.trabalhoPOO.modelos.FolhaPagamento;
import org.serratec.trabalhoPOO.modelos.Funcionario;

public class EscritorArquivo {

    private static void escreverLinha(BufferedWriter bw, String linha) throws IOException {
        bw.write(linha);
        bw.newLine();
    }

    public static void escreverDadosDeFuncionarios(String nomeArquivo, List<Funcionario> funcionarios) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Funcionario funcionario : funcionarios) {
                escreverLinha(bw, funcionario.getNome() + ";" +
                             funcionario.getCpf() + ";" +
                             String.format(Locale.US, "%.2f", funcionario.calcularINSS(funcionario.getSalarioBruto())) + ";" +
                             String.format(Locale.US, "%.2f", funcionario.calcularIR(funcionario.getSalarioBruto(), funcionario.getNumDependentes())) + ";" +
                             String.format(Locale.US, "%.2f", funcionario.calcularSalarioLiquido()));
            }
        }
    }

    public static void escreverDadosDeFolhaPagamento(String nomeArquivo, List<FolhaPagamento> folhasPagamento) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (FolhaPagamento folha : folhasPagamento) {
                escreverLinha(bw, folha.getFuncionario().getNome() + ";" +
                             folha.getFuncionario().getCpf() + ";" +
                             String.format(Locale.US, "%.2f", folha.getDescontoINSS()) + ";" +
                             String.format(Locale.US, "%.2f", folha.getDescontoIR()) + ";" +
                             String.format(Locale.US, "%.2f", folha.getSalarioLiquido()));
            }
        }
    }
}
