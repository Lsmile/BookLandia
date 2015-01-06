package Vendita;

import it.unisalento.BookLandia.model.Libro;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegistraPanel extends JPanel {
	Libro LibroVendita;
	
private static RegistraPanel instance;
	
	public static RegistraPanel getInstance(Libro Lbr)
	{
		if(instance == null)
		{
			instance = new RegistraPanel(Lbr);
		}
		return instance;
	}
	
	public RegistraPanel(Libro LibroVnd)
	{
		this.LibroVendita = LibroVnd;
		this.add(new JLabel("Funziono"));
	}
}
