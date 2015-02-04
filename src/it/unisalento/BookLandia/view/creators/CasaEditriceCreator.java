package it.unisalento.BookLandia.view.creators;

import it.unisalento.BookLandia.dao.AutoreDAO;
import it.unisalento.BookLandia.dao.CasaEditriceDAO;
import it.unisalento.BookLandia.dao.GenereDAO;
import it.unisalento.BookLandia.listener.CreatorListener;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.bookManagement.InserisciPanel;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.Content;

public class CasaEditriceCreator extends JFrame {
	Container container;
	JTextField nome;
	JList lista;
	JButton insert;
	JScrollPane scaffalePanelScroll;
	JPanel panel;
	CreatorListener listener;
	
	MainFrame source;
	
	public JTextField getNome() {
		return nome;
	}

	public CasaEditriceCreator(MainFrame source)
	{
		super("Nuova Casa Editrice");
		this.setBounds(0, 0, 500, 500);
		
		this.source = source;
		
		panel = new JPanel();
		
		container = this.getContentPane();
		
		container.setLayout(new FlowLayout());
		
		listener = new CreatorListener(null,null,this,null);
		
		nome = new JTextField();
		nome.setColumns(15);
		lista = new JList(CasaEditriceDAO.getInstance().getNomiCaseEditrici());
		insert = new JButton("Inserisci");
		insert.setName("CreaCasaEditrice");
		insert.addActionListener(listener);
		
		panel.add(lista);
		scaffalePanelScroll = new JScrollPane(panel);
		container.add(nome);
		container.add(scaffalePanelScroll);
		container.add(insert);
		
	
		
		this.setVisible(true);
		this.pack();
	}
	
	public void Update()
	{
		lista = new JList(CasaEditriceDAO.getInstance().getNomiCaseEditrici());
		panel.removeAll();
		panel.add(lista);
		container.revalidate();
		container.repaint();
		
		source.getInserisci().Update();
		source.getModifica_Libro().Update();
		
		this.pack();
	}
}
