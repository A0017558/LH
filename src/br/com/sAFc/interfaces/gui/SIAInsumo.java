package br.com.sAFc.interfaces.gui; 


import br.com.sAFc.interfaces.nucleo.CanalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.ModalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.TipoInsumo_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;


public interface SIAInsumo extends SolicitacaoGenericaSAFC {
	
	
	public UnidadeMedida_IN getUnidadeMedida();
	
	public TipoInsumo_IN getTipoInsumo();
	
	public ModalAquisicao_IN getModalAquisicao();
	
	public CanalAquisicao_IN getCanalAquisicao();
	
	public int getCodigoInsumo();
	public String getNomeInsumo();
	public int getTempoParaAquisicao();
	public int getTempoLiberacao();
	public int getCompraMinima();
	public int getUnidadeCompra();
	public int getValorParaAquisicao();
	
	
}
