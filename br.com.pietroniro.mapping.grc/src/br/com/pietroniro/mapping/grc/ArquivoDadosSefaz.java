package br.com.pietroniro.mapping.grc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArquivoDadosSefaz implements DadosSefaz {

	private List<Servico> servicos = new ArrayList<Servico>();

	@Override
	public Servico procuraServico(String estado, String servico, String versao, String ambiente) {
		Servico ret = null;
		
		for (Servico serv: servicos) {
			if (serv.existeEstado(estado)         &&
			    serv.getServico().equals(servico) &&
			    serv.getVersao().equals(versao)   &&
			    serv.getAmbiente().equals(ambiente)) {
				ret = serv;
			}
		}
		return ret;
	}

	@Override
	public List<Servico> readData(String uri) {
		this.readResource(uri);
		return this.servicos;
	}

	private void readResource(String uri) {
		String line;
		BufferedReader br;

		try {
			br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(uri)));
			while((line = br.readLine()) != null ) {
				Servico serv = this.transformData(line);
				
				if (serv != null) {
					servicos.add(serv);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Boolean isRegistroValido(String[] registro) {
		Boolean ret = false;
		
		if (registro.length == 7) {
			ret = true;
		}
		return ret;
	}
	
	private Servico transformData(String servico) {
		String[] separado;
		Servico ret = null;
		
		separado = servico.split(Separador.CAMPOS.getSeparador());
		if (isRegistroValido(separado)) {
			ret = new ServicoBean(
					separado[0], 
					separado[1], 
					separado[2],
					separado[3],
					separado[4].split(Separador.ESTADOS.getSeparador()),
					separado[5],
					separado[6]);			
		} else {
			//throw new Exception("Arquivo de dados de serviços da SEFAZ inválido!");
		}
		return ret;
	}

}