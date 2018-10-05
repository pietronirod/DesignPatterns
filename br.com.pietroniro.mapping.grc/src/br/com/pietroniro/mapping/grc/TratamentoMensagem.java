package br.com.pietroniro.mapping.grc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Scanner;

public class TratamentoMensagem implements TrataMensagem {

	@Override
	public Servico defineServico(InputStream in) {
//		String xml = this.converte(in, Charset.defaultCharset());
		
		
		return null;
	}

	@Override
	public String converte(InputStream in, Charset charset) throws IOException {
		try(Scanner scan = new Scanner(in, charset.name())) {
			return scan.useDelimiter("\\A").next();
		}
	}

}
