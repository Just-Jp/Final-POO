package org.serratec.trabalhoPOO.calculos;

import java.util.Locale;

    public class CalculadoraINSS {

        public static double calcular(double salario) {
            if (salario <= 0) {
                throw new IllegalArgumentException("Salário deve ser maior que zero.");
            }

            double inss;
            if (salario <= 1518.00) {
                inss = salario * 0.075;
            } else if (salario <= 2793.88) {
                inss = (salario * 0.09) - 22.77;
            } else if (salario <= 4190.83) {
                inss = (salario * 0.12) - 106.60;
            } else if (salario <= 8157.41) {
                inss = (salario * 0.14) - 190.42;
            } else inss = 951.62; 

            return Double.parseDouble(String.format(Locale.US, "%.2f", inss));
        }
    }