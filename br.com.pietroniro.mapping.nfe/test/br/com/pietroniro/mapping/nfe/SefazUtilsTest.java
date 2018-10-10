package br.com.pietroniro.mapping.nfe;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class SefazUtilsTest {

	private SefazUtils sefaz;
	
	@Before
	public void setUp() throws Exception {
		sefaz = SefazUtils.getInstance("sefaz.csv");
	}

	@Test
	public void testConstructor() {
	assertThat(sefaz, is(notNullValue()));
	}

	@Test
	public void testBusca() {
		String[] estado = { "12" };
		
		SefazBean sef = SefazBean.getInstance("", "NfeInutilizacao", "4.0", "", "1", estado, "", "");
		
		int url = sefaz.buscaServico(sef);
		
		assertThat(url, is(notNullValue()));
	}
}
