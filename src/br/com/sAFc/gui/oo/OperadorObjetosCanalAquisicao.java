package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIACanalAquisicao;
import br.com.sAFc.interfaces.gui.SPOCanalAquisicao;
import br.com.sAFc.interfaces.nucleo.CanalAquisicao_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosCanalAquisicao extends OperadorObjetosAbstratoSAFC implements SIACanalAquisicao,SPOCanalAquisicao {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"canalAquisicao/detalhe.html");
	
	
	
	
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCodigoCanalAquisicao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCanalAquisicao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoCodigoCanalAquisicao = new CampoFormularioIntSAFC(this, "Código do Canal de Aquisição                                                                                                                                                                            ",CampoDeFormulario.TIPO_TEXTO){
		public boolean isBloqueado() {
			return true;
		}
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				CanalAquisicao_IN objNeg =  (CanalAquisicao_IN) objetoNegocio;
				setValor(objNeg.getCodigoCanalAquisicao());
		};
	};
	private CampoFormularioSAFC campoCanalAquisicao = new CampoFormularioSAFC(this, "Canal de Aquisição                                                                                                                                                                                      ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				CanalAquisicao_IN objNeg =  (CanalAquisicao_IN) objetoNegocio;
				setValor(objNeg.getCanalAquisicao());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoCodigoCanalAquisicao
		,
		campoCanalAquisicao
	};
	
	
	
	public OperadorObjetosCanalAquisicao(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoCanalAquisicao(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getCanalAquisicaos(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "CanalAquisicao";
	}
	
	
	
	
	
	
	public CampoFormularioIntSAFC getCampoCodigoCanalAquisicao(){
		     return this.campoCodigoCanalAquisicao;
	}
	public int getCodigoCanalAquisicao(){ return getCampoCodigoCanalAquisicao().getInt();}
	
	public CampoFormularioSAFC getCampoCanalAquisicao(){
		return this.campoCanalAquisicao;
	}
	public String getCanalAquisicao(){ return (String)getCampoCanalAquisicao().getObjetoValor();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCodigoCanalAquisicao(){
		return this.campoPesquisaCodigoCanalAquisicao;
	}
	public String getCodigoCanalAquisicaoPesquisa(){
		return this.getCampoPesquisaCodigoCanalAquisicao().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCanalAquisicao(){
		return this.campoPesquisaCanalAquisicao;
	}
	public String getCanalAquisicaoPesquisa(){
		return this.getCampoPesquisaCanalAquisicao().getValorString();
	}
	
	
	
}
