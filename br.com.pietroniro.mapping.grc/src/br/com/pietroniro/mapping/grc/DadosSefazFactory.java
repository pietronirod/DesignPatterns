package br.com.pietroniro.mapping.grc;

public class DadosSefazFactory {
	public static DadosSefaz getDadosSefaz(DadosSefazAbstractFactory factory) {
		return factory.criaDadosSefaz();
	}
}
