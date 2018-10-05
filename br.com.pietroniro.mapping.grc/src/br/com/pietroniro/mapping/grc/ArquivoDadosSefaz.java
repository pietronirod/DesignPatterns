package br.com.pietroniro.mapping.grc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.aii.mapping.api.AbstractTrace;

public class ArquivoDadosSefaz implements DadosSefaz {

	private String MSG01 = "Erro ao processar registro: ";
	private String MSG02 = "Erro ao acessar arquivo ";
	
	private List<Servico> servicos = new ArrayList<Servico>();

	private AbstractTrace trace;
	private Logger logger;

	public ArquivoDadosSefaz(String uri, Object trace) {
		if (trace instanceof AbstractTrace) {
			this.trace = (AbstractTrace) trace;
		} else {
			this.logger = (Logger) trace;
		}
		servicos = this.readData(uri);
	}
			
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
		this.servicos.clear();
		this.readResource(uri);
		return this.servicos;
	}

	private void log(String msg) {
		if (trace == null) {
			logger.log(Level.WARNING, msg);
		} else {
			trace.addWarning(msg);
		}
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
		} catch (Exception e) {
			this.log(MSG02 + uri);
		}
	}
	
	private Boolean isRegistroValido(String[] registro) {
		Boolean ret = false;
		String msg = "";
		
		if (registro.length == 7) {
			ret = true;
		} else {
			for (String reg: registro) {
				msg = MSG01 + "** " + reg + " ";
			}
			this.log(msg);
		}
		return ret;
	}
	
	private Servico transformData(String servico) {
		String[] separado;
		Servico ret = null;
		
		separado = servico.split(Separador.CAMPOS.getSeparador());
		if (isRegistroValido(separado)) {
			ret = ServicoFactory.getServico(new ServicoBeanFactory(
					separado[0], 
					separado[1], 
					separado[2],
					separado[3],
					separado[4].split(Separador.ESTADOS.getSeparador()),
					separado[5],
					separado[6]));			
		} else {
			//throw new Exception("Arquivo de dados de serviços da SEFAZ inválido!");
		}
		return ret;
	}

}