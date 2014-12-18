package it.unisalento.BookLandia.enums;

public class EnumUtils {

	public static String getStringFromType(UserType tipoUtente)
	{
		String tipo = "";
		if(tipoUtente == UserType.CLIENTE)
			tipo = "Cliente";
		else if(tipoUtente == UserType.SCAFFALI)
			tipo = "Addetto Scaffali";
		else if(tipoUtente == UserType.VENDITE)
			tipo = "Addetto Vendite";
		
		return tipo;
	}

};
