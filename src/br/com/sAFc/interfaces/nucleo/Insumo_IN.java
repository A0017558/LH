package br.com.sAFc.interfaces.nucleo; 


public interface Insumo_IN extends ObjetosNegocioSAFC {
	
	
	public int getCodigoInsumo();
	public String getNomeInsumo();
	public String getSiglaunidademedida();
	public int getCodigotipoinsumo();
	public int getCodigomodalaquisicao();
	public int getCodigocanalaquisicao();
	public int getTempoParaAquisicao();
	public int getTempoLiberacao();
	public int getCompraMinima();
	public int getUnidadeCompra();
	public int getValorParaAquisicao();
	
	
	///5 relacionamentos localizados
	
	
	public InsumoProduto_IN [] getInsumossRelacionados();
	public UnidadeMedida_IN getUnidadeMedida();
	public TipoInsumo_IN getTipoInsumo();
	public ModalAquisicao_IN getModalAquisicao();
	public CanalAquisicao_IN getCanalAquisicao();
	
	
}
