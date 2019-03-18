package br.com.sAFc.interfaces.gui; 


import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;


public interface SIAInsumoProduto extends SolicitacaoGenericaSAFC {
	
	
	public Insumo_IN getProdutos();
	
	public Produto_IN getInsumos();
	
	public int getQuantidadeInsumoporUnidadeProduto();
	
	
}
