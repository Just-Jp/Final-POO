package org.serratec.trabalhoPOO.calculos;

public class CalculadoraIR {

    public static double calcular(double salarioBruto, double descontoINSS, int numDependentes) {
        if (salarioBruto <= 0 || descontoINSS < 0 || numDependentes < 0) {
            throw new IllegalArgumentException("Valores de entrada inválidos.");
        }

        double ir = salarioBruto - descontoINSS - (numDependentes * 189.59);

        if (ir <= 2259.20) {
            return 0.0;
        } else if (ir <= 2826.65) {
            return (ir * 0.075) - 169.44;
        } else if (ir <= 3751.05) {
            return (ir * 0.15) - 381.44;
        } else if (ir <= 4664.68) {
            return (ir * 0.225) - 662.77;
        } else {
            return (ir * 0.275) - 896.00;
        }
    }
}