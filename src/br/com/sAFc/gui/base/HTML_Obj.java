package br.com.sAFc.gui.base;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;
import java.util.Vector;

import loginterface.LogMensagens;
import util.HashTableControlavel;
import util.StringManager;
import formularios.Area;
import formularios.ElementoPaginaHTML;
import formularios.HTML;

public class HTML_Obj extends HTML {

	private StringBuffer htmlFonte = null;
	private HashTableControlavel elementos = new HashTableControlavel();
	private Vector vetorElementos = new Vector();
	private boolean interpretado = false;
	private String nomeArquivo = null;
	private String nomeBaseArquivos = "/html/";
	
	
	public HTML_Obj(String nomeArquivo){
		super();
		this.nomeArquivo = nomeArquivo;
	}
	
	
	public HTML_Obj(){
		super();
		if(getHTML()==null)throw new NullPointerException("Erro");
	}
	

	public String getHTML(){
		return null;
	}
	public StringBuffer getFonteHTML(){
		if(this.htmlFonte!=null)return htmlFonte;
		String fhtml = getHTML();
		if(fhtml!=null){
			this.htmlFonte = new StringBuffer();
			this.htmlFonte.append(fhtml);
			return this.htmlFonte;
		}
		InputStream in = getInputFonte();
		StringBuffer sb = new StringBuffer();
		if(in!=null){
			byte [] bytes = new byte[1024];
			try {
				int nB = in.read(bytes);
				while (nB>0) {					
					String s = new String(bytes,0,nB,"ISO-8859-1"); //$NON-NLS-1$
					sb.append(s);
					nB = in.read(bytes);
				}
				in.close();
			} catch (Exception e) {
				try {in.close();} catch (Exception e2) {}
				throw new RuntimeException(e);
			}
		}else{
			LogMensagens.getLogMensagens().addMensagem("InputStream nulo "+getClass().getName()); //$NON-NLS-1$
		}
		//System.out.println(this.getClass()+"\n\n"+sb.toString()+"\n\n");
		return sb;
	}
	
	
	public InputStream getInputFonte() {
		if(isFonteResourceAsStream()){
			return getInputFonteResource();
		}
		try {
			InputStream in = new  java.io.FileInputStream(getNomeBaseArquivos()+getNomeArquivo());
			return in;
		} catch (Exception e) {
			LogMensagens.getLogMensagens().addMensagemErro("",e); //$NON-NLS-1$
		}		
		return null;
	}
	
	
	public InputStream getInputFonteResource() {
	    Class resourceClass = HTML.class;
	    String nmCaminho = getNomeBaseArquivos()+getNomeArquivo();
	    InputStream stream = resourceClass.getResourceAsStream(nmCaminho);
	    if(stream==null){
	    	throw new NullPointerException(nmCaminho+" não localizado.");
	    }
		return stream;
	}
	
	public boolean isFonteResourceAsStream(){
		return true;
	}
	
	public String getNomeArquivo(){
		return nomeArquivo;
	}	
	public String getNomeBaseArquivos(){
		return nomeBaseArquivos;
	}	
	
	
	private void interpretar(){
		this.htmlFonte = getFonteHTML();
		int posVar = 0;
		int ultimaPosInicio =-1;
		String strId = getStringId();		
		while(this.htmlFonte.indexOf(strId, posVar)>=0 ){
			int posId = this.htmlFonte.indexOf(getStringId(), posVar);
			if(posId>0 && this.htmlFonte.indexOf("-->", posId)>=0){ //$NON-NLS-1$
				int posFim = this.htmlFonte.indexOf("-->", posId); //$NON-NLS-1$
				int posInic = this.htmlFonte.substring(0,posId).lastIndexOf("<!--"); //$NON-NLS-1$
				if(posFim>0 && posInic>ultimaPosInicio){
					char charIgual = this.htmlFonte.charAt(posId+strId.length()); 
					if(charIgual=='='){
						char proxChar = this.htmlFonte.charAt(posId+strId.length()+1);
						if(proxChar=='\'' || proxChar=='"'){
							int posInicNome = posId+strId.length()+2;
							int posFimNome = this.htmlFonte.indexOf(new String(new char[]{proxChar}), posInicNome);
							if(posInicNome>0 && posFimNome>posInicNome){
								String nome = this.htmlFonte.substring(posInicNome,posFimNome);
								ultimaPosInicio = posInic;
								String conteudo = obterConteudo(this.htmlFonte.substring(posInic, posFim+3));
								String idCompleto = strId+"='"+nome+"'"; //$NON-NLS-1$ //$NON-NLS-2$
								conteudo = StringManager.stringReplace(idCompleto, conteudo, ""); //$NON-NLS-1$
								ElementoContido elemento = new ElementoContido(nome,posInic,posFim+3,conteudo);
								this.vetorElementos.add(elemento);
								posVar = posFim+1;
							}else{
								posVar=posFim+1;
							}
						}else{
							posVar=posFim+1;
						}
					}else{
						posVar=posFim+1;
					}
				}
			}else{
				break;
			}
		}
		this.interpretado = true;		
	}
	
