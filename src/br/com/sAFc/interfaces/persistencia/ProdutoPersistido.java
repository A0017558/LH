package br.com.sAFc.interfaces.persistencia; 
public interface ProdutoPersistido  extends br.com.sAFc.interfaces.persistencia.ObjetoPersistidoSAFC{
	   public int getCodigoProduto();
	   public void setCodigoProduto(int valor);
	
	   public String getNomeProduto();
	   public void setNomeProduto(String valor);
	   public int getCodigolinha();
	   public void setCodigolinha(int valor);
	   public String getSiglaunidademedida();
	   public void setSiglaunidademedida(String valor);
	   public int getLotePadrao();
	   public void setLotePadrao(int valor);
	   public String getApresentacao();
	   public void setApresentacao(String valor);
	   public int getFatorAjusteProdutividade();
	   public void setFatorAjusteProdutividade(int valor);
	   public int getValorParaVenda();
	   public void setValorParaVenda(int valor);
	   public int getCodigodestinacao();
	   public void setCodigodestinacao(int valor);
	   public String getCodigocurva();
	   public void setCodigocurva(String valor);
	   public int getPoliticaEstoque();
	   public void setPoliticaEstoque(int valor);
	public InsumoProdutoPersistido[] getRegistroProdutossRelacionados();
	public PrevisaoVendaPersistido[] getRegistroPrevisoesVendasRelacionados();
	public LoteProducaoPersistido[] getRegistroLotessRelacionados();
	public UnidadeMedidaPersistido getRegistroUnidadeMedidaRelacionado();
	public LinhaProducaoPersistido getRegistroLinhaProducaoRelacionado();
	public DestinacaoPersistido getRegistroDestinoRelacionado();
	public CurvaPersistido getRegistroCurvaRelacionado();
}
