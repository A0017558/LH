package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosLinhaProducao;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioLinhaProducao extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"linhaProducao/form.html");
	
	
	private OperadorObjetosLinhaProducao operador =  new OperadorObjetosLinhaProducao(this);
	
	
	public FormularioLinhaProducao(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosLinhaProducao getOperadorObjetosLinhaProducao(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
