package br.com.sAFc.interfaces.nucleo; 


public interface LoteProducao_IN extends ObjetosNegocioSAFC {
	
	
	public int getCodigoLote();
	public int getCodigoproduto();
	
	
	///1 relacionamentos localizados
	
	
	public Produto_IN getProduto();
	
	
}
