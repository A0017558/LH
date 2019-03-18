package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIAInsumoProduto;
import br.com.sAFc.interfaces.gui.SPOInsumoProduto;
import br.com.sAFc.interfaces.nucleo.InsumoProduto_IN;
import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.persistencia.InsumoPersistido;
import br.com.sAFc.interfaces.persistencia.InsumoProdutoPersistido;
import br.com.sAFc.interfaces.persistencia.ProdutoPersistido;




public class InsumoProduto extends ObjetoNegocioSAFC implements InsumoProduto_IN {
	
	
	private InsumoProdutoPersistido insumoProdutoPersistido = null; 
	
	
	public static InsumoProduto_IN[] getInsumoProduto_IN(SPOInsumoProduto spo){
		InsumoProdutoPersistido [] insumoProdutoPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getInsumoProdutoPersistido(spo);
		return getInsumoProduto_IN(insumoProdutoPersistidos);
	}
	public static InsumoProduto_IN getInsumoProduto_INPorIdentficador(String identificador){
		InsumoProdutoPersistido  insumoProdutoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getInsumoProdutoPersistidoPorIdentficador(identificador);
		return getUmInsumoProduto_IN(insumoProdutoPersistido);
	}
	
	
	public static InsumoProduto_IN[] getInsumoProduto_IN(InsumoProdutoPersistido [] insumoProdutoPersistidos){
		InsumoProduto_IN[] objs = new InsumoProduto_IN[insumoProdutoPersistidos.length];
		for(int i=0;i<insumoProdutoPersistidos.length;i++){
			objs[i] = new InsumoProduto(insumoProdutoPersistidos[i]);
		}
		return objs;
	}
	
	
	public static InsumoProduto_IN getUmInsumoProduto_IN(InsumoProdutoPersistido insumoProdutoPersistido){
		if(insumoProdutoPersistido==null)return null;
		InsumoProduto_IN obj = new InsumoProduto(insumoProdutoPersistido);
		return obj;
	}
	
	
	public static InsumoProduto_IN criarNovoInsumoProduto_IN(SIAInsumoProduto sol){
		InsumoProdutoPersistido  insumoProdutoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoInsumoProdutoPersistido();
		InsumoProduto_IN obj = new InsumoProduto(insumoProdutoPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public InsumoProduto(InsumoProdutoPersistido insumoProdutoPersistido){
		super(insumoProdutoPersistido);
		this.insumoProdutoPersistido=insumoProdutoPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.insumoProdutoPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		//TODO implementar.
		return "Não implementado!";
	}
	public void atualizar(Object objDados){
		SIAInsumoProduto sol  = (SIAInsumoProduto) objDados;
		this.insumoProdutoPersistido.setQuantidadeInsumoporUnidadeProduto(sol.getQuantidadeInsumoporUnidadeProduto());
		Insumo_IN  objProdutos = sol.getProdutos();
		if(objProdutos==null){
			this.insumoProdutoPersistido.setCodigoinsumo(0);
		}
		else{
			this.insumoProdutoPersistido.setCodigoinsumo(objProdutos.getCodigoInsumo());
		}
		
		Produto_IN  objInsumos = sol.getInsumos();
		if(objInsumos==null){
			this.insumoProdutoPersistido.setCodigoproduto(0);
		}
		else{
			this.insumoProdutoPersistido.setCodigoproduto(objInsumos.getCodigoProduto());
		}
		
		this.insumoProdutoPersistido.salvar();
	}
	
	
	public int getCodigoproduto(){
		return this.insumoProdutoPersistido.getCodigoproduto();
	}
	public int getCodigoinsumo(){
		return this.insumoProdutoPersistido.getCodigoinsumo();
	}
	public int getQuantidadeInsumoporUnidadeProduto(){
		return this.insumoProdutoPersistido.getQuantidadeInsumoporUnidadeProduto();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.insumoProdutoPersistido.excluir();
	}
	///2 relacionamentos localizados
	
	
	//Acesso ao objeto Produtos
	public Insumo_IN getProdutos(){
		InsumoPersistido op = this.insumoProdutoPersistido.getRegistroProdutosRelacionado();
		if(op==null)return null;
		return new Insumo(op);
	}
	//Acesso ao objeto Insumos
	public Produto_IN getInsumos(){
		ProdutoPersistido op = this.insumoProdutoPersistido.getRegistroInsumosRelacionado();
		if(op==null)return null;
		return new Produto(op);
	}
}
