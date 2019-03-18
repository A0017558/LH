package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosCurva;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioCurva extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"curva/form.html");
	
	
	private OperadorObjetosCurva operador =  new OperadorObjetosCurva(this);
	
	
	public FormularioCurva(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosCurva getOperadorObjetosCurva(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
