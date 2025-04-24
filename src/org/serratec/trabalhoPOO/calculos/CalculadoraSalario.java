package org.serratec.trabalhoPOO.calculos;

public class CalculadoraSalario {

	public double calcularLiquido(double bruto, double inss, double ir) {
		
		double salarioLiquido = 0.0;

		if (bruto < 0 || inss < 0 || ir < 0) {
			throw new IllegalArgumentException("Valores de entrada devem ser não negativos.");
		}
		return bruto - inss - ir;
	}
}