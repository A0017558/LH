package br.com.sAFc.interfaces.nucleo; 


public interface InsumoProduto_IN extends ObjetosNegocioSAFC {
	
	
	public int getCodigoproduto();
	public int getCodigoinsumo();
	public int getQuantidadeInsumoporUnidadeProduto();
	
	
	///2 relacionamentos localizados
	
	
	public Insumo_IN getProdutos();
	public Produto_IN getInsumos();
	
	
}
