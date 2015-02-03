package it.unisalento.BookLandia.view.catalogo;

import it.unisalento.BookLandia.listener.OrdinaListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ButtonPanel  extends JPanel{
	
	OrdinaListener listener;
	Box vertical;
	
	public ButtonPanel(JTable table){
		listener = new OrdinaListener(table,null);
		
		this.setLayout(new BorderLayout());
		vertical = Box.createVerticalBox();
		vertical.setAlignmentY(TOP_ALIGNMENT);
		add(vertical, BorderLayout.NORTH);
		vertical.add(Box.createRigidArea(new Dimension(0,21)));
	}
	
	public void addButton(int n)
	{
		for(int z = 0; z < n; z++)
		{
			JButton added = new JButton("ordina"){ { setSize(80,16); setMaximumSize(getSize()); }};
			added.setName("ordina"+z);
			added.addActionListener(listener);
			vertical.add(added);
		}
	}
	
	private void removeButtons()
	{
		vertical.removeAll();
		vertical.add(Box.createRigidArea(new Dimension(0,21)));
	}
	
	public void updateButtons(int n)
	{
		removeButtons();
		addButton(n);
	}

}
