package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.campos.CampoSelecionaObjetoSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIAInsumo;
import br.com.sAFc.interfaces.gui.SPOInsumo;
import br.com.sAFc.interfaces.nucleo.CanalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.ModalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.TipoInsumo_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosInsumo extends OperadorObjetosAbstratoSAFC implements SIAInsumo,SPOInsumo {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"insumo/detalhe.html");
	
	
	private CampoSelecionaObjetoSAFC campoSelecionaUnidadeMedidaPesquisa = new CampoSelecionaObjetoSAFC(this, "Unidade de Medida                                                                                                                                                                                       "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getUnidadeMedidas(null);
		}
	};
	private CampoSelecionaObjetoSAFC campoSelecionaTipoInsumoPesquisa = new CampoSelecionaObjetoSAFC(this, "Tipo de Insumo                                                                                                                                                                                          "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getTipoInsumos(null);
		}
	};
	private CampoSelecionaObjetoSAFC campoSelecionaModalAquisicaoPesquisa = new CampoSelecionaObjetoSAFC(this, "Modal de Aquisicao                                                                                                                                                                                      "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getModalAquisicaos(null);
		}
	};
	private CampoSelecionaObjetoSAFC campoSelecionaCanalAquisicaoPesquisa = new CampoSelecionaObjetoSAFC(this, "Canal de Aquisição                                                                                                                                                                                      "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getCanalAquisicaos(null);
		}
	};
	
	
	// Campo de Relacionamento com objeto:UnidadeMedida
	private CampoSelecionaObjetoSAFC campoSelecionaUnidadeMedida = new CampoSelecionaObjetoSAFC(this, "Unidade de Medida                                                                                                                                                                                       "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getUnidadeMedida();
			if(objRel!=null){
				setValor(objRel.getCodigoIdentificadorLista());
			}
			else{
				setNull();
			}
		}
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getUnidadeMedidas(null);
		}
	};
	// Campo de Relacionamento com objeto:TipoInsumo
	private CampoSelecionaObjetoSAFC campoSelecionaTipoInsumo = new CampoSelecionaObjetoSAFC(this, "Tipo de Insumo                                                                                                                                                                                          "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getTipoInsumo();
			if(objRel!=null){
				setValor(objRel.getCodigoIdentificadorLista());
			}
			else{
				setNull();
			}
		}
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getTipoInsumos(null);
		}
	};
	// Campo de Relacionamento com objeto:ModalAquisicao
	private CampoSelecionaObjetoSAFC campoSelecionaModalAquisicao = new CampoSelecionaObjetoSAFC(this, "Modal de Aquisicao                                                                                                                                                                                      "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getModalAquisicao();
			if(objRel!=null){
				setValor(objRel.getCodigoIdentificadorLista());
			}
			else{
				setNull();
			}
		}
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getModalAquisicaos(null);
		}
	};
	// Campo de Relacionamento com objeto:CanalAquisicao
	private CampoSelecionaObjetoSAFC campoSelecionaCanalAquisicao = new CampoSelecionaObjetoSAFC(this, "Canal de Aquisição                                                                                                                                                                                      "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getCanalAquisicao();
			if(objRel!=null){
				setValor(objRel.getCodigoIdentificadorLista());
			}
			else{
				setNull();
			}
		}
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getCanalAquisicaos(null);
		}
	};
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCodigoInsumo = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaNomeInsumo = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaTempoParaAquisicao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaTempoLiberacao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCompraMinima = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaUnidadeCompra = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaValorParaAquisicao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoCodigoInsumo = new CampoFormularioIntSAFC(this, "Codigo do Insumo                                                                                                                                                                                        ",CampoDeFormulario.TIPO_TEXTO){
		public boolean isBloqueado() {
			return true;
		}
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
				setValor(objNeg.getCodigoInsumo());
		};
	};
	private CampoFormularioSAFC campoNomeInsumo = new CampoFormularioSAFC(this, "Nome do Insumo                                                                                                                                                                                          ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
				setValor(objNeg.getNomeInsumo());
		};
	};
	private CampoFormularioIntSAFC campoTempoParaAquisicao = new CampoFormularioIntSAFC(this, "Tempo para Aquisição                                                                                                                                                                                    ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
				setValor(objNeg.getTempoParaAquisicao());
		};
	};
	private CampoFormularioIntSAFC campoTempoLiberacao = new CampoFormularioIntSAFC(this, "Tempo de Liberação                                                                                                                                                                                      ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
				setValor(objNeg.getTempoLiberacao());
		};
	};
	private CampoFormularioIntSAFC campoCompraMinima = new CampoFormularioIntSAFC(this, "Compra Minima                                                                                                                                                                                           ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
				setValor(objNeg.getCompraMinima());
		};
	};
	private CampoFormularioIntSAFC campoUnidadeCompra = new CampoFormularioIntSAFC(this, "Unidade de Compra                                                                                                                                                                                       ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
				setValor(objNeg.getUnidadeCompra());
		};
	};
	private CampoFormularioIntSAFC campoValorParaAquisicao = new CampoFormularioIntSAFC(this, "Valor para Aquisição                                                                                                                                                                                    ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Insumo_IN objNeg =  (Insumo_IN) objetoNegocio;
				setValor(objNeg.getValorParaAquisicao());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoCodigoInsumo
		,
		campoNomeInsumo
		,
		campoTempoParaAquisicao
		,
		campoTempoLiberacao
		,
		campoCompraMinima
		,
		campoUnidadeCompra
		,
		campoValorParaAquisicao
		,
		campoSelecionaUnidadeMedida
		,
		campoSelecionaTipoInsumo
		,
		campoSelecionaModalAquisicao
		,
		campoSelecionaCanalAquisicao
	};
	
	
	
	public OperadorObjetosInsumo(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoInsumo(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getInsumos(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "Insumo";
	}
	
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaUnidadeMedida(){
		return  campoSelecionaUnidadeMedida;
	}
	public UnidadeMedida_IN getUnidadeMedida(){
		return (UnidadeMedida_IN) getCampoSelecionaUnidadeMedida().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaTipoInsumo(){
		return  campoSelecionaTipoInsumo;
	}
	public TipoInsumo_IN getTipoInsumo(){
		return (TipoInsumo_IN) getCampoSelecionaTipoInsumo().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaModalAquisicao(){
		return  campoSelecionaModalAquisicao;
	}
	public ModalAquisicao_IN getModalAquisicao(){
		return (ModalAquisicao_IN) getCampoSelecionaModalAquisicao().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaCanalAquisicao(){
		return  campoSelecionaCanalAquisicao;
	}
	public CanalAquisicao_IN getCanalAquisicao(){
		return (CanalAquisicao_IN) getCampoSelecionaCanalAquisicao().getObjetoSelecionado();
	}
	
	
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaUnidadeMedidaPesquisa(){
		return  campoSelecionaUnidadeMedidaPesquisa;
	}
	public UnidadeMedida_IN getUnidadeMedidaPesquisa(){
		return (UnidadeMedida_IN) getCampoSelecionaUnidadeMedidaPesquisa().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaTipoInsumoPesquisa(){
		return  campoSelecionaTipoInsumoPesquisa;
	}
	public TipoInsumo_IN getTipoInsumoPesquisa(){
		return (TipoInsumo_IN) getCampoSelecionaTipoInsumoPesquisa().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaModalAquisicaoPesquisa(){
		return  campoSelecionaModalAquisicaoPesquisa;
	}
	public ModalAquisicao_IN getModalAquisicaoPesquisa(){
		return (ModalAquisicao_IN) getCampoSelecionaModalAquisicaoPesquisa().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaCanalAquisicaoPesquisa(){
		return  campoSelecionaCanalAquisicaoPesquisa;
	}
	public CanalAquisicao_IN getCanalAquisicaoPesquisa(){
		return (CanalAquisicao_IN) getCampoSelecionaCanalAquisicaoPesquisa().getObjetoSelecionado();
	}
	
	
	
	public CampoFormularioIntSAFC getCampoCodigoInsumo(){
		     return this.campoCodigoInsumo;
	}
	public int getCodigoInsumo(){ return getCampoCodigoInsumo().getInt();}
	
	public CampoFormularioSAFC getCampoNomeInsumo(){
		return this.campoNomeInsumo;
	}
	public String getNomeInsumo(){ return (String)getCampoNomeInsumo().getObjetoValor();}
	
	public CampoFormularioIntSAFC getCampoTempoParaAquisicao(){
		     return this.campoTempoParaAquisicao;
	}
	public int getTempoParaAquisicao(){ return getCampoTempoParaAquisicao().getInt();}
	
	public CampoFormularioIntSAFC getCampoTempoLiberacao(){
		     return this.campoTempoLiberacao;
	}
	public int getTempoLiberacao(){ return getCampoTempoLiberacao().getInt();}
	
	public CampoFormularioIntSAFC getCampoCompraMinima(){
		     return this.campoCompraMinima;
	}
	public int getCompraMinima(){ return getCampoCompraMinima().getInt();}
	
	public CampoFormularioIntSAFC getCampoUnidadeCompra(){
		     return this.campoUnidadeCompra;
	}
	public int getUnidadeCompra(){ return getCampoUnidadeCompra().getInt();}
	
	public CampoFormularioIntSAFC getCampoValorParaAquisicao(){
		     return this.campoValorParaAquisicao;
	}
	public int getValorParaAquisicao(){ return getCampoValorParaAquisicao().getInt();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCodigoInsumo(){
		return this.campoPesquisaCodigoInsumo;
	}
	public String getCodigoInsumoPesquisa(){
		return this.getCampoPesquisaCodigoInsumo().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaNomeInsumo(){
		return this.campoPesquisaNomeInsumo;
	}
	public String getNomeInsumoPesquisa(){
		return this.getCampoPesquisaNomeInsumo().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaTempoParaAquisicao(){
		return this.campoPesquisaTempoParaAquisicao;
	}
	public String getTempoParaAquisicaoPesquisa(){
		return this.getCampoPesquisaTempoParaAquisicao().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaTempoLiberacao(){
		return this.campoPesquisaTempoLiberacao;
	}
	public String getTempoLiberacaoPesquisa(){
		return this.getCampoPesquisaTempoLiberacao().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCompraMinima(){
		return this.campoPesquisaCompraMinima;
	}
	public String getCompraMinimaPesquisa(){
		return this.getCampoPesquisaCompraMinima().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaUnidadeCompra(){
		return this.campoPesquisaUnidadeCompra;
	}
	public String getUnidadeCompraPesquisa(){
		return this.getCampoPesquisaUnidadeCompra().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaValorParaAquisicao(){
		return this.campoPesquisaValorParaAquisicao;
	}
	public String getValorParaAquisicaoPesquisa(){
		return this.getCampoPesquisaValorParaAquisicao().getValorString();
	}
	
	
	
}
