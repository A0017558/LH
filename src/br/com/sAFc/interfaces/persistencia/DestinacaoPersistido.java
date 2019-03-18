package br.com.sAFc.interfaces.persistencia; 
public interface DestinacaoPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getCodigoDestinacao();
	   public void setCodigoDestinacao(int valor);
	
	   public String getNomeDestinacao();
	   public void setNomeDestinacao(String valor);
	public ProdutoPersistido[] getRegistroProdutossRelacionados();
}
