package br.com.sAFc.tabelas; 

public class RegistroCurva  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.CurvaPersistido{
	public RegistroCurva() {
			super(TabelaCurva.getInstancia());
	}
	
	
	   public String getCodigoCurva(){
		      return this.getCampo(TabelaCurva.colunaCodigoCurva).getValorString();
	   }
	   public void setCodigoCurva(String valor){
		      this.getCampo(TabelaCurva.colunaCodigoCurva).setValor(valor);
	   }
	
	public RegistroProduto[] getRegistroProdutossRelacionados(){
		return  (RegistroProduto[]) TabelaCurva.RELACIONAMENTO_Produtos.getRegistrosRelacionados(this);
	}
}
