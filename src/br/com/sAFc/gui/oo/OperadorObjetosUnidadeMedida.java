package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIAUnidadeMedida;
import br.com.sAFc.interfaces.gui.SPOUnidadeMedida;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosUnidadeMedida extends OperadorObjetosAbstratoSAFC implements SIAUnidadeMedida,SPOUnidadeMedida {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"unidadeMedida/detalhe.html");
	
	
	
	
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaSiglaUnidadeMedida = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaNomeUnidadeMedida = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioSAFC campoSiglaUnidadeMedida = new CampoFormularioSAFC(this, "Sigla da Unidade de Medida                                                                                                                                                                              ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				UnidadeMedida_IN objNeg =  (UnidadeMedida_IN) objetoNegocio;
				setValor(objNeg.getSiglaUnidadeMedida());
		};
	};
	private CampoFormularioSAFC campoNomeUnidadeMedida = new CampoFormularioSAFC(this, "Nome da Unidade de Medida                                                                                                                                                                               ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				UnidadeMedida_IN objNeg =  (UnidadeMedida_IN) objetoNegocio;
				setValor(objNeg.getNomeUnidadeMedida());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoSiglaUnidadeMedida
		,
		campoNomeUnidadeMedida
	};
	
	
	
	public OperadorObjetosUnidadeMedida(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoUnidadeMedida(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getUnidadeMedidas(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "UnidadeMedida";
	}
	
	
	
	
	
	
	public CampoFormularioSAFC getCampoSiglaUnidadeMedida(){
		return this.campoSiglaUnidadeMedida;
	}
	public String getSiglaUnidadeMedida(){ return (String)getCampoSiglaUnidadeMedida().getObjetoValor();}
	
	public CampoFormularioSAFC getCampoNomeUnidadeMedida(){
		return this.campoNomeUnidadeMedida;
	}
	public String getNomeUnidadeMedida(){ return (String)getCampoNomeUnidadeMedida().getObjetoValor();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaSiglaUnidadeMedida(){
		return this.campoPesquisaSiglaUnidadeMedida;
	}
	public String getSiglaUnidadeMedidaPesquisa(){
		return this.getCampoPesquisaSiglaUnidadeMedida().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaNomeUnidadeMedida(){
		return this.campoPesquisaNomeUnidadeMedida;
	}
	public String getNomeUnidadeMedidaPesquisa(){
		return this.getCampoPesquisaNomeUnidadeMedida().getValorString();
	}
	
	
	
}
