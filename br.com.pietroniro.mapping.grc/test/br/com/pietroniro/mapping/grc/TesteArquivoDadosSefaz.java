package br.com.pietroniro.mapping.grc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TesteArquivoDadosSefaz {
	
	private DadosSefaz cut;
	private List<Servico> servicos;
	
	@Before
	public void setUp() throws Exception {
		cut = new ArquivoDadosSefaz();
	}

	@Test
	public void testArquivoNaoExiste() {
		this.servicos = cut.readData("notFound.csv");
		
		assertTrue(this.servicos.isEmpty());
	}
	

	@Test
	public void testArquivoNaoExisteServicoNaoExiste() {
		Servico serv = cut.procuraServico("estado", "servico", "versao", "ambiente");
		
		assertNull(serv);
	}
	
	@Test
	public void testArquivoExisteServicoNaoExiste() {
		cut.readData("sefaz.csv");
		Servico serv = cut.procuraServico("estado", "servico", "versao", "ambiente");
		
		assertNull(serv);
	}
	
	@Test
	public void testArquivoExisteServicoExiste() {
		cut.readData("sefaz.csv");
		Servico serv = cut.procuraServico("Estados", "Servico", "Versao", "Ambiente");
		
		assertNotNull(serv);
	}
}
