package br.com.sAFc.gui.campos;

import aplicacao.AtributoListagemCampo;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.util.ComparadorGregorianCalendar;
import formularios.AtributoListagemObjetoNegocio;
import formularios.CampoDeFormularioTimestamp;
import formularios.FormularioAbstrato;

public class CampoFormularioTimestampSAFC extends CampoDeFormularioTimestamp {

	 public static final String yyyy_MM_dd_HH_mm_ss_SSS = "yyyy/MM/dd HH:mm:ss:SSS";
	 public static final String yyyy_MM_dd_HH_mm_ss = "yyyy/MM/dd HH:mm:ss";
	 public static final String yyyy_MM_dd = "yyyy/MM/dd ";
	 public static final String dd_MM_yyyy = "dd/MM/yyyy";
	 public static final String dd_MM_yyyy_HH_mm_ss_SSS = "dd/MM/yyyy HH:mm:ss:SSS";
	 public static final String dd_MM_yyyy_HH_mm_ss = "dd/MM/yyyy HH:mm:ss";
	 public static final String dd_MMMMMMMMMMMMMMMM_yyyy_HH_mm_ss = "dd 'de' MMMMMMMMMMMMMM 'de' yyyy 'às' HH:mm:ss";

	
	private static String formato_ = "dd/MM/yyyy";
	private AtributoListagemObjetoNegocio atr = null;

	
	public CampoFormularioTimestampSAFC(FormularioAbstrato formulario,
			boolean requerido, int tipo) {
		super(formulario, requerido, tipo);
		setFormato(getFormato());
		setFormatosValidos(new String[]{getFormato()});		
	}

	public CampoFormularioTimestampSAFC(
			OperadorObjetosAbstratoSAFC operadorObjetos, 
			String nome,
			int tipo) {
		this(operadorObjetos.getFormularioAbstratoSAFC(),false,tipo);
		setFormato(getFormato());	
		setFormatosValidos(new String[]{getFormato()});
		if(nome!=null){
			this.atr = new AtributoListagemCampo(nome, new ComparadorGregorianCalendar());
		}
	}
	
	public String getFormato(){
		return formato_;
	}
	
	@Override
	public AtributoListagemObjetoNegocio getAtributoListagemObjetoNegocio() {
		if(this.atr!=null){
			return this.atr;
		}
		return super.getAtributoListagemObjetoNegocio();
	}
	
	
	@Override
	public String getParmsHTML() {
		return super.getParmsHTML()+" class='tcal'  ";
	}
	@Override
	public String getCodigo() {
		return "<div>"+super.getCodigo()+"</div>";
	}
	
	@Override
	public void setValor(String valor) {
		// TODO Auto-generated method stub
		super.setValor(valor);
	}
}
