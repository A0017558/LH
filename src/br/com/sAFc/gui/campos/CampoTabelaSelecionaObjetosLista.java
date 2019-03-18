package br.com.sAFc.gui.campos;

import aplicacao.CampoTabelaSelecionaObjetoGerador;
import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import formularios.ObjetoNegocio;
import formularios.OperadorObjetos;

public abstract class CampoTabelaSelecionaObjetosLista  extends CampoTabelaSelecionaObjetoGerador {

	public CampoTabelaSelecionaObjetosLista(OperadorObjetos operadorObjetos) {
		super(operadorObjetos);
	}
	
	
	@Override
	public String getCodigo() {
		ObjetoNegocio [] objetosNegocio = getObjetosNegocio();
		if(objetosNegocio==null){
			 objetosNegocio = new  ObjetoNegocio [0];
		}
		StringBuffer resp = new StringBuffer();
		codigoHTMLAbreTitulo(resp);
		HTML_Obj htmlTitulo = getHTMLTitulo();
		if(htmlTitulo!=null){
			resp.append(htmlTitulo.renderizar(this));
		}
		codigoHTMLFechaTitulo(resp);	
		for (int i = 0; i < objetosNegocio.length; i++) {
			codigoHTMLAbreLinha(resp,objetosNegocio[i]);
			HTML_Obj htmlObjs = getHTMLObjeto(objetosNegocio[i]);
			if(htmlObjs!=null){
				resp.append(htmlObjs.renderizar(objetosNegocio[i]));		
			}
			codigoHTMLFechaLinha(resp,objetosNegocio[i]);			
		}
		HTML_Obj htmlFim = getHTMLRodape();
		if(htmlFim!=null){
			resp.append(htmlFim.renderizar(this));
		}
		codigoHTMLFechaTabela(resp);
		return resp.toString();		
	}

	@Override
	public String getBgcolorTHTitulo() {
		return "#FFFFFF";
	}
	
	public void codigoHTMLAbreTitulo(StringBuffer sb){
		if(usarTabelaExterna()){
			String cor = getBgcolorTHTitulo();
			sb.append("<input type='hidden' name='"+getNome()+"' id='"+getNome()+"' >\n");
			sb.append("<script>\n" );
			sb.append("function marcar_(idc,vlc){\n");
			sb.append(" document.getElementById(idc).value=vlc;\n" );
			String nmCampoBt = ((OperadorObjetosAbstratoSAFC)getOperadorObjetos()).getBotaoAbrirObjetoHidden().getNome();			
			sb.append(" document.getElementById('"+nmCampoBt+"').value='ok';\n" );
			sb.append(" document.getElementById(idc).form.submit();\n" );
			sb.append("" );
			sb.append("" );
			sb.append("" );
			sb.append("" );
			sb.append("}" );
			sb.append("</script>\n");
			sb.append("<table width='100%' title='corpo campo tabela' >");
			if(criarTituloTabelaExterna()){
				sb.append("<tr><th bgcolor='"+cor+"' >");
			}
		}
	} 
	public void codigoHTMLFechaTitulo(StringBuffer sb){
		if(usarTabelaExterna()&&criarTituloTabelaExterna()){
			sb.append("</th></tr>");
		}
	}
	@SuppressWarnings("rawtypes")
	public void codigoHTMLAbreLinha(StringBuffer sb,ObjetoNegocio obj){
		if(usarTabelaExterna()){
			if(((OperadorObjetosAbstratoSAFC)this.getOperadorObjetos()).isOperadorConsulta()){
				sb.append("<tr><td onclick='javascript:document.location.href=document.location.href+\"&i="+obj.getCodigoIdentificadorLista()+"\"' >");
			}else{
				sb.append("<tr><td onclick='marcar_(\""+getNome()+"\",\""+obj.getCodigoIdentificadorLista()+"\")'>");
			}
		}
	}
	public void codigoHTMLFechaLinha(StringBuffer sb,ObjetoNegocio obj){
		if(usarTabelaExterna()){
			sb.append("</td></tr>");
		}
	}
	public void codigoHTMLFechaTabela(StringBuffer sb){
		if(usarTabelaExterna()){
			sb.append("</table>");
		}
	}
	
	public  HTML_Obj getHTMLTitulo(){
		return null;
	}
	public  HTML_Obj getHTMLRodape(){
		return null;
	}
	public abstract HTML_Obj getHTMLObjeto(ObjetoNegocio objetoNegocio);
	
	public boolean usarTabelaExterna(){
		return true;
	};
	public boolean criarTituloTabelaExterna(){
		return true;
	};

}
