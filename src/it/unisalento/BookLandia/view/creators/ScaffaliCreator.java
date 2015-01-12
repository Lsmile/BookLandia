package it.unisalento.BookLandia.view.creators;

import it.unisalento.BookLandia.dao.AutoreDAO;
import it.unisalento.BookLandia.dao.CasaEditriceDAO;
import it.unisalento.BookLandia.dao.GenereDAO;
import it.unisalento.BookLandia.dao.ScaffaleDAO;
import it.unisalento.BookLandia.listener.CreatorListener;
import it.unisalento.BookLandia.view.MainFrame;
import it.unisalento.BookLandia.view.catalogo.InserisciPanel;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.AbstractDocument.Content;

public class ScaffaliCreator extends JFrame {
	Container container;
	JTextField nome;
	JList lista;
	JButton insert;
	JScrollPane scaffalePanelScroll;
	JPanel panel;
	CreatorListener listener;
	
	JLabel numScaffale;
	SpinnerModel model1;
	JSpinner spinner1; //numero scaffale
	
	JLabel numLibreria;
	SpinnerModel model2;     
	JSpinner spinner2; //numero libreria
	
	
	MainFrame source;
	
	public JTextField getNome() {
		return nome;
	}

	public ScaffaliCreator(MainFrame source)
	{
		super("Nuovi Scaffali");
		this.setBounds(0, 0, 500, 500);
		
		this.source = source;
		
		numScaffale = new JLabel("Scaffale");
		model1 = new SpinnerNumberModel(1, 1, 100, 1);     
		spinner1 = new JSpinner(model1);
		
		numLibreria = new JLabel("Libreria");
		model2 = new SpinnerNumberModel(1, 1, 100, 1);
		spinner2 = new JSpinner(model2);
		
		panel = new JPanel();
		
		container = this.getContentPane();
		
		container.setLayout(new FlowLayout());
		
		listener = new CreatorListener(null,null,null,this);
		
		nome = new JTextField();
		nome.setColumns(15);
		lista = new JList(ScaffaleDAO.getInstance().getSettoriScaffali());
		insert = new JButton("Inserisci");
		insert.setName("CreaScaffale");
		insert.addActionListener(listener);
		
		panel.add(lista);
		scaffalePanelScroll = new JScrollPane(panel);
		container.add(nome);
		container.add(numScaffale);
		container.add(spinner1);
		container.add(numLibreria);
		container.add(spinner2);
		container.add(scaffalePanelScroll);
		container.add(insert);
		
		
	
		
		this.setVisible(true);
		this.pack();
	}
	
	public JSpinner getSpinner1() {
		return spinner1;
	}

	public JSpinner getSpinner2() {
		return spinner2;
	}

	public void Update()
	{
		lista = new JList(ScaffaleDAO.getInstance().getSettoriScaffali());
		panel.removeAll();
		panel.add(lista);
		container.revalidate();
		container.repaint();
		
		source.getInserisci().Update();
		source.getModifica_Libro().Update();
		
		this.pack();
	}
}
