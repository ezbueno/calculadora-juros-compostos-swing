package com.buenoezandro.calculadora;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora extends CalculadoraForm {

	private static final long serialVersionUID = 1L;

	@Override
	protected void btnCalcularClick(ActionEvent ev) {
        var capital = toBigDecimal(this.txtCapital.getText());
        var taxaJuros = toBigDecimal(this.txtTaxaJuros.getText());
        var periodo = toBigDecimal(this.txtPeriodo.getText());

        BigDecimal montante = taxaJuros.divide(new BigDecimal(100), RoundingMode.HALF_EVEN);
        montante = montante.add(BigDecimal.ONE);
        montante = montante.pow(periodo.intValue());
        montante = montante.multiply(capital);
        montante = montante.setScale(2, RoundingMode.HALF_EVEN);

        this.txtMontante.setText(montante.toPlainString());		
	}

	@Override
	protected void btnLimparClick(ActionEvent ev) {
		this.txtCapital.setText("");
		this.txtTaxaJuros.setText("");
		this.txtPeriodo.setText("");
		this.txtMontante.setText("");
	}

	@Override
	protected void btnFecharClick(ActionEvent ev) {
		this.setVisible(false);
		this.dispose();		
	}
	
    private BigDecimal toBigDecimal(String valor) {
        try {
            return new BigDecimal(valor).setScale(4, RoundingMode.HALF_EVEN);
        } catch (Exception ex) {
            return BigDecimal.ZERO;
        }
    }

}
