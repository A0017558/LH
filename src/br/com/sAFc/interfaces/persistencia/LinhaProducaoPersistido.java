package br.com.sAFc.interfaces.persistencia; 
public interface LinhaProducaoPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getCodigoLinha();
	   public void setCodigoLinha(int valor);
	
	   public String getNomeLinhaProducao();
	   public void setNomeLinhaProducao(String valor);
	   public int getCapacidadeLinha();
	   public void setCapacidadeLinha(int valor);
	public ProdutoPersistido[] getRegistroProdutossRelacionados();
}
