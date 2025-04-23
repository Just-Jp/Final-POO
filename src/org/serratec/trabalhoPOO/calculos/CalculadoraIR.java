package org.serratec.trabalhoPOO.calculos;

public class CalculadoraIR {

    public static double calcular(double salarioBruto, double descontoINSS, int numDependentes) {
        if (salarioBruto <= 0 || descontoINSS < 0 || numDependentes < 0) {
            throw new IllegalArgumentException("Valores de entrada inválidos.");
        }

        double base = salarioBruto - descontoINSS - (numDependentes * 189.59);

        if (base <= 2259.20) {
            return 0.0;
        } else if (base <= 2826.65) {
            return (base * 0.075) - 169.44;
        } else if (base <= 3751.05) {
            return (base * 0.15) - 381.44;
        } else if (base <= 4664.68) {
            return (base * 0.225) - 662.77;
        } else {
            return (base * 0.275) - 896.00;
        }
    }
}