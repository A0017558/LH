package br.com.sAFc.tabelas; 

public class RegistroUnidadeMedida  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.UnidadeMedidaPersistido{
	public RegistroUnidadeMedida() {
			super(TabelaUnidadeMedida.getInstancia());
	}
	
	
	   public String getSiglaUnidadeMedida(){
		      return this.getCampo(TabelaUnidadeMedida.colunaSiglaUnidadeMedida).getValorString();
	   }
	   public void setSiglaUnidadeMedida(String valor){
		      this.getCampo(TabelaUnidadeMedida.colunaSiglaUnidadeMedida).setValor(valor);
	   }
	
	
	   public String getNomeUnidadeMedida(){
		      return this.getCampo(TabelaUnidadeMedida.colunaNomeUnidadeMedida).getValorString();
	   }
	   public void setNomeUnidadeMedida(String valor){
		      this.getCampo(TabelaUnidadeMedida.colunaNomeUnidadeMedida).setValor(valor);
	   }
	public RegistroInsumo[] getRegistroInsumossRelacionados(){
		return  (RegistroInsumo[]) TabelaUnidadeMedida.RELACIONAMENTO_Insumos.getRegistrosRelacionados(this);
	}
	public RegistroProduto[] getRegistroProdutossRelacionados(){
		return  (RegistroProduto[]) TabelaUnidadeMedida.RELACIONAMENTO_Produtos.getRegistrosRelacionados(this);
	}
}
