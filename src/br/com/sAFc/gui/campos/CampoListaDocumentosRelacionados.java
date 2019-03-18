package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.ObjetoGenerico_CodigoTipoObjeto;
import br.com.sAFc.interfaces.nucleo.ObjetoGenerico_IN;
import formularios.FormularioAbstrato;

public abstract class CampoListaDocumentosRelacionados extends
		CampoListaObjetosRelacionados {

	private boolean primeiro = false;
	private HTML_Obj htmlDocumentos = new HTML_Obj(){
		public String getHTML() {
			return "<div style='float:left;width:25px;'>" +
					"<img src='img/ico/icone-manuscrito.png' width='20' height='20' align='absmiddle'>" +
					"</div><div style='float:left;width:"+getLargura()+"px;'>" +
					"<a href='?secao=acervo&i=<!-- !id='codigoIdentificadorLista' -->'>" + 
					"<!-- !id='tituloLista' --></a></div><div style='clear:both;'></div>\n";
		} 
	};
	private HTML_Obj htmlDocumentos1 = new HTML_Obj(){
		public String getHTML() {
			return "<div style='float:left;width:25px;'>" +
					"<img src='img/ico/icone-manuscrito.png' width='20' height='20' align='absmiddle'>" +
					"</div><div style='float:left;width:"+getLargura()+"px;margin-bottom:10px;'>" +
					"<a href='?secao=acervo&i=<!-- !id='codigoIdentificadorLista' -->'>" + 
					"<!-- !id='tituloLista' --></a></div><div style='clear:both;'></div>\n";
		} 
	};
	
	public CampoListaDocumentosRelacionados(FormularioAbstrato formulario) {
		super(formulario);
	}

	public CampoListaDocumentosRelacionados(
			OperadorObjetosAbstratoSAFC operadorObjetosAcervo) {
		super(operadorObjetosAcervo);
	}
	@Override
	public String getCodigo() {
		primeiro = true;
		return super.getCodigo();
	}
	
	public abstract int getLargura();

	
	@Override
	public HTML_Obj getHTMLObjeto(Object objeto) {
		ObjetoGenerico_IN obj =  (ObjetoGenerico_IN) objeto;
		if(obj.getCodigoTipoObjeto()!=ObjetoGenerico_CodigoTipoObjeto.DOCUMENTO.getCodigoObjetoGenerico_CodigoTipoObjeto()){
			return null;
		}
		if(primeiro){
			primeiro = false;
			return htmlDocumentos1;
		}
		return htmlDocumentos;
	}
	@Override
	public String getClasseTitulo() {
		return "amarelo";
	}
	@Override
	public String getTitulo() {
		return "Documentos";
	}
	
	public void codigoHTMLFechaLista(StringBuffer resp) {
		//resp.append("</div>");
	}

	public void codigoHTMLAbreLista(StringBuffer resp) {
//		String tit = getTitulo();
//		if(tit!=null)resp.append("<h3 class=\""+getClasseTitulo()+"\">"+tit+"</h3>");
//		resp.append("<div id=\"box\">");
	}
}
