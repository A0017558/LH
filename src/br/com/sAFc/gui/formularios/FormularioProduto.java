package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosProduto;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioProduto extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"produto/form.html");
	
	
	private OperadorObjetosProduto operador =  new OperadorObjetosProduto(this);
	
	
	public FormularioProduto(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosProduto getOperadorObjetosProduto(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