	private String obterConteudo(String textoTag){
	//	System.out.println(textoTag);
		int posI = textoTag.indexOf("<!--")+4; //$NON-NLS-1$
		char proxChar = textoTag.charAt(posI);
		while(proxChar=='-' && posI<textoTag.length()){
			posI++;
			proxChar = textoTag.charAt(posI);
		}
		if(posI==textoTag.length()){
			return ""; //$NON-NLS-1$
		}
		int posF = textoTag.lastIndexOf("-->")-1; //$NON-NLS-1$
		char ultimoChar = textoTag.charAt(posF);
		while(posF>posI && ultimoChar=='-'){
			posF--;
			ultimoChar = textoTag.charAt(posF);
		}
		return textoTag.substring(posI, posF+1);
	}
	public String getStringId(){
		return " !id"; //$NON-NLS-1$
	}
	
	public void setElementoPaginaHTML(ElementoPaginaHTML elementoPaginaHTML,String posicao){
		this.elementos.put(posicao, elementoPaginaHTML);
	}
	public void setElementoPaginaHTML(ElementoPaginaHTML elementoPaginaHTML,String posicao,Area area){
		this.elementos.put(posicao, elementoPaginaHTML);
	}
	public ElementoPaginaHTML getElementoPaginaHTML(String posicao){
		return (ElementoPaginaHTML) this.elementos.get(posicao);
	}
	
	
	public synchronized String renderizar(Object elemento){
		if(!interpretado){	
			this.interpretar();
		}		
		StringBuffer htmlRenderizado = new StringBuffer();
		htmlRenderizado.append(this.htmlFonte);		
		for (int i = 0; i < this.vetorElementos.size() ; i++) {		
			ElementoContido e = (ElementoContido) this.vetorElementos.elementAt(i);	
			e.calcularValor(elemento);
		}
		for (int i = this.vetorElementos.size()-1; i >=0 ; i--) {
			ElementoContido e = (ElementoContido) this.vetorElementos.elementAt(i);
			e.render(htmlRenderizado);
		}
		return htmlRenderizado.toString();
	}
	

//	
//	public static void main(String[] args) {
//		final StringBuffer html = new StringBuffer();
//		html.append("teste V1:<!-- !id='v1' --> V3:<!-- !id='v3' --> V2:<!-- !id='v2' ok --> FIM");
//		HTML_Obj htTeste =  new HTML_Obj(""){
//			@Override
//			public StringBuffer getFonteHTML() {
//				return html;
//			}
//		};
//		ObsTeste objTeste =  new ObsTeste("A", "BB", "CCC");
//		System.out.println(htTeste.renderizar(objTeste));
//	}
	
	
	
	

	

}class ElementoContido{
	private String nome = null;
	private int posInicio = 0;
	private int posFim = 0;
	private String conteudo = null;
	private String  valor = null;
	private Method [] methods = null;
	
	public ElementoContido(String nome, int posInicio, int posFim,String conteudo) {
		super();
		this.nome = nome;
		this.posInicio = posInicio;
		this.posFim = posFim;
		this.conteudo = conteudo;
	}
	public ElementoContido getClone(){
		ElementoContido clone = new ElementoContido(nome,posInicio,posFim,conteudo);
		clone.valor = this.valor;
		return clone;
	}
	public String getNome() {
		return nome;
	}
	public int getPosInicio() {
		return posInicio;
	}
	public int getPosFim() {
		return posFim;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void calcularValor(ElementoPaginaHTML elementoPaginaHTML){		
		if(elementoPaginaHTML==null){
			this.valor=null;			
			return;
		}
		if(!elementoPaginaHTML.isHabilitado()){
			this.valor=""; //$NON-NLS-1$
		}else{
			elementoPaginaHTML.informaInicioExpansao();
			this.valor = elementoPaginaHTML.getCodigoHTML(conteudo);
		}
	}	
	public void calcularValor(Object objeto){		
		if(objeto==null){
			this.valor=null;			
			return;
		}
//		Method m = getMethod(objeto);
//		if(m==null){
//			this.valor="<!-- método "+getNomeMetodo()+" não localizado -->";
//			return;
//		}
//		Object r;
//		try {
//			r = m.invoke(objeto, new Object[0]);
//		} catch (IllegalAccessException | IllegalArgumentException
//				| InvocationTargetException e) {
//			r = e;
//		}
//		if(r==null){
//			r = "";  
//		}
		this.valor = invocarMetodo(objeto);// r.toString();
	}
	public String invocarMetodo(Object objeto){
		if(objeto==null){
			return "<!-- valor nulo para a propriedade:"+getNome()+" -->";
		}	
		Method [] metodos = getMethods(objeto);		
		for (int i = 0; i < metodos.length; i++) {
			Method method = metodos[i];
			try {
				if(method==null){
					return "<!-- método não localizado -->";
				}
				objeto = method.invoke(objeto, new Object[0]);
				if(objeto==null){
					return "<!-- valor nulo para o método:"+method.getName()+" -->";
				}				
			} catch (
					IllegalAccessException | 
					IllegalArgumentException | 
					InvocationTargetException e) {
				objeto = e;
			}catch (NullPointerException e) {
				return "<!-- método "+getNomeMetodo()+" não localizado em:"+objeto+" -->";
			}
		}
		return objeto.toString();
	}
	@SuppressWarnings("rawtypes")
	public Method [] getMethods(Object objeto){
		if(this.methods!=null){
			return this.methods;
		}
		String [] nomes = getNomeMetodo();
		Method [] metodos = new Method[nomes.length];
		Class classeObjeto = objeto.getClass();
		for (int i = 0; i < metodos.length; i++) {
			metodos[i] = getMethod(classeObjeto, nomes[i]);
			if(metodos[i]!=null){
				classeObjeto = metodos[i].getReturnType(); 
			}
		}
		this.methods = metodos;
		return this.methods;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Method getMethod(Class classeObjeto,String nomeMetodo) {
//		if(this.method!=null && this.method.getClass()==objeto.getClass()){
//			return this.method;
//		}
		Method method = null;
		try {
			method  = classeObjeto.getMethod(nomeMetodo, new Class[0]);
		} catch (NoSuchMethodException | SecurityException e) {
			method = null;
			this.valor = e.toString();
		}
		return method;
	}
	
	private String[] getNomeMetodo(){
		StringTokenizer st =  new StringTokenizer( getNome(),".");
		String [] nomes = new String[st.countTokens()];
		for (int i = 0; i < nomes.length; i++) {
			String nm = st.nextToken();// this.nome.substring(1);
			String letra1 = nm.substring(0,1).toUpperCase();
			nm = nm.substring(1);
			nomes[i] = "get"+letra1+nm;					 
		}
//		String nm = this.nome.substring(1);
//		String letra1 = this.nome.substring(0,1).toUpperCase();
		return nomes;//"get"+letra1+nm;		
	}
	public void render(StringBuffer html){
		if(valor==null){
			html.replace(this.posInicio, this.posFim,"<!--- /////PROPIEDADE "+this.nome+" NÃO LOCALIZADA! ///// --->");			 //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		if(html==null){
			return;
		}		
		html.replace(this.posInicio, this.posFim,valor);
	}	
}
