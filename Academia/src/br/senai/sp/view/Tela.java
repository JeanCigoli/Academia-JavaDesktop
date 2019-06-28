package br.senai.sp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import br.senai.sp.model.Calculos;
import br.senai.sp.model.Aluno;

public class Tela extends JFrame {

	public Tela() {
		
		this.setSize(700, 800);
		this.setTitle("Academia");
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//definindo as cores
		Color azulEscuro = new Color(3, 72, 99);
		Color azul = new Color(141, 211, 239);
		Color branco = new Color(255, 255, 255);
		Color cinza = new Color(181, 182, 183);
		
		Color verde = new Color(106, 237, 104);
		Color amarelo = new Color(237, 244, 36);
		Color vermelho = new Color(237, 78, 75);
		Color preto = new Color(0,0,0);
		
		//Criando o painel de titulo
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(azulEscuro);
		panelTitulo.setBounds(0, 0, 685, 90);
		
		
		Border lineBorder = BorderFactory.createLineBorder(preto);
		
		Font titulo = new Font("Arial" , Font.BOLD , 32);
		
		//Criando o texto de titulo
		JLabel lblTitulo = new JLabel("Cadastro de Alunos");
		lblTitulo.setFont(titulo);
		lblTitulo.setBounds(125, 25, 665, 50);
		lblTitulo.setForeground(branco);
		
		JLabel lblIcon = new JLabel();
		lblIcon.setBounds(25, 15, 60, 60);
		lblIcon.setIcon(new ImageIcon(Tela.class.getResource("/br/senai/sp/imagens/registration.png")));
		
		
		//adicionando na Tela
		panelTitulo.add(lblTitulo);
		panelTitulo.add(lblIcon);
		
		// Criando o principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(branco);
		panelPrincipal.setBounds(0, 90, 685, 765);
		
		
		//Criando o Painel pessoal
		JPanel panelDadosPessoais = new JPanel();
		panelDadosPessoais.setLayout(null);
		panelDadosPessoais.setBackground(branco);
		panelDadosPessoais.setBounds(10, 10, 665, 120);
		
		TitledBorder bordaDadosPessoais = new TitledBorder(lineBorder, "Dados pessoais:");
		panelDadosPessoais.setBorder(bordaDadosPessoais);
		
		//Declarando os componetes do painel dados Pessoais
		JLabel lblNome = new JLabel("Nome: ");
		JLabel lblIdade = new JLabel("Idade: ");
		JLabel lblDataNascimento = new JLabel("Data Nasc.: ");
		JLabel lblSexo = new JLabel("Sexo: ");
		
		JTextField txtNome = new JTextField();
		JTextField txtIdade = new JTextField();
		JTextField txtDataNascimento = new JTextField();
		
		ButtonGroup gbSexo = new ButtonGroup();
		
		JRadioButton btrMasculino = new JRadioButton("M");
		JRadioButton btrFeminino = new JRadioButton("F");
		
		gbSexo.add(btrMasculino);
		gbSexo.add(btrFeminino);
		
		lblNome.setBounds(25, 20, 50, 30);
		txtNome.setBounds(25, 55, 255, 30);
		lblDataNascimento.setBounds(300, 20, 70, 30);
		txtDataNascimento.setBounds(300, 55, 150, 30);
		lblIdade.setBounds(470, 20, 50, 30);
		txtIdade.setBounds(470, 55, 50, 30);
		lblSexo.setBounds(560, 20, 50, 30);
		btrFeminino.setBounds(560, 55, 40, 30);
		btrFeminino.setBackground(branco);
		btrMasculino.setBounds(600, 55, 40, 30);
		btrMasculino.setBackground(branco);
		
		panelDadosPessoais.add(lblNome);
		panelDadosPessoais.add(lblIdade);
		panelDadosPessoais.add(lblSexo);
		panelDadosPessoais.add(lblDataNascimento);
		panelDadosPessoais.add(txtNome);
		panelDadosPessoais.add(txtIdade);
		panelDadosPessoais.add(txtDataNascimento);
		panelDadosPessoais.add(btrMasculino);
		panelDadosPessoais.add(btrFeminino);
		
		
		//Declarando os componentes do painel dados Endereço
		JPanel panelComunicacao = new JPanel();
		panelComunicacao.setLayout(null);
		panelComunicacao.setBackground(branco);
		panelComunicacao.setBounds(10, 140, 665,200);
		
		TitledBorder bordaComunicacao = new TitledBorder( lineBorder,"Comunicação:");
		panelComunicacao.setBorder(bordaComunicacao);
		
		JLabel lblEndereco = new JLabel("Endereço: ");
		JLabel lblEmail = new JLabel("E-mail: ");
		JLabel lblTelefone = new JLabel("Telefone: ");
		
		JTextArea txtEndereco = new JTextArea();
		TitledBorder bordaEndereco = new TitledBorder(lineBorder,"");
		txtEndereco.setBorder(bordaEndereco);
		JTextField txtEmail = new JTextField();
		JTextField txtTelefone = new JTextField();
		
		lblEndereco.setBounds(25, 25, 80, 30);
		txtEndereco.setBounds(25, 55, 320, 125);
		lblEmail.setBounds(370, 25, 50, 30);
		txtEmail.setBounds(370, 55, 270, 30);
		lblTelefone.setBounds(370, 105, 80, 30);
		txtTelefone.setBounds(370, 145, 270, 30);
		
		panelComunicacao.add(lblTelefone);
		panelComunicacao.add(lblEmail);
		panelComunicacao.add(lblEndereco);
		panelComunicacao.add(txtTelefone);
		panelComunicacao.add(txtEmail);
		panelComunicacao.add(txtEndereco);
		
		
		// Criado o painel de Bio
		JPanel panelBio = new JPanel();
		panelBio.setLayout(null);
		panelBio.setBackground(branco);
		panelBio.setBounds(10, 350, 180, 200);
		
		TitledBorder bordaBio = new TitledBorder(lineBorder , "Bio:");
		panelBio.setBorder(bordaBio);
		
		JLabel lblPeso = new JLabel("Peso: ");
		JLabel lblAltura = new JLabel("Altura: ");
		JLabel lblKg = new JLabel("Kg");
		JLabel lblCm = new JLabel("Cm");
		
		JTextField txtPeso = new JTextField();
		JTextField txtAltura = new JTextField();
		
		//posicionando os paineis na tela
		
		lblPeso.setBounds(25, 25, 50, 30);
		txtPeso.setBounds(25, 55, 100, 30);
		lblKg.setBounds(135, 55, 50, 30);
		lblAltura.setBounds(25, 105, 50, 30);
		txtAltura.setBounds(25, 135, 100, 30);
		lblCm.setBounds(135, 135, 50, 30);
		
		panelBio.add(lblPeso);
		panelBio.add(lblAltura);
		panelBio.add(lblKg);
		panelBio.add(lblCm);
		panelBio.add(txtPeso);
		panelBio.add(txtAltura);
		
		
		//Criando o Painel de resposta
		JPanel panelResposta = new JPanel();
		panelResposta.setLayout(null);
		panelResposta.setBackground(branco);
		panelResposta.setBounds(200, 350, 475, 200);
		
		TitledBorder bordaResposta = new TitledBorder(lineBorder ,"Resultados:");
		panelResposta.setBorder(bordaResposta);
		
		//declarando os componentes do painel resposta
		JLabel lblImc = new JLabel("Imc: ");
		JLabel lblImcString = new JLabel("Situação do imc!");
		JLabel lblFmc = new JLabel("Fmc: ");
		JLabel lblTmb = new JLabel("Tmb: ");
		
		JLabel lblResultadoImc = new JLabel("00000");
		JLabel lblResultadoFmc = new JLabel("00000");
		JLabel lblResultadoTmb = new JLabel("00000");
		
		
		//Colocando os botoes na tela
		panelResposta.add(lblImcString);
		panelResposta.add(lblImc);
		panelResposta.add(lblFmc);
		panelResposta.add(lblTmb);
		panelResposta.add(lblResultadoImc);
		panelResposta.add(lblResultadoFmc);
		panelResposta.add(lblResultadoTmb);
		
		// Adicionando a posicao na tela
		lblImc.setBounds(25, 25, 50, 30);
		lblResultadoImc.setBounds(65, 25, 100, 30);
		lblImcString.setBounds(155, 25, 150, 30);
		lblFmc.setBounds(25, 80, 40, 30);
		lblTmb.setBounds(25, 135, 40, 30);
		lblResultadoFmc.setBounds(65, 80, 150, 30);
		lblResultadoTmb.setBounds(65, 135, 150, 30);	
		
		
		
		JButton btCalcular = new JButton("Gravar");
		btCalcular.setBounds(463, 560, 210, 70);
		btCalcular.setIcon(new ImageIcon(Tela.class.getResource("/br/senai/sp/imagens/diskette.png")));
		panelPrincipal.add(btCalcular);
		
		
		
		// Calculando os botoes
		btCalcular.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
								
				Calculos calcular = new Calculos();
				Aluno aluno = new Aluno();
				calcular.aluno = aluno;
				
				// Para validar os Códigos
				
				if (txtNome.getText().matches("^[A-Z a-z ãõéíáóúç]+$")) {
					aluno.setNome(txtNome.getText()); 
					if (txtIdade.getText().matches("^[0-9][0-9]?$")) {
						//pessoa.setIdade(Integer.parseInt(txtIdade.getText()));
						if (txtPeso.getText().matches("^[0-9][0-9][0-9 .]?[0-9]?[0-9]?[0-9]?$")){
							aluno.setPeso(Double.parseDouble(txtPeso.getText()));
							if (txtAltura.getText().matches("^[0-9][0-9][0-9]?$")) {
								aluno.setAltura(Integer.parseInt(txtAltura.getText()));
								
								if(btrMasculino.isSelected()) {
									aluno.setSexo('M');
								}else if(btrFeminino.isSelected()) {
									aluno.setSexo('F');
								}			
								
								double imc = calcular.calcularImc();
								
								lblResultadoImc.setText(String.format("%.2f",imc));
								lblImcString.setText(calcular.situacaoImc(imc));
								lblResultadoFmc.setText(String.format("%.2f",calcular.calculoFmc()));
								lblResultadoTmb.setText(String.format("%.2f",calcular.calculoTmb()));
								
								if(calcular.situacaoImc(imc) == "Peso Normal") {
									panelResposta.setBackground(verde);
								} else if(calcular.situacaoImc(imc) == "Abaixo do Peso" || calcular.situacaoImc(imc) == "Acima do Peso" ) {
									panelResposta.setBackground(amarelo);
								}else if (calcular.situacaoImc(imc) == "Muito Abaixo do Peso" || calcular.situacaoImc(imc) == "Obesidade I"){
									panelResposta.setBackground(vermelho);
								}else if (calcular.situacaoImc(imc) == "Obesidade II" || calcular.situacaoImc(imc) == "Obesidade III"){
									panelResposta.setBackground(vermelho);
								}
								
								
					        }else {
					        	JOptionPane.showMessageDialog(null, "Por favor, digite uma altura válida!");
					        }
				        }else {
				        	JOptionPane.showMessageDialog(null, "Por favor, digite um peso válida!");
				        }
			        }else {
			        	JOptionPane.showMessageDialog(null, "Por favor, digite uma idade válida!");
			        }
		        }else {
		        	JOptionPane.showMessageDialog(null, "Por favor, digite um nome!");
		        }
				
					
				//JOptionPane.showConfirmDialog
				
			}
		});
		
		this.getContentPane().add(panelTitulo);
		this.getContentPane().add(panelPrincipal);
		this.getContentPane().add(panelDadosPessoais);
		this.getContentPane().add(panelComunicacao);
		this.getContentPane().add(panelBio);
		this.getContentPane().add(panelResposta);
		panelPrincipal.add(panelDadosPessoais);
		panelPrincipal.add(panelComunicacao);
		panelPrincipal.add(panelBio);
		panelPrincipal.add(panelResposta);

	}

}
