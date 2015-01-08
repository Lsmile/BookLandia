package it.unisalento.BookLandia.view.creators;

import it.unisalento.BookLandia.dao.AutoreDAO;
import it.unisalento.BookLandia.listener.CreatorListener;
import it.unisalento.BookLandia.view.catalogo.InserisciPanel;

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

public class AutoreCreator extends JFrame {
	Container container;
	JTextField nome;
	JList lista;
	JButton insert;
	JScrollPane scaffalePanelScroll;
	JPanel panel;
	CreatorListener listener;
	
	public JTextField getNome() {
		return nome;
	}

	public AutoreCreator(InserisciPanel source)
	{
		super("Nuovo Autore");
		this.setBounds(0, 0, 500, 500);
		
		panel = new JPanel();
		
		container = this.getContentPane();
		
		container.setLayout(new FlowLayout());
		
		listener = new CreatorListener(this,source);
		
		nome = new JTextField();
		nome.setColumns(15);
		lista = new JList(AutoreDAO.getInstance().getNomiAutori());
		insert = new JButton("Inserisci");
		insert.setName("CreaAutore");
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
		lista = new JList(AutoreDAO.getInstance().getNomiAutori());
		panel.removeAll();
		panel.add(lista);
		container.revalidate();
		container.repaint();
		this.pack();
	}
}
