package br.com.pietroniro.mapping.nfe;

public enum Separador {
	VIRGULA(","), PONTOVIRGULA(";"), PIPE("|");
	
	String sep;
	
	Separador(String sep) {
		this.sep = sep;
	}
	
	public String getValue() {
		return sep;
	}
}
