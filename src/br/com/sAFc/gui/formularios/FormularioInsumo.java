package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosInsumo;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioInsumo extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"insumo/form.html");
	
	
	private OperadorObjetosInsumo operador =  new OperadorObjetosInsumo(this);
	
	
	public FormularioInsumo(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosInsumo getOperadorObjetosInsumo(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
