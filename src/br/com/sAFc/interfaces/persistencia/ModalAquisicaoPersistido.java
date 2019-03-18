package br.com.sAFc.interfaces.persistencia; 
public interface ModalAquisicaoPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getCodigoModalAquisicao();
	   public void setCodigoModalAquisicao(int valor);
	
	   public String getNomeModalAquisicao();
	   public void setNomeModalAquisicao(String valor);
	public InsumoPersistido[] getRegistroInsumossRelacionados();
}
