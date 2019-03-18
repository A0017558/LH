package br.com.sAFc.interfaces.nucleo; 


public interface TipoInsumo_IN extends ObjetosNegocioSAFC {
	
	
	public int getCodigoTipoInsumo();
	public String getNomeTipoInsumo();
	
	
	///1 relacionamentos localizados
	
	
	public Insumo_IN [] getInsumossRelacionados();
	
	
}
