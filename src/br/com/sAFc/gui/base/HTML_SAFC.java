package br.com.sAFc.gui.base;

import java.io.InputStream;

import formularios.FormularioAbstrato;
import formularios.HTML;
import formularios.OperadorObjetos;

public class HTML_SAFC extends HTML {

	private String nmArquivo =  null;
	
	public HTML_SAFC() {
		super();
	}

	public HTML_SAFC(FormularioAbstrato formulario) {
		super(formulario);
	}

	public HTML_SAFC(OperadorObjetos operadorObjetos,String htmlFonte) {
		super(operadorObjetos);
		nmArquivo = htmlFonte;
	}

	@Deprecated
	public HTML_SAFC(String htmlFonte) {
		super(htmlFonte);
		nmArquivo = htmlFonte;
	}
	public HTML_SAFC(FormularioAbstrato form,String htmlFonte) {
		super(form);
		nmArquivo = htmlFonte;
	}

	public String getNomeBaseArquivos() {
		return "/html/";
	}	
	public  String getNomeArquivo(){
		return nmArquivo; 
	}
	
	public boolean isFonteResourceAsStream() {
		return true;
	}
	
	
	@Override
	public InputStream getInputFonte() {
		
		return super.getInputFonte();
	}
	
	public static void main(String[] args) throws Exception {
		HTML_SAFC  hs =  new HTML_SAFC("acervo/form.html");
		HTML_SAFC h = new HTML_SAFC("lista.html");
		InputStream in =  h.getInputFonte();
		int b = in.read();
		while(b>0){
			System.out.print((char)b);
			b = in.read();
		}
	}
	
}
