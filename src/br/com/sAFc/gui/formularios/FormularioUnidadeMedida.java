package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosUnidadeMedida;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioUnidadeMedida extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"unidadeMedida/form.html");
	
	
	private OperadorObjetosUnidadeMedida operador =  new OperadorObjetosUnidadeMedida(this);
	
	
	public FormularioUnidadeMedida(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosUnidadeMedida getOperadorObjetosUnidadeMedida(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
