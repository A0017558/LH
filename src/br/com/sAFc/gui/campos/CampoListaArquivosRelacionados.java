package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import formularios.FormularioAbstrato;

public abstract class CampoListaArquivosRelacionados extends CampoListaObjetosRelacionados	 {

	private HTML_Obj htmlArquivos = new HTML_Obj(){
		public String getHTML() {
			return "<img src='img/ico/icone-download.png' width='20' height='20' align='absmiddle'>" +
					"<a href='arq.jsp?nm=<!-- !id='EnderecoArquivo' -->&d=d'><!-- !id='tituloLista' --></a><br>";
		} 
	};
	
	
	public CampoListaArquivosRelacionados(FormularioAbstrato formulario) {
		super(formulario);
	}

	@SuppressWarnings("rawtypes")
	public CampoListaArquivosRelacionados(
			OperadorObjetosAbstratoSAFC operadorObjetosAcervo) {
		super(operadorObjetosAcervo);
	}

	@Override
	public HTML_Obj getHTMLObjeto(Object objeto) {
		return htmlArquivos;
	}
	@Override
	public String getClasseTitulo() {
		return "azul";
	}
	@Override
	public String getTitulo() {
		return "";
	}

}
