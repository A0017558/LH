package br.com.sAFc.interfaces.gui; 


import br.com.sAFc.interfaces.nucleo.Produto_IN;


public interface SIALoteProducao extends SolicitacaoGenericaSAFC {
	
	
	public Produto_IN getProduto();
	
	public int getCodigoLote();
	
	
}
