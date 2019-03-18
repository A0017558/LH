package br.com.sAFc.gui.oo; 


import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoFormularioIntSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.campos.CampoSelecionaObjetoSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIAProduto;
import br.com.sAFc.interfaces.gui.SPOProduto;
import br.com.sAFc.interfaces.nucleo.Curva_IN;
import br.com.sAFc.interfaces.nucleo.Destinacao_IN;
import br.com.sAFc.interfaces.nucleo.LinhaProducao_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;
import formularios.CampoDeFormulario;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;


public  class OperadorObjetosProduto extends OperadorObjetosAbstratoSAFC implements SIAProduto,SPOProduto {
	
	
	private HTML_SAFC  htmlDetalhe =  new HTML_SAFC(this,"produto/detalhe.html");
	
	
	private CampoSelecionaObjetoSAFC campoSelecionaUnidadeMedidaPesquisa = new CampoSelecionaObjetoSAFC(this, "Unidade de Medida                                                                                                                                                                                       "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getUnidadeMedidas(null);
		}
	};
	private CampoSelecionaObjetoSAFC campoSelecionaLinhaProducaoPesquisa = new CampoSelecionaObjetoSAFC(this, "Linha de Produção                                                                                                                                                                                       "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getLinhaProducaos(null);
		}
	};
	private CampoSelecionaObjetoSAFC campoSelecionaDestinoPesquisa = new CampoSelecionaObjetoSAFC(this, "Destino                                                                                                                                                                                                 "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getDestinacaos(null);
		}
	};
	private CampoSelecionaObjetoSAFC campoSelecionaCurvaPesquisa = new CampoSelecionaObjetoSAFC(this, "Curva                                                                                                                                                                                                   "){
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getCurvas(null);
		}
	};
	
	
	// Campo de Relacionamento com objeto:UnidadeMedida
	private CampoSelecionaObjetoSAFC campoSelecionaUnidadeMedida = new CampoSelecionaObjetoSAFC(this, "Unidade de Medida                                                                                                                                                                                       "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			Produto_IN objNeg =  (Produto_IN) objetoNegocio;
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
	// Campo de Relacionamento com objeto:LinhaProducao
	private CampoSelecionaObjetoSAFC campoSelecionaLinhaProducao = new CampoSelecionaObjetoSAFC(this, "Linha de Produção                                                                                                                                                                                       "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			Produto_IN objNeg =  (Produto_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getLinhaProducao();
			if(objRel!=null){
				setValor(objRel.getCodigoIdentificadorLista());
			}
			else{
				setNull();
			}
		}
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getLinhaProducaos(null);
		}
	};
	// Campo de Relacionamento com objeto:Destinacao
	private CampoSelecionaObjetoSAFC campoSelecionaDestino = new CampoSelecionaObjetoSAFC(this, "Destino                                                                                                                                                                                                 "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			Produto_IN objNeg =  (Produto_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getDestino();
			if(objRel!=null){
				setValor(objRel.getCodigoIdentificadorLista());
			}
			else{
				setNull();
			}
		}
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getDestinacaos(null);
		}
	};
	// Campo de Relacionamento com objeto:Curva
	private CampoSelecionaObjetoSAFC campoSelecionaCurva = new CampoSelecionaObjetoSAFC(this, "Curva                                                                                                                                                                                                   "){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
			Produto_IN objNeg =  (Produto_IN) objetoNegocio;
			ObjetoNegocio objRel = objNeg.getCurva();
			if(objRel!=null){
				setValor(objRel.getCodigoIdentificadorLista());
			}
			else{
				setNull();
			}
		}
		public ObjetoNegocio[] getObjetosDominio(){
			return getNucleoSAFC().getCurvas(null);
		}
	};
	
	
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaCodigoProduto = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaNomeProduto = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaLotePadrao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaApresentacao = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaFatorAjusteProdutividade = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaValorParaVenda = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	// Campo de pesquisa de objeto.
	private CampoFormularioSAFC campoPesquisaPoliticaEstoque = new CampoFormularioSAFC(this, null,CampoDeFormulario.TIPO_TEXTO);
	
	
	private CampoFormularioIntSAFC campoCodigoProduto = new CampoFormularioIntSAFC(this, "Codigo do Produto                                                                                                                                                                                       ",CampoDeFormulario.TIPO_TEXTO){
		public boolean isBloqueado() {
			return true;
		}
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Produto_IN objNeg =  (Produto_IN) objetoNegocio;
				setValor(objNeg.getCodigoProduto());
		};
	};
	private CampoFormularioSAFC campoNomeProduto = new CampoFormularioSAFC(this, "Nome do Produto                                                                                                                                                                                         ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Produto_IN objNeg =  (Produto_IN) objetoNegocio;
				setValor(objNeg.getNomeProduto());
		};
	};
	private CampoFormularioIntSAFC campoLotePadrao = new CampoFormularioIntSAFC(this, "Lote Padrão                                                                                                                                                                                             ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Produto_IN objNeg =  (Produto_IN) objetoNegocio;
				setValor(objNeg.getLotePadrao());
		};
	};
	private CampoFormularioSAFC campoApresentacao = new CampoFormularioSAFC(this, "Apresentação                                                                                                                                                                                            ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Produto_IN objNeg =  (Produto_IN) objetoNegocio;
				setValor(objNeg.getApresentacao());
		};
	};
	private CampoFormularioIntSAFC campoFatorAjusteProdutividade = new CampoFormularioIntSAFC(this, "Fator de Ajuste de Produtividade                                                                                                                                                                        ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Produto_IN objNeg =  (Produto_IN) objetoNegocio;
				setValor(objNeg.getFatorAjusteProdutividade());
		};
	};
	private CampoFormularioIntSAFC campoValorParaVenda = new CampoFormularioIntSAFC(this, "Valor para Venda                                                                                                                                                                                        ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Produto_IN objNeg =  (Produto_IN) objetoNegocio;
				setValor(objNeg.getValorParaVenda());
		};
	};
	private CampoFormularioIntSAFC campoPoliticaEstoque = new CampoFormularioIntSAFC(this, "Politica de Estoque                                                                                                                                                                                     ",CampoDeFormulario.TIPO_TEXTO){
		public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
				Produto_IN objNeg =  (Produto_IN) objetoNegocio;
				setValor(objNeg.getPoliticaEstoque());
		};
	};
	
	
	private CampoDeFormulario campos[] =  new CampoDeFormulario[]{
		campoCodigoProduto
		,
		campoNomeProduto
		,
		campoLotePadrao
		,
		campoApresentacao
		,
		campoFatorAjusteProdutividade
		,
		campoValorParaVenda
		,
		campoPoliticaEstoque
		,
		campoSelecionaUnidadeMedida
		,
		campoSelecionaLinhaProducao
		,
		campoSelecionaDestino
		,
		campoSelecionaCurva
	};
	
	
	
	public OperadorObjetosProduto(FormularioAbstratoSAFC formularioAbstrato){
		super(formularioAbstrato);
	}
	
	
	public CampoDeFormulario[] getListaCamposNegocio(){
		return campos;
	}
	
	public CampoDeFormulario[] getCamposListagemObjeto(){
		return campos;
	}
	
	public boolean criarNovoObjeto(){
		return getNucleoSAFC().criarNovoProduto(this)!=null;
	}
	
	
	public ObjetoItemLista[] getListaObjetos() {
		return getNucleoSAFC().getProdutos(this);
	}
	
	public HTML getHTMLDetalhe() {
		return this.htmlDetalhe;
	}
	
	public String getTitulo() {
		return "Produto";
	}
	
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaUnidadeMedida(){
		return  campoSelecionaUnidadeMedida;
	}
	public UnidadeMedida_IN getUnidadeMedida(){
		return (UnidadeMedida_IN) getCampoSelecionaUnidadeMedida().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaLinhaProducao(){
		return  campoSelecionaLinhaProducao;
	}
	public LinhaProducao_IN getLinhaProducao(){
		return (LinhaProducao_IN) getCampoSelecionaLinhaProducao().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaDestino(){
		return  campoSelecionaDestino;
	}
	public Destinacao_IN getDestino(){
		return (Destinacao_IN) getCampoSelecionaDestino().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaCurva(){
		return  campoSelecionaCurva;
	}
	public Curva_IN getCurva(){
		return (Curva_IN) getCampoSelecionaCurva().getObjetoSelecionado();
	}
	
	
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaUnidadeMedidaPesquisa(){
		return  campoSelecionaUnidadeMedidaPesquisa;
	}
	public UnidadeMedida_IN getUnidadeMedidaPesquisa(){
		return (UnidadeMedida_IN) getCampoSelecionaUnidadeMedidaPesquisa().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaLinhaProducaoPesquisa(){
		return  campoSelecionaLinhaProducaoPesquisa;
	}
	public LinhaProducao_IN getLinhaProducaoPesquisa(){
		return (LinhaProducao_IN) getCampoSelecionaLinhaProducaoPesquisa().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaDestinoPesquisa(){
		return  campoSelecionaDestinoPesquisa;
	}
	public Destinacao_IN getDestinoPesquisa(){
		return (Destinacao_IN) getCampoSelecionaDestinoPesquisa().getObjetoSelecionado();
	}
	
	public CampoSelecionaObjetoSAFC getCampoSelecionaCurvaPesquisa(){
		return  campoSelecionaCurvaPesquisa;
	}
	public Curva_IN getCurvaPesquisa(){
		return (Curva_IN) getCampoSelecionaCurvaPesquisa().getObjetoSelecionado();
	}
	
	
	
	public CampoFormularioIntSAFC getCampoCodigoProduto(){
		     return this.campoCodigoProduto;
	}
	public int getCodigoProduto(){ return getCampoCodigoProduto().getInt();}
	
	public CampoFormularioSAFC getCampoNomeProduto(){
		return this.campoNomeProduto;
	}
	public String getNomeProduto(){ return (String)getCampoNomeProduto().getObjetoValor();}
	
	public CampoFormularioIntSAFC getCampoLotePadrao(){
		     return this.campoLotePadrao;
	}
	public int getLotePadrao(){ return getCampoLotePadrao().getInt();}
	
	public CampoFormularioSAFC getCampoApresentacao(){
		return this.campoApresentacao;
	}
	public String getApresentacao(){ return (String)getCampoApresentacao().getObjetoValor();}
	
	public CampoFormularioIntSAFC getCampoFatorAjusteProdutividade(){
		     return this.campoFatorAjusteProdutividade;
	}
	public int getFatorAjusteProdutividade(){ return getCampoFatorAjusteProdutividade().getInt();}
	
	public CampoFormularioIntSAFC getCampoValorParaVenda(){
		     return this.campoValorParaVenda;
	}
	public int getValorParaVenda(){ return getCampoValorParaVenda().getInt();}
	
	public CampoFormularioIntSAFC getCampoPoliticaEstoque(){
		     return this.campoPoliticaEstoque;
	}
	public int getPoliticaEstoque(){ return getCampoPoliticaEstoque().getInt();}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaCodigoProduto(){
		return this.campoPesquisaCodigoProduto;
	}
	public String getCodigoProdutoPesquisa(){
		return this.getCampoPesquisaCodigoProduto().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaNomeProduto(){
		return this.campoPesquisaNomeProduto;
	}
	public String getNomeProdutoPesquisa(){
		return this.getCampoPesquisaNomeProduto().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaLotePadrao(){
		return this.campoPesquisaLotePadrao;
	}
	public String getLotePadraoPesquisa(){
		return this.getCampoPesquisaLotePadrao().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaApresentacao(){
		return this.campoPesquisaApresentacao;
	}
	public String getApresentacaoPesquisa(){
		return this.getCampoPesquisaApresentacao().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaFatorAjusteProdutividade(){
		return this.campoPesquisaFatorAjusteProdutividade;
	}
	public String getFatorAjusteProdutividadePesquisa(){
		return this.getCampoPesquisaFatorAjusteProdutividade().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaValorParaVenda(){
		return this.campoPesquisaValorParaVenda;
	}
	public String getValorParaVendaPesquisa(){
		return this.getCampoPesquisaValorParaVenda().getValorString();
	}
	
	// Método de acesso à campo de pesquisa de objeto.
	public CampoFormularioSAFC getCampoPesquisaPoliticaEstoque(){
		return this.campoPesquisaPoliticaEstoque;
	}
	public String getPoliticaEstoquePesquisa(){
		return this.getCampoPesquisaPoliticaEstoque().getValorString();
	}
	
	
	
}
