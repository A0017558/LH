package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.ObjetoGenerico_IN;

public abstract class CampoListaTagsRelacionados extends CampoListaObjetosRelacionados {

	private HTML_Obj htmlSimples = new HTML_Obj(){
		public String getHTML() {
			return "<a href='?secao=escola&i=<!-- !id='CodigoIdentificadorLista' -->'><!-- !id='tituloLista' --></a><br>";
		} 
	};

	@SuppressWarnings("rawtypes")
	public CampoListaTagsRelacionados(
			OperadorObjetosAbstratoSAFC operadorObjetosAcervo) {
		super(operadorObjetosAcervo);
	}

	@Override
	public String getClasseTitulo() {
		return "azulD";
	}

	@Override
	public String getTitulo() {
		return "Tags";
	}

	@Override
	public Object[] getObjetosLista() {
		return getObjetoGenerico().getTags_NxN_ObjetosMarcadossRelacionados();
	}
	
	public abstract ObjetoGenerico_IN getObjetoGenerico();

	@Override
	public HTML_Obj getHTMLObjeto(Object objeto) {
		return htmlSimples;
	}

}
