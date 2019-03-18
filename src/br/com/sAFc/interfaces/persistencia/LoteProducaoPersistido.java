package br.com.sAFc.interfaces.persistencia; 
public interface LoteProducaoPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getCodigoLote();
	   public void setCodigoLote(int valor);
	
	   public int getCodigoproduto();
	   public void setCodigoproduto(int valor);
	public ProdutoPersistido getRegistroProdutoRelacionado();
}
