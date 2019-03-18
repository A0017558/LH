package br.com.sAFc.persistencia; 


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
import br.com.sAFc.interfaces.persistencia.CanalAquisicaoPersistido;
import br.com.sAFc.interfaces.persistencia.ContrutorPersistenciaSAFC_IP;
import br.com.sAFc.interfaces.persistencia.CurvaPersistido;
import br.com.sAFc.interfaces.persistencia.DestinacaoPersistido;
import br.com.sAFc.interfaces.persistencia.InsumoPersistido;
import br.com.sAFc.interfaces.persistencia.InsumoProdutoPersistido;
import br.com.sAFc.interfaces.persistencia.LinhaProducaoPersistido;
import br.com.sAFc.interfaces.persistencia.LoteProducaoPersistido;
import br.com.sAFc.interfaces.persistencia.ModalAquisicaoPersistido;
import br.com.sAFc.interfaces.persistencia.PrevisaoVendaPersistido;
import br.com.sAFc.interfaces.persistencia.ProdutoPersistido;
import br.com.sAFc.interfaces.persistencia.TipoInsumoPersistido;
import br.com.sAFc.interfaces.persistencia.UnidadeMedidaPersistido;
import br.com.sAFc.tabelas.TabelaCanalAquisicao;
import br.com.sAFc.tabelas.TabelaCurva;
import br.com.sAFc.tabelas.TabelaDestinacao;
import br.com.sAFc.tabelas.TabelaInsumo;
import br.com.sAFc.tabelas.TabelaInsumoProduto;
import br.com.sAFc.tabelas.TabelaLinhaProducao;
import br.com.sAFc.tabelas.TabelaLoteProducao;
import br.com.sAFc.tabelas.TabelaModalAquisicao;
import br.com.sAFc.tabelas.TabelaPrevisaoVenda;
import br.com.sAFc.tabelas.TabelaProduto;
import br.com.sAFc.tabelas.TabelaTipoInsumo;
import br.com.sAFc.tabelas.TabelaUnidadeMedida;


