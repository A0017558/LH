package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIADestinacao;
import br.com.sAFc.interfaces.gui.SPODestinacao;
import br.com.sAFc.interfaces.nucleo.Destinacao_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosDestinacao extends OperadorObjetosAbstratoSAFC implements SIADestinacao,SPODestinacao {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"destinacao/detalhe.html");
	
	
	
	
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCodigoDestinacao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaNomeDestinacao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoCodigoDestinacao = new CampoFormularioIntSAFC(this, "Codigo da Destinação                                                                                                                                                                                    ",CampoDeFormulario.TIPO_TEXTO){
		public boolean isBloqueado() {
			return true;
		}
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Destinacao_IN objNeg =  (Destinacao_IN) objetoNegocio;
				setValor(objNeg.getCodigoDestinacao());
		};
	};
	private CampoFormularioSAFC campoNomeDestinacao = new CampoFormularioSAFC(this, "Nome da Destinação                                                                                                                                                                                      ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Destinacao_IN objNeg =  (Destinacao_IN) objetoNegocio;
				setValor(objNeg.getNomeDestinacao());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoCodigoDestinacao
		,
		campoNomeDestinacao
	};
	
	
	
	public OperadorObjetosDestinacao(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoDestinacao(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getDestinacaos(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "Destinacao";
	}
	
	
	
	
	
	
	public CampoFormularioIntSAFC getCampoCodigoDestinacao(){
		     return this.campoCodigoDestinacao;
	}
	public int getCodigoDestinacao(){ return getCampoCodigoDestinacao().getInt();}
	
	public CampoFormularioSAFC getCampoNomeDestinacao(){
		return this.campoNomeDestinacao;
	}
	public String getNomeDestinacao(){ return (String)getCampoNomeDestinacao().getObjetoValor();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCodigoDestinacao(){
		return this.campoPesquisaCodigoDestinacao;
	}
	public String getCodigoDestinacaoPesquisa(){
		return this.getCampoPesquisaCodigoDestinacao().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaNomeDestinacao(){
		return this.campoPesquisaNomeDestinacao;
	}
	public String getNomeDestinacaoPesquisa(){
		return this.getCampoPesquisaNomeDestinacao().getValorString();
	}
	
	
	
}
