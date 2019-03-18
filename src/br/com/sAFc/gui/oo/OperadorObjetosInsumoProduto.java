package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.campos.CampoSelecionaObjetoSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIAInsumoProduto;
import br.com.sAFc.interfaces.gui.SPOInsumoProduto;
import br.com.sAFc.interfaces.nucleo.InsumoProduto_IN;
import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosInsumoProduto extends OperadorObjetosAbstratoSAFC implements SIAInsumoProduto,SPOInsumoProduto {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"insumoProduto/detalhe.html");
	
	
	private CampoSelecionaObjetoSAFC campoSelecionaProdutosPesquisa = new CampoSelecionaObjetoSAFC(this, "Produtos                                                                                                                                                                                                "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getInsumos(null);
		}
	};
	private CampoSelecionaObjetoSAFC campoSelecionaInsumosPesquisa = new CampoSelecionaObjetoSAFC(this, "Insumos                                                                                                                                                                                                 "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getProdutos(null);
		}
	};
	
	
	// Campo de Relacionamento com objeto:Insumo
	private CampoSelecionaObjetoSAFC campoSelecionaProdutos = new CampoSelecionaObjetoSAFC(this, "Produtos                                                                                                                                                                                                "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			InsumoProduto_IN objNeg =  (InsumoProduto_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getProdutos();
			if(objRel!=null){
				setValor(objRel.getCodigoIdentificadorLista());
			}
			else{
				setNull();
			}
		}
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getInsumos(null);
		}
	};
	// Campo de Relacionamento com objeto:Produto
	private CampoSelecionaObjetoSAFC campoSelecionaInsumos = new CampoSelecionaObjetoSAFC(this, "Insumos                                                                                                                                                                                                 "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			InsumoProduto_IN objNeg =  (InsumoProduto_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getInsumos();
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
	private CampoFormularioSAFC campoPesquisaQuantidadeInsumoporUnidadeProduto = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoQuantidadeInsumoporUnidadeProduto = new CampoFormularioIntSAFC(this, "Quantidade de Insumo por Unidade de Produto                                                                                                                                                             ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				InsumoProduto_IN objNeg =  (InsumoProduto_IN) objetoNegocio;
				setValor(objNeg.getQuantidadeInsumoporUnidadeProduto());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoQuantidadeInsumoporUnidadeProduto
		,
		campoSelecionaProdutos
		,
		campoSelecionaInsumos
	};
	
	
	
	public OperadorObjetosInsumoProduto(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoInsumoProduto(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getInsumoProdutos(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "InsumoProduto";
	}
	
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaProdutos(){
		return  campoSelecionaProdutos;
	}
	public Insumo_IN getProdutos(){
		return (Insumo_IN) getCampoSelecionaProdutos().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaInsumos(){
		return  campoSelecionaInsumos;
	}
	public Produto_IN getInsumos(){
		return (Produto_IN) getCampoSelecionaInsumos().getObjetoSelecionado();
	}
	
	
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaProdutosPesquisa(){
		return  campoSelecionaProdutosPesquisa;
	}
	public Insumo_IN getProdutosPesquisa(){
		return (Insumo_IN) getCampoSelecionaProdutosPesquisa().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaInsumosPesquisa(){
		return  campoSelecionaInsumosPesquisa;
	}
	public Produto_IN getInsumosPesquisa(){
		return (Produto_IN) getCampoSelecionaInsumosPesquisa().getObjetoSelecionado();
	}
	
	
	
	public CampoFormularioIntSAFC getCampoQuantidadeInsumoporUnidadeProduto(){
		     return this.campoQuantidadeInsumoporUnidadeProduto;
	}
	public int getQuantidadeInsumoporUnidadeProduto(){ return getCampoQuantidadeInsumoporUnidadeProduto().getInt();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaQuantidadeInsumoporUnidadeProduto(){
		return this.campoPesquisaQuantidadeInsumoporUnidadeProduto;
	}
	public String getQuantidadeInsumoporUnidadeProdutoPesquisa(){
		return this.getCampoPesquisaQuantidadeInsumoporUnidadeProduto().getValorString();
	}
	
	
	
}
