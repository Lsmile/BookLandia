package it.unisalento.BookLandia.listener;

import it.unisalento.BookLandia.business.UserManager;
import it.unisalento.BookLandia.dao.LibroDAO;
import it.unisalento.BookLandia.dao.OrdiniDAO;
import it.unisalento.BookLandia.enums.UserType;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.ricerca.PanelCerca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class OrdinaListener implements ActionListener {
	

	JTable source;

	public OrdinaListener(JTable source)
	{
		this.source = source;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() instanceof JButton)
		{
			JButton bottone = (JButton) event.getSource();
			int bookPosition = Integer.parseInt(bottone.getName());
			if(UserManager.getInstance().getUtente_connesso() == UserType.CLIENTE)
			{
				 int riga = bookPosition;
				 int colonna = 0;
				 int id = (int)source.getValueAt(riga, colonna);
				 OrdiniDAO.getInstance().insertOrdinazione(id);
				 JOptionPane.showMessageDialog(null, "Inserito ordine per libro "+  LibroDAO.getInstance().getLibro(id)[0] );
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Entra come utente registrato per ordinare" );
			}
		}
	}

}
