package br.com.pietroniro.mapping.grc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoDadosSefaz implements DadosSefaz {

	@Override
	public Servico[] readData() {
		// TODO Auto-generated method stub
		return null;
	}

	public void readResource(String uri) {
		String line;
		BufferedReader br;

		try {
			br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/sefaz.csv")));
			while((line = br.readLine()) != null ) {
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
