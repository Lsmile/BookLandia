package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.business.UserManager;
import it.unisalento.BookLandia.enums.EnumUtils;
import it.unisalento.BookLandia.enums.UserType;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.northpan.NorthPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class NorthPanelListener implements ActionListener{

	NorthPanel source;
	MainFrame root;
	
	public NorthPanelListener(NorthPanel panel, MainFrame root)
	{
		source = panel;
		this.root = root;
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
					String tipo = EnumUtils.getStringFromType(tipoUtente); //stringa da stampare nel message dialog
					
					JOptionPane.showMessageDialog(null, "Benvenuto "+UserManager.getInstance().getCurUser().getNome()+" "+UserManager.getInstance().getCurUser().getCognome()+" Ti sei loggato come "+tipo);
					
					root.selectMenu(tipoUtente);
					source.loginDone();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Login fallito");
				}
			}
			if(button.getName() == "Logout")
			{
				root.selectMenu(UserType.NESSUNO);
				source.logoutDone();
				UserManager.getInstance().LogOut();
				
			}
		}
	}

}
