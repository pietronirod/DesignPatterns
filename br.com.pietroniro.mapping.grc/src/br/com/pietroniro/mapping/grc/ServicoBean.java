package br.com.pietroniro.mapping.grc;

public class ServicoBean implements Servico {
	protected String autorizador;
	protected String servico;
	protected String versao;
	protected String tpEmis;
	protected String ambiente;
	protected String[] estados;
	protected String url;
	protected String soapAction;
	
	public ServicoBean(String autorizador, String servico, String versao, String tpEmis, 
			String ambiente, String[] estados, String url, String soapAction) {
		this.setAutorizador(autorizador);
		this.setServico(servico);
		this.setVersao(versao);
		this.setTpEmis(tpEmis);
		this.setAmbiente(ambiente);
		this.setEstados(estados);
		this.setUrl(url);
		this.setSoapAction(soapAction);
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#getAutorizador()
	 */
	@Override
	public String getAutorizador() {
		return autorizador;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#setAutorizador(java.lang.String)
	 */
	@Override
	public void setAutorizador(String autorizador) {
		this.autorizador = autorizador;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#getServico()
	 */
	@Override
	public String getServico() {
		return servico;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#setServico(java.lang.String)
	 */
	@Override
	public void setServico(String servico) {
		this.servico = servico;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#getVersao()
	 */
	@Override
	public String getVersao() {
		return versao;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#setVersao(java.lang.String)
	 */
	@Override
	public void setVersao(String versao) {
		this.versao = versao;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#getAmbiente()
	 */
	@Override
	public String getAmbiente() {
		return ambiente;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#setAmbiente(java.lang.String)
	 */
	@Override
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#getEstados()
	 */
	@Override
	public String[] getEstados() {
		return estados;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#setEstados(java.lang.String[])
	 */
	@Override
	public void setEstados(String[] estados) {
		this.estados = estados;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#getUrl()
	 */
	@Override
	public String getUrl() {
		return url;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#setUrl(java.lang.String)
	 */
	@Override
	public void setUrl(String url) {
		this.url = url;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#getSoapAction()
	 */
	@Override
	public String getSoapAction() {
		return soapAction;
	}
	/* (non-Javadoc)
	 * @see br.com.pietroniro.mapping.grc.Servico#setSoapAction(java.lang.String)
	 */
	@Override
	public void setSoapAction(String soapAction) {
		this.soapAction = soapAction;
	}
	@Override
	public boolean existeEstado(String estado) {
		for (String est: this.estados) {
			if (est.equals(estado)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String getTpEmis() {
		return tpEmis;
	}
	@Override
	public void setTpEmis(String tpEmis) {
		this.tpEmis = tpEmis;
	}
}
