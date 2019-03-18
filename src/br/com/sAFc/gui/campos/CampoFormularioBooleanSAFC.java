package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import formularios.CampoDeFormularioBoolean;
import formularios.FormularioAbstrato;

public class CampoFormularioBooleanSAFC extends CampoDeFormularioBoolean {

	public CampoFormularioBooleanSAFC(OperadorObjetosAbstratoSAFC operador, int tipo) {
		super(operador.getFormulario(),false, tipo);
	}

	public CampoFormularioBooleanSAFC(OperadorObjetosAbstratoSAFC operador) {
		super(operador.getFormulario(),false, TIPO_CHECKBOX);
	}

	public CampoFormularioBooleanSAFC(FormularioAbstrato formulario,
			boolean requerido, int tipo, String nomeControladorCamposBoolean) {
		super(formulario, requerido, tipo, nomeControladorCamposBoolean);
	}

	public CampoFormularioBooleanSAFC(FormularioAbstrato formulario,
			boolean requerido, int tipo) {
		super(formulario, requerido, tipo);
	}
	
	public CampoFormularioBooleanSAFC(FormularioAbstrato formulario) {
		super(formulario, false, TIPO_CHECKBOX);
	}


}
