package org.serratec.trabalhoPOO.calculos;

public class CalculadoraSalario {

	public double calcularLiquido(double bruto, double inss, double ir) {

		if (bruto < 0 || inss < 0 || ir < 0) {
			//throw new IllegalArgumentException("Valores de entrada devem ser não negativos.");
		}
		return bruto - inss - ir;
	}
}