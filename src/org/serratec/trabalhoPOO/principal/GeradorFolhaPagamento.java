package org.serratec.trabalhoPOO.principal;

    import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.trabalhoPOO.modelos.FolhaPagamento;
import org.serratec.trabalhoPOO.modelos.Funcionario;

    public class GeradorFolhaPagamento {

        public static List<FolhaPagamento> gerarFolhasPagamento(List<Funcionario> funcionarios) {
            List<FolhaPagamento> folhasPagamento = new ArrayList<>();
            int codigo = 1;
            LocalDate dataPagamento = LocalDate.now();

            for (Funcionario funcionario : funcionarios) {
                folhasPagamento.add(new FolhaPagamento(codigo++, funcionario, dataPagamento));
            }
            return folhasPagamento;
        }
    }