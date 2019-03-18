package br.com.sAFc.interfaces.persistencia; 
public interface InsumoPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getCodigoInsumo();
	   public void setCodigoInsumo(int valor);
	
	   public String getNomeInsumo();
	   public void setNomeInsumo(String valor);
	   public String getSiglaunidademedida();
	   public void setSiglaunidademedida(String valor);
	   public int getCodigotipoinsumo();
	   public void setCodigotipoinsumo(int valor);
	   public int getCodigomodalaquisicao();
	   public void setCodigomodalaquisicao(int valor);
	   public int getCodigocanalaquisicao();
	   public void setCodigocanalaquisicao(int valor);
	   public int getTempoParaAquisicao();
	   public void setTempoParaAquisicao(int valor);
	   public int getTempoLiberacao();
	   public void setTempoLiberacao(int valor);
	   public int getCompraMinima();
	   public void setCompraMinima(int valor);
	   public int getUnidadeCompra();
	   public void setUnidadeCompra(int valor);
	   public int getValorParaAquisicao();
	   public void setValorParaAquisicao(int valor);
	public InsumoProdutoPersistido[] getRegistroInsumossRelacionados();
	public UnidadeMedidaPersistido getRegistroUnidadeMedidaRelacionado();
	public TipoInsumoPersistido getRegistroTipoInsumoRelacionado();
	public ModalAquisicaoPersistido getRegistroModalAquisicaoRelacionado();
	public CanalAquisicaoPersistido getRegistroCanalAquisicaoRelacionado();
}
