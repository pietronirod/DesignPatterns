package br.com.pietroniro.mapping.grc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mapping.api.AbstractTransformation;
import com.sap.aii.mapping.api.DynamicConfiguration;
import com.sap.aii.mapping.api.DynamicConfigurationKey;
import com.sap.aii.mapping.api.StreamTransformationException;
import com.sap.aii.mapping.api.TransformationInput;
import com.sap.aii.mapping.api.TransformationOutput;

public class MapSoapAdapter extends AbstractTransformation {

	private static final DynamicConfigurationKey KEY_URL = 
			DynamicConfigurationKey.create("http://sap.com/xi/XI/System/SOAP", "TServerLocation");
	private static final DynamicConfigurationKey KEY_ACTION = 
			DynamicConfigurationKey.create("http://sap.com/xi/XI/System/SOAP", "THeaderSOAPACTION");
	private static final String MSG01 = "Erro ao copiar payload.";
	
	@Override
	public void transform(TransformationInput input, TransformationOutput output) throws StreamTransformationException {
		AbstractTrace trace = this.getTrace();
		
		this.copyPayload(input.getInputPayload().getInputStream(), output.getOutputPayload().getOutputStream());
		
		DynamicConfiguration conf = input.getDynamicConfiguration();
		
		
		
		conf.put(KEY_URL, "");
		conf.put(KEY_ACTION, "");
		
	}
	
	private void copyPayload(InputStream in, OutputStream out) {
		int c;
		
		try {
			c = in.read();

			while (c != -1) {
				out.write(c);
				c = in.read();
			}
		} catch (IOException e) {
//			trace.addWarning(MSG01);
		}
	}

}
