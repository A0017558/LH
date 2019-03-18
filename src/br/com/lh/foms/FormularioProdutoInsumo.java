package br.com.lh.foms;

import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.gui.oo.OperadorObjetosInsumoProduto;
import br.com.sAFc.gui.oo.OperadorObjetosProduto;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import formularios.DecodificadorComandos;
import formularios.HTML;

public class FormularioProdutoInsumo extends FormularioAbstratoSAFC {

	private HTML_Obj html = new HTML_Obj(){
		public String getHTML() {
			return "<!-- !id='operadorObjetosProduto' --><br>" +
					"<!-- !id='operadorObjetosInsumoProduto' -->";
		};
	};
	private OperadorObjetosProduto operadorObjetosProduto = new OperadorObjetosProduto(this);
	private OperadorObjetosInsumoProduto operadorObjetosInsumoProduto = new OperadorObjetosInsumoProduto(this){
		public formularios.OperadorObjetos getOperadorObjetosSubordinante() {
			return operadorObjetosProduto;
		};
		public formularios.ObjetoItemLista[] getListaObjetos() {
			return ((Produto_IN)operadorObjetosProduto.getObjetoEmEdicao()).getProdutossRelacionados();
		};
		public Produto_IN getProduto() {
			return ((Produto_IN)operadorObjetosProduto.getObjetoEmEdicao());
		};
	};
	public FormularioProdutoInsumo(DecodificadorComandos decodificadorComandos) {
		super(decodificadorComandos);
	}

	@Override
	public HTML getHtml() {
		return html;
	}
	public OperadorObjetosInsumoProduto getOperadorObjetosInsumoProduto() {
		return operadorObjetosInsumoProduto;
	}
	public OperadorObjetosProduto getOperadorObjetosProduto() {
		return operadorObjetosProduto;
	}
}
