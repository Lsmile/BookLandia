package it.unisalento.BookLandia.view.ricerca;

import javax.swing.JTextField;

public class CampiTesto extends JTextField{
	
	int minLength;
	int fixedLength;
	
	public CampiTesto()
	{
		super();
		this.setColumns(15);
	}
	
	public void setMinLength(int Length)
	{
		minLength = Length;
	}
	
	public void setFixedLength(int Length)
	{
		fixedLength = Length;
	}
	
	public Boolean CheckMinLength()
	{
		if(this.getText().length() >= minLength)
			return true;
		else
			return false;
	}
}
