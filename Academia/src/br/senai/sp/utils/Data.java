package br.senai.sp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
		
	public static String converterParaBanco(String date){
		
		// 28/03/2019 ---> 2019-03-28
		
		String dataBanco;
		String dia = date.substring(0, 2);
		String mes = date.substring(3, 5);
		String ano = date.substring(6, 10);
		
		dataBanco = ano + "-" + mes + "-" + dia;
		
		return dataBanco;
	}
	
	public static String converterParaUsuario(String date) {

		// 2019-03-28 ---> 28/03/2019 

		String dataTela;
		String dia = date.substring(8, 10);
		String mes = date.substring(5, 7);
		String ano = date.substring(0, 4);

		dataTela = dia + "/" + mes + "/" + ano;

		return dataTela;
	}
	
	public static int calcularIdade(String dataNascimento) {
		 
		 // OBTER A DATA ATUAL
		 Date hoje = new Date();
		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 
		 //TRANSFORMAR A DATA DE NASCIMENTO EM UM OBJETO DE TIPO DATE
		 
		 Date dataNascimentoDate = null;
		 
		 try {
			dataNascimentoDate = df.parse(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		 // Obtendo a diferença da atual com a do nascimento
		 
		long mils = hoje.getTime() - dataNascimentoDate.getTime(); 
		
		double idade = mils / 1000 / 60 / 60 / 24 / 365.25;
		
		return (int)idade;
	}
	
}
