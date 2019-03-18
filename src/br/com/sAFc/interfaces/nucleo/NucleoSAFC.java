package br.com.sAFc.interfaces.nucleo; 


import br.com.sAFc.interfaces.gui.SIACanalAquisicao;
import br.com.sAFc.interfaces.gui.SIACurva;
import br.com.sAFc.interfaces.gui.SIADestinacao;
import br.com.sAFc.interfaces.gui.SIAInsumo;
import br.com.sAFc.interfaces.gui.SIAInsumoProduto;
import br.com.sAFc.interfaces.gui.SIALinhaProducao;
import br.com.sAFc.interfaces.gui.SIALoteProducao;
import br.com.sAFc.interfaces.gui.SIAModalAquisicao;
import br.com.sAFc.interfaces.gui.SIAPrevisaoVenda;
import br.com.sAFc.interfaces.gui.SIAProduto;
import br.com.sAFc.interfaces.gui.SIATipoInsumo;
import br.com.sAFc.interfaces.gui.SIAUnidadeMedida;
import br.com.sAFc.interfaces.gui.SPOCanalAquisicao;
import br.com.sAFc.interfaces.gui.SPOCurva;
import br.com.sAFc.interfaces.gui.SPODestinacao;
import br.com.sAFc.interfaces.gui.SPOInsumo;
import br.com.sAFc.interfaces.gui.SPOInsumoProduto;
import br.com.sAFc.interfaces.gui.SPOLinhaProducao;
import br.com.sAFc.interfaces.gui.SPOLoteProducao;
import br.com.sAFc.interfaces.gui.SPOModalAquisicao;
import br.com.sAFc.interfaces.gui.SPOPrevisaoVenda;
import br.com.sAFc.interfaces.gui.SPOProduto;
import br.com.sAFc.interfaces.gui.SPOTipoInsumo;
import br.com.sAFc.interfaces.gui.SPOUnidadeMedida;


public interface NucleoSAFC {
	
	
	public Insumo_IN [] getInsumos(SPOInsumo spo);
	public Insumo_IN criarNovoInsumo(SIAInsumo sia);
	
	public Produto_IN [] getProdutos(SPOProduto spo);
	public Produto_IN criarNovoProduto(SIAProduto sia);
	
	public UnidadeMedida_IN [] getUnidadeMedidas(SPOUnidadeMedida spo);
	public UnidadeMedida_IN criarNovoUnidadeMedida(SIAUnidadeMedida sia);
	
	public TipoInsumo_IN [] getTipoInsumos(SPOTipoInsumo spo);
	public TipoInsumo_IN criarNovoTipoInsumo(SIATipoInsumo sia);
	
	public ModalAquisicao_IN [] getModalAquisicaos(SPOModalAquisicao spo);
	public ModalAquisicao_IN criarNovoModalAquisicao(SIAModalAquisicao sia);
	
	public CanalAquisicao_IN [] getCanalAquisicaos(SPOCanalAquisicao spo);
	public CanalAquisicao_IN criarNovoCanalAquisicao(SIACanalAquisicao sia);
	
	public LinhaProducao_IN [] getLinhaProducaos(SPOLinhaProducao spo);
	public LinhaProducao_IN criarNovoLinhaProducao(SIALinhaProducao sia);
	
	public InsumoProduto_IN [] getInsumoProdutos(SPOInsumoProduto spo);
	public InsumoProduto_IN criarNovoInsumoProduto(SIAInsumoProduto sia);
	
	public Destinacao_IN [] getDestinacaos(SPODestinacao spo);
	public Destinacao_IN criarNovoDestinacao(SIADestinacao sia);
	
	public Curva_IN [] getCurvas(SPOCurva spo);
	public Curva_IN criarNovoCurva(SIACurva sia);
	
	public PrevisaoVenda_IN [] getPrevisaoVendas(SPOPrevisaoVenda spo);
	public PrevisaoVenda_IN criarNovoPrevisaoVenda(SIAPrevisaoVenda sia);
	
	public LoteProducao_IN [] getLoteProducaos(SPOLoteProducao spo);
	public LoteProducao_IN criarNovoLoteProducao(SIALoteProducao sia);
	
}
