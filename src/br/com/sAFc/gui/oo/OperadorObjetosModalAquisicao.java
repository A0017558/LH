package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIAModalAquisicao;
import br.com.sAFc.interfaces.gui.SPOModalAquisicao;
import br.com.sAFc.interfaces.nucleo.ModalAquisicao_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosModalAquisicao extends OperadorObjetosAbstratoSAFC implements SIAModalAquisicao,SPOModalAquisicao {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"modalAquisicao/detalhe.html");
	
	
	
	
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCodigoModalAquisicao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaNomeModalAquisicao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoCodigoModalAquisicao = new CampoFormularioIntSAFC(this, "Codigo do Modal de Aquisição                                                                                                                                                                            ",CampoDeFormulario.TIPO_TEXTO){
		public boolean isBloqueado() {
			return true;
		}
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				ModalAquisicao_IN objNeg =  (ModalAquisicao_IN) objetoNegocio;
				setValor(objNeg.getCodigoModalAquisicao());
		};
	};
	private CampoFormularioSAFC campoNomeModalAquisicao = new CampoFormularioSAFC(this, "Nome do Modal de Aquisição                                                                                                                                                                              ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				ModalAquisicao_IN objNeg =  (ModalAquisicao_IN) objetoNegocio;
				setValor(objNeg.getNomeModalAquisicao());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoCodigoModalAquisicao
		,
		campoNomeModalAquisicao
	};
	
	
	
	public OperadorObjetosModalAquisicao(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoModalAquisicao(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getModalAquisicaos(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "ModalAquisicao";
	}
	
	
	
	
	
	
	public CampoFormularioIntSAFC getCampoCodigoModalAquisicao(){
		     return this.campoCodigoModalAquisicao;
	}
	public int getCodigoModalAquisicao(){ return getCampoCodigoModalAquisicao().getInt();}
	
	public CampoFormularioSAFC getCampoNomeModalAquisicao(){
		return this.campoNomeModalAquisicao;
	}
	public String getNomeModalAquisicao(){ return (String)getCampoNomeModalAquisicao().getObjetoValor();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCodigoModalAquisicao(){
		return this.campoPesquisaCodigoModalAquisicao;
	}
	public String getCodigoModalAquisicaoPesquisa(){
		return this.getCampoPesquisaCodigoModalAquisicao().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaNomeModalAquisicao(){
		return this.campoPesquisaNomeModalAquisicao;
	}
	public String getNomeModalAquisicaoPesquisa(){
		return this.getCampoPesquisaNomeModalAquisicao().getValorString();
	}
	
	
	
}
