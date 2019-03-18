package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIACurva;
import br.com.sAFc.interfaces.gui.SPOCurva;
import br.com.sAFc.interfaces.nucleo.Curva_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosCurva extends OperadorObjetosAbstratoSAFC implements SIACurva,SPOCurva {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"curva/detalhe.html");
	
	
	
	
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCodigoCurva = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioSAFC campoCodigoCurva = new CampoFormularioSAFC(this, "Codigo da Curva                                                                                                                                                                                         ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Curva_IN objNeg =  (Curva_IN) objetoNegocio;
				setValor(objNeg.getCodigoCurva());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoCodigoCurva
	};
	
	
	
	public OperadorObjetosCurva(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoCurva(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getCurvas(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "Curva";
	}
	
	
	
	
	
	
	public CampoFormularioSAFC getCampoCodigoCurva(){
		return this.campoCodigoCurva;
	}
	public String getCodigoCurva(){ return (String)getCampoCodigoCurva().getObjetoValor();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCodigoCurva(){
		return this.campoPesquisaCodigoCurva;
	}
	public String getCodigoCurvaPesquisa(){
		return this.getCampoPesquisaCodigoCurva().getValorString();
	}
	
	
	
}
