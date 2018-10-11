package br.com.pietroniro.mapping.nfe;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SefazBean implements Comparable<SefazBean> {
	private String       autorizador;
	private String       servico;
	private String       versao;
	private String       emissao;
	private String       ambiente;
	private List<String> estados;
	private String       url;
	private String       soapAction;	
	
	private SefazBean(String autorizador, String servico, String versao, 
			String emissao, String ambiente, String[] estados, String url, String soapAction) {
		setAutorizador(autorizador);
		setServico(servico);
		setVersao(versao);
		setEmissao(emissao);
		setAmbiente(ambiente);
		setEstados(estados);
		setUrl(url);
		setSoapAction(soapAction);
	}
	
	public static SefazBean getInstance(String autorizador, String servico, String versao,
			String emissao, String ambiente, String[] estados, String url, String soapAction) {
		return new SefazBean(autorizador, servico, versao, emissao, ambiente, estados, url, soapAction);
	}
	
	private void setAutorizador(String autorizador) {
		this.autorizador = autorizador;
	}
	private void setServico(String servico) {
		this.servico = servico;
	}
	private void setVersao(String versao) {
		this.versao = versao;
	}
	private void setEmissao(String emissao) {
		this.emissao = emissao;
	}
	private void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	private void setEstados(String[] estados) {
		this.estados = Arrays.asList(estados);
		Collections.sort(this.estados);
	}
	private void setUrl(String url) {
		this.url = url;
	}
	private void setSoapAction(String soapAction) {
		this.soapAction = soapAction;
	}
	public String getAutorizador() {
		return autorizador;
	}
	public String getServico() {
		return servico;
	}
	public String getVersao() {
		return versao;
	}
	public String getEmissao() {
		return emissao;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public List<String> getEstados() {
		return estados;
	}
	public String getUrl() {
		return url;
	}
	public String getSoapAction() {
		return soapAction;
	}

	@Override
	public int compareTo(SefazBean outraSefaz) {
		int ret;
		
		ret = servico.compareTo(outraSefaz.getServico());
		if (ret != 0) return ret;
		
		ret = versao.compareTo(outraSefaz.getVersao());
		if (ret != 0) return ret;
		
		ret = emissao.compareTo(outraSefaz.getEmissao());
		if (ret != 0) return ret;
		
		ret = ambiente.compareTo(outraSefaz.getAmbiente());
		if (ret != 0) return ret;
		
		ret = estados.toString().compareTo(outraSefaz.getEstados().toString());
//		ret = estados.
		if (ret != 0) return ret;
		
		return ret;
	}

}
