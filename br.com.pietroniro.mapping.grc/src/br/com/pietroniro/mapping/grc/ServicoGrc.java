package br.com.pietroniro.mapping.grc;

public enum ServicoGrc {
	AUTORIZACAO("nfeAutorizacaoLote"), RETAUTORIZACAO("nfeRetAutorizacaoLote"),
	INUTILIZACAO("nfeInutilizacaoNF"), CONSULTA("nfeConsultaNF");
	
	String serv;
	
	ServicoGrc(String serv) {
		this.serv = serv;
	}
	
	public String getValue() {
		return serv;
	}
}
