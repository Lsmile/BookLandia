package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.business.UserManager;
import it.unisalento.BookLandia.enums.UserType;
import it.unisalento.BookLandia.view.northpan.NorthPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class NorthPanelListener implements ActionListener{

	NorthPanel source;
	
	public NorthPanelListener(NorthPanel panel)
	{
		source = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() instanceof JButton)
		{
			JButton button = (JButton)event.getSource();
			if(button.getName() == "Login")
			{
				source.loginView();
			}
			if(button.getName() == "Entra")
			{
				//prende dall'interfaccia l'username e la password e li passa allo user manager per effettuare il login
				if(UserManager.getInstance().LogIn(source.getUsername().getText(), String.valueOf(source.getPassword().getPassword())) != UserType.NESSUNO)
				{
					UserType tipoUtente = UserManager.getInstance().getUtente_connesso();
					String tipo = ""; //stringa da stampare nel message dialog
					if(tipoUtente == UserType.CLIENTE)
						tipo = "Cliente";
					else if(tipoUtente == UserType.SCAFFALI)
						tipo = "Addetto Scaffali";
					else if(tipoUtente == UserType.VENDITE)
						tipo = "Addetto Vendite";
					
					JOptionPane.showMessageDialog(null, "Benvenuto "+UserManager.getInstance().getCurUser().getNome()+" "+UserManager.getInstance().getCurUser().getCognome()+" Ti sei loggato come "+tipo);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Login fallito");
				}
			}
		}
	}

}
