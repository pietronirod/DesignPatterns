package br.com.pietroniro.mapping.nfe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SefazUtils {
	private static final int  COL = 8;
	private static SefazUtils sefazUtils;
	private List<SefazBean>   lstSefaz;
	
	private SefazUtils(String arquivo) {
		lstSefaz = new ArrayList<SefazBean>();
		CsvUtils csv = CsvUtils.newInstance();
		List<List<String>> lista = csv.getData(csv.getResource(arquivo), COL);
		
		for (List<String> sefaz : lista) {
			lstSefaz.add(SefazBean.getInstance(
					sefaz.get(0), //autorizador 
					sefaz.get(1), //servico
					sefaz.get(2), //versao
					sefaz.get(3), //emissao
					sefaz.get(4), //ambiente
					sefaz.get(5).split(Separador.VIRGULA.getValue()), //estados
					sefaz.get(6), //url
					sefaz.get(7)  //SOAP Action
			));
		}
	}
	
	public static SefazUtils getInstance(String arquivo) {
		if (sefazUtils == null) {
			sefazUtils = new SefazUtils(arquivo);
		}
		return sefazUtils;
	}
	
	public int buscaServico(SefazBean sefaz) {
		
		Collections.sort(lstSefaz);
		return Collections.binarySearch(lstSefaz, sefaz);
	}
}
