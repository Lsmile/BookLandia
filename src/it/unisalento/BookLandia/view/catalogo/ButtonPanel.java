package it.unisalento.BookLandia.view.catalogo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel  extends JPanel{
		Box vertical;
	
	public ButtonPanel(){
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
			added.setName(""+z);
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
