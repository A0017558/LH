package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.ObjetoGenerico_CodigoTipoObjeto;
import br.com.sAFc.interfaces.nucleo.ObjetoGenerico_IN;
import formularios.FormularioAbstrato;

public abstract class CampoListaAtividadesRelacionadas extends CampoListaObjetosRelacionados	 {

//	private HTML_Obj htmlArquivos = new HTML_Obj(){
//		public String getHTML() {
//			return "<img src='img/ico/icone-download.png' width='20' height='20' align='absmiddle'>" +
//					"<a href=''><!-- !id='tituloLista' --></a><br>";
//		} 
//	};
	private HTML_Obj htmlSimples = new HTML_Obj(){
		public String getHTML() {
			return "<a href='?secao=escola&i=<!-- !id='CodigoIdentificadorLista' -->'><!-- !id='tituloLista' --></a><br>";
		} 
	};
	
	public CampoListaAtividadesRelacionadas(FormularioAbstrato formulario) {
		super(formulario);
	}

	@SuppressWarnings("rawtypes")
	public CampoListaAtividadesRelacionadas(
			OperadorObjetosAbstratoSAFC operadorObjetosAcervo) {
		super(operadorObjetosAcervo);
	}

	@Override
	public HTML_Obj getHTMLObjeto(Object objeto) {
		int cd  = ((ObjetoGenerico_IN)objeto).getCodigoTipoObjeto();
		if(cd==ObjetoGenerico_CodigoTipoObjeto.ATIVIDADE.getCodigoObjetoGenerico_CodigoTipoObjeto()){
			return htmlSimples;	
		}
		return null;		
	}
	@Override
	public String getClasseTitulo() {
		return "verde";
	}
	@Override
	public String getTitulo() {
		return "Atividades";
	}

}
