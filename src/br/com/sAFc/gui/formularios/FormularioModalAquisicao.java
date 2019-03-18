package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosModalAquisicao;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioModalAquisicao extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"modalAquisicao/form.html");
	
	
	private OperadorObjetosModalAquisicao operador =  new OperadorObjetosModalAquisicao(this);
	
	
	public FormularioModalAquisicao(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosModalAquisicao getOperadorObjetosModalAquisicao(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
