package br.com.sAFc.interfaces.nucleo; 


public interface ModalAquisicao_IN extends ObjetosNegocioSAFC {
	
	
	public int getCodigoModalAquisicao();
	public String getNomeModalAquisicao();
	
	
	///1 relacionamentos localizados
	
	
	public Insumo_IN [] getInsumossRelacionados();
	
	
}
