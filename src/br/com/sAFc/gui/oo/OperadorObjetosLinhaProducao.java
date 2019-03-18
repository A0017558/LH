package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIALinhaProducao;
import br.com.sAFc.interfaces.gui.SPOLinhaProducao;
import br.com.sAFc.interfaces.nucleo.LinhaProducao_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosLinhaProducao extends OperadorObjetosAbstratoSAFC implements SIALinhaProducao,SPOLinhaProducao {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"linhaProducao/detalhe.html");
	
	
	
	
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCodigoLinha = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaNomeLinhaProducao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCapacidadeLinha = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoCodigoLinha = new CampoFormularioIntSAFC(this, "Codigo da Linha                                                                                                                                                                                         ",CampoDeFormulario.TIPO_TEXTO){
		public boolean isBloqueado() {
			return true;
		}
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				LinhaProducao_IN objNeg =  (LinhaProducao_IN) objetoNegocio;
				setValor(objNeg.getCodigoLinha());
		};
	};
	private CampoFormularioSAFC campoNomeLinhaProducao = new CampoFormularioSAFC(this, "Nome da Linha de Produção                                                                                                                                                                               ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				LinhaProducao_IN objNeg =  (LinhaProducao_IN) objetoNegocio;
				setValor(objNeg.getNomeLinhaProducao());
		};
	};
	private CampoFormularioIntSAFC campoCapacidadeLinha = new CampoFormularioIntSAFC(this, "Capacidade de Linha                                                                                                                                                                                     ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				LinhaProducao_IN objNeg =  (LinhaProducao_IN) objetoNegocio;
				setValor(objNeg.getCapacidadeLinha());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoCodigoLinha
		,
		campoNomeLinhaProducao
		,
		campoCapacidadeLinha
	};
	
	
	
	public OperadorObjetosLinhaProducao(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoLinhaProducao(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getLinhaProducaos(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "LinhaProducao";
	}
	
	
	
	
	
	
	public CampoFormularioIntSAFC getCampoCodigoLinha(){
		     return this.campoCodigoLinha;
	}
	public int getCodigoLinha(){ return getCampoCodigoLinha().getInt();}
	
	public CampoFormularioSAFC getCampoNomeLinhaProducao(){
		return this.campoNomeLinhaProducao;
	}
	public String getNomeLinhaProducao(){ return (String)getCampoNomeLinhaProducao().getObjetoValor();}
	
	public CampoFormularioIntSAFC getCampoCapacidadeLinha(){
		     return this.campoCapacidadeLinha;
	}
	public int getCapacidadeLinha(){ return getCampoCapacidadeLinha().getInt();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCodigoLinha(){
		return this.campoPesquisaCodigoLinha;
	}
	public String getCodigoLinhaPesquisa(){
		return this.getCampoPesquisaCodigoLinha().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaNomeLinhaProducao(){
		return this.campoPesquisaNomeLinhaProducao;
	}
	public String getNomeLinhaProducaoPesquisa(){
		return this.getCampoPesquisaNomeLinhaProducao().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCapacidadeLinha(){
		return this.campoPesquisaCapacidadeLinha;
	}
	public String getCapacidadeLinhaPesquisa(){
		return this.getCampoPesquisaCapacidadeLinha().getValorString();
	}
	
	
	
}
