package br.com.pietroniro.mapping.grc;

public class FactoryServico {
	public Servico getServico(String autorizador, String servico, 
			String versao, String ambiente, String[] estados, String url, String soapAction ) {
		return new ServicoBean(autorizador, servico, versao, ambiente, estados, url, soapAction);
	}
}
