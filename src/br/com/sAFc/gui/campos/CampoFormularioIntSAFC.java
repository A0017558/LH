package br.com.sAFc.gui.campos;

import util.ComparadorInteiros;
import aplicacao.AtributoListagemCampo;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.Usuario_IN;
import formularios.AtributoListagemObjetoNegocio;
import formularios.CampoDeFormularioInt;
import formularios.FormularioAbstrato;

public class CampoFormularioIntSAFC extends CampoDeFormularioInt {

	private AtributoListagemObjetoNegocio atr = null;	
	
	public CampoFormularioIntSAFC(boolean requerido, int tipo) {
		super(requerido, tipo);
	}

	public CampoFormularioIntSAFC(FormularioAbstrato formulario,
			boolean requerido, int tipo) {
		super(formulario, requerido, tipo);
	}

	public CampoFormularioIntSAFC(
			OperadorObjetosAbstratoSAFC operadorObjetos,
			String nome, int tipo) {
		this(operadorObjetos.getFormulario(),false,tipo);
		if(nome!=null)
			this.atr = new AtributoListagemCampo(nome, new ComparadorInteiros());

	}

	@Override
	public AtributoListagemObjetoNegocio getAtributoListagemObjetoNegocio() {
		return atr;
	}
	
	public int getInt(){
		Integer i = getValorInt();
		if(i==null){
			return 0;
		}
		return i.intValue();
	}
	
	
	
	public boolean isCampoLogin(){
		return false;
	}
	
	public Usuario_IN getUsuario(){
		return ((FormularioAbstratoSAFC)getFormulario()).getUsuario();
	}
	
}
