package br.com.sAFc.gui.base;


import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.hsqldb.persist.Log;

import util.HashTableControlavel;
import util.StringManager;
import acopladorcamadas.GerenciadorCamadasTHTML;
import br.com.sAFc.interfaces.gui.UsuarioSAFC;
import br.com.sAFc.interfaces.nucleo.NucleoSAFC;
import br.com.sAFc.interfaces.nucleo.Usuario_IN;
import br.com.sAFc.nucleo.NucleoEstendidoSAFC;
import formularios.Area;
import formularios.DecodificadorComandos;
import formularios.ElementoPaginaHTML;
import formularios.FormularioAbstrato;
import formularios.HTML;
import formularios.PoolDecodificadores;

public class DecodificadorSAFC extends DecodificadorComandos {

	
	private boolean desligarAplicacao = false;
	private UsuarioSAFC usuarioSAFC =  new UsuarioWebSAFC();
	private Usuario_IN usuarioLogado = null;
	public UsuarioSAFC getUsuarioSAFC() {
		return usuarioSAFC;
	}

	private static Hashtable<String, String> tabelaFormulariosConteudo = new Hashtable<String, String>();
	private static Hashtable<String, String> tabelaFormulariosMenuLLateral = new Hashtable<String, String>();
	
	public static final String FORMULARIO_SOBRE = "sobre";
	public static final String FORMULARIO_ABERTURA = "";
	public static final String FORMULARIO_TEMAS = "tema";
	public static final String FORMULARIO_ACERVO = "acervo";
	public static final String FORMULARIO_ESCOLA = "escola";
	public static final String FORMULARIO_ESPACO = "espaco";
	public static final String FORMULARIO_TEMPO = "tempo";
	public static final String FORMULARIO_DOCUMENTOS = "documento";
	public static final String FORMULARIO_PAGINAS = "pagina";
	public static final String FORMULARIO_ROTEIROS = "roteiro";
	public static final String FORMULARIO_BUSCA = "busca";
	public static final String FORMULARIO_LOGIN = "adm";
	public static final String FORMULARIO_TAGS = "tags";
	
	
	static{
		try {
			GerenciadorCamadasTHTML.getInstancia().setServico("loginterface.ConstrutorLogMensagens", Log.class.getName());			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {  
//			tabelaFormulariosConteudo.put(FORMULARIO_SOBRE, FormularioSobre.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_ABERTURA, FormularioPaginaAbertura.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_TEMAS, FormularioTema.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_ACERVO, FormularioAcervo.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_ESCOLA, FormularioNaEscola.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_DOCUMENTOS, FormularioDocumento.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_PAGINAS, FormularioPagina.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_ROTEIROS, FormularioRoteiro.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_LOGIN, FormularioLogin.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_BUSCA, FormularioBusca.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_ESPACO, FormularioMapa.class.getName());
//			tabelaFormulariosConteudo.put(FORMULARIO_TAGS, FormularioNuvemTags.class.getName());
//			
//			
//			tabelaFormulariosMenuLLateral.put(FORMULARIO_SOBRE, FormularioFiltroSobre.class.getName());
////			tabelaFormulariosMenuLLateral.put(FORMULARIO_ABERTURA, FormularioPaginaAbertura.class.getName());
//			tabelaFormulariosMenuLLateral.put(FORMULARIO_TEMAS, FormularioFiltroTema.class.getName());
//			tabelaFormulariosMenuLLateral.put(FORMULARIO_ACERVO, FormularioFiltroAcervo.class.getName());
//			tabelaFormulariosMenuLLateral.put(FORMULARIO_ESCOLA, FormularioFiltroAtividades.class.getName());
////			tabelaFormulariosMenuLLateral.put(FORMULARIO_ATIVIDADES, FormularioAtividade.class.getName());
//			tabelaFormulariosMenuLLateral.put(FORMULARIO_ROTEIROS, FormularioFiltroRoteiros.class.getName());
////			tabelaFormulariosMenuLLateral.put(FORMULARIO_DOCUMENTOS, FormularioDocumento.class.getName());
////			tabelaFormulariosMenuLLateral.put(FORMULARIO_PAGINAS, FormularioPagina.class.getName());
//			
			
		} catch (Throwable e) {
			e.printStackTrace();  
		}
	}
	
	@Override
	public FormularioAbstrato decodificarComandos(ServletRequest request)
			throws Exception {
	
		return super.decodificarComandos(request);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3217824311786501141L;
	private NucleoSAFC nucleoSAFC = new NucleoEstendidoSAFC();
	private String codigoSequencialComando = null;
	//private String url = null;
	private HttpServletRequest request = null;
	private boolean admMode = false; 
//	private FormularioAbstrato formSubmenu = null;
	private HashTableControlavel formularioPorPosicao = new HashTableControlavel();
	
	
	private HTML_SAFC htmlAreaPrincipal = new HTML_SAFC(){
		public String getNomeBaseArquivos() {
			return "/html/";
		}		
		public boolean isFonteResourceAsStream() {
			return true;
		};
		public String getNomeArquivo() {
			return "principal.html";
		}
	};
	private Area areaPrincipal =  new Area("principal"){
		public HTML getHtml() {
			return htmlAreaPrincipal;
		}
		public ElementoPaginaHTML getElemento(String posicao) {
			return getFormulario(getFormularioAtivo(posicao));
		}
		public synchronized String getCodigoHTML(String parms) {
			String s =  super.getCodigoHTML(parms);
			String rs [] =((UsuarioWebSAFC)getUsuarioSAFC()).getMensagens();
			if(rs!=null && rs.length>0){
				StringBuffer sb =  new StringBuffer();
				sb.append("<SCRIPT>\n");
				sb.append("var msgs = new Array(); \n");
				for (int i = 0; i < rs.length; i++) {
					sb.append("  msgs ["+i+"] = '"); 
					rs[i] = StringManager.stringReplace("\n", rs[i], "\\n");
					rs[i] = StringManager.stringReplace("'", rs[i], "\\'");
					sb.append(rs[i]);
					sb.append("';\n"); 
				}
				sb.append("for(var i =0;i<msgs.length;i++)alert(msgs[i]);\n");
				sb.append("\n");
				sb.append("\n");
				sb.append("\n");
				sb.append("\n");
				sb.append("</SCRIPT>\n");
				return s+sb.toString();
			}
			return s;
		};
	};

	public Area getAreaPrincipal() {
		return areaPrincipal;
	}


	public DecodificadorSAFC() {
		super();
		try {
	//		setFormularioAtivo(FormularioAbertura.class);			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getNomeComando() {
		return "EX";
	}

	@Override
	public String getURLDestinoSessaoEncerrada() {
		return "www.uol.com.br";
	}


	@Override
	public String getCodigoSequencialComando() {
		if(codigoSequencialComando==null){
			this.codigoSequencialComando = super.getCodigoSequencialComando(); 
		}
		return codigoSequencialComando;
	}

	public NucleoSAFC getNucleoSAFC() {
		return nucleoSAFC;
	}

	public boolean isHabilitadoControleThread() {
		return false;
	}

	/*
	@Override
	public FormularioAbstrato getFormulario(String nomeFormulario) {
		if(nomeFormulario !=null && nomeFormulario.equals("mdl")){
			nomeFormulario = FormularioModulos.class.getName();
		} 
		FormularioAbstrato  f = super.getFormulario(nomeFormulario);
		return f;
	}
	*/

	@Override
	public FormularioAbstrato decodificarComandos(HttpServletRequest request)	throws Exception {
		//this.url = request.getParameter("l");
		this.request = request;
		String adm = request.getParameter("adm");
		String server = request.getParameter("server");
		if(adm!=null){
			if(adm.equalsIgnoreCase("on")){
				this.admMode = true;
			}
			if(adm.equalsIgnoreCase("off")){
				this.admMode = false;
				PoolDecodificadores.removerDecodificador(this);
				if(this.usuarioLogado!=null){
					PoolUsuariosLogados.removeUsuario(getCodigoSequencialComando());
				}
				this.usuarioLogado = null; 
			} 
		}
		if(server!=null){
			if(server.equalsIgnoreCase("off")){
				this.desligarAplicacao = true;
			}
		}
		return super.decodificarComandos(request);
		
	}	

	
//	@Override
//	public FormularioAbstrato getFormulario(String nomeFormulario) {
//		try {
//			if(admMode==true){
//				FormularioAbstratoSAFC f =  (FormularioAbstratoSAFC) super.getFormulario(nomeFormulario);
//				return f;
//			}
//		} catch (Exception e) {}
//		
//		if (nomeFormulario==null) {
//			return null;  
//		}
//		String traducao = tabelaFormulariosConteudo.get(nomeFormulario); 
//		if(traducao!=null){
//			nomeFormulario = traducao;
//		}
//		if(admMode==false &&
//				traducao==null && 
//				getSecaoAtiva()==null ){
//			nomeFormulario =  FormularioAbertura.class.getName();
//		}
//		return super.getFormulario(nomeFormulario);
//	}
//	
//	@Override
//	public void setFormularioAtivo(String nomeGrupo, String classe) {
//		FormularioAbstrato form = getFormulario(classe);		
//		super.setFormularioAtivo(nomeGrupo, form.getClass().getName());	
//		this.formularioPorPosicao.put(nomeGrupo, form);
//	}
//	
//	public FormularioAbstratoSAFC getFormularioAtivoPorArea(String nomeArea){
//		return  (FormularioAbstratoSAFC) this.formularioPorPosicao.get(nomeArea);
//	}
//	
//	@Override
//	public String getFormularioAtivo(String nomeGrupo) {
//		if(FormularioAbstratoSAFC.nomeGrupoMenu.equals(nomeGrupo)){
//			return FormularioMenuLH.class.getName();				
//		}
//		if(admMode && getUsuarioLogado()==null && FormularioAbstratoSAFC.nomeGrupoConteudo.equals(nomeGrupo)){
//			return FormularioLogin.class.getName();
//		}
//		String sa = getFormularioPorUrl();
//		if(sa!=null){
//			return sa;
//		}
//		sa = super.getFormularioAtivo(nomeGrupo); 
//	
//		if(sa==null){
//			sa = FormularioAbertura.class.getName();
//		}
//		return sa; 
//	}
//	
//	public FormularioAbstratoSAFC getFormularioAtivoPorUrl(){
//		return (FormularioAbstratoSAFC) getFormulario(getFormularioPorUrl());
//	}
//
//	public String getFormularioPorUrl(){
//		String secao =  getSecaoAtiva();//request.getParameter("secao");
//		if(secao!=null){
//			return DecodificadorSAFC.tabelaFormulariosConteudo.get(secao);
//		}
//		return null;
//	}
//	public String getFormularioMenuLateralPorUrl(){
//		String m =  request.getParameter("m");
//		if(m!=null){
//			return DecodificadorSAFC.tabelaFormulariosMenuLLateral.get(m);
//		}
//		String secao =  request.getParameter("secao");
//		if(secao!=null){
//			return DecodificadorSAFC.tabelaFormulariosMenuLLateral.get(secao);
//		}
//		return null;
//	}
//	
//	public String getSecaoAtiva(){
//		return request.getParameter("secao");
//	}
//	
//	public String getCodigoTemaAtivo(){
//		return request.getParameter("tm");
//	}
//	
//	public Tema_IN getTemaAtivo(){
//		String cdTema = getCodigoTemaAtivo();
//		if(cdTema==null){
//			return null;
//		}
//		return Tema.getTema_INPorIdentficador(cdTema);
//	}
//	
//	private  int getValorIdObj(String valor){
//		int posBarra = valor.indexOf("_");
//		if(posBarra>0){
//			valor = valor.substring(0, posBarra);
//		}
//		return Integer.parseInt(valor);
//	}
//	
//	
//	private String getValorIdObjUrl(String url){
//		int posBarra = url.indexOf("/");
//		if(posBarra>0){
//			int posEspaco = url.indexOf("-",posBarra);
//			int posFimValor = posEspaco;
//			if(posEspaco<0){
//				posFimValor = url.length();
//			}
//			return url.substring(posBarra+1, posFimValor);
//		}
//		return null;
//	}
//	
//	public String getIdObjeto(){
//		return request.getParameter("i");
//	}
//	
	public String getParameter(String p){
		return request.getParameter(p);
	}

	
	public Usuario_IN getUsuario(){
		return PoolUsuariosLogados.getUsuario(getCodigoSequencialComando());
	}

//	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException  {
//		DecodificadorSAFC dec=  (DecodificadorSAFC) PoolDecodificadores.getDedodificador(DecodificadorSAFC.class.getName(), "SAFC");// new DecodificadorSAFC();
//		FormularioAbstratoSAFC f = dec.getFormularioAtivoPorArea(FormularioAbstratoSAFC.nomeGrupoConteudo);
//		System.out.println(f.getCodigoHTML(null));
//	}

	public HttpServletRequest getRequest() {
		return request;
	}
	public String getParmsExceto(String parmExceto){
		Enumeration<String> nmParms = getRequest().getParameterNames();
		StringBuffer sb = new StringBuffer();
		while(nmParms.hasMoreElements()){
			String nm = nmParms.nextElement();
			if(nm.equals(parmExceto)){
				continue;
			}
			if(sb.length()>0){
				sb.append("&");
			}else{
				sb.append("?");
			}
			sb.append(nm);
			sb.append("=");
			sb.append(getRequest().getParameter(nm));
		}
		return sb.toString(); 
	}
	
	public Usuario_IN getUsuarioLogado() {
		return usuarioLogado;
	}


	public void setUsuarioLogado(Usuario_IN usuarioLogado) {
		PoolUsuariosLogados.setUsuario(getCodigoSequencialComando(), usuarioLogado);
		this.admMode = usuarioLogado!=null;		
		this.usuarioLogado = usuarioLogado;
	}
	
	public boolean isDesligarAplicacao() {
		return desligarAplicacao;
	}
	
	
	
}
