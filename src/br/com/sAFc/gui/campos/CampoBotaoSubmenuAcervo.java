package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.DecodificadorSAFC;
import formularios.FormularioAbstrato;

public abstract class CampoBotaoSubmenuAcervo extends CampoFormularioSAFC {

	private String textoBotao = null;
	
	public CampoBotaoSubmenuAcervo(FormularioAbstrato formulario,
			String textoBotao) {
		super(formulario,false,TIPO_HIDDEN);
		this.textoBotao = textoBotao;
	}

	public String getCorFundoItem() {
		return "#FFFFFF";
	}
	


	
	@Override
	public String getCodigo() {	
		StringBuffer sb =  new StringBuffer();
		
		sb.append("<a class=\"");
		if(getValorBoolean()){
			sb.append("inativo");		
		}else{
			sb.append("ativo");		
		}
		sb.append("\" id=\"");		
		sb.append(getIdBotao());
		sb.append("\" style=\"cursor:pointer;background:url('/SAFC2/img/ico/");
		sb.append(getIdBotao());
		if(getValorBoolean()){
			sb.append("Off");		
		}
		sb.append(".png')no-repeat;padding:5px;padding-left:25px;");
		
		if(isPrimeiroSegundaColuna()){
			sb.append("margin-top:25px");
		}
		sb.append("\" onclick=\"showP(this,0,'");
		sb.append(getNome());
		sb.append("')\"> ");
		sb.append(this.textoBotao);
		sb.append("</a><br><br>");
		sb.append("");
		sb.append("<script>bts.push(document.getElementById('"+getIdBotao()+"'));</script>");
		//sb.append(super.getCodigo()); 
		return sb.toString();
	}
	
		
	public boolean isPrimeiroSegundaColuna(){
		return false;
	}
	
	public String getAlign(){
		return "left";
	} 
	
	
	public boolean getValorBoolean() {
		String busca = ((DecodificadorSAFC)getFormulario().getDecodificadorComandos()).getParameter("busca");
		if(busca==null){
			return false;
		}
		return busca.indexOf(this.getIdBotao().substring(6))>0;
//		return "S".equalsIgnoreCase(getValorString());
	}
	
	
	public abstract String getIdBotao();
	
	@Override
	public boolean isBloqueado() {
		return false;
	}

}
