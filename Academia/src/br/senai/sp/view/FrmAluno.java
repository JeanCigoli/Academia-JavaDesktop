package br.senai.sp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import br.senai.sp.model.Calculos;
import br.senai.sp.utils.Data;
import br.senai.sp.dao.AlunoDAO;
import br.senai.sp.model.Aluno;

public class FrmAluno extends JDialog{

	public JTextField txtNome;	
	public JTextField txtIdade;
	public JTextField txtPeso;
	public JTextField txtAltura;
	public JTextField txtDataNascimento;
	public JTextArea txtEndereco;
	public JTextField txtTelefone;
	public JTextField txtEmail;
	public JRadioButton btrMasculino;
	public JRadioButton btrFeminino;
	
	public JLabel lblTitulo;
	public JLabel lblMatricula;
	
	public JButton btGravar;
	
	public JLabel lblIcon;
	
	public JLabel lblResultadoTmb;
	public JLabel lblResultadoImc;
	public JLabel lblResultadoFmc;
	public JLabel lblImcString;
	
	public JPanel panelTitulo;
	
	public JPanel panelResposta;
	
	//definindo as cores
	public Color azulEscuro = new Color(3, 72, 99);
	public Color azul = new Color(141, 211, 239);
	public Color branco = new Color(255, 255, 255);
	public Color cinza = new Color(181, 182, 183);
			
	public Color verde = new Color(19, 191, 21);
	public Color amarelo = new Color(237, 218, 9);
	public Color vermelho = new Color(237, 78, 75);
	public Color preto = new Color(0,0,0);
	
	public FrmAluno() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(700, 800);
		this.setTitle("Cadastro de Alunos");
		this.setLayout(null);
		this.setResizable(false);
		// Para colocar no centro da Tela
		this.setLocationRelativeTo(null);
		
		//Criando o painel de titulo
		panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(azulEscuro);
		panelTitulo.setBounds(0, 0, 685, 90);
		
		
		Border lineBorder = BorderFactory.createLineBorder(preto);
		
		Font titulo = new Font("Arial" , Font.BOLD , 32);
		
		//Criando o texto de titulo
		lblTitulo = new JLabel("Cadastro de Alunos");
		lblTitulo.setFont(titulo);
		lblTitulo.setBounds(125, 25, 665, 50);
		lblTitulo.setForeground(branco);
		
		lblMatricula = new JLabel("000");
		lblMatricula.setBounds(570, 25, 100, 50);
		lblMatricula.setFont(titulo);
		lblMatricula.setForeground(branco);
		
		lblIcon = new JLabel();
		lblIcon.setBounds(25, 15, 60, 60);
		lblIcon.setIcon(new ImageIcon(FrmAluno.class.getResource("/br/senai/sp/imagens/registration.png")));
		
		
		//adicionando na Tela
		panelTitulo.add(lblTitulo);
		panelTitulo.add(lblMatricula);
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
		
		txtNome = new JTextField();
		txtIdade = new JTextField();
		txtIdade.setEditable(false);
		txtIdade.setHorizontalAlignment(JTextField.CENTER);
		txtDataNascimento = new JTextField();
		
		ButtonGroup gbSexo = new ButtonGroup();
		
		btrMasculino = new JRadioButton("M");
		btrFeminino = new JRadioButton("F");
		
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
		
		
		txtEndereco = new JTextArea();
		txtEndereco.setLineWrap(true);
		txtEmail = new JTextField();
		txtTelefone = new JTextField();
		
		
		JScrollPane scrollEndereco = new JScrollPane();
		scrollEndereco.setBounds(25, 55, 320, 125);
		scrollEndereco.setViewportView(txtEndereco);
		panelComunicacao.add(scrollEndereco);
		
		
		lblEndereco.setBounds(25, 25, 80, 30);
		lblEmail.setBounds(370, 25, 50, 30);
		txtEmail.setBounds(370, 55, 270, 30);
		lblTelefone.setBounds(370, 105, 80, 30);
		txtTelefone.setBounds(370, 145, 270, 30);
		
		panelComunicacao.add(lblTelefone);
		panelComunicacao.add(lblEmail);
		panelComunicacao.add(lblEndereco);
		panelComunicacao.add(txtTelefone);
		panelComunicacao.add(txtEmail);
		
		
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
		
		txtPeso = new JTextField();
		txtPeso.setHorizontalAlignment(JTextField.RIGHT);
		txtAltura = new JTextField();
		txtAltura.setHorizontalAlignment(JTextField.RIGHT);
		
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
		panelResposta = new JPanel();
		panelResposta.setLayout(null);
		panelResposta.setBackground(branco);
		panelResposta.setBounds(200, 350, 475, 200);
		
		TitledBorder bordaResposta = new TitledBorder(lineBorder ,"Resultados:");
		panelResposta.setBorder(bordaResposta);
		
		//declarando os componentes do painel resposta
		JLabel lblImc = new JLabel("Imc: ");
		lblImcString = new JLabel("Situação do imc!");
		JLabel lblFmc = new JLabel("Fmc: ");
		JLabel lblTmb = new JLabel("Tmb: ");
		
		lblResultadoImc = new JLabel("00000");
		lblResultadoFmc = new JLabel("00000");
		lblResultadoTmb = new JLabel("00000");
		
		
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
		
