package br.com.pietroniro.mapping.grc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public interface TrataMensagem {
	public Servico defineServico(InputStream in);
	public String converte(InputStream in, Charset charset) throws IOException;
}
