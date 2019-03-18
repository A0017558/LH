package br.com.sAFc.interfaces.gui; 


import br.com.sAFc.interfaces.nucleo.CanalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.ModalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.TipoInsumo_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;


public interface SPOInsumo extends SolicitacaoGenericaSAFC {
	
	
	public UnidadeMedida_IN getUnidadeMedidaPesquisa();
	
	public TipoInsumo_IN getTipoInsumoPesquisa();
	
	public ModalAquisicao_IN getModalAquisicaoPesquisa();
	
	public CanalAquisicao_IN getCanalAquisicaoPesquisa();
	
	
	
	public String getCodigoInsumoPesquisa();
	public String getNomeInsumoPesquisa();
	public String getTempoParaAquisicaoPesquisa();
	public String getTempoLiberacaoPesquisa();
	public String getCompraMinimaPesquisa();
	public String getUnidadeCompraPesquisa();
	public String getValorParaAquisicaoPesquisa();
	
	
}
