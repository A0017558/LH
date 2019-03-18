package br.com.sAFc.interfaces.nucleo; 


public interface Destinacao_IN extends ObjetosNegocioSAFC {
	
	
	public int getCodigoDestinacao();
	public String getNomeDestinacao();
	
	
	///1 relacionamentos localizados
	
	
	public Produto_IN [] getProdutossRelacionados();
	
	
}
