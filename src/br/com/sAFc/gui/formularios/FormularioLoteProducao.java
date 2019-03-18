package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosLoteProducao;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioLoteProducao extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"loteProducao/form.html");
	
	
	private OperadorObjetosLoteProducao operador =  new OperadorObjetosLoteProducao(this);
	
	
	public FormularioLoteProducao(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosLoteProducao getOperadorObjetosLoteProducao(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
