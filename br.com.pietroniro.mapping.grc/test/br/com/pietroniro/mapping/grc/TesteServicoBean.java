package br.com.pietroniro.mapping.grc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteServicoBean {
	Servico cut;
			
	@Before
	public void setUp() throws Exception {
		String[] estados = { 
				String.valueOf(Estados.SP.getCodigo()),
				String.valueOf(Estados.RJ.getCodigo()) };
		
		cut = new ServicoBean("autorizador", "servico", "versao", "ambiente", estados, "url", "soapAction");
	}

	@Test
	public void testGetAutorizador() {
		assertEquals("autorizador", cut.getAutorizador());
	}

	@Test
	public void testGetServico() {
		assertEquals("servico", cut.getServico());
	}

	@Test
	public void testGetVersao() {
		assertEquals("versao", cut.getVersao());
	}

	@Test
	public void testGetAmbiente() {
		assertEquals("ambiente", cut.getAmbiente());
	}

	@Test
	public void testGetEstados() {
		String[] estados = { 
				String.valueOf(Estados.SP.getCodigo()),
				String.valueOf(Estados.RJ.getCodigo())};
		
		assertArrayEquals(estados, cut.getEstados());
	}

	@Test
	public void testBuscaEstado() {
		String sp = String.valueOf(Estados.SP.getCodigo());
		
		assertTrue(cut.existeEstado(sp));
	}
	
	@Test
	public void testGetUrl() {
		assertEquals("url", cut.getUrl());
	}

	@Test
	public void testGetSoapAction() {
		assertEquals("soapAction", cut.getSoapAction());
	}

}
