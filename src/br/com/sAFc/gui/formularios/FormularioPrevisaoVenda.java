package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosPrevisaoVenda;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioPrevisaoVenda extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"previsaoVenda/form.html");
	
	
	private OperadorObjetosPrevisaoVenda operador =  new OperadorObjetosPrevisaoVenda(this);
	
	
	public FormularioPrevisaoVenda(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosPrevisaoVenda getOperadorObjetosPrevisaoVenda(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
