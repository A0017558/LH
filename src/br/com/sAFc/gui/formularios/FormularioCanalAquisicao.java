package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosCanalAquisicao;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioCanalAquisicao extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"canalAquisicao/form.html");
	
	
	private OperadorObjetosCanalAquisicao operador =  new OperadorObjetosCanalAquisicao(this);
	
	
	public FormularioCanalAquisicao(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosCanalAquisicao getOperadorObjetosCanalAquisicao(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
