package br.senai.sp.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.senai.sp.dao.AlunoDAO;
import br.senai.sp.dao.Conexao;
import br.senai.sp.model.Aluno;
import br.senai.sp.view.FrmPrincipal;
import br.senai.sp.view.FrmAluno;

public class AppAcademia {

	public static void main(String[] args) {
		
		    try {
		            // Set cross-platform Java L&F (also called "Metal")
		        UIManager.setLookAndFeel(
		        //	UIManager.getCrossPlatformLookAndFeelClassName());
		        	UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (UnsupportedLookAndFeelException e) {
		       // handle exception
		    }
		    catch (ClassNotFoundException e) {
		       // handle exception
		    }
		    catch (InstantiationException e) {
		       // handle exception
		    }
		    catch (IllegalAccessException e) {
		       // handle exception
		    }
		
		 UIManager.put("OptionPane.yesButtonText", "Sim");
		 UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		 UIManager.put("OptionPane.noButtonText", "Não");
		 UIManager.put("OptionPane.okButtonText", "Ok");
		 
		 FrmPrincipal principal = new FrmPrincipal();
		
		 
	}

}
