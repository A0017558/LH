package br.com.sAFc.interfaces.nucleo; 


public interface UnidadeMedida_IN extends ObjetosNegocioSAFC {
	
	
	public String getSiglaUnidadeMedida();
	public String getNomeUnidadeMedida();
	
	
	///2 relacionamentos localizados
	
	
	public Insumo_IN [] getInsumossRelacionados();
	public Produto_IN [] getProdutossRelacionados();
	
	
}
