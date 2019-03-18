package br.com.sAFc.gui.oo; 


import java.util.GregorianCalendar;

import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.campos.CampoSelecionaObjetoSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIAPrevisaoVenda;
import br.com.sAFc.interfaces.gui.SPOPrevisaoVenda;
import br.com.sAFc.interfaces.nucleo.PrevisaoVenda_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosPrevisaoVenda extends OperadorObjetosAbstratoSAFC implements SIAPrevisaoVenda,SPOPrevisaoVenda {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"previsaoVenda/detalhe.html");
	
	
	private CampoSelecionaObjetoSAFC campoSelecionaProdutoPesquisa = new CampoSelecionaObjetoSAFC(this, "Produto                                                                                                                                                                                                 "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getProdutos(null);
		}
	};
	
	
	// Campo de Relacionamento com objeto:Produto
	private CampoSelecionaObjetoSAFC campoSelecionaProduto = new CampoSelecionaObjetoSAFC(this, "Produto                                                                                                                                                                                                 "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			PrevisaoVenda_IN objNeg =  (PrevisaoVenda_IN) objetoNegocio;
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
	private CampoFormularioSAFC campoPesquisaNumeroPrevisao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaDataPrevisaoVenda = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaQuantidadeProduto = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoNumeroPrevisao = new CampoFormularioIntSAFC(this, "Numero da Previsão                                                                                                                                                                                      ",CampoDeFormulario.TIPO_TEXTO){
		public boolean isBloqueado() {
			return true;
		}
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				PrevisaoVenda_IN objNeg =  (PrevisaoVenda_IN) objetoNegocio;
				setValor(objNeg.getNumeroPrevisao());
		};
	};
	private CampoFormularioDataSAFC campoDataPrevisaoVenda = new CampoFormularioDataSAFC(this, "Data da Previsão de Venda                                                                                                                                                                               ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				PrevisaoVenda_IN objNeg =  (PrevisaoVenda_IN) objetoNegocio;
				setValor(objNeg.getDataPrevisaoVenda());
		};
	};
	private CampoFormularioIntSAFC campoQuantidadeProduto = new CampoFormularioIntSAFC(this, "Quantidade do Produto                                                                                                                                                                                   ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				PrevisaoVenda_IN objNeg =  (PrevisaoVenda_IN) objetoNegocio;
				setValor(objNeg.getQuantidadeProduto());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoNumeroPrevisao
		,
		campoDataPrevisaoVenda
		,
		campoQuantidadeProduto
		,
		campoSelecionaProduto
	};
	
	
	
	public OperadorObjetosPrevisaoVenda(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoPrevisaoVenda(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getPrevisaoVendas(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "PrevisaoVenda";
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
	
	
	
	public CampoFormularioIntSAFC getCampoNumeroPrevisao(){
		     return this.campoNumeroPrevisao;
	}
	public int getNumeroPrevisao(){ return getCampoNumeroPrevisao().getInt();}
	
	public CampoFormularioDataSAFC getCampoDataPrevisaoVenda(){
		return this.campoDataPrevisaoVenda; 
	}
	public GregorianCalendar getDataPrevisaoVenda(){ return (GregorianCalendar)getCampoDataPrevisaoVenda().getObjetoValor();}
	
	public CampoFormularioIntSAFC getCampoQuantidadeProduto(){
		     return this.campoQuantidadeProduto;
	}
	public int getQuantidadeProduto(){ return getCampoQuantidadeProduto().getInt();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaNumeroPrevisao(){
		return this.campoPesquisaNumeroPrevisao;
	}
	public String getNumeroPrevisaoPesquisa(){
		return this.getCampoPesquisaNumeroPrevisao().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaDataPrevisaoVenda(){
		return this.campoPesquisaDataPrevisaoVenda;
	}
	public String getDataPrevisaoVendaPesquisa(){
		return this.getCampoPesquisaDataPrevisaoVenda().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaQuantidadeProduto(){
		return this.campoPesquisaQuantidadeProduto;
	}
	public String getQuantidadeProdutoPesquisa(){
		return this.getCampoPesquisaQuantidadeProduto().getValorString();
	}
	
	
	
}
