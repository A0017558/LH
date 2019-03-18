package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosTipoInsumo;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioTipoInsumo extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"tipoInsumo/form.html");
	
	
	private OperadorObjetosTipoInsumo operador =  new OperadorObjetosTipoInsumo(this);
	
	
	public FormularioTipoInsumo(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosTipoInsumo getOperadorObjetosTipoInsumo(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
