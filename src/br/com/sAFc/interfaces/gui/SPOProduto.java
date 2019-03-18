package br.com.sAFc.interfaces.gui; 


import br.com.sAFc.interfaces.nucleo.Curva_IN;
import br.com.sAFc.interfaces.nucleo.Destinacao_IN;
import br.com.sAFc.interfaces.nucleo.LinhaProducao_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;


public interface SPOProduto extends SolicitacaoGenericaSAFC {
	
	
	public UnidadeMedida_IN getUnidadeMedidaPesquisa();
	
	public LinhaProducao_IN getLinhaProducaoPesquisa();
	
	public Destinacao_IN getDestinoPesquisa();
	
	public Curva_IN getCurvaPesquisa();
	
	
	
	public String getCodigoProdutoPesquisa();
	public String getNomeProdutoPesquisa();
	public String getLotePadraoPesquisa();
	public String getApresentacaoPesquisa();
	public String getFatorAjusteProdutividadePesquisa();
	public String getValorParaVendaPesquisa();
	public String getPoliticaEstoquePesquisa();
	
	
}
