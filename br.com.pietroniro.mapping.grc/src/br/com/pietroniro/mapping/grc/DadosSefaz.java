package br.com.pietroniro.mapping.grc;

import java.util.List;

public interface DadosSefaz {
	public List<Servico> readData(String uri);
	public Servico procuraServico(String estado, String servico, String versao, String emissao, String ambiente);
}
