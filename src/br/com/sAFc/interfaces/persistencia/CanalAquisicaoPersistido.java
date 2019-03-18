package br.com.sAFc.interfaces.persistencia; 
public interface CanalAquisicaoPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getCodigoCanalAquisicao();
	   public void setCodigoCanalAquisicao(int valor);
	
	   public String getCanalAquisicao();
	   public void setCanalAquisicao(String valor);
	public InsumoPersistido[] getRegistroInsumossRelacionados();
}
