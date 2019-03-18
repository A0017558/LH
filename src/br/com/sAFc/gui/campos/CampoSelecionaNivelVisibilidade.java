package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.CodigosSAFC;
import formularios.FormularioAbstrato;

public class CampoSelecionaNivelVisibilidade extends CampoFormularioIntSAFC {

	
	private static final String [] codigos = new String[]{
		String.valueOf(CodigosSAFC.OBJETO_EM_EDICAO),
		String.valueOf(CodigosSAFC.OBJETO_VISIVEL)
	};
			
	private static final String [] nomes = new String[]{
		"Em edição",
		"Publico"
	};

	public CampoSelecionaNivelVisibilidade(FormularioAbstrato formulario) {
		super(formulario, false, TIPO_SELECT);
		setValoresPossiveis(codigos, nomes);
	}

	public CampoSelecionaNivelVisibilidade(OperadorObjetosAbstratoSAFC operadorObjetos, String string) {
		super(operadorObjetos, string, TIPO_SELECT);
		setValoresPossiveis(codigos, nomes);
	}
	
	
			
	
	
}
