package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.DecodificadorSAFC;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import formularios.FormularioAbstrato;

public abstract class CampoLinkMenuSAFC extends CampoBotaoSubmitSAFC {

	public CampoLinkMenuSAFC(FormularioAbstrato formulario, String textoBotao) {
		super(formulario, textoBotao);
	}

	@SuppressWarnings("rawtypes")
	public CampoLinkMenuSAFC(OperadorObjetosAbstratoSAFC operadorObjetos,
			String textoBotao) {
		super(operadorObjetos, textoBotao);
	}
	//<div id="menuFilho"><a href="">Lorem ipsum dolor sit amet</a></div>
	@Override
	public String getCodigo() {	
		if(isEstiloFilho()){
			return "<div id='menuFilho'><a href='?secao="+getSecao()+"&sm="+getIdOpcaoMenu()+"' >"+getEtiqueta()+"</a></div><input type='hidden'  id='"+getNome()+"'  >";
		}
		return 
				"<a  href='?secao="+getSecao()+"&sm="+getIdOpcaoMenu()+"' class='"+getClasseCor()+"' >"+getEtiqueta()+"</a><input type='hidden'  id='"+getNome()+"'  >";
	}
	public boolean isEstiloFilho(){
		return false;
	}
	
	public String getClasseCor(){
		return "verde textoMed";
	}
	
	public abstract String getSecao();
	public abstract String getIdOpcaoMenu();
	
	public boolean isAtivo(){
		String idOP =getIdOpcaoMenu();
		String vlp = ((DecodificadorSAFC)getFormulario().getDecodificadorComandos()).getParameter("sm");
		
		if(vlp==null){
			return idOP==null || idOP.length()==0;
		}
		return idOP.equals(vlp);
	}
}
