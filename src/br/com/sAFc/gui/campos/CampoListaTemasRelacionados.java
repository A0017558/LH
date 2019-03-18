package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import formularios.FormularioAbstrato;

public abstract class CampoListaTemasRelacionados extends CampoListaObjetosRelacionados {

	private HTML_Obj htmlSimples = new HTML_Obj(){
		public String getHTML() {
			return "<a href='?secao=tema&tm=<!-- !id='NumeroTema' -->'><!-- !id='tituloLista' --></a><br>";
		} 
	};
	
	public CampoListaTemasRelacionados(FormularioAbstrato formulario) {
		super(formulario);
	}

	@SuppressWarnings("rawtypes")
	public CampoListaTemasRelacionados(
			OperadorObjetosAbstratoSAFC operadorObjetosAcervo) {
		super(operadorObjetosAcervo);
	}

	@Override
	public HTML_Obj getHTMLObjeto(Object objeto) {
		return htmlSimples;
	}
	@Override
	public String getClasseTitulo() {
		return "azul";
	}
	@Override
	public String getTitulo() {
		return "Temas";
	}

}
