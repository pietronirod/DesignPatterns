package br.com.pietroniro.mapping.nfe;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class CsvUtilsTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testResourceNotFound() {
		boolean erro = false;
		
		try {
			CsvUtils csv = CsvUtils.newInstance();
			csv.getResource("Teste.csv");			
		} catch (NullPointerException e) {
			erro = true;
		}
		
		assertThat(erro, is(true));
	}

	@Test
	public void testResourceFound() {
		CsvUtils csv = CsvUtils.newInstance();
		InputStream in = csv.getResource("sefaz.csv");
		
		assertThat(in, is(notNullValue()));
	}
	
	@Test
	public void testDataRetrieved() {
		CsvUtils csv = CsvUtils.newInstance();
		
		List<List<String>> dados = csv.getData(csv.getResource("sefaz.csv"), 8);
		
		assertThat(dados.size(), is(anything()));
	}
}
