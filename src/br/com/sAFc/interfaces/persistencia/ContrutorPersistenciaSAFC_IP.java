package br.com.sAFc.interfaces.persistencia; 


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



public interface ContrutorPersistenciaSAFC_IP {
	
	
	public InsumoPersistido [] getInsumoPersistido(SPOInsumo spo);
	public InsumoPersistido getInsumoPersistidoPorIdentficador(String identificador);
	public ProdutoPersistido [] getProdutoPersistido(SPOProduto spo);
	public ProdutoPersistido getProdutoPersistidoPorIdentficador(String identificador);
	public UnidadeMedidaPersistido [] getUnidadeMedidaPersistido(SPOUnidadeMedida spo);
	public UnidadeMedidaPersistido getUnidadeMedidaPersistidoPorIdentficador(String identificador);
	public TipoInsumoPersistido [] getTipoInsumoPersistido(SPOTipoInsumo spo);
	public TipoInsumoPersistido getTipoInsumoPersistidoPorIdentficador(String identificador);
	public ModalAquisicaoPersistido [] getModalAquisicaoPersistido(SPOModalAquisicao spo);
	public ModalAquisicaoPersistido getModalAquisicaoPersistidoPorIdentficador(String identificador);
	public CanalAquisicaoPersistido [] getCanalAquisicaoPersistido(SPOCanalAquisicao spo);
	public CanalAquisicaoPersistido getCanalAquisicaoPersistidoPorIdentficador(String identificador);
	public LinhaProducaoPersistido [] getLinhaProducaoPersistido(SPOLinhaProducao spo);
	public LinhaProducaoPersistido getLinhaProducaoPersistidoPorIdentficador(String identificador);
	public InsumoProdutoPersistido [] getInsumoProdutoPersistido(SPOInsumoProduto spo);
	public InsumoProdutoPersistido getInsumoProdutoPersistidoPorIdentficador(String identificador);
	public DestinacaoPersistido [] getDestinacaoPersistido(SPODestinacao spo);
	public DestinacaoPersistido getDestinacaoPersistidoPorIdentficador(String identificador);
	public CurvaPersistido [] getCurvaPersistido(SPOCurva spo);
	public CurvaPersistido getCurvaPersistidoPorIdentficador(String identificador);
	public PrevisaoVendaPersistido [] getPrevisaoVendaPersistido(SPOPrevisaoVenda spo);
	public PrevisaoVendaPersistido getPrevisaoVendaPersistidoPorIdentficador(String identificador);
	public LoteProducaoPersistido [] getLoteProducaoPersistido(SPOLoteProducao spo);
	public LoteProducaoPersistido getLoteProducaoPersistidoPorIdentficador(String identificador);
	
	
	
	
	public InsumoPersistido  getNovoInsumoPersistido();
	public ProdutoPersistido  getNovoProdutoPersistido();
	public UnidadeMedidaPersistido  getNovoUnidadeMedidaPersistido();
	public TipoInsumoPersistido  getNovoTipoInsumoPersistido();
	public ModalAquisicaoPersistido  getNovoModalAquisicaoPersistido();
	public CanalAquisicaoPersistido  getNovoCanalAquisicaoPersistido();
	public LinhaProducaoPersistido  getNovoLinhaProducaoPersistido();
	public InsumoProdutoPersistido  getNovoInsumoProdutoPersistido();
	public DestinacaoPersistido  getNovoDestinacaoPersistido();
	public CurvaPersistido  getNovoCurvaPersistido();
	public PrevisaoVendaPersistido  getNovoPrevisaoVendaPersistido();
	public LoteProducaoPersistido  getNovoLoteProducaoPersistido();
	
	
}
