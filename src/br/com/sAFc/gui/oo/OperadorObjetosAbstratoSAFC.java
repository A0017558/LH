package br.com.sAFc.gui.oo;

import aplicacao.OperadorObjetosAbstratoGerador;
import br.com.sAFc.gui.base.DecodificadorSAFC;
import br.com.sAFc.gui.base.HTML_SAFC;
import br.com.sAFc.gui.campos.CampoBotaoSubmitSAFC;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import br.com.sAFc.gui.campos.CampoSelecionaPaginaSAFC;
import br.com.sAFc.gui.campos.CampoTabelaSelecionaObjetosSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SolicitacaoGenericaSAFC;
import br.com.sAFc.interfaces.gui.UsuarioSAFC;
import br.com.sAFc.interfaces.nucleo.NucleoSAFC;
import formularios.CampoSelecaoPagina;
import formularios.CampoSelecionaObjeto;
import formularios.FormularioAbstrato;
import formularios.HTML;
import formularios.ObjetoItemLista;
import formularios.OperadorObjetos;

public abstract class OperadorObjetosAbstratoSAFC<TipoObj extends ObjetoItemLista> extends OperadorObjetosAbstratoGerador implements SolicitacaoGenericaSAFC {

	
	private HTML_SAFC htmlLista =  new HTML_SAFC(this,"lista.html");
	private TipoObj objetoParaDetalhamento = null;
	
	private CampoBotaoSubmitSAFC botaoAbrirObjetoHidden = new CampoBotaoSubmitSAFC(getFormulario(), ""){
		public String getCodigo() {
			return "<input tyoe='hidden' name='"+getNome()+"' id='"+getNome()+"' >";
		};
		public boolean isBloqueado() {
			return true;
		};
		public boolean exec() {
			executarComandoExecBotaoAbrirObjetoHidden();
			return false;
		};
	}; 
	
	public OperadorObjetosAbstratoSAFC(FormularioAbstrato formularioAbstrato,
			OperadorObjetos operadorObjetosSubordinante) {
		super(formularioAbstrato, operadorObjetosSubordinante);
	}


	public OperadorObjetosAbstratoSAFC() {
		super();
	}
	
	private CampoFormularioSAFC campoNomeLinkObjeto = new CampoFormularioSAFC(this, "", CampoFormularioSAFC.TIPO_TEXTO){
		public void setObjetoNegocio(formularios.ObjetoNegocio objetoNegocio) {
			setValor(objetoNegocio.getTituloLista());
		};
	};

	
	
	public void executarComandoExecBotaoAbrirObjetoHidden(){
		
		getCampoBotaoAlterar().exec();
	}
	

	public OperadorObjetosAbstratoSAFC(FormularioAbstrato formularioAbstrato) {
		super(formularioAbstrato);
	}

	public NucleoSAFC getNucleoSAFC(){
		return getFormularioAbstratoSAFC().getNucleoSAFC();
	}
	
	public FormularioAbstratoSAFC getFormularioAbstratoSAFC(){
		return  (FormularioAbstratoSAFC) getFormulario();
	}
	
	public DecodificadorSAFC getDecodificadorSAFC(){
		return getFormularioAbstratoSAFC().getDecodificadorSAFC();
	}
	
	@Override
	public HTML getHTMLLista() {
		return htmlLista;
	}
	
	@Override
	public CampoSelecionaObjeto getInstanciaCampoSelecionaObjeto() {
		return new CampoTabelaSelecionaObjetosSAFC(this){
			@Override
			public boolean isBloqueado() {
				return isEdicaoBloqueada();
			}
		};
	}
	
	@Override
	public boolean isEdicaoBloqueada() {
//		if(isOperadorConsulta()){
//			return true;
//		}
//		Usuario_IN usu = getFormularioAbstratoSAFC().getDecodificadorSAFC().getUsuarioLogado();
//		return usu==null;
		return false;
	}
	
	public boolean isOperadorConsulta(){
		return false;
	}
	
	public CampoFormularioSAFC getCampoNomeLinkObjeto() {
		return campoNomeLinkObjeto;
	}
	
	


	
	public TipoObj getObjetoPorLink(){
		return null;
	}
	
	@Override
	public TipoObj getObjetoEmEdicao(){
		if(isOperadorConsulta()){
			return getObjetoPorLink();
		}
		ObjetoItemLista obj = super.getObjetoEmEdicao();
		TipoObj objDet = getObjetoParaDetalhamento();
		if(objDet!=null){
			return objDet;
		}
		return (TipoObj) obj;
	}
	
	
	
	public TipoObj getObjetoParaDetalhamento() {
		return objetoParaDetalhamento;
	}

	public void setObjetoParaDetalhamento(TipoObj objetoParaDetalhamento) {
		this.objetoParaDetalhamento = objetoParaDetalhamento;
	}
	@Override
	public boolean isPaginacaoHabilidata() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public int getNumeroPreferencialObjetosPorPagina() {
		// TODO Auto-generated method stub
		return 12;
	}
	
	@Override
	public CampoSelecaoPagina getInstanciaCampoSelecaoPagina() {		
		return new CampoSelecionaPaginaSAFC(this);
	}
	@Override
	public boolean isHabilitado() {
		OperadorObjetos opSubordinante =  getOperadorObjetosSubordinante();
		if(opSubordinante==null){
			return super.isHabilitado();
		}
		boolean  modoOpVis  = opSubordinante.getModoOperacao()==MODO_VISUALIZACAO; 
		if(!modoOpVis){
			this.setModoOperacao(MODO_LISTAGEM);
		}
		Object objSubr =  opSubordinante.getObjetoEmEdicao();
		if(objSubr==null){ 
			return false;
		}
		return modoOpVis;
	}
	public CampoBotaoSubmitSAFC getBotaoAbrirObjetoHidden() {
		return botaoAbrirObjetoHidden;
	}
	
	public boolean isModoInclusao(){
		return getModoOperacao()==MODO_INCLUSAO;
	}
	public boolean isModoAlteracao(){
		return getModoOperacao()==MODO_ALTERACAO;
	}
	public boolean isModoListagem(){
		return getModoOperacao()==MODO_LISTAGEM;
	}
	public boolean isModoVisualizacao(){
		return getModoOperacao()==MODO_VISUALIZACAO;
	}
	
	@Override
	public UsuarioSAFC getUsuarioSAFC() {
		return getFormularioAbstratoSAFC().getDecodificadorSAFC().getUsuarioSAFC();
	}

	
}
