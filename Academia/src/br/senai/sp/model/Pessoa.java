package br.senai.sp.model;

public class Pessoa {

	private String nome;
	private int idade;
	private double peso;
	private double altura;
	private char sexo;
	private Calculos calculos;

	// METODOS DE ACESSO SETTER E GETTER

	public void setNome(String nome) {
		this.nome = nome;
	};

	public String getNome() {
		return this.nome;
	};

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return this.idade;
	};

	public void setPeso(double peso) {
		this.peso = peso;
	};

	public double getPeso() {
		return this.peso;
	};

	public void setAltura(double altura) {
		this.altura = altura;
	};

	public double getAltura() {
		return this.altura;
	};

	public void setSexo(char sexo) {
		this.sexo = sexo;
	};

	public char getSexo() {
		return this.sexo;
	};

}
