package org.serratec.trabalhoPOO.interfaces;

public interface CalculadorSalario {

    double calcularINSS(double salarioBruto);

    double calcularIR(double salarioBruto, int numDependentes);
}