package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIAUnidadeMedida;
import br.com.sAFc.interfaces.gui.SPOUnidadeMedida;
import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.nucleo.UnidadeMedida_IN;
import br.com.sAFc.interfaces.persistencia.UnidadeMedidaPersistido;


public class UnidadeMedida extends ObjetoNegocioSAFC implements UnidadeMedida_IN {
	
	
	private UnidadeMedidaPersistido unidadeMedidaPersistido = null; 
	
	
	public static UnidadeMedida_IN[] getUnidadeMedida_IN(SPOUnidadeMedida spo){
		UnidadeMedidaPersistido [] unidadeMedidaPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getUnidadeMedidaPersistido(spo);
		return getUnidadeMedida_IN(unidadeMedidaPersistidos);
	}
	public static UnidadeMedida_IN getUnidadeMedida_INPorIdentficador(String identificador){
		UnidadeMedidaPersistido  unidadeMedidaPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getUnidadeMedidaPersistidoPorIdentficador(identificador);
		return getUmUnidadeMedida_IN(unidadeMedidaPersistido);
	}
	
	
	public static UnidadeMedida_IN[] getUnidadeMedida_IN(UnidadeMedidaPersistido [] unidadeMedidaPersistidos){
		UnidadeMedida_IN[] objs = new UnidadeMedida_IN[unidadeMedidaPersistidos.length];
		for(int i=0;i<unidadeMedidaPersistidos.length;i++){
			objs[i] = new UnidadeMedida(unidadeMedidaPersistidos[i]);
		}
		return objs;
	}
	
	
	public static UnidadeMedida_IN getUmUnidadeMedida_IN(UnidadeMedidaPersistido unidadeMedidaPersistido){
		if(unidadeMedidaPersistido==null)return null;
		UnidadeMedida_IN obj = new UnidadeMedida(unidadeMedidaPersistido);
		return obj;
	}
	
	
	public static UnidadeMedida_IN criarNovoUnidadeMedida_IN(SIAUnidadeMedida sol){
		UnidadeMedidaPersistido  unidadeMedidaPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoUnidadeMedidaPersistido();
		UnidadeMedida_IN obj = new UnidadeMedida(unidadeMedidaPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public UnidadeMedida(UnidadeMedidaPersistido unidadeMedidaPersistido){
		super(unidadeMedidaPersistido);
		this.unidadeMedidaPersistido=unidadeMedidaPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.unidadeMedidaPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		return this.unidadeMedidaPersistido.getNomeUnidadeMedida();
	}
	public void atualizar(Object objDados){
		SIAUnidadeMedida sol  = (SIAUnidadeMedida) objDados;
		this.unidadeMedidaPersistido.setSiglaUnidadeMedida(sol.getSiglaUnidadeMedida());
		this.unidadeMedidaPersistido.setNomeUnidadeMedida(sol.getNomeUnidadeMedida());
		this.unidadeMedidaPersistido.salvar();
	}
	
	
	public String getSiglaUnidadeMedida(){
		return this.unidadeMedidaPersistido.getSiglaUnidadeMedida();
	}
	public String getNomeUnidadeMedida(){
		return this.unidadeMedidaPersistido.getNomeUnidadeMedida();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.unidadeMedidaPersistido.excluir();
	}
	///2 relacionamentos localizados
	
	
	//Acesso aos objetos gcn Insumos
	public Insumo_IN [] getInsumossRelacionados(){
		return Insumo.getInsumo_IN(this.unidadeMedidaPersistido.getRegistroInsumossRelacionados() );
	}
	//Acesso aos objetos gcn Produtos
	public Produto_IN [] getProdutossRelacionados(){
		return Produto.getProduto_IN(this.unidadeMedidaPersistido.getRegistroProdutossRelacionados() );
	}
}
