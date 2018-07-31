
public class ContadorSimples implements ContadorPalavras {

	private int qtd;
	
	@Override
	public void contar(String palavras) {
		qtd ++;
		
	}

	@Override
	public int contagem() {
		return qtd;
	}

}
