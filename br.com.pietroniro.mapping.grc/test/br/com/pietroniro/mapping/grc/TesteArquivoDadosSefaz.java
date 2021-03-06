package br.com.pietroniro.mapping.grc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

public class TesteArquivoDadosSefaz {
	
	private DadosSefaz cut;
	private List<Servico> servicos;
	
	@Before
	public void setUp() throws Exception {
		cut = DadosSefazFactory.getDadosSefaz(
				new ArquivoDadosSefazFactory("sefaz.csv", 
						Logger.getLogger(TesteArquivoDadosSefaz.class.getName())));
	}

	@Test
	public void testArquivoNaoExiste() {
		servicos = cut.readData("notFound.csv");
		
		assertTrue(servicos.isEmpty());
	}
	

	@Test
	public void testArquivoNaoExisteServicoNaoExiste() {
		cut.readData("notFound.csv");
		Servico serv = cut.procuraServico("estado", "servico", "tpemis", "versao", "ambiente");
		
		assertNull(serv);
	}
	
	@Test
	public void testArquivoExisteServicoNaoExiste() {
		Servico serv = cut.procuraServico("estado", "servico", "tpemis", "versao", "ambiente");
		
		assertNull(serv);
	}
	
	@Test
	public void testArquivoExisteServicoExiste() {
		Servico serv = cut.procuraServico("Estados", "Servico", "Versao", "Emissao", "Ambiente");
		
		assertNotNull(serv);
	}
}
