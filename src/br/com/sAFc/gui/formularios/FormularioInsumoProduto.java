package br.com.sAFc.gui.formularios; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.oo.OperadorObjetosInsumoProduto;
import formularios.DecodificadorComandos;
import formularios.HTML;


public class FormularioInsumoProduto extends FormularioAbstratoSAFC {
	
	
	private HTML_SAFC  html =  new HTML_SAFC(this,"insumoProduto/form.html");
	
	
	private OperadorObjetosInsumoProduto operador =  new OperadorObjetosInsumoProduto(this);
	
	
	public FormularioInsumoProduto(DecodificadorComandos decodificadorComandos){
		super(decodificadorComandos);
	}
	
	
	public OperadorObjetosInsumoProduto getOperadorObjetosInsumoProduto(){
		return operador;
	}
	
	public HTML getHtml() {
			return html;
	}
	
}
