package br.com.sAFc.interfaces.nucleo; 

import java.util.GregorianCalendar;


public interface PrevisaoVenda_IN extends ObjetosNegocioSAFC {
	
	
	public int getNumeroPrevisao();
	public GregorianCalendar getDataPrevisaoVenda();
	public int getCodigoproduto();
	public int getQuantidadeProduto();
	
	
	///1 relacionamentos localizados
	
	
	public Produto_IN getProduto();
	
	
}
