package com.buenoezandro.calculadora;

import javax.swing.SwingUtilities;

public class Aplicacao {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var calc = new Calculadora();
			calc.setVisible(true);
		});
	}

}
