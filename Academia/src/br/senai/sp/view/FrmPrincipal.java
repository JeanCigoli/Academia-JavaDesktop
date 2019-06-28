package br.senai.sp.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.dao.AlunoDAO;
import br.senai.sp.model.Aluno;
import br.senai.sp.utils.Data;

public class FrmPrincipal extends JFrame {

	private final JTable tabelaAlunos = new JTable();
	private final JScrollPane scroll = new JScrollPane();
	private DefaultTableModel modelo; 
	private JPanel painelTabela;

	public Color vermelho = new Color(237, 78, 75);

	public FrmPrincipal() {

		setTitle("Academia Boa Forma");
		setSize(700, 565);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);

		Color azulEscuro = new Color(3, 72, 99);
		Color azul = new Color(141, 211, 239);
		Color branco = new Color(255, 255, 255);
		Color cinza = new Color(181, 182, 183);

		// Criar painel da tabela

		painelTabela = new JPanel();
		painelTabela.setBounds(10, 10, 660, 400);
		painelTabela.setLayout(null);

		TitledBorder bordaTabela = new TitledBorder("Lista de Alunos");
		painelTabela.setBorder(bordaTabela);

		// Criando painel de botões

		JPanel painelBotao = new JPanel();
		painelBotao.setBounds(12, 420, 656, 90);
		painelBotao.setLayout(null);

		TitledBorder bordaBotao = new TitledBorder("");
		painelBotao.setBorder(bordaBotao);

		// Criando os botões

		JButton btAdicionar = new JButton();
		btAdicionar.setBounds(15, 15, 100, 60);
		painelBotao.add(btAdicionar);
		btAdicionar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/adicionar48.png")));
		btAdicionar.setToolTipText("Adicionar Novo Aluno");

		JButton btExcluir = new JButton();
		btExcluir.setBounds(125, 15, 100, 60);
		painelBotao.add(btExcluir);
		btExcluir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/excluir48.png")));
		btExcluir.setToolTipText("Excluir Aluno");

		JButton btEditar = new JButton();
		btEditar.setBounds(235, 15, 100, 60);
		painelBotao.add(btEditar);
		btEditar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/editar48.png")));
		btEditar.setToolTipText("Alterar dados do Aluno");

		JButton btSair = new JButton();
		btSair.setBounds(540, 15, 100, 60);
		painelBotao.add(btSair);
		btSair.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/sair32.png")));
		btSair.setToolTipText("Sair do Sistema");


		// ------------------------ Ouvintes de ação ---------------------------------
		// //

		btAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrmAluno frmAluno = new FrmAluno();
				frmAluno.setVisible(true);
			}
		});

		btEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				abrirFormularioAluno("Atualização de Aluno", "Atualizar", "edit.png");

			}
		});

		btExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				abrirFormularioAluno("Excluir Aluno", "Excluir", "delete.png");

			}
		});

		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int resposta;

				resposta = JOptionPane.showConfirmDialog(null, "Confirma a saída do sistema?", "Fechar Sistema",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (resposta == 0) {
					System.exit(EXIT_ON_CLOSE);
				}

			}
		});

		getContentPane().add(painelTabela);
		getContentPane().add(painelBotao);

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
				criarTabela();
			}
		});

		this.setVisible(true);

	}

	private void criarTabela() {
		
		// criar a tabela com a lista
		scroll.setBounds(15, 25, 630, 360);

		// criar os vetores/matriz para preencher a JTable

		String[] cabecalho = { "MAT", "NOME", "E-MAIL", "TELEFONE" };

		AlunoDAO dao = new AlunoDAO();
		ArrayList<Aluno> alunos = dao.listarAlunos();

		// Para pegar o máximo de linhas na tabela
		int linhas = alunos.size();

		// PAra ir pulando de linha;
		int linha = 0;

		String[][] dados = new String[linhas][4];

		for (Aluno aluno : alunos) {
			dados[linha][0] = String.valueOf(aluno.getMatricula());
			dados[linha][1] = aluno.getNome();
			dados[linha][2] = aluno.getEmail();
			dados[linha][3] = aluno.getTelefone();
			linha++;
		}

		modelo = new DefaultTableModel(dados, cabecalho);

		// Criar a tabela (JTable)
		tabelaAlunos.setModel(modelo);

		// Determinar largura das colunas da tabela
		tabelaAlunos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaAlunos.getColumnModel().getColumn(0).setPreferredWidth(52);
		tabelaAlunos.getColumnModel().getColumn(1).setPreferredWidth(170);
		tabelaAlunos.getColumnModel().getColumn(2).setPreferredWidth(230);
		tabelaAlunos.getColumnModel().getColumn(3).setPreferredWidth(160);

		// Para impedir a edição da tabela
		tabelaAlunos.setDefaultEditor(Object.class, null);

		// Para impedir o drag and drop (arrastar) das colunas da tabela
		tabelaAlunos.getTableHeader().setReorderingAllowed(false);

		// Para impedir o redimencionamento da tabela
		// tabelaAlunos.getTableHeader().setResizingAllowed(false);

		// Colocando a tabelo dentro do scroll
		scroll.setViewportView(tabelaAlunos);

		painelTabela.add(scroll);
		
	}

	private void abrirFormularioAluno(String textoTitulo, String textoBotao, String nomeDaImagem) {
		FrmAluno frmAluno = new FrmAluno();

		// mudando os titulos
		frmAluno.btGravar.setText(textoBotao);
		frmAluno.lblTitulo.setText(textoTitulo);
		frmAluno.btGravar
				.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/imagens/" + nomeDaImagem)));

		if (textoBotao.equals("Excluir")) {
			frmAluno.panelTitulo.setBackground(vermelho);
		}

		// pegando a linha que vc quer
		int matricula = 0;

		int linha = tabelaAlunos.getSelectedRow();

		int coluna = 0;

		if (linha == -1) {

			JOptionPane.showMessageDialog(null, "Por favor selecione um aluno na lista!", "Aluno não selecionado",
					JOptionPane.ERROR_MESSAGE);

		} else {

			matricula = Integer.parseInt(tabelaAlunos.getValueAt(linha, coluna).toString());

			// Criando um aluno pelo o aluno no banco
			AlunoDAO dao = new AlunoDAO();
			Aluno aluno = dao.getAluno(matricula);

			frmAluno.lblMatricula.setText(String.valueOf(aluno.getMatricula()));
			frmAluno.txtNome.setText(aluno.getNome());
			frmAluno.txtDataNascimento.setText(Data.converterParaUsuario(aluno.getDataDeNascimento()));
			frmAluno.txtEndereco.setText(aluno.getEndereco());
			frmAluno.txtEmail.setText(aluno.getEmail());
			frmAluno.txtTelefone.setText(aluno.getTelefone());
			frmAluno.txtPeso.setText(String.valueOf(aluno.getPeso()));
			frmAluno.txtAltura.setText(String.valueOf(aluno.getAltura()));
			frmAluno.txtIdade.setText(String.valueOf(Data.calcularIdade(frmAluno.txtDataNascimento.getText())));

			if (aluno.getSexo() == 'M')
				frmAluno.btrMasculino.setSelected(true);
			else if (aluno.getSexo() == 'F')
				frmAluno.btrFeminino.setSelected(true);

			frmAluno.calcularBiometria(aluno);

			frmAluno.setVisible(true);

		}

	}

}
