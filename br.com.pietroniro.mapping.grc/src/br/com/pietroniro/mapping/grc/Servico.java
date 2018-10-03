package br.com.pietroniro.mapping.grc;

public interface Servico {

	String getAutorizador();

	void setAutorizador(String autorizador);

	String getServico();

	void setServico(String servico);

	String getVersao();

	void setVersao(String versao);

	String getAmbiente();

	void setAmbiente(String ambiente);

	String[] getEstados();

	void setEstados(String[] estados);

	String getUrl();

	void setUrl(String url);

	String getSoapAction();

	void setSoapAction(String soapAction);

}