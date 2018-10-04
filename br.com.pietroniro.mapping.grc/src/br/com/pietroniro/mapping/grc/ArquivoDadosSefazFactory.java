package br.com.pietroniro.mapping.grc;

public class ArquivoDadosSefazFactory implements DadosSefazAbstractFactory {
	private String uri;
	
	public ArquivoDadosSefazFactory(String uri) {
		this.uri = uri;
	}
	
	@Override
	public DadosSefaz criaDadosSefaz() {
		return new ArquivoDadosSefaz(uri);
	}
}
