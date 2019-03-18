package br.com.sAFc.tabelas; 

public class RegistroLoteProducao  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.LoteProducaoPersistido{
	public RegistroLoteProducao() {
			super(TabelaLoteProducao.getInstancia());
	}
	
	
	   public int getCodigoLote(){
		      return this.getCampo(TabelaLoteProducao.colunaCodigoLote).getValorInt();
	   }
	   public void setCodigoLote(int valor){
		      this.getCampo(TabelaLoteProducao.colunaCodigoLote).setValor(valor);
	   }
	
	
	   public int getCodigoproduto(){
		      return this.getCampo(TabelaLoteProducao.colunaCodigoproduto).getValorInt();
	   }
	   public void setCodigoproduto(int valor){
		      this.getCampo(TabelaLoteProducao.colunaCodigoproduto).setValor(valor);
	   }
	public RegistroProduto getRegistroProdutoRelacionado(){
		return  (RegistroProduto) TabelaProduto.RELACIONAMENTO_Lotes.getRegistroRelacionado(this);
	}
}
