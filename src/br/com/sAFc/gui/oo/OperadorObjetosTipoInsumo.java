package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIATipoInsumo;
import br.com.sAFc.interfaces.gui.SPOTipoInsumo;
import br.com.sAFc.interfaces.nucleo.TipoInsumo_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosTipoInsumo extends OperadorObjetosAbstratoSAFC implements SIATipoInsumo,SPOTipoInsumo {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"tipoInsumo/detalhe.html");
	
	
	
	
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCodigoTipoInsumo = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaNomeTipoInsumo = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoCodigoTipoInsumo = new CampoFormularioIntSAFC(this, "Codigo Tipo de Insumo                                                                                                                                                                                   ",CampoDeFormulario.TIPO_TEXTO){
		public boolean isBloqueado() {
			return true;
		}
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				TipoInsumo_IN objNeg =  (TipoInsumo_IN) objetoNegocio;
				setValor(objNeg.getCodigoTipoInsumo());
		};
	};
	private CampoFormularioSAFC campoNomeTipoInsumo = new CampoFormularioSAFC(this, "Nome do Tipo de Insumo                                                                                                                                                                                  ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				TipoInsumo_IN objNeg =  (TipoInsumo_IN) objetoNegocio;
				setValor(objNeg.getNomeTipoInsumo());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoCodigoTipoInsumo
		,
		campoNomeTipoInsumo
	};
	
	
	
	public OperadorObjetosTipoInsumo(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoTipoInsumo(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getTipoInsumos(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "TipoInsumo";
	}
	
	
	
	
	
	
	public CampoFormularioIntSAFC getCampoCodigoTipoInsumo(){
		     return this.campoCodigoTipoInsumo;
	}
	public int getCodigoTipoInsumo(){ return getCampoCodigoTipoInsumo().getInt();}
	
	public CampoFormularioSAFC getCampoNomeTipoInsumo(){
		return this.campoNomeTipoInsumo;
	}
	public String getNomeTipoInsumo(){ return (String)getCampoNomeTipoInsumo().getObjetoValor();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCodigoTipoInsumo(){
		return this.campoPesquisaCodigoTipoInsumo;
	}
	public String getCodigoTipoInsumoPesquisa(){
		return this.getCampoPesquisaCodigoTipoInsumo().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaNomeTipoInsumo(){
		return this.campoPesquisaNomeTipoInsumo;
	}
	public String getNomeTipoInsumoPesquisa(){
		return this.getCampoPesquisaNomeTipoInsumo().getValorString();
	}
	
	
	
}
