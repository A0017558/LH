package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIAInsumo;
import br.com.sAFc.interfaces.gui.SPOInsumo;
import br.com.sAFc.interfaces.nucleo.CanalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.InsumoProduto_IN;
import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.ModalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.TipoInsumo_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;
import br.com.sAFc.interfaces.persistencia.CanalAquisicaoPersistido;
import br.com.sAFc.interfaces.persistencia.InsumoPersistido;
import br.com.sAFc.interfaces.persistencia.ModalAquisicaoPersistido;
import br.com.sAFc.interfaces.persistencia.TipoInsumoPersistido;
import br.com.sAFc.interfaces.persistencia.UnidadeMedidaPersistido;


public class Insumo extends ObjetoNegocioSAFC implements Insumo_IN {
	
	
	private InsumoPersistido insumoPersistido = null; 
	
	
	public static Insumo_IN[] getInsumo_IN(SPOInsumo spo){
		InsumoPersistido [] insumoPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getInsumoPersistido(spo);
		return getInsumo_IN(insumoPersistidos);
	}
	public static Insumo_IN getInsumo_INPorIdentficador(String identificador){
		InsumoPersistido  insumoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getInsumoPersistidoPorIdentficador(identificador);
		return getUmInsumo_IN(insumoPersistido);
	}
	
	
	public static Insumo_IN[] getInsumo_IN(InsumoPersistido [] insumoPersistidos){
		Insumo_IN[] objs = new Insumo_IN[insumoPersistidos.length];
		for(int i=0;i<insumoPersistidos.length;i++){
			objs[i] = new Insumo(insumoPersistidos[i]);
		}
		return objs;
	}
	
	
	public static Insumo_IN getUmInsumo_IN(InsumoPersistido insumoPersistido){
		if(insumoPersistido==null)return null;
		Insumo_IN obj = new Insumo(insumoPersistido);
		return obj;
	}
	
	
	public static Insumo_IN criarNovoInsumo_IN(SIAInsumo sol){
		InsumoPersistido  insumoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoInsumoPersistido();
		Insumo_IN obj = new Insumo(insumoPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public Insumo(InsumoPersistido insumoPersistido){
		super(insumoPersistido);
		this.insumoPersistido=insumoPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.insumoPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		return this.insumoPersistido.getNomeInsumo();
	}
	public void atualizar(Object objDados){
		SIAInsumo sol  = (SIAInsumo) objDados;
		/// [CodigoInsumo] autoincremental
		this.insumoPersistido.setNomeInsumo(sol.getNomeInsumo());
		this.insumoPersistido.setTempoParaAquisicao(sol.getTempoParaAquisicao());
		this.insumoPersistido.setTempoLiberacao(sol.getTempoLiberacao());
		this.insumoPersistido.setCompraMinima(sol.getCompraMinima());
		this.insumoPersistido.setUnidadeCompra(sol.getUnidadeCompra());
		this.insumoPersistido.setValorParaAquisicao(sol.getValorParaAquisicao());
		UnidadeMedida_IN  objUnidadeMedida = sol.getUnidadeMedida();
		if(objUnidadeMedida==null){
			this.insumoPersistido.setSiglaunidademedida(null);
		}
		else{
			this.insumoPersistido.setSiglaunidademedida(objUnidadeMedida.getSiglaUnidadeMedida());
		}
		
		TipoInsumo_IN  objTipoInsumo = sol.getTipoInsumo();
		if(objTipoInsumo==null){
			this.insumoPersistido.setCodigotipoinsumo(0);
		}
		else{
			this.insumoPersistido.setCodigotipoinsumo(objTipoInsumo.getCodigoTipoInsumo());
		}
		
		ModalAquisicao_IN  objModalAquisicao = sol.getModalAquisicao();
		if(objModalAquisicao==null){
			this.insumoPersistido.setCodigomodalaquisicao(0);
		}
		else{
			this.insumoPersistido.setCodigomodalaquisicao(objModalAquisicao.getCodigoModalAquisicao());
		}
		
		CanalAquisicao_IN  objCanalAquisicao = sol.getCanalAquisicao();
		if(objCanalAquisicao==null){
			this.insumoPersistido.setCodigocanalaquisicao(0);
		}
		else{
			this.insumoPersistido.setCodigocanalaquisicao(objCanalAquisicao.getCodigoCanalAquisicao());
		}
		
		this.insumoPersistido.salvar();
	}
	
	
	public int getCodigoInsumo(){
		return this.insumoPersistido.getCodigoInsumo();
	}
	public String getNomeInsumo(){
		return this.insumoPersistido.getNomeInsumo();
	}
	public String getSiglaunidademedida(){
		return this.insumoPersistido.getSiglaunidademedida();
	}
	public int getCodigotipoinsumo(){
		return this.insumoPersistido.getCodigotipoinsumo();
	}
	public int getCodigomodalaquisicao(){
		return this.insumoPersistido.getCodigomodalaquisicao();
	}
	public int getCodigocanalaquisicao(){
		return this.insumoPersistido.getCodigocanalaquisicao();
	}
	public int getTempoParaAquisicao(){
		return this.insumoPersistido.getTempoParaAquisicao();
	}
	public int getTempoLiberacao(){
		return this.insumoPersistido.getTempoLiberacao();
	}
	public int getCompraMinima(){
		return this.insumoPersistido.getCompraMinima();
	}
	public int getUnidadeCompra(){
		return this.insumoPersistido.getUnidadeCompra();
	}
	public int getValorParaAquisicao(){
		return this.insumoPersistido.getValorParaAquisicao();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.insumoPersistido.excluir();
	}
	///5 relacionamentos localizados
	
	
	//Acesso aos objetos gcn Insumos
	public InsumoProduto_IN [] getInsumossRelacionados(){
		return InsumoProduto.getInsumoProduto_IN(this.insumoPersistido.getRegistroInsumossRelacionados() );
	}
	//Acesso ao objeto UnidadeMedida
	public UnidadeMedida_IN getUnidadeMedida(){
		UnidadeMedidaPersistido op = this.insumoPersistido.getRegistroUnidadeMedidaRelacionado();
		if(op==null)return null;
		return new UnidadeMedida(op);
	}
	//Acesso ao objeto TipoInsumo
	public TipoInsumo_IN getTipoInsumo(){
		TipoInsumoPersistido op = this.insumoPersistido.getRegistroTipoInsumoRelacionado();
		if(op==null)return null;
		return new TipoInsumo(op);
	}
	//Acesso ao objeto ModalAquisicao
	public ModalAquisicao_IN getModalAquisicao(){
		ModalAquisicaoPersistido op = this.insumoPersistido.getRegistroModalAquisicaoRelacionado();
		if(op==null)return null;
		return new ModalAquisicao(op);
	}
	//Acesso ao objeto CanalAquisicao
	public CanalAquisicao_IN getCanalAquisicao(){
		CanalAquisicaoPersistido op = this.insumoPersistido.getRegistroCanalAquisicaoRelacionado();
		if(op==null)return null;
		return new CanalAquisicao(op);
	}
}
