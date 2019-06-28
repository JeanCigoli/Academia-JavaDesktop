package br.senai.sp.utils;

public class Date {
		
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
	
}
