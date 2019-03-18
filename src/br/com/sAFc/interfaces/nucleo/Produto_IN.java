package br.com.sAFc.interfaces.nucleo; 


public interface Produto_IN extends ObjetosNegocioSAFC {
	
	
	public int getCodigoProduto();
	public String getNomeProduto();
	public int getCodigolinha();
	public String getSiglaunidademedida();
	public int getLotePadrao();
	public String getApresentacao();
	public int getFatorAjusteProdutividade();
	public int getValorParaVenda();
	public int getCodigodestinacao();
	public String getCodigocurva();
	public int getPoliticaEstoque();
	
	
	///7 relacionamentos localizados
	
	
	public InsumoProduto_IN [] getProdutossRelacionados();
	public PrevisaoVenda_IN [] getPrevisoesVendasRelacionados();
	public LoteProducao_IN [] getLotessRelacionados();
	public UnidadeMedida_IN getUnidadeMedida();
	public LinhaProducao_IN getLinhaProducao();
	public Destinacao_IN getDestino();
	public Curva_IN getCurva();
	
	
}
