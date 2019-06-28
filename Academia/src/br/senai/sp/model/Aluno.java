package br.senai.sp.model;

public class Aluno {
	
	private int matricula;
	private String nome;
	private int idade;
	private double peso;
	private int altura;
	private char sexo;
	private String endereco;
	private String telefone;
	private String email;
	private String dataDeNascimento;

	// METODOS DE ACESSO SETTER E GETTER

	public void setNome(String nome) {
		this.nome = nome;
	};

	public String getNome() {
		return this.nome;
	};

	public int getIdade() {
		return this.idade;
	};

	public void setPeso(double peso) {
		this.peso = peso;
	};

	public double getPeso() {
		return this.peso;
	};

	public void setAltura(int altura) {
		this.altura = altura;
	};

	public int getAltura() {
		return this.altura;
	};

	public void setSexo(char sexo) {
		this.sexo = sexo;
	};

	public char getSexo() {
		return this.sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String toString() {
		return "Aluno [matricula = " + matricula + ", nome = " + nome + ", idade = " + idade + ", peso = " + peso + ", altura = "
				+ altura + ", sexo = " + sexo + ", endereco = " + endereco + ", telefone = " + telefone + ", email = " + email
				+ ", dataDeNascimento = " + dataDeNascimento + "]";
	}

}
