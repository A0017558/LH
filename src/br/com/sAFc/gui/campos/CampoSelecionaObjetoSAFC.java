package br.com.sAFc.gui.campos;

import java.util.Comparator;

import aplicacao.CampoSelecionaObjetos;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.NucleoSAFC;
import br.com.sAFc.interfaces.nucleo.Usuario_IN;
import formularios.ObjetoNegocio;

public abstract class CampoSelecionaObjetoSAFC<TipoObj extends ObjetoNegocio> extends CampoSelecionaObjetos {

	@SuppressWarnings("rawtypes")
	private OperadorObjetosAbstratoSAFC operadorObjetosAbstrato =null;
	
	
	@SuppressWarnings("rawtypes")
	public CampoSelecionaObjetoSAFC(
			OperadorObjetosAbstratoSAFC operadorObjetosAbstrato,
			String nome,
			Comparator comparador) {
		super(operadorObjetosAbstrato, nome, comparador);
		this.operadorObjetosAbstrato = (OperadorObjetosAbstratoSAFC) operadorObjetosAbstrato;
		setFormulario(operadorObjetosAbstrato.getFormulario());
	}
	@SuppressWarnings("rawtypes")
	public CampoSelecionaObjetoSAFC(
			OperadorObjetosAbstratoSAFC operadorObjetosAbstrato, String nome) {
		super(operadorObjetosAbstrato, nome);
		this.operadorObjetosAbstrato = (OperadorObjetosAbstratoSAFC) operadorObjetosAbstrato;
		setFormulario(operadorObjetosAbstrato.getFormulario());		
	}
	@SuppressWarnings("rawtypes")
	public CampoSelecionaObjetoSAFC(
			OperadorObjetosAbstratoSAFC operadorObjetosAbstrato) {
		super(operadorObjetosAbstrato);
		this.operadorObjetosAbstrato = (OperadorObjetosAbstratoSAFC) operadorObjetosAbstrato;
		setFormulario(operadorObjetosAbstrato.getFormulario());		
	}
	@SuppressWarnings("rawtypes")
	public CampoSelecionaObjetoSAFC(FormularioAbstratoSAFC formulario) {
		super(null);
		setFormulario(formulario);		
	}
	@SuppressWarnings("rawtypes")
	public OperadorObjetosAbstratoSAFC getOperadorObjetosAbstrato() {
		return operadorObjetosAbstrato;	 	
	}

	public NucleoSAFC getNucleoTHTML(){
		return getOperadorObjetosAbstrato().getNucleoSAFC();
	}
	
	
	public void setValor(int valor) {
		super.setValor(String.valueOf(valor));
	}
	
	public void setValor(TipoObj valor){
		if(valor==null){
			setNull();
		}else{
			super.setValor(valor.getCodigoIdentificadorLista());
		}
	}
	

	
	public boolean isCampoLogin(){
		return false;
	}
	
	public Usuario_IN getUsuario(){
		return ((FormularioAbstratoSAFC)getFormulario()).getUsuario();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TipoObj getObjetoSelecionado() {
		return  (TipoObj) super.getObjetoSelecionado();
	}
	
	@Override
	public abstract TipoObj[] getObjetosDominio();
	
}
