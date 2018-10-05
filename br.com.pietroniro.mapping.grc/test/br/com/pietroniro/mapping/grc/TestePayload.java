package br.com.pietroniro.mapping.grc;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestePayload {

	private Payload cut;
	
	@Before
	public void setUp() throws Exception {
		cut = new Payload(this.getClass().getClassLoader().getResourceAsStream("nfeAutorizacaoLote.xml"));
	}

	@Test
	public void testDeterminaServico() {
		@SuppressWarnings("unused")
		Map<String, String> map = cut.determinaServico();

		fail("Not yet implemented");
	}

}
