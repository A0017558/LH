package br.com.sAFc.gui.campos;

import util.ComparadorStrings;
import aplicacao.AtributoListagemCampo;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.NucleoSAFC;
import br.com.sAFc.interfaces.nucleo.Usuario_IN;
import formularios.AtributoListagemObjetoNegocio;
import formularios.CampoDeFormulario;
import formularios.FormularioAbstrato;

public class CampoFormularioSAFC extends CampoDeFormulario {

	private AtributoListagemObjetoNegocio atr = null;
	
	

	public CampoFormularioSAFC(FormularioAbstrato formulario,
			boolean requerido, int tipo) {
		super(formulario, requerido, tipo);
	}
	
	public CampoFormularioSAFC(FormularioAbstrato formulario) {
		super(formulario, false, TIPO_TEXTO);
	}

	public CampoFormularioSAFC(FormularioAbstrato formulario,
			boolean requerido, int tipo, boolean multiplo) {
		super(formulario, requerido, tipo, multiplo);
		// TODO Auto-generated constructor stub
	}

	public CampoFormularioSAFC(String nome, FormularioAbstrato formulario,
			boolean requerido, int tipo, boolean multiplo) {
		super(nome, formulario, requerido, tipo, multiplo);
		if(nome!=null)
			this.atr = new AtributoListagemCampo(nome, new ComparadorStrings());
	}

	public CampoFormularioSAFC(String nome, FormularioAbstrato formulario,
			boolean requerido, int tipo) {
		super(nome, formulario, requerido, tipo);
		if(nome!=null)
			this.atr = new AtributoListagemCampo(nome, new ComparadorStrings());

	}

	public CampoFormularioSAFC(
			OperadorObjetosAbstratoSAFC operadorObjetosAcervo,
			String nome, int tipo) {
		this(nome,operadorObjetosAcervo.getFormularioAbstratoSAFC(),false,tipo);
		if(nome!=null)
			this.atr = new AtributoListagemCampo(nome, new ComparadorStrings());
	}

	@Override
	public AtributoListagemObjetoNegocio getAtributoListagemObjetoNegocio() {
		return atr;
	}

	
	@Override
	public String getParmsHTML() {
		if(getType()==TIPO_TEXTAREA){
			return "  cols='"+getParmCols()+"' rows='"+getParmRows()+"' "+super.getParmsHTML();
		}
		return super.getParmsHTML();
	}
	
	
	public int getParmCols(){
		return 150;
	}
	
	public int getParmRows(){
		return 30;
	}
	
	
	@Override
	public boolean isBloqueado() {
		if(!getFormulario().isBloqueado()){
			return super.isBloqueado();
		}
		if(getUsuario()==null){
			return true;
		} 
		return super.isBloqueado();
	}
	
	public boolean isCampoLogin(){
		return false;
	}
	
	public Usuario_IN getUsuario(){
		return ((FormularioAbstratoSAFC)getFormulario()).getDecodificadorSAFC().getUsuario();			
	}
	
	
	public NucleoSAFC getNucleoSAFC(){
		return ((FormularioAbstratoSAFC)getFormulario()).getNucleoSAFC();
	}
	

	
	public boolean isGlossarioAtivo(){
		return getType()==TIPO_TEXTAREA;				
		
	}
	
}
