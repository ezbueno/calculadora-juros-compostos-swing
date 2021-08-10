package com.buenoezandro.calculadora;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class CalculadoraForm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static final int TAMANHO_TXT = 10;

	protected JPanel pnlForm;
	protected JPanel pnlRodape;

	protected JButton btnCalcular;
	protected JButton btnLimpar;
	protected JButton btnFechar;

	protected JLabel lblCapital;
	protected JTextField txtCapital;

	protected JLabel lblTaxaJuros;
	protected JTextField txtTaxaJuros;

	protected JLabel lblPeriodo;
	protected JTextField txtPeriodo;

	protected JLabel lblMontante;
	protected JTextField txtMontante;
	
	protected abstract void btnCalcularClick(ActionEvent ev);
	protected abstract void btnLimparClick(ActionEvent ev);
	protected abstract void btnFecharClick(ActionEvent ev);

	protected CalculadoraForm() {
		this.inicializar();
		this.eventos();
	}

	private void inicializar() {
		this.setTitle("Calculadora");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(this.getPnlForm(), BorderLayout.CENTER);
		this.getContentPane().add(this.getPnlRodape(), BorderLayout.PAGE_END);
		
		this.pack();
	}
		
	private void eventos() {
		this.btnCalcular.addActionListener(this::btnCalcularClick);
		this.btnLimpar.addActionListener(this::btnLimparClick);
		this.btnFechar.addActionListener(this::btnFecharClick);
	}

	public JPanel getPnlForm() {
		if (this.pnlForm == null) {
			this.pnlForm = new JPanel(new GridLayout(4, 2));
			
			this.lblCapital = new JLabel("Capital");
			this.txtCapital = new JTextField(TAMANHO_TXT);
			
			this.lblTaxaJuros = new JLabel("Taxa de Juros");
			this.txtTaxaJuros = new JTextField(TAMANHO_TXT);
			
			this.lblPeriodo = new JLabel("Período");
			this.txtPeriodo = new JTextField(TAMANHO_TXT);
			
			this.lblMontante = new JLabel("Montante");
			this.txtMontante = new JTextField(TAMANHO_TXT);
			this.txtMontante.setEditable(false);
			
			this.pnlForm.add(this.lblCapital);
			this.pnlForm.add(this.txtCapital);
			
			this.pnlForm.add(this.lblTaxaJuros);
			this.pnlForm.add(this.txtTaxaJuros);
			
			this.pnlForm.add(this.lblPeriodo);
			this.pnlForm.add(this.txtPeriodo);
			
			this.pnlForm.add(this.lblMontante);
			this.pnlForm.add(this.txtMontante);
		}
		return this.pnlForm;
	}

	public JPanel getPnlRodape() {
		if (this.pnlRodape == null) {
			this.pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

			this.btnCalcular = new JButton("Calcular");
			this.btnLimpar = new JButton("Limpar");
			this.btnFechar = new JButton("Fechar");

			this.pnlRodape.add(this.btnCalcular);
			this.pnlRodape.add(this.btnLimpar);
			this.pnlRodape.add(this.btnFechar);
		}
		return this.pnlRodape;
	}

}
