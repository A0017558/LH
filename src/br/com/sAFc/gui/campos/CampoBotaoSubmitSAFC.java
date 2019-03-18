package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import formularios.CampoBotaoSubmit;
import formularios.FormularioAbstrato;

public class CampoBotaoSubmitSAFC extends CampoBotaoSubmit {

	public CampoBotaoSubmitSAFC(FormularioAbstrato formulario, String textoBotao) {
		super(formulario, textoBotao);
	}

	public CampoBotaoSubmitSAFC(OperadorObjetosAbstratoSAFC operadorObjetos, String textoBotao) {
		super(operadorObjetos.getFormularioAbstratoSAFC() , textoBotao);
	}

	
	
}
