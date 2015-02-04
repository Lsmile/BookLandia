package it.unisalento.BookLandia.view.ordini;

import it.unisalento.BookLandia.business.UserManager;
import it.unisalento.BookLandia.enums.UserType;
import it.unisalento.BookLandia.listener.OrdinaListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ButtonPanelOrdini  extends JPanel{
	
	OrdinaListener listener;
	Box verticalCancella; //spaziatura
	Box verticalCompleta;
	VistaOrdini source;
	JTable t;
	int rows = 0; //numero di righe di bottoni
	
	public ButtonPanelOrdini(JTable table, VistaOrdini source){
		this.source = source;
		t = table;
		
		listener = new OrdinaListener(table,source);
		
			this.setLayout(new GridLayout(1,1));
		
		JPanel cancellaPanel = new JPanel();
		this.add(cancellaPanel);
		
		
		cancellaPanel.setLayout(new BorderLayout());
		verticalCancella = Box.createVerticalBox();
		verticalCancella.setAlignmentY(TOP_ALIGNMENT);
		cancellaPanel.add(verticalCancella, BorderLayout.NORTH);
		verticalCancella.add(Box.createRigidArea(new Dimension(0,21)));
		if(UserManager.getInstance().getUtente_connesso() != UserType.CLIENTE) //l'utente non è un cliente, quindi può completare un ordine
		{
			this.setLayout(new GridLayout(1,2));
			JPanel completaPanel = new JPanel();
			
			this.add(completaPanel);
			
			
			completaPanel.setLayout(new BorderLayout());
			verticalCompleta = Box.createVerticalBox();
			verticalCompleta.setAlignmentY(TOP_ALIGNMENT);
			completaPanel.add(verticalCompleta, BorderLayout.NORTH);
			verticalCompleta.add(Box.createRigidArea(new Dimension(0,21)));
		}
	}
	
	public void addButton(int n)
	{
		for(int z = 0; z < n; z++)
		{   if(t.getValueAt(rows, 9) == "In corso" || t.getValueAt(rows, 9) == "Arrivato")
			{
				JButton added1 = new JButton("cancella"){ { setSize(80,16); setMaximumSize(getSize()); }};
				added1.setName("cancella"+z);
				added1.addActionListener(listener);
				verticalCancella.add(added1);
			
				if(UserManager.getInstance().getUtente_connesso() != UserType.CLIENTE) //l'utente non è un cliente, quindi può completare un ordine
				{
					if(t.getValueAt(rows, 9) == "In corso")
					{
						JButton added2 = new JButton("arrivato"){ { setSize(80,16); setMaximumSize(getSize()); }};
						added2.setName("arrivato"+z);
						added2.addActionListener(listener);
						verticalCompleta.add(added2);
					}
					else if(t.getValueAt(rows, 9) == "Arrivato")
					{
						JButton added2 = new JButton("completa"){ { setSize(80,16); setMaximumSize(getSize()); }};
						added2.setName("completa"+z);
						added2.addActionListener(listener);
						verticalCompleta.add(added2);
					}
				}
			}
			else
			{
				JButton added1 = new JButton("/"){ { setSize(80,16); setMaximumSize(getSize()); }};
				verticalCancella.add(added1);
				if(UserManager.getInstance().getUtente_connesso() != UserType.CLIENTE) //l'utente non è un cliente, quindi può completare un ordine
				{
				JButton added2 = new JButton("/"){ { setSize(80,16); setMaximumSize(getSize()); }};
				verticalCompleta.add(added2);
				}
			}
			
			rows++;
		}
	}
	
	private void removeButtons()
	{
		verticalCancella.removeAll();
		verticalCancella.add(Box.createRigidArea(new Dimension(0,21)));
		if(UserManager.getInstance().getUtente_connesso() != UserType.CLIENTE) //l'utente non è un cliente, quindi può completare un ordine
		{
		verticalCompleta.removeAll();
		verticalCompleta.add(Box.createRigidArea(new Dimension(0,21)));
		}
	}
	
	public void updateButtons(int n)
	{
		removeButtons();
		addButton(n);
	}

}
