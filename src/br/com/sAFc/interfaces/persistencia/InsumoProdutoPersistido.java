package br.com.sAFc.interfaces.persistencia; 
public interface InsumoProdutoPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getCodigoproduto();
	   public void setCodigoproduto(int valor);
	   public int getCodigoinsumo();
	   public void setCodigoinsumo(int valor);
	
	   public int getQuantidadeInsumoporUnidadeProduto();
	   public void setQuantidadeInsumoporUnidadeProduto(int valor);
	public InsumoPersistido getRegistroProdutosRelacionado();
	public ProdutoPersistido getRegistroInsumosRelacionado();
}
