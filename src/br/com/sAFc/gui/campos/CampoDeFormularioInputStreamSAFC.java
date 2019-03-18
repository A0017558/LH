package br.com.sAFc.gui.campos;

import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;

public class CampoDeFormularioInputStreamSAFC extends CampoFormularioUpload {

	/*
	 $("a#example2").fancybox({
				'overlayShow'	: false,
				'transitionIn'	: 'elastic',
				'transitionOut'	: 'elastic'
			});
	 */
	private static int cont = 0;
	private OperadorObjetosAbstratoSAFC operadorObjetosAbstratoSAFC = null;
//	public CampoDeFormularioInputStreamSAFC(FormularioAbstrato formulario) {
//		super(formulario);
//	}
	
	@SuppressWarnings("rawtypes")
	public CampoDeFormularioInputStreamSAFC(OperadorObjetosAbstratoSAFC operadorObjetosAbstratoSAFC,String nm) {
		super(operadorObjetosAbstratoSAFC);
		this.operadorObjetosAbstratoSAFC = operadorObjetosAbstratoSAFC;
	}
	
	@Override
	public String getCodigo() {
		String r = super.getCodigo(); 
		String vl = super.getValorString();	
		String img = "";
		if(getNomeDesignado()!=null){
			vl = getNomeDesignado();
			//img =   "<a href='arq.jsp?nm="+getNomeDesignado()+"' ><img src='arq.jsp?nm="+getNomeDesignado()+"' "+getParmsHTML()+"></a>";
		}
		if(vl!=null){
			String id = getIdScript();
			img =   "<a id='"+id+"' href='arq.jsp?nm="+vl+"' ><img border='0' src='arq.jsp?nm="+vl+"'  "+getParmsHTML()+" ></a><script>$(\"a#"+id+"\").fancybox();</script>";
		}
		if(isBloqueado()){
			return img;
		}
	
		return img+"<BR>"+r;
	}
	
	private String getIdScript(){
		return "img_"+cont++;
	}
	
	@Override
	public String getParmsHTML() {
		//  width='200px'
		String strParms =  super.getParmsHTML();
		if(strParms==null){
			return  " width='200px' ";
		}
		if(strParms.toUpperCase().indexOf("WIDTH")==-1){
			return  strParms+" width='200px' ";
		}
		return strParms;
	}
	
	@Override
	public String getValorString() {
		String vl = super.getValorString();
		String nmArq = getNomeDesignado();
		if(nmArq!=null){
			return nmArq+"&nmf="+vl;
		}
		return vl;
	}
	
	@Override
	public void setValor(String valor) {
		if(valor==null || valor.trim().length()==0){
			return;
		}
		super.setValor(valor);
	}
	
//	@Override
//	public String getNomeDesignado()  {
//		String nm = super.getNomeDesignado();
//		if(nm==null){
//			if(!operadorObjetosAbstratoSAFC.isModoInclusao()){
//				String vl = getValorString();
//				return vl;
//			}
//		}
//		return nm;
//	}

}
