package br.com.pietroniro.mapping.nfe;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvUtils {
	
	
	public static CsvUtils newInstance() {
		return new CsvUtils();
	}
	
	public List<List<String>> getData(InputStream resource, int col) {
		List<String> colunas = new ArrayList<String>();
		List<List<String>> ret = new ArrayList<List<String>>();
		Scanner scan = new Scanner(resource).useDelimiter(Separador.PONTOVIRGULA.getValue()+"|\\n");

		while(scan.hasNext()) {		
			for (int i=0; i < col; i++) {
				colunas.add(scan.next());
			}
			ret.add(colunas);
			ret.clear();
		}
		
		return ret;
	}
	
	public InputStream getResource(String name) throws NullPointerException {
		InputStream in = getClass().getClassLoader().getResourceAsStream(name);
		
		if (in == null) {
			throw new NullPointerException();
		}
		
		return in;
	}
	
	private CsvUtils() {
	}
}
