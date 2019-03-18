package br.com.sAFc.nucleo; 


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
import br.com.sAFc.interfaces.nucleo.CanalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.Curva_IN;
import br.com.sAFc.interfaces.nucleo.Destinacao_IN;
import br.com.sAFc.interfaces.nucleo.InsumoProduto_IN;
import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.LinhaProducao_IN;
import br.com.sAFc.interfaces.nucleo.LoteProducao_IN;
import br.com.sAFc.interfaces.nucleo.ModalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.NucleoSAFC;
import br.com.sAFc.interfaces.nucleo.PrevisaoVenda_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.nucleo.TipoInsumo_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;


public class SAFC  implements NucleoSAFC {
	
	
	public Insumo_IN [] getInsumos(SPOInsumo spo){
		return Insumo.getInsumo_IN(spo);
	}
	public Insumo_IN criarNovoInsumo(SIAInsumo sia){
		return Insumo.criarNovoInsumo_IN(sia);
	}
	
	public Produto_IN [] getProdutos(SPOProduto spo){
		return Produto.getProduto_IN(spo);
	}
	public Produto_IN criarNovoProduto(SIAProduto sia){
		return Produto.criarNovoProduto_IN(sia);
	}
	
	public UnidadeMedida_IN [] getUnidadeMedidas(SPOUnidadeMedida spo){
		return UnidadeMedida.getUnidadeMedida_IN(spo);
	}
	public UnidadeMedida_IN criarNovoUnidadeMedida(SIAUnidadeMedida sia){
		return UnidadeMedida.criarNovoUnidadeMedida_IN(sia);
	}
	
	public TipoInsumo_IN [] getTipoInsumos(SPOTipoInsumo spo){
		return TipoInsumo.getTipoInsumo_IN(spo);
	}
	public TipoInsumo_IN criarNovoTipoInsumo(SIATipoInsumo sia){
		return TipoInsumo.criarNovoTipoInsumo_IN(sia);
	}
	
	public ModalAquisicao_IN [] getModalAquisicaos(SPOModalAquisicao spo){
		return ModalAquisicao.getModalAquisicao_IN(spo);
	}
	public ModalAquisicao_IN criarNovoModalAquisicao(SIAModalAquisicao sia){
		return ModalAquisicao.criarNovoModalAquisicao_IN(sia);
	}
	
	public CanalAquisicao_IN [] getCanalAquisicaos(SPOCanalAquisicao spo){
		return CanalAquisicao.getCanalAquisicao_IN(spo);
	}
	public CanalAquisicao_IN criarNovoCanalAquisicao(SIACanalAquisicao sia){
		return CanalAquisicao.criarNovoCanalAquisicao_IN(sia);
	}
	
	public LinhaProducao_IN [] getLinhaProducaos(SPOLinhaProducao spo){
		return LinhaProducao.getLinhaProducao_IN(spo);
	}
	public LinhaProducao_IN criarNovoLinhaProducao(SIALinhaProducao sia){
		return LinhaProducao.criarNovoLinhaProducao_IN(sia);
	}
	
	public InsumoProduto_IN [] getInsumoProdutos(SPOInsumoProduto spo){
		return InsumoProduto.getInsumoProduto_IN(spo);
	}
	public InsumoProduto_IN criarNovoInsumoProduto(SIAInsumoProduto sia){
		return InsumoProduto.criarNovoInsumoProduto_IN(sia);
	}
	
	public Destinacao_IN [] getDestinacaos(SPODestinacao spo){
		return Destinacao.getDestinacao_IN(spo);
	}
	public Destinacao_IN criarNovoDestinacao(SIADestinacao sia){
		return Destinacao.criarNovoDestinacao_IN(sia);
	}
	
	public Curva_IN [] getCurvas(SPOCurva spo){
		return Curva.getCurva_IN(spo);
	}
	public Curva_IN criarNovoCurva(SIACurva sia){
		return Curva.criarNovoCurva_IN(sia);
	}
	
	public PrevisaoVenda_IN [] getPrevisaoVendas(SPOPrevisaoVenda spo){
		return PrevisaoVenda.getPrevisaoVenda_IN(spo);
	}
	public PrevisaoVenda_IN criarNovoPrevisaoVenda(SIAPrevisaoVenda sia){
		return PrevisaoVenda.criarNovoPrevisaoVenda_IN(sia);
	}
	
	public LoteProducao_IN [] getLoteProducaos(SPOLoteProducao spo){
		return LoteProducao.getLoteProducao_IN(spo);
	}
	public LoteProducao_IN criarNovoLoteProducao(SIALoteProducao sia){
		return LoteProducao.criarNovoLoteProducao_IN(sia);
	}
	
}
