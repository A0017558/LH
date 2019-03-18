package br.com.sAFc.gui.campos;

import java.util.Date;

import util.Messages;
import br.com.sAFc.gui.base.DecodificadorSAFC;
import formularios.CampoDeFormulario;
import formularios.CampoSelecaoPagina;
import formularios.CampoTabelaSelecaoObjeto;
import formularios.ListaIdentificada;
import formularios.ObjetoItemLista;
import formularios.ObjetoNegocio;
import formularios.OperadorObjetos;

public class CampoSelecionaPaginaSAFC extends CampoSelecaoPagina {

	private String idInstancia = "_"+ new Date().getTime();
	private OperadorObjetos operadorObjetos = null;
	private String [] opcoes; //= null; new String[0];
	
	public CampoSelecionaPaginaSAFC(OperadorObjetos operadorObjetos) {
		super(operadorObjetos);
		this.operadorObjetos = operadorObjetos;
	}
	

	public String getTituloCampo(){
		return Messages.getString("CampoSelecionaPagina.0"); //$NON-NLS-1$
	}
	public String getTituloLista(int pagina){
		return Messages.getString("CampoSelecionaPagina.1")+(pagina+1); //$NON-NLS-1$
	}	
	
	public boolean isHabilitado() {
		return operadorObjetos.isPaginacaoHabilidata();
	}
	
