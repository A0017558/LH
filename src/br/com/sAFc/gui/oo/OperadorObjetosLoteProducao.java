package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.campos.CampoSelecionaObjetoSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIALoteProducao;
import br.com.sAFc.interfaces.gui.SPOLoteProducao;
import br.com.sAFc.interfaces.nucleo.LoteProducao_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosLoteProducao extends OperadorObjetosAbstratoSAFC implements SIALoteProducao,SPOLoteProducao {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"loteProducao/detalhe.html");
	
	
	private CampoSelecionaObjetoSAFC campoSelecionaProdutoPesquisa = new CampoSelecionaObjetoSAFC(this, "Produto                                                                                                                                                                                                 "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getProdutos(null);
		}
	};
	
	
	// Campo de Relacionamento com objeto:Produto
	private CampoSelecionaObjetoSAFC campoSelecionaProduto = new CampoSelecionaObjetoSAFC(this, "Produto                                                                                                                                                                                                 "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			LoteProducao_IN objNeg =  (LoteProducao_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getProduto();
			if(objRel!=null){
				setValor(objRel.getCodigoIdentificadorLista());
			}
			else{
				setNull();
			}
		}
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getProdutos(null);
		}
	};
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCodigoLote = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoCodigoLote = new CampoFormularioIntSAFC(this, "Codigo do Lote                                                                                                                                                                                          ",CampoDeFormulario.TIPO_TEXTO){
		public boolean isBloqueado() {
			return true;
		}
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				LoteProducao_IN objNeg =  (LoteProducao_IN) objetoNegocio;
				setValor(objNeg.getCodigoLote());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoCodigoLote
		,
		campoSelecionaProduto
	};
	
	
	
	public OperadorObjetosLoteProducao(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoLoteProducao(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getLoteProducaos(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "LoteProducao";
	}
	
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaProduto(){
		return  campoSelecionaProduto;
	}
	public Produto_IN getProduto(){
		return (Produto_IN) getCampoSelecionaProduto().getObjetoSelecionado();
	}
	
	
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaProdutoPesquisa(){
		return  campoSelecionaProdutoPesquisa;
	}
	public Produto_IN getProdutoPesquisa(){
		return (Produto_IN) getCampoSelecionaProdutoPesquisa().getObjetoSelecionado();
	}
	
	
	
	public CampoFormularioIntSAFC getCampoCodigoLote(){
		     return this.campoCodigoLote;
	}
	public int getCodigoLote(){ return getCampoCodigoLote().getInt();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCodigoLote(){
		return this.campoPesquisaCodigoLote;
	}
	public String getCodigoLotePesquisa(){
		return this.getCampoPesquisaCodigoLote().getValorString();
	}
	
	
	
}
