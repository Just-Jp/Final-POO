    import java.time.LocalDate;

import org.serratec.trabalhoPOO.enums.Parentesco;
import org.serratec.trabalhoPOO.excecao.DependenteException;

    public class Dependente extends Pessoa {
        private Parentesco parentesco;

        public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) throws DependenteException {
            super(nome, cpf, dataNascimento);
            if (calcularIdade(dataNascimento) >= 18) {
                throw new DependenteException("Dependente deve ser menor que 18 anos.");
            }
            this.parentesco = parentesco;
        }

        private int calcularIdade(LocalDate dataNascimento) {
            LocalDate hoje = LocalDate.now();
            return hoje.getYear() - dataNascimento.getYear();
        }

        public Parentesco getParentesco() {
            return parentesco;
        }
    }
