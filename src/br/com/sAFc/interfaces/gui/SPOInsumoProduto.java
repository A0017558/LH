package br.com.sAFc.interfaces.gui; 


import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;


public interface SPOInsumoProduto extends SolicitacaoGenericaSAFC {
	
	
	public Insumo_IN getProdutosPesquisa();
	
	public Produto_IN getInsumosPesquisa();
	
	
	
	public String getQuantidadeInsumoporUnidadeProdutoPesquisa();
	
	
}
