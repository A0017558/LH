package br.com.sAFc.interfaces.gui; 


import br.com.sAFc.interfaces.nucleo.Curva_IN;
import br.com.sAFc.interfaces.nucleo.Destinacao_IN;
import br.com.sAFc.interfaces.nucleo.LinhaProducao_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;


public interface SIAProduto extends SolicitacaoGenericaSAFC {
	
	
	public UnidadeMedida_IN getUnidadeMedida();
	
	public LinhaProducao_IN getLinhaProducao();
	
	public Destinacao_IN getDestino();
	
	public Curva_IN getCurva();
	
	public int getCodigoProduto();
	public String getNomeProduto();
	public int getLotePadrao();
	public String getApresentacao();
	public int getFatorAjusteProdutividade();
	public int getValorParaVenda();
	public int getPoliticaEstoque();
	
	
}
