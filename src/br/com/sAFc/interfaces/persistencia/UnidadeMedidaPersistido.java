package br.com.sAFc.interfaces.persistencia; 
public interface UnidadeMedidaPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public String getSiglaUnidadeMedida();
	   public void setSiglaUnidadeMedida(String valor);
	
	   public String getNomeUnidadeMedida();
	   public void setNomeUnidadeMedida(String valor);
	public InsumoPersistido[] getRegistroInsumossRelacionados();
	public ProdutoPersistido[] getRegistroProdutossRelacionados();
}
