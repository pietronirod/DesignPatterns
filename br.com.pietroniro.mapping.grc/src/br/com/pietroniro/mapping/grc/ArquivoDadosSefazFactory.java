package br.com.pietroniro.mapping.grc;

public class ArquivoDadosSefazFactory implements DadosSefazAbstractFactory {
	private String uri;
	private Object trace;
	
	public ArquivoDadosSefazFactory(String uri, Object trace) {
		this.uri = uri;
		this.trace = trace;
	}
	
	@Override
	public DadosSefaz criaDadosSefaz() {
		return new ArquivoDadosSefaz(uri, trace);
	}
}