package br.com.pietroniro.mapping.grc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TesteArquivoDadosSefaz {
	
	private DadosSefaz cut;
	
	@Before
	public void setUp() throws Exception {
		cut = new ArquivoDadosSefaz();
		this.testReadData();
	}

	@Test
	public void testReadData() {
		@SuppressWarnings("unused")
		List<Servico> servico = cut.readData("sefaz.csv");
	}
	
	@Test
	public void testProcuraServico() {
		Servico serv = cut.procuraServico("Estados", "Servico", "Versao", "Ambiente");
		
		assertNotNull(serv);
	}
}