public class ContrutorPersistenciaSAFC  implements ContrutorPersistenciaSAFC_IP {
	
	
	public InsumoPersistido [] getInsumoPersistido(SPOInsumo spo){
		return (InsumoPersistido[]) TabelaInsumo.getInstancia().getRegistros(spo);
	}
	public InsumoPersistido getInsumoPersistidoPorIdentficador(String identificador){
		return (InsumoPersistido) TabelaInsumo.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public ProdutoPersistido [] getProdutoPersistido(SPOProduto spo){
		return (ProdutoPersistido[]) TabelaProduto.getInstancia().getRegistros(spo);
	}
	public ProdutoPersistido getProdutoPersistidoPorIdentficador(String identificador){
		return (ProdutoPersistido) TabelaProduto.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public UnidadeMedidaPersistido [] getUnidadeMedidaPersistido(SPOUnidadeMedida spo){
		return (UnidadeMedidaPersistido[]) TabelaUnidadeMedida.getInstancia().getRegistros(spo);
	}
	public UnidadeMedidaPersistido getUnidadeMedidaPersistidoPorIdentficador(String identificador){
		return (UnidadeMedidaPersistido) TabelaUnidadeMedida.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public TipoInsumoPersistido [] getTipoInsumoPersistido(SPOTipoInsumo spo){
		return (TipoInsumoPersistido[]) TabelaTipoInsumo.getInstancia().getRegistros(spo);
	}
	public TipoInsumoPersistido getTipoInsumoPersistidoPorIdentficador(String identificador){
		return (TipoInsumoPersistido) TabelaTipoInsumo.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public ModalAquisicaoPersistido [] getModalAquisicaoPersistido(SPOModalAquisicao spo){
		return (ModalAquisicaoPersistido[]) TabelaModalAquisicao.getInstancia().getRegistros(spo);
	}
	public ModalAquisicaoPersistido getModalAquisicaoPersistidoPorIdentficador(String identificador){
		return (ModalAquisicaoPersistido) TabelaModalAquisicao.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public CanalAquisicaoPersistido [] getCanalAquisicaoPersistido(SPOCanalAquisicao spo){
		return (CanalAquisicaoPersistido[]) TabelaCanalAquisicao.getInstancia().getRegistros(spo);
	}
	public CanalAquisicaoPersistido getCanalAquisicaoPersistidoPorIdentficador(String identificador){
		return (CanalAquisicaoPersistido) TabelaCanalAquisicao.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public LinhaProducaoPersistido [] getLinhaProducaoPersistido(SPOLinhaProducao spo){
		return (LinhaProducaoPersistido[]) TabelaLinhaProducao.getInstancia().getRegistros(spo);
	}
	public LinhaProducaoPersistido getLinhaProducaoPersistidoPorIdentficador(String identificador){
		return (LinhaProducaoPersistido) TabelaLinhaProducao.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public InsumoProdutoPersistido [] getInsumoProdutoPersistido(SPOInsumoProduto spo){
		return (InsumoProdutoPersistido[]) TabelaInsumoProduto.getInstancia().getRegistros(spo);
	}
	public InsumoProdutoPersistido getInsumoProdutoPersistidoPorIdentficador(String identificador){
		return (InsumoProdutoPersistido) TabelaInsumoProduto.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public DestinacaoPersistido [] getDestinacaoPersistido(SPODestinacao spo){
		return (DestinacaoPersistido[]) TabelaDestinacao.getInstancia().getRegistros(spo);
	}
	public DestinacaoPersistido getDestinacaoPersistidoPorIdentficador(String identificador){
		return (DestinacaoPersistido) TabelaDestinacao.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public CurvaPersistido [] getCurvaPersistido(SPOCurva spo){
		return (CurvaPersistido[]) TabelaCurva.getInstancia().getRegistros(spo);
	}
	public CurvaPersistido getCurvaPersistidoPorIdentficador(String identificador){
		return (CurvaPersistido) TabelaCurva.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public PrevisaoVendaPersistido [] getPrevisaoVendaPersistido(SPOPrevisaoVenda spo){
		return (PrevisaoVendaPersistido[]) TabelaPrevisaoVenda.getInstancia().getRegistros(spo);
	}
	public PrevisaoVendaPersistido getPrevisaoVendaPersistidoPorIdentficador(String identificador){
		return (PrevisaoVendaPersistido) TabelaPrevisaoVenda.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	public LoteProducaoPersistido [] getLoteProducaoPersistido(SPOLoteProducao spo){
		return (LoteProducaoPersistido[]) TabelaLoteProducao.getInstancia().getRegistros(spo);
	}
	public LoteProducaoPersistido getLoteProducaoPersistidoPorIdentficador(String identificador){
		return (LoteProducaoPersistido) TabelaLoteProducao.getInstancia().getRegistroPorChaveReduzida(identificador);
	}
	
	
	
	
	public InsumoPersistido  getNovoInsumoPersistido(){
		return (InsumoPersistido) TabelaInsumo.getInstancia().getRegistroVazio();
	}
	public ProdutoPersistido  getNovoProdutoPersistido(){
		return (ProdutoPersistido) TabelaProduto.getInstancia().getRegistroVazio();
	}
	public UnidadeMedidaPersistido  getNovoUnidadeMedidaPersistido(){
		return (UnidadeMedidaPersistido) TabelaUnidadeMedida.getInstancia().getRegistroVazio();
	}
	public TipoInsumoPersistido  getNovoTipoInsumoPersistido(){
		return (TipoInsumoPersistido) TabelaTipoInsumo.getInstancia().getRegistroVazio();
	}
	public ModalAquisicaoPersistido  getNovoModalAquisicaoPersistido(){
		return (ModalAquisicaoPersistido) TabelaModalAquisicao.getInstancia().getRegistroVazio();
	}
	public CanalAquisicaoPersistido  getNovoCanalAquisicaoPersistido(){
		return (CanalAquisicaoPersistido) TabelaCanalAquisicao.getInstancia().getRegistroVazio();
	}
	public LinhaProducaoPersistido  getNovoLinhaProducaoPersistido(){
		return (LinhaProducaoPersistido) TabelaLinhaProducao.getInstancia().getRegistroVazio();
	}
	public InsumoProdutoPersistido  getNovoInsumoProdutoPersistido(){
		return (InsumoProdutoPersistido) TabelaInsumoProduto.getInstancia().getRegistroVazio();
	}
	public DestinacaoPersistido  getNovoDestinacaoPersistido(){
		return (DestinacaoPersistido) TabelaDestinacao.getInstancia().getRegistroVazio();
	}
	public CurvaPersistido  getNovoCurvaPersistido(){
		return (CurvaPersistido) TabelaCurva.getInstancia().getRegistroVazio();
	}
	public PrevisaoVendaPersistido  getNovoPrevisaoVendaPersistido(){
		return (PrevisaoVendaPersistido) TabelaPrevisaoVenda.getInstancia().getRegistroVazio();
	}
	public LoteProducaoPersistido  getNovoLoteProducaoPersistido(){
		return (LoteProducaoPersistido) TabelaLoteProducao.getInstancia().getRegistroVazio();
	}
	
	
}
