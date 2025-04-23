package org.serratec.trabalhoPOO.calculos;

public class CalculadoraINSS {

    static public double calcular(double salario) {
        if (salario <= 0) {
           // throw new IllegalArgumentException("Salário deve ser maior que zero.");
        }

        if (salario <= 1412.00) {
            return salario * 0.075;
        } else if (salario <= 2666.68) {
            return salario * 0.09;
        } else if (salario <= 4000.03) {
            return salario * 0.12;
        } else if (salario <= 7786.02) {
            return salario * 0.14;
        } else {
            return 7786.02 * 0.14;
        }
    }
}