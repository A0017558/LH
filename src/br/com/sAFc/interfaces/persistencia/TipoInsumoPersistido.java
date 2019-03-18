package br.com.sAFc.interfaces.persistencia; 
public interface TipoInsumoPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getCodigoTipoInsumo();
	   public void setCodigoTipoInsumo(int valor);
	
	   public String getNomeTipoInsumo();
	   public void setNomeTipoInsumo(String valor);
	public InsumoPersistido[] getRegistroInsumossRelacionados();
}
