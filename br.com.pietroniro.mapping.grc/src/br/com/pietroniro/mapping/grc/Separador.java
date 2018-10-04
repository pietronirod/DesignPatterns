package br.com.pietroniro.mapping.grc;

public enum Separador {
	CAMPOS(";"), ESTADOS(",");
	
	private String sep;
	
	Separador(String sep) {
		this.sep = sep;
	}
	
	public String getSeparador() {
		return sep;
	}
}
