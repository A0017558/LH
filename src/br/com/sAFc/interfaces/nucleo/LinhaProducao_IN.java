package br.com.sAFc.interfaces.nucleo; 


public interface LinhaProducao_IN extends ObjetosNegocioSAFC {
	
	
	public int getCodigoLinha();
	public String getNomeLinhaProducao();
	public int getCapacidadeLinha();
	
	
	///1 relacionamentos localizados
	
	
	public Produto_IN [] getProdutossRelacionados();
	
	
}
