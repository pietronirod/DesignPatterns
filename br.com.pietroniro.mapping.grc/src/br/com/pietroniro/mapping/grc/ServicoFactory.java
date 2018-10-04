package br.com.pietroniro.mapping.grc;

public class ServicoFactory {
	public static Servico getServico(ServicoAbstractFactory factory) {
		return factory.criaServico();
	}
}
