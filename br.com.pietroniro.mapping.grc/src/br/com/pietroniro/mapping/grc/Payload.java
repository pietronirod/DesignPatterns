package br.com.pietroniro.mapping.grc;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Payload {
	
	private InputStream in;
	
	public Payload(InputStream in) {
		this.in = in;
	}
	
	public Map<String, String> determinaServico() {
		Map<String, String> ret = new HashMap<>();
		
		try {
			SAXParserFactory factory    = SAXParserFactory.newInstance();

			factory.setNamespaceAware(true);
			SAXParser        saxParser  = factory.newSAXParser();
			XmlHandler       xmlHandler = new XmlHandler();
			saxParser.parse(in, xmlHandler);
			
			ret.put("servico", xmlHandler.getServico());
			ret.put("estado", xmlHandler.getEstado());
			ret.put("versao", xmlHandler.getVersao());
			ret.put("emissao", xmlHandler.getEmissao());
			ret.put("ambiente", xmlHandler.getAmbiente());
		} catch (Exception e) {
			
		}
		
		return ret;
	}
}

class XmlHandler extends DefaultHandler{
	private boolean bEstado;
	private boolean bVersao;
	private boolean bEmissao;
	private boolean bAmbiente;
	
	private String servico;
	private String estado;
	private String versao;
	private String emissao;
	private String ambiente;
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		estado   = bEstado?  new String(ch, start, length):  estado;
		versao   = bVersao?  new String(ch, start, length):  versao;
		emissao  = bEmissao? new String(ch, start, length):  emissao;
		ambiente = bAmbiente? new String(ch, start, length): ambiente;
		
		bEstado = bVersao = bEmissao = bAmbiente = false;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public String getEmissao() {
		return emissao;
	}

	public String getVersao() {
		return versao;
	}

	public String getEstado() {
		return estado;
	}

	public String getServico() {
		return servico;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		servico = localName.equalsIgnoreCase(ServicoGrc.AUTORIZACAO.getValue())?localName:servico;
		bEstado = localName.equalsIgnoreCase("cUF")?true:false;
		bEmissao = localName.equalsIgnoreCase("tpEmis")?true:false;
		bAmbiente = localName.equalsIgnoreCase("tpAmb")?true:false;
	}
}