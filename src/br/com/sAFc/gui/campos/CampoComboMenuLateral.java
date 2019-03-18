package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.Tema_IN;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;

public abstract class CampoComboMenuLateral extends CampoTabelaSelecionaObjetosLista{

		
	private HTML_Obj htmlTitulo = new HTML_Obj(){
		public String getHTML(){
			String lnk = getLinkTitulo(); 
			if(lnk==null){
				return "<a class='"+getClasseCor()+"'>"+getTituloOpcao()+"</a><br>";	
			}else{
				return "<a href='"+lnk+"' class='"+getClasseCor()+"'>"+getTituloOpcao()+"</a><br>";
			}
		}
	};

	public abstract String getTituloOpcao();
//	public abstract String getCodigoOpcoes();
	public ObjetoItemLista [] getOpcoes(){
		return new ObjetoItemLista [0]; 
	}
	public Tema_IN getTema(){
		return null;
	}
	public String getSecaoObjeto(){
		return null;
	}
	public String getLinkTitulo(){
		return null;
	}

	@Override
	public String getCodigo() {
		setValoresPossiveis(getOpcoes());
		return super.getCodigo();
	}

	
	@SuppressWarnings("rawtypes")
	public CampoComboMenuLateral(OperadorObjetosAbstratoSAFC operadorObjetosAbstrato) {
		super(operadorObjetosAbstrato);
	}

	public CampoComboMenuLateral(FormularioAbstratoSAFC formulario) {
		super(null);
	}
	
	@Override
	public HTML_Obj getHTMLTitulo() {
		return  new HTML_Obj(){
			public String getHTML(){
				String lnk = getLinkTitulo(); 
				if(lnk==null){
					return "<a class='"+getClasseCor()+"'>"+getTituloOpcao()+"</a><br>";	
				}else{
					return "<a href='"+lnk+"' class='"+getClasseCor()+"'>"+getTituloOpcao()+"</a><br>";
				}
			}
		};
		//return htmlTitulo;
	}
	
	public String getClasseCor() {
		return "azul textoMed";
	};
	
	private int getNumeroTema(){
		Tema_IN tm = getTema();
		if(tm==null){
			return 0;
		}
		return tm.getNumeroTema();
	}
	
	@Override
	public HTML_Obj getHTMLObjeto(ObjetoNegocio objetoNegocio){
		HTML_Obj htmlSimples = new HTML_Obj(){
			public String getHTML() {
				return "<div id='menuFilho'>" +
						"<a href='?" +
						"tm="+getNumeroTema()+
						"&secao="+getSecaoObjeto()+
						"&m=tema&i=<!-- !id='CodigoIdentificadorLista' -->" +
						"' >" +
						"<!-- !id='tituloLista' --></a></div>";
			}  
		};  
		return htmlSimples;
	}
	@Override
	public boolean usarTabelaExterna() {
		return false;
	}
	@Override
	public boolean criarTituloTabelaExterna() {
		return false;
	}

}
