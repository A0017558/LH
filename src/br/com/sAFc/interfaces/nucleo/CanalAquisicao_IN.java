package br.com.sAFc.interfaces.nucleo; 


public interface CanalAquisicao_IN extends ObjetosNegocioSAFC {
	
	
	public int getCodigoCanalAquisicao();
	public String getCanalAquisicao();
	
	
	///1 relacionamentos localizados
	
	
	public Insumo_IN [] getInsumossRelacionados();
	
	
}
