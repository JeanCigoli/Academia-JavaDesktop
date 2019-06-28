package br.senai.sp.model;

import br.senai.sp.model.Aluno;

public class Calculos {
	
	public Aluno aluno;
	
	public double calcularImc() {
		double imc = 0.0;	
		imc = aluno.getPeso() / Math.pow(aluno.getAltura()/100.0, 2);
		return imc;
	}
	
	public String situacaoImc(double imc) {

		String situacaoImc = "";
		
		if(imc < 17) {
			situacaoImc = "Muito Abaixo do Peso";
		}else if(imc <= 18.49) {
			situacaoImc = "Abaixo do Peso";
		}else if(imc <= 24.99) {
			situacaoImc = "Peso Normal";
		}else if(imc <= 29.99) {
			situacaoImc = "Acima do Peso";
		}else if(imc <= 34.99) {
			situacaoImc = "Obesidade I";
		}else if(imc <= 39.99) {
			situacaoImc = "Obesidade II";
		}else if(imc > 40 ){
			situacaoImc = "Obesidade III";
		}else{
			situacaoImc = "";
		}
		return situacaoImc;
	}
	
	public double calculoTmb() {
		double tmb = 0.0;
		if(aluno.getSexo() == 'F') {
			tmb = 665 + (9.6 * aluno.getPeso()) + (1.8 * aluno.getAltura()) - (4.7 * aluno.getIdade());
			return tmb;
		}else {
			tmb = 66 + (13.7 * aluno.getPeso()) + (5.0 * aluno.getAltura()) - (6.8 * aluno.getIdade());
			return tmb;
		}
		
	}
	
	public double calculoFmc() {
			double fmc = 0.0;
			if(aluno.getSexo() == 'F') {
				fmc = 226 - aluno.getIdade();
				return fmc;
			}else {
				fmc = 220 - aluno.getIdade();
				return fmc;
			}
		
	}

}
