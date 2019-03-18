package br.com.sAFc.interfaces.nucleo; 


public interface Curva_IN extends ObjetosNegocioSAFC {
	
	
	public String getCodigoCurva();
	
	
	///1 relacionamentos localizados
	
	
	public Produto_IN [] getProdutossRelacionados();
	
	
}
