package it.unisalento.BookLandia.view;

import it.unisalento.BookLandia.view.catalogo.PanelCatalogo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Window;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	
	
	public MainFrame()
	{
		super("BookLandia");
		this.setBounds(0, 0, 500, 500);
		Container Contenitore = this.getContentPane();
		Contenitore.setLayout(new BorderLayout());
		Contenitore.add(new PanelCatalogo(), BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
