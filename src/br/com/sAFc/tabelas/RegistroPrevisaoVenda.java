package br.com.sAFc.tabelas; 

public class RegistroPrevisaoVenda  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.PrevisaoVendaPersistido{
	public RegistroPrevisaoVenda() {
			super(TabelaPrevisaoVenda.getInstancia());
	}
	
	
	   public int getNumeroPrevisao(){
		      return this.getCampo(TabelaPrevisaoVenda.colunaNumeroPrevisao).getValorInt();
	   }
	   public void setNumeroPrevisao(int valor){
		      this.getCampo(TabelaPrevisaoVenda.colunaNumeroPrevisao).setValor(valor);
	   }
	
	
	   public java.util.GregorianCalendar getDataPrevisaoVenda(){
		      return this.getCampo(TabelaPrevisaoVenda.colunaDataPrevisaoVenda).getValorGregorianCalendar();
	   }
	   public void setDataPrevisaoVenda(java.util.GregorianCalendar valor){
		      this.getCampo(TabelaPrevisaoVenda.colunaDataPrevisaoVenda).setValor(valor);
	   }
	
	
	   public int getCodigoproduto(){
		      return this.getCampo(TabelaPrevisaoVenda.colunaCodigoproduto).getValorInt();
	   }
	   public void setCodigoproduto(int valor){
		      this.getCampo(TabelaPrevisaoVenda.colunaCodigoproduto).setValor(valor);
	   }
	
	   public int getQuantidadeProduto(){
		      return this.getCampo(TabelaPrevisaoVenda.colunaQuantidadeProduto).getValorInt();
	   }
	   public void setQuantidadeProduto(int valor){
		      this.getCampo(TabelaPrevisaoVenda.colunaQuantidadeProduto).setValor(valor);
	   }
	public RegistroProduto getRegistroProdutoRelacionado(){
		return  (RegistroProduto) TabelaProduto.RELACIONAMENTO_PrevisoesVenda.getRegistroRelacionado(this);
	}
}
