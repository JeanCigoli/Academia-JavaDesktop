package br.senai.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.model.Aluno;

public class AlunoDAO {
	
	private Aluno aluno;
	
	public AlunoDAO(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public AlunoDAO() {};
	
	// Create
	public void gravar() {
		
		String sql = "INSERT INTO tbl_aluno "
				+ "(nome, telefone, email, data_nascimento, sexo, "
				+ "peso, altura, endereco)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, aluno.getNome());
			stm.setString(2, aluno.getTelefone());
			stm.setString(3, aluno.getEmail());
			stm.setString(4, aluno.getDataDeNascimento());
			stm.setString(5, String.valueOf(aluno.getSexo()));
			stm.setDouble(6, aluno.getPeso());
			stm.setInt(7, aluno.getAltura());
			stm.setString(8, aluno.getEndereco());
			
			// Executar o comando no banco!!
			stm.execute();
			
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// Read
	public Aluno getAluno(int matricula){

		Aluno aluno = new Aluno();
		
		String sql = "SELECT * FROM tbl_aluno WHERE matricula = ?";
		
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, matricula);
			
			ResultSet rs;
			
			// Para executar e voltar, tem q criar um Result Set para poder manipular
			rs = stm.executeQuery();
			
			// O result sempre retorna no primero indice, ou seja a columa de titulo, então usasse o next para ir pra proxima
			rs.next();
			
			// Para criar o aluno
			
			aluno.setMatricula(rs.getInt("matricula"));
			aluno.setNome(rs.getString("nome"));
			aluno.setTelefone(rs.getString("telefone"));
			aluno.setEmail(rs.getString("email"));
			aluno.setDataDeNascimento(rs.getString("data_nascimento"));
			aluno.setSexo(rs.getString("sexo").charAt(0));
			aluno.setPeso(rs.getDouble("peso"));
			aluno.setAltura(rs.getInt("altura"));
			aluno.setEndereco(rs.getString("endereco"));
				
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		return aluno;
		
	}
	
	public ArrayList<Aluno> listarAlunos() {
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		Aluno aluno;

		String sql = "SELECT * FROM tbl_aluno";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);

			ResultSet rs;

			// Para executar e voltar, tem q criar um Result Set para poder manipular
			rs = stm.executeQuery();

			// O result sempre retorna no primero indice, ou seja a columa de titulo, então
			// usasse o next para ir pra proxima
			while (rs.next()) {

				aluno = new Aluno();
			
				// Para criar o aluno
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEmail(rs.getString("email"));
				aluno.setDataDeNascimento(rs.getString("data_nascimento"));
				aluno.setSexo(rs.getString("sexo").charAt(0));
				aluno.setPeso(rs.getDouble("peso"));
				aluno.setAltura(rs.getInt("altura"));
				aluno.setEndereco(rs.getString("endereco"));
				
				alunos.add(aluno);
			}	
			
			Conexao.fecharConexao();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return alunos;
		
	}
	
	public ArrayList<Aluno> listarAlunosPorSexo(char sexo) {
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		Aluno aluno;

		String sql = "SELECT * FROM tbl_aluno WHERE sexo = ?";

		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1 , String.valueOf(sexo));

			ResultSet rs;

			// Para executar e voltar, tem q criar um Result Set para poder manipular
			rs = stm.executeQuery();
			


			// O result sempre retorna no primero indice, ou seja a columa de titulo, então
			// usasse o next para ir pra proxima
			while (rs.next()) {

				aluno = new Aluno();

				// Para criar o aluno
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEmail(rs.getString("email"));
				aluno.setDataDeNascimento(rs.getString("data_nascimento"));
				aluno.setSexo(rs.getString("sexo").charAt(0));
				aluno.setPeso(rs.getDouble("peso"));
				aluno.setAltura(rs.getInt("altura"));
				aluno.setEndereco(rs.getString("endereco"));

				alunos.add(aluno);
			}
			
			Conexao.fecharConexao();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return alunos;
	}
	
	// Update
	public void atualizar() {
		
		String sql = "UPDATE tbl_aluno SET nome = ?, telefone = ?, email = ?, data_nascimento = ?, "
				+ "sexo = ?, peso = ?, altura = ?, endereco = ? WHERE matricula = ?";
		
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, aluno.getNome());
			stm.setString(2, aluno.getTelefone());
			stm.setString(3, aluno.getEmail());
			stm.setString(4, aluno.getDataDeNascimento());
			stm.setString(5, String.valueOf(aluno.getSexo()));
			stm.setDouble(6, aluno.getPeso());
			stm.setInt(7, aluno.getAltura());
			stm.setString(8, aluno.getEndereco());
			stm.setInt(9, aluno.getMatricula());
			
			// Executar o comando no banco!!
			stm.execute();
			
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// Delete
	public void deletar(int matricula) {
		
		String sql = "DELETE FROM tbl_aluno	WHERE matricula = ? ";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, matricula);
			
			// Executar o comando no banco!!
			stm.execute();
			
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	};

}
