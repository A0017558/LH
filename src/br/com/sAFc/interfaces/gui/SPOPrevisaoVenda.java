package br.com.sAFc.interfaces.gui; 


import br.com.sAFc.interfaces.nucleo.Produto_IN;


public interface SPOPrevisaoVenda extends SolicitacaoGenericaSAFC {
	
	
	public Produto_IN getProdutoPesquisa();
	
	
	
	public String getNumeroPrevisaoPesquisa();
	public String getDataPrevisaoVendaPesquisa();
	public String getQuantidadeProdutoPesquisa();
	
	
}
