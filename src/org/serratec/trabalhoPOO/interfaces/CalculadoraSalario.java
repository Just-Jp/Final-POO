package org.serratec.trabalhoPOO.interfaces;

public interface CalculadoraSalario {

	double calcularINSS(double salarioBruto);

	double calcularIR(double salarioBase, int numDependentes);
}