		JLabel lblDescImc = new JLabel("IMC - Índice de Massa Corporal");
		JLabel lblDescTmb = new JLabel("TMB - Taxa Metabólica Basal");
		JLabel lblDescFcm = new JLabel("FCM - Frequência Cardíaca Máxima");
		
		lblDescImc.setBounds(25, 550, 210, 50);
		lblDescTmb.setBounds(25, 570, 210, 50);
		lblDescFcm.setBounds(25, 590, 210, 50);
		
		panelPrincipal.add(lblDescImc);
		panelPrincipal.add(lblDescTmb);
		panelPrincipal.add(lblDescFcm);
		
		btGravar = new JButton("Gravar");
		btGravar.setBounds(463, 560, 210, 70);
		btGravar.setIcon(new ImageIcon(FrmAluno.class.getResource("/br/senai/sp/imagens/diskette.png")));
		panelPrincipal.add(btGravar);
		
		// --------------------- Ouvintes -------------------------------
		
		// Calculando os botoes
		btGravar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {					
				
				if(btGravar.getText().equals("Gravar")) {
					gravar();
				}else if(btGravar.getText().equals("Excluir")) {
					excluir();
				}else {
					atualizar();
				}
				
			}

			
		});
		
		
		txtDataNascimento.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
				txtIdade.setText(String.valueOf(Data.calcularIdade(txtDataNascimento.getText())));
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
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
		
		this.setModal(true);

	}
	
	private void atualizar() {
		
		AlunoDAO dao = new AlunoDAO(criarAluno());
		
		
		dao.atualizar();
		JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!",
				"Atualização de aluno", 
				JOptionPane.INFORMATION_MESSAGE, null);
		
	}

	private void excluir() {
		
		int resposta = JOptionPane.showConfirmDialog(null,
				"Confirma a exclusão do aluno(a) " + txtNome.getText() + " ?", 
				"Excluir Aluno", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
		
		if (resposta == 0) {
			AlunoDAO dao = new AlunoDAO();
			dao.deletar(Integer.parseInt(lblMatricula.getText()));
			this.dispose() ;
		}
	}
	
	private void gravar() {
		
		AlunoDAO dao = new AlunoDAO(criarAluno());
		
		dao.gravar();
		JOptionPane.showMessageDialog(null, "Aluno registrado com sucesso", "Novo Aluno", JOptionPane.INFORMATION_MESSAGE, null);

		btGravar.setEnabled(false);
		
	}

	private Aluno criarAluno() {
		
		Aluno aluno = new Aluno();
		
		// Para validar os Códigos
		
		if(!btGravar.getText().equals("Gravar")) {
			aluno.setMatricula(Integer.parseInt(lblMatricula.getText()));
		}
			
		aluno.setNome(txtNome.getText());
		aluno.setPeso(Double.parseDouble(txtPeso.getText()));
		aluno.setAltura(Integer.parseInt(txtAltura.getText()));
						
		if(btrMasculino.isSelected()) {
			aluno.setSexo('M');
		}else if(btrFeminino.isSelected()) {
			aluno.setSexo('F');
		}	
					
		aluno.setEndereco(txtEndereco.getText());
		aluno.setTelefone(txtTelefone.getText());
		aluno.setEmail(txtEmail.getText());
						
		// Coleta a data e transforma para o modo do banco
		aluno.setDataDeNascimento(Data.converterParaBanco(txtDataNascimento.getText()));
		
		calcularBiometria(aluno);
		
		return aluno;
	}
	
	
	public void calcularBiometria(Aluno aluno) {
		
		Calculos calcular = new Calculos();
		calcular.aluno = aluno;
		
		double imc = calcular.calcularImc();
		
		lblResultadoImc.setText(String.format("%.2f",imc));
		lblImcString.setText(calcular.situacaoImc(imc));
		lblResultadoFmc.setText(String.format("%.2f",calcular.calculoFmc()));
		lblResultadoTmb.setText(String.format("%.2f",calcular.calculoTmb()));
		
		
		// para colocar cor na borda da BIO
		
		Border verdeBorder = BorderFactory.createLineBorder(verde);
		Border amareloBorder = BorderFactory.createLineBorder(amarelo);
		Border vermelhoBorder = BorderFactory.createLineBorder(vermelho);
						
		if(calcular.situacaoImc(imc) == "Peso Normal") {
							
			TitledBorder bordaResposta = new TitledBorder(verdeBorder ,"Resultados:");
			panelResposta.setBorder(bordaResposta);
							
		} else if(calcular.situacaoImc(imc) == "Abaixo do Peso" || calcular.situacaoImc(imc) == "Acima do Peso" ) {
							
			TitledBorder bordaResposta = new TitledBorder(amareloBorder ,"Resultados:");
			panelResposta.setBorder(bordaResposta);
							
		}else if (calcular.situacaoImc(imc) == "Muito Abaixo do Peso" || calcular.situacaoImc(imc) == "Obesidade I"){
							
			TitledBorder bordaResposta = new TitledBorder(vermelhoBorder ,"Resultados:");
			panelResposta.setBorder(bordaResposta);
							
		}else if (calcular.situacaoImc(imc) == "Obesidade II" || calcular.situacaoImc(imc) == "Obesidade III"){
							
			TitledBorder bordaResposta = new TitledBorder(vermelhoBorder ,"Resultados:");
			panelResposta.setBorder(bordaResposta);
							
		}
		
	}

}
