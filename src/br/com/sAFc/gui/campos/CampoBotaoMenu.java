package br.com.sAFc.gui.campos;

import br.com.sAFc.custom.gui.forms.FormularioMenu;
import br.com.sAFc.gui.base.DecodificadorSAFC;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import formularios.FormularioAbstrato;

public abstract class CampoBotaoMenu extends CampoBotaoSubmitSAFC {

	private FormularioAbstrato formulario = null;
	
	
	
	public CampoBotaoMenu(FormularioMenu formulario, String textoBotao) {
		super(formulario, textoBotao);
		this.formulario = formulario;
	}
	
	public CampoBotaoMenu(FormularioAbstrato formulario, String textoBotao) {
		super(formulario, textoBotao);
		this.formulario = formulario;
	}
	
	@Override
	public String getCodigo() {	
		StringBuffer sb =  new StringBuffer();
		
		//<li><a href="temas.html" class="cor1"><div style="margin-top:7px;" class="menu">TEMAS</div></a></li>
		String nmSecao = getNomeSecao();
		if(nmSecao != null){
			sb.append("<li><a href='javascript:document.location.href=\"?secao="+nmSecao+"\"' class='"+getClasseItem());
		}else{
			sb.append("<li><a href='javascript:clicouMenu(\""+getNome()+"\")' class='"+getClasseItem());			
		}  
		if(isItemMenuAtivo()){
			sb.append(" marcado' ");			
		}else{
			sb.append("' ");
		}
		sb.append(" "+getParmsHTML()+" >");

		sb.append("<div style=\""+getStyleDiv()+"\" class=\"menu\" >");		
		sb.append(getEtiqueta());
		sb.append("</div></a></li>");
		sb.append("<input type='hidden' id='"+this.getNome()+"' e='"+this.getNome()+"' > ");		
		return sb.toString();
	}

//	@Override
//	public String getEtiqueta() {
//		if(isItemMenuAtivo()){
//			return "";
//		}
//		return super.getEtiqueta(); 
//	} 

	public String getStyleDiv(){
		return "margin-top:7px;";
	}
	
	public String getAlign(){
		return "center";
	}
	
	public abstract String getClasseItem();
	
	@SuppressWarnings("rawtypes")
	public Class getClassFormularioVinculado(){
		return null;
	}
	
	public String getNomeSecao(){
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean exec() {
		Class classeForm = getClassFormularioVinculado();
		formulario.getDecodificadorComandos().setFormularioAtivo(classeForm);
		FormularioAbstratoSAFC form =  (FormularioAbstratoSAFC) formulario.getDecodificadorComandos().getFormulario(classeForm.getName());
		if(form!=null)form.reset();
//		if(this.formulario instanceof FormularioMenu){
//			((FormularioMenu)this.formulario).setCorBarraTitulo(getClasseItem());
//		}
		return false;
	};

	public boolean isItemMenuAtivo(){
		String m =((DecodificadorSAFC)formulario.getDecodificadorComandos()).getParameter("m");
		String nmSecao = this.getNomeSecao();
		if(nmSecao!=null){
			if(m!=null){
				return nmSecao.equals(m);
			}
			String secao =((DecodificadorSAFC)formulario.getDecodificadorComandos()).getParameter("secao");
			if(secao!=null){
				return nmSecao.equals(secao);
			}
		}
		String s = formulario.getDecodificadorComandos().getFormularioAtivo(FormularioAbstratoSAFC.nomeGrupoConteudo);
		return getClassFormularioVinculado().getName().equals(s);
	}			

	
	
}
