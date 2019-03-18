package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import formularios.FormularioAbstrato;

public abstract class CampoListaObjetosRelacionados extends CampoListaMultiplosObjetos {

	public CampoListaObjetosRelacionados(FormularioAbstrato formulario) {
		super(formulario);
	}

	@SuppressWarnings("rawtypes")
	public CampoListaObjetosRelacionados(
			OperadorObjetosAbstratoSAFC operadorObjetosAcervo) {
		super(operadorObjetosAcervo);
	}



	public abstract String getClasseTitulo(); 

	public abstract String getTitulo();

	public void codigoHTMLFechaLista(StringBuffer resp) {
		resp.append("</div>");
	}

	public void codigoHTMLAbreLista(StringBuffer resp) {
		String tit = getTitulo();
		if(tit!=null)resp.append("<h3 class=\""+getClasseTitulo()+"\">"+tit+"</h3>");
		resp.append("<div id=\"box\">");
	}

}
