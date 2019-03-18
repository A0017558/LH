package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import formularios.FormularioAbstrato;
import formularios.ObjetoNegocio;

public abstract class CampoListaMultiplosObjetos extends CampoFormularioSAFC {

	



	public CampoListaMultiplosObjetos(FormularioAbstrato formulario) {
		super(formulario, false, TIPO_TEXTO);
	}

	@SuppressWarnings("rawtypes")
	public CampoListaMultiplosObjetos(	OperadorObjetosAbstratoSAFC operadorObjetosAcervo) {
		super(operadorObjetosAcervo, null, TIPO_TEXTO);
	}

	public abstract Object [] getObjetosLista();
	public abstract HTML_Obj getHTMLObjeto(Object objeto);


	@Override
	public String getCodigo() {
		Object []  objetosNegocio = getObjetosLista();
		if(objetosNegocio==null){
			objetosNegocio = new  ObjetoNegocio [0];
		}
		StringBuffer resp = new StringBuffer();
		codigoHTMLAbreLista(resp);
		for (int i = 0; i < objetosNegocio.length; i++) {
			codigoHTMLAbreLinha(resp,objetosNegocio[i]);
			HTML_Obj htmlObjs = getHTMLObjeto(objetosNegocio[i]);
			if(htmlObjs!=null){
				resp.append(htmlObjs.renderizar(objetosNegocio[i]));		
			}
			codigoHTMLFechaLinha(resp,objetosNegocio[i]);			
		}
		codigoHTMLFechaLista(resp);
		return resp.toString();		
	}



    public void codigoHTMLFechaLista(StringBuffer resp) {
    }

    public void codigoHTMLAbreLista(StringBuffer resp) {
    }

	public void codigoHTMLFechaLinha(StringBuffer resp, Object object) {
	}

	public void codigoHTMLAbreLinha(StringBuffer resp, Object object) {
	}

}
