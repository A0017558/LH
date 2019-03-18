package br.com.sAFc.tabelas; 

public class RegistroInsumoProduto  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.InsumoProdutoPersistido{
	public RegistroInsumoProduto() {
			super(TabelaInsumoProduto.getInstancia());
	}
	
	
	   public int getCodigoproduto(){
		      return this.getCampo(TabelaInsumoProduto.colunaCodigoproduto).getValorInt();
	   }
	   public void setCodigoproduto(int valor){
		      this.getCampo(TabelaInsumoProduto.colunaCodigoproduto).setValor(valor);
	   }
	
	
	   public int getCodigoinsumo(){
		      return this.getCampo(TabelaInsumoProduto.colunaCodigoinsumo).getValorInt();
	   }
	   public void setCodigoinsumo(int valor){
		      this.getCampo(TabelaInsumoProduto.colunaCodigoinsumo).setValor(valor);
	   }
	
	
	   public int getQuantidadeInsumoporUnidadeProduto(){
		      return this.getCampo(TabelaInsumoProduto.colunaQuantidadeInsumoporUnidadeProduto).getValorInt();
	   }
	   public void setQuantidadeInsumoporUnidadeProduto(int valor){
		      this.getCampo(TabelaInsumoProduto.colunaQuantidadeInsumoporUnidadeProduto).setValor(valor);
	   }
	public RegistroInsumo getRegistroProdutosRelacionado(){
		return  (RegistroInsumo) TabelaInsumo.RELACIONAMENTO_Insumos.getRegistroRelacionado(this);
	}
	public RegistroProduto getRegistroInsumosRelacionado(){
		return  (RegistroProduto) TabelaProduto.RELACIONAMENTO_Produtos.getRegistroRelacionado(this);
	}
}
