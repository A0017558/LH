package br.com.sAFc.interfaces.gui; 


import java.util.GregorianCalendar;

import br.com.sAFc.interfaces.nucleo.Produto_IN;


public interface SIAPrevisaoVenda extends SolicitacaoGenericaSAFC {
	
	
	public Produto_IN getProduto();
	
	public int getNumeroPrevisao();
	public GregorianCalendar getDataPrevisaoVenda();
	public int getQuantidadeProduto();
	
	
}
