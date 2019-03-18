package br.com.sAFc.tabelas; 

public class RegistroDestinacao  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.DestinacaoPersistido{
	public RegistroDestinacao() {
			super(TabelaDestinacao.getInstancia());
	}
	
	
	   public int getCodigoDestinacao(){
		      return this.getCampo(TabelaDestinacao.colunaCodigoDestinacao).getValorInt();
	   }
	   public void setCodigoDestinacao(int valor){
		      this.getCampo(TabelaDestinacao.colunaCodigoDestinacao).setValor(valor);
	   }
	
	
	   public String getNomeDestinacao(){
		      return this.getCampo(TabelaDestinacao.colunaNomeDestinacao).getValorString();
	   }
	   public void setNomeDestinacao(String valor){
		      this.getCampo(TabelaDestinacao.colunaNomeDestinacao).setValor(valor);
	   }
	public RegistroProduto[] getRegistroProdutossRelacionados(){
		return  (RegistroProduto[]) TabelaDestinacao.RELACIONAMENTO_Produtos.getRegistrosRelacionados(this);
	}
}
