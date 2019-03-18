package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIAProduto;
import br.com.sAFc.interfaces.gui.SPOProduto;
import br.com.sAFc.interfaces.nucleo.Curva_IN;
import br.com.sAFc.interfaces.nucleo.Destinacao_IN;
import br.com.sAFc.interfaces.nucleo.InsumoProduto_IN;
import br.com.sAFc.interfaces.nucleo.LinhaProducao_IN;
import br.com.sAFc.interfaces.nucleo.LoteProducao_IN;
import br.com.sAFc.interfaces.nucleo.PrevisaoVenda_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;
import br.com.sAFc.interfaces.persistencia.CurvaPersistido;
import br.com.sAFc.interfaces.persistencia.DestinacaoPersistido;
import br.com.sAFc.interfaces.persistencia.LinhaProducaoPersistido;
import br.com.sAFc.interfaces.persistencia.ProdutoPersistido;
import br.com.sAFc.interfaces.persistencia.UnidadeMedidaPersistido;


public class Produto extends ObjetoNegocioSAFC implements Produto_IN {
	
	
	private ProdutoPersistido produtoPersistido = null; 
	
	
	public static Produto_IN[] getProduto_IN(SPOProduto spo){
		ProdutoPersistido [] produtoPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getProdutoPersistido(spo);
		return getProduto_IN(produtoPersistidos);
	}
	public static Produto_IN getProduto_INPorIdentficador(String identificador){
		ProdutoPersistido  produtoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getProdutoPersistidoPorIdentficador(identificador);
		return getUmProduto_IN(produtoPersistido);
	}
	
	
	public static Produto_IN[] getProduto_IN(ProdutoPersistido [] produtoPersistidos){
		Produto_IN[] objs = new Produto_IN[produtoPersistidos.length];
		for(int i=0;i<produtoPersistidos.length;i++){
			objs[i] = new Produto(produtoPersistidos[i]);
		}
		return objs;
	}
	
	
	public static Produto_IN getUmProduto_IN(ProdutoPersistido produtoPersistido){
		if(produtoPersistido==null)return null;
		Produto_IN obj = new Produto(produtoPersistido);
		return obj;
	}
	
	
	public static Produto_IN criarNovoProduto_IN(SIAProduto sol){
		ProdutoPersistido  produtoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoProdutoPersistido();
		Produto_IN obj = new Produto(produtoPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public Produto(ProdutoPersistido produtoPersistido){
		super(produtoPersistido);
		this.produtoPersistido=produtoPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.produtoPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		return this.produtoPersistido.getNomeProduto();
	}
	public void atualizar(Object objDados){
		SIAProduto sol  = (SIAProduto) objDados;
		/// [CodigoProduto] autoincremental
		this.produtoPersistido.setNomeProduto(sol.getNomeProduto());
		this.produtoPersistido.setLotePadrao(sol.getLotePadrao());
		this.produtoPersistido.setApresentacao(sol.getApresentacao());
		this.produtoPersistido.setFatorAjusteProdutividade(sol.getFatorAjusteProdutividade());
		this.produtoPersistido.setValorParaVenda(sol.getValorParaVenda());
		this.produtoPersistido.setPoliticaEstoque(sol.getPoliticaEstoque());
		UnidadeMedida_IN  objUnidadeMedida = sol.getUnidadeMedida();
		if(objUnidadeMedida==null){
			this.produtoPersistido.setSiglaunidademedida(null);
		}
		else{
			this.produtoPersistido.setSiglaunidademedida(objUnidadeMedida.getSiglaUnidadeMedida());
		}
		
		LinhaProducao_IN  objLinhaProducao = sol.getLinhaProducao();
		if(objLinhaProducao==null){
			this.produtoPersistido.setCodigolinha(0);
		}
		else{
			this.produtoPersistido.setCodigolinha(objLinhaProducao.getCodigoLinha());
		}
		
		Destinacao_IN  objDestino = sol.getDestino();
		if(objDestino==null){
			this.produtoPersistido.setCodigodestinacao(0);
		}
		else{
			this.produtoPersistido.setCodigodestinacao(objDestino.getCodigoDestinacao());
		}
		
		Curva_IN  objCurva = sol.getCurva();
		if(objCurva==null){
			this.produtoPersistido.setCodigocurva(null);
		}
		else{
			this.produtoPersistido.setCodigocurva(objCurva.getCodigoCurva());
		}
		
		this.produtoPersistido.salvar();
	}
	
	
	public int getCodigoProduto(){
		return this.produtoPersistido.getCodigoProduto();
	}
	public String getNomeProduto(){
		return this.produtoPersistido.getNomeProduto();
	}
	public int getCodigolinha(){
		return this.produtoPersistido.getCodigolinha();
	}
	public String getSiglaunidademedida(){
		return this.produtoPersistido.getSiglaunidademedida();
	}
	public int getLotePadrao(){
		return this.produtoPersistido.getLotePadrao();
	}
	public String getApresentacao(){
		return this.produtoPersistido.getApresentacao();
	}
	public int getFatorAjusteProdutividade(){
		return this.produtoPersistido.getFatorAjusteProdutividade();
	}
	public int getValorParaVenda(){
		return this.produtoPersistido.getValorParaVenda();
	}
	public int getCodigodestinacao(){
		return this.produtoPersistido.getCodigodestinacao();
	}
	public String getCodigocurva(){
		return this.produtoPersistido.getCodigocurva();
	}
	public int getPoliticaEstoque(){
		return this.produtoPersistido.getPoliticaEstoque();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.produtoPersistido.excluir();
	}
	///7 relacionamentos localizados
	
	
	//Acesso aos objetos gcn Produtos
	public InsumoProduto_IN [] getProdutossRelacionados(){
		return InsumoProduto.getInsumoProduto_IN(this.produtoPersistido.getRegistroProdutossRelacionados() );
	}
	//Acesso aos objetos gcn PrevisoesVenda
	public PrevisaoVenda_IN [] getPrevisoesVendasRelacionados(){
		return PrevisaoVenda.getPrevisaoVenda_IN(this.produtoPersistido.getRegistroPrevisoesVendasRelacionados() );
	}
	//Acesso aos objetos gcn Lotes
	public LoteProducao_IN [] getLotessRelacionados(){
		return LoteProducao.getLoteProducao_IN(this.produtoPersistido.getRegistroLotessRelacionados() );
	}
	//Acesso ao objeto UnidadeMedida
	public UnidadeMedida_IN getUnidadeMedida(){
		UnidadeMedidaPersistido op = this.produtoPersistido.getRegistroUnidadeMedidaRelacionado();
		if(op==null)return null;
		return new UnidadeMedida(op);
	}
	//Acesso ao objeto LinhaProducao
	public LinhaProducao_IN getLinhaProducao(){
		LinhaProducaoPersistido op = this.produtoPersistido.getRegistroLinhaProducaoRelacionado();
		if(op==null)return null;
		return new LinhaProducao(op);
	}
	//Acesso ao objeto Destino
	public Destinacao_IN getDestino(){
		DestinacaoPersistido op = this.produtoPersistido.getRegistroDestinoRelacionado();
		if(op==null)return null;
		return new Destinacao(op);
	}
	//Acesso ao objeto Curva
	public Curva_IN getCurva(){
		CurvaPersistido op = this.produtoPersistido.getRegistroCurvaRelacionado();
		if(op==null)return null;
		return new Curva(op);
	}
}
