package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosDestinacao;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioDestinacao extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"destinacao/form.html");
	
	
	private OperadorObjetosDestinacao operador =  new OperadorObjetosDestinacao(this);
	
	
	public FormularioDestinacao(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosDestinacao getOperadorObjetosDestinacao(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
