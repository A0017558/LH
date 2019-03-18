package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.DecodificadorSAFC;
import br.com.sAFc.gui.base.HTML_Obj;
import formularios.ObjetoNegocio;
import formularios.OperadorObjetos;

public abstract class CampoTabelaSelecionaListaDiv extends
		CampoTabelaSelecionaObjetosLista {

	public CampoTabelaSelecionaListaDiv(OperadorObjetos operadorObjetos) {
		super(operadorObjetos);
	}

	public abstract String getUrlImagemIconeObjeto(final ObjetoNegocio objetoNegocio);
	public abstract String getSecao(final ObjetoNegocio objetoNegocio);
	
	@Override
	public HTML_Obj getHTMLObjeto(ObjetoNegocio objetoNegocio){
		final String tm = getDecodificadorSAFC().getParameter("tm");
		final String m = getDecodificadorSAFC().getParameter("m");
		final ObjetoNegocio obj = objetoNegocio;
		if(tm!=null){
			return new HTML_Obj(){
				public String getHTML() {
					return "<div class='fundoTable'><div style='float:left;margin:-2px;margin-right:5px;'>" +
							"<img src='"+getUrlImagemIconeObjeto(obj)+"' align='absmiddle'></div>" +
							"<a href='?secao="+getSecao(obj)+"&tm="+tm+"&m="+m+"&i=<!-- !id='codigoIdentificadorLista' -->'><!-- !id='tituloLista' --></a></div>";
				}
			};					
		}
		return new HTML_Obj(){
			public String getHTML() {
				return "<div class='fundoTable'><div style='float:left;margin:-2px;margin-right:5px;'>" +
						"<img src='"+getUrlImagemIconeObjeto(obj)+"' align='absmiddle'></div>" +
						"<a href='?secao="+getSecao(obj)+"&i=<!-- !id='codigoIdentificadorLista' -->'><!-- !id='tituloLista' --></a></div>";			}
		};
	}

	public DecodificadorSAFC getDecodificadorSAFC() {
		return  (DecodificadorSAFC) getFormulario().getDecodificadorComandos();
	}

	@Override
	public boolean usarTabelaExterna() {
		return false;
	}
}