	public Integer getValorInt() {
		String pgn = ((DecodificadorSAFC)getFormulario().getDecodificadorComandos()).getParameter("pgn");
		if(pgn==null){
			return new Integer(1);
		}
		return Integer.valueOf(pgn);
		
	};
	public String getCodigo() {
		if(this.opcoes==null){
			return "<!-- opções nulas... -->";
		}
		if(this.opcoes.length==0){
			return "<!-- sem páginas disponíveis... -->";
		}
		StringBuffer s = new StringBuffer();
		/*
		 * <div id="box" style="float:left;text-align:left;width:200px;">
		 * <a onclick="javascript:history.back();" style="cursor:pointer;">Anterior</a></div>
		 * 
		 * <div id="box" style="float:right;text-align:right;width:200px;">
		 * <a onclick="javascript:history.back();" style="cursor:pointer;">Próximo</a></div>
		 */
		String cod = this.getNome()+"_"; //$NON-NLS-1$
		int npAtual = getValorInt().intValue();
		String baseUrl = ((DecodificadorSAFC)getFormulario().getDecodificadorComandos()).getParmsExceto("pgn");
		s.append("<input type='hidden' id='"+getNome()+"'  name='"+getNome()+"' value='"+getValorInt().intValue()+"' >"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		if(npAtual>1){
			s.append("<div id='box' style='float:left;text-align:left;width:200px;'>");
//			s.append("<a onclick='selecionouPagina"+idInstancia+"("+(npAtual-1)+");' style='cursor:pointer;' >Anterior</a></div>");
			s.append("<a href='"+baseUrl+"&pgn="+(npAtual-1)+"' style='cursor:pointer;' >Anterior</a></div>");
		}
		if(npAtual<this.opcoes.length){
			s.append("<div id='box' style='float:right;text-align:right;width:200px;'>");
//			s.append("<a onclick='selecionouPagina"+idInstancia+"("+(npAtual+1)+");' style='cursor:pointer;' >Próximo</a></div>");
			s.append("<a href='"+baseUrl+"&pgn="+(npAtual+1)+"' style='cursor:pointer;' >Próximo</a></div>");
		}
//		s.append("<table align='center' cellpadding='1' cellspacing='1'>\n"); //$NON-NLS-1$
//		s.append("<tr>"); //$NON-NLS-1$
//		s.append("<td colspan='"+opcoes.length+"' align='center'>");		 //$NON-NLS-1$ //$NON-NLS-2$
//		s.append(getTituloCampo());
//		s.append("</td>"); //$NON-NLS-1$
//		s.append("</tr>"); //$NON-NLS-1$
//		s.append("<tr>\n"); //$NON-NLS-1$
//		int j = 0;
//		for (int i = 0; i < this.opcoes.length; i++) {
//			j = i+1;
//			s.append("<td height='29'>"); //$NON-NLS-1$
//			s.append("<a class='linkAzulEscuro' id='"); //$NON-NLS-1$
//			s.append(cod);
//			s.append(idInstancia);			
//			s.append("_");			
//			s.append(j);  			
//			s.append("' onfocus='mouseOverSelPagina"+idInstancia+"("); //$NON-NLS-1$
//			s.append(j);
//			s.append(")' onblur='mouseOutSelPagina"+idInstancia+"()' href='javascript:selecionouPagina"+idInstancia+"("); //$NON-NLS-1$
//			s.append(j);
//			s.append(")' onmouseover='mouseOverSelPagina"+idInstancia+"("); //$NON-NLS-1$
//			s.append(j);
//			s.append(")' title='"); //$NON-NLS-1$
//			s.append(opcoes[i]);
//			s.append("'  onmouseout='mouseOutSelPagina"+idInstancia+"()'>["); //$NON-NLS-1$
//			s.append(j);
//			s.append("]</a>"); //$NON-NLS-1$
//			s.append("</td>\n"); //$NON-NLS-1$
//		}
//		s.append("</tr>"); //$NON-NLS-1$
//		s.append("</table>\n"); //$NON-NLS-1$
		
/*		
		
		s.append("<script>\n"); //$NON-NLS-1$
		s.append("var numE"+idInstancia+" = "+this.opcoes.length+";\n"); //$NON-NLS-1$ //$NON-NLS-2$
		s.append("function selecionouPagina"+idInstancia+"(n){\nif(n=="+getValorInt().intValue()+")return;\nvar c = document.getElementById('"+this.getNome()+"');\nc.value=n;document.getElementById('"+getFormulario().getNomeFormHTML()+"').submit();\n};\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		s.append("function mouseOverSelPagina"+idInstancia+"(n){\n"); //$NON-NLS-1$
		s.append("for(var i=0;i<=numE"+idInstancia+";i++){\n"); //$NON-NLS-1$
		s.append("var e =  document.getElementById('"+cod+idInstancia+"_'+i);\n"); //$NON-NLS-1$ //$NON-NLS-2$
		s.append("if(e!=null){\n");			 //$NON-NLS-1$
		s.append("if(n-i==0){e.style.fontSize=25;}\n"); //$NON-NLS-1$
		s.append("if(n-i==1 || n-i==-1){e.style.fontSize=18;}\n"); //$NON-NLS-1$
		s.append("if(n-i>=2 || n-i<=-2){e.style.fontSize=12;}\n"); //$NON-NLS-1$
		s.append("}\n"); //$NON-NLS-1$
		s.append("}\n"); //$NON-NLS-1$
		s.append("}\n"); //$NON-NLS-1$
		s.append("function mouseOutSelPagina"+idInstancia+"(){\n"); //$NON-NLS-1$
		s.append("mouseOverSelPagina"+idInstancia+"("+getValorInt().intValue()+");\n"); //$NON-NLS-1$ //$NON-NLS-2$
		s.append("}\n"); //$NON-NLS-1$
		s.append("mouseOutSelPagina"+idInstancia+"();\n"); //$NON-NLS-1$
		s.append("</script>\n");		 //$NON-NLS-1$
*/
		return s.toString();// super.getCodigo();
	}

	private static String removeTags(String entrada){
		if(entrada==null){
			return ""; //$NON-NLS-1$
		}
		int posA = entrada.indexOf('<');
		int posF = entrada.indexOf('>');		
		while(posA>=0 && posA<posF){
			entrada = entrada.substring(0,posA)+entrada.substring(posF+1, entrada.length());
			posA = entrada.indexOf('<');
			posF = entrada.indexOf('>');					
		}
		return entrada;
	}
		
	public void setValoresPossiveis(
			int[] inteiros,
			ObjetoItemLista [] objetos, 
			int objetosPorPagina){
		
		CampoDeFormulario campoSelecionaObjeto =  operadorObjetos.getCampoSelecionaObjeto();
		
		
		if(campoSelecionaObjeto instanceof CampoTabelaSelecaoObjeto &&
				this.getOperadorObjetos().getListaCamposNegocio()!=null){
			CampoTabelaSelecaoObjeto campoT = (CampoTabelaSelecaoObjeto) campoSelecionaObjeto;			
			CampoDeFormulario campoOrdenador = campoT.getCampoOrdenador();
	//		if(campoOrdenador!=null && objetos.length>0){
			if(objetos.length>0){
				int paginas = ((objetos.length-1)/objetosPorPagina)+1;
				Ops_CampoSelecionaPagina [] opcoes = new Ops_CampoSelecionaPagina[paginas];
				this.opcoes = new String[paginas];
				for (int i = 0; i < opcoes.length; i++) {
					if(campoOrdenador!=null){
						String c = String.valueOf(inteiros[i]);
						int ob1 = i*objetosPorPagina;
						int ob2 = ((i+1)*objetosPorPagina)-1;
						if(ob2>=objetos.length){
							ob2 = objetos.length-1;
						}
						campoOrdenador.setObjetoNegocio((ObjetoNegocio)objetos[ob1]);
						String vc1 = campoOrdenador.getValorString();
						if(vc1==null)vc1=""; //$NON-NLS-1$
						campoOrdenador.setObjetoNegocio((ObjetoNegocio)objetos[ob2]);
						String vc2 = campoOrdenador.getValorString();
						if(vc2==null)vc2=""; //$NON-NLS-1$
						String nmCampo = campoOrdenador.getAtributoListagemObjetoNegocio().getTituloColuna();					
						this.opcoes[i] = removeTags(nmCampo)+" "+vc1+Messages.getString("CampoSelecionaPagina.4")+vc2; //$NON-NLS-1$ //$NON-NLS-2$
						if(vc1.length()>12){
							vc1 = vc1.substring(0,12)+"..."; //$NON-NLS-1$
						}
						if(vc2.length()>12){
							vc2 = vc2.substring(0,12)+"..."; //$NON-NLS-1$
						}
						opcoes[i] = new Ops_CampoSelecionaPagina(c,c+" - "+nmCampo+" "+vc1+Messages.getString("CampoSelecionaPagina.5")+nmCampo+" "+vc2); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					}else{
						String nmOpcao = getTituloLista(i);
						opcoes[i] = new Ops_CampoSelecionaPagina(String.valueOf(i),nmOpcao);
						this.opcoes[i] = nmOpcao;
					}
				}
				//this.opcoes = opcoes;
				this.setValoresPossiveis(opcoes);
				return;
			}
		}
		super.setValoresPossiveis(inteiros);		
	}
}class Ops_CampoSelecionaPagina implements ListaIdentificada{
	String c = null;
	String t = null;	
	public Ops_CampoSelecionaPagina(String c, String t) {
		super();
		this.c = c;
		this.t = t;
	}
	public String getCodigoIdentificadorLista() {
		return c;
	}
	public String getTituloLista() {
		return t;
	}
}

	
