package br.com.pietroniro.mapping.grc;

public class ServicoBeanFactory implements ServicoAbstractFactory {
	private String autorizador;
	private String servico;
	private String versao;
	private String tpEmis;
	private String ambiente;
	private String[] estados;
	private String url;
	private String soapAction;
	
	public ServicoBeanFactory(String autorizador, String servico, String versao, String tpEmis, 
			String ambiente, String[] estados, String url, String soapAction) {
		this.autorizador = autorizador;
		this.servico     = servico;
		this.versao      = versao;
		this.tpEmis      = tpEmis;
		this.ambiente    = ambiente;
		this.estados     = estados;
		this.url         = url;
		this.soapAction   = soapAction;
	}
	
	@Override
	public Servico criaServico() {
		return new ServicoBean(autorizador, servico, versao, tpEmis, ambiente, estados, url, soapAction);
	}

}
