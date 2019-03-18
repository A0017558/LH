package br.com.sAFc.interfaces.persistencia; 
public interface CurvaPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public String getCodigoCurva();
	   public void setCodigoCurva(String valor);
	
	public ProdutoPersistido[] getRegistroProdutossRelacionados();
}
