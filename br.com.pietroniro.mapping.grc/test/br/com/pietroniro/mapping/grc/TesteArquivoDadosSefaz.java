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
		cut = DadosSefazFactory.getDadosSefaz(new ArquivoDadosSefazFactory("sefaz.csv"));
	}

	@Test
	public void testArquivoNaoExiste() {
		servicos = cut.readData("notFound.csv");
		
		assertTrue(servicos.isEmpty());
	}
	

	@Test
	public void testArquivoNaoExisteServicoNaoExiste() {
		cut.readData("notFound.csv");
		Servico serv = cut.procuraServico("estado", "servico", "versao", "ambiente");
		
		assertNull(serv);
	}
	
	@Test
	public void testArquivoExisteServicoNaoExiste() {
		Servico serv = cut.procuraServico("estado", "servico", "versao", "ambiente");
		
		assertNull(serv);
	}
	
	@Test
	public void testArquivoExisteServicoExiste() {
		Servico serv = cut.procuraServico("Estados", "Servico", "Versao", "Ambiente");
		
		assertNotNull(serv);
	}
}
