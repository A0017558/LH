package br.com.sAFc.interfaces.persistencia; 
public interface PrevisaoVendaPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getNumeroPrevisao();
	   public void setNumeroPrevisao(int valor);
	   public java.util.GregorianCalendar getDataPrevisaoVenda();
	   public void setDataPrevisaoVenda(java.util.GregorianCalendar valor);
	
	   public int getCodigoproduto();
	   public void setCodigoproduto(int valor);
	   public int getQuantidadeProduto();
	   public void setQuantidadeProduto(int valor);
	public ProdutoPersistido getRegistroProdutoRelacionado();
}
