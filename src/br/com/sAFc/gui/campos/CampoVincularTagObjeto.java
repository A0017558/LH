package br.com.sAFc.gui.campos;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.gui.SIATag;
import br.com.sAFc.interfaces.gui.UsuarioSAFC;
import br.com.sAFc.interfaces.nucleo.ObjetoGenerico_IN;
import br.com.sAFc.interfaces.nucleo.Tag_IN;
import br.com.sAFc.nucleo.Tag;

public abstract class CampoVincularTagObjeto extends CampoFormularioSAFC {

	private String vl =  "";
	@SuppressWarnings("rawtypes")
	public CampoVincularTagObjeto(OperadorObjetosAbstratoSAFC operadorObjetosAcervo) {
		super(operadorObjetosAcervo, null, TIPO_TEXTO);
	}
	
	
	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}
	
	@Override
	public void setValor(String valor) {
		this.vl = valor;
	}
	
	@Override
	public String getValorString() {
		ObjetoGenerico_IN narr = getObjetoGenerico();
		if(narr==null){
			return "";
		}
		Tag_IN [] tags =  narr.getTags_NxN_ObjetosMarcadossRelacionados();
		StringBuffer sb =  new StringBuffer();
		for (int i = 0; i < tags.length; i++) {
			if(i>0)sb.append(", ");
			sb.append(tags[i].getTextotag());
		}
		return sb.toString();
	}

	public void gravarVinculos(){
		ObjetoGenerico_IN narr = getObjetoGenerico();
		Tag_IN [] tags =  narr.getTags_NxN_ObjetosMarcadossRelacionados();
//		String txTags = getValorString();
		StringTokenizer st =  new StringTokenizer(vl,",");
		Hashtable<String, Tag_IN> tagsRemover = new Hashtable<String, Tag_IN>();
		Hashtable<String, Tag_IN> tagsIncluir = new Hashtable<String, Tag_IN>();
		for (int i = 0; i < tags.length; i++) {
			tagsRemover.put(tags[i].getTextotag().trim(), tags[i]);
		}
		while(st.hasMoreElements()){
			String t = st.nextToken();
			t = t.trim();
			Tag_IN tag =  Tag.getTag_INPorIdentficador(t);
			if(tag==null){
				tag = Tag.criarNovoTag_IN(new criaTag(t));
			}
			Tag_IN tj = tagsRemover.remove(t);
			if(tj==null){
				tagsIncluir.put(t, tag);
			}
		}
		Enumeration<Tag_IN> enumTr = tagsRemover.elements();
		Enumeration<Tag_IN> enumTa = tagsIncluir.elements();
		while(enumTr.hasMoreElements()){
			Tag_IN t = enumTr.nextElement();
			narr.desvincularTags_NxN_ObjetosMarcados(t);
		}
		while(enumTa.hasMoreElements()){
			Tag_IN t = enumTa.nextElement();
			narr.vincularTags_NxN_ObjetosMarcados(t);			
		}
	}
	
	public abstract ObjetoGenerico_IN getObjetoGenerico();
	
}class criaTag implements SIATag{
	private String t = null;
	
	public criaTag(String t) {
		super();
		this.t = t;
	}
	@Override
	public String getTextotag() {
		return t;
	}
	@Override
	public UsuarioSAFC getUsuarioSAFC() {
		return null;
	}
}
