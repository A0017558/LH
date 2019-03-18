package br.com.sAFc.tabelas; 

public class RegistroModalAquisicao  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.ModalAquisicaoPersistido{
	public RegistroModalAquisicao() {
			super(TabelaModalAquisicao.getInstancia());
	}
	
	
	   public int getCodigoModalAquisicao(){
		      return this.getCampo(TabelaModalAquisicao.colunaCodigoModalAquisicao).getValorInt();
	   }
	   public void setCodigoModalAquisicao(int valor){
		      this.getCampo(TabelaModalAquisicao.colunaCodigoModalAquisicao).setValor(valor);
	   }
	
	
	   public String getNomeModalAquisicao(){
		      return this.getCampo(TabelaModalAquisicao.colunaNomeModalAquisicao).getValorString();
	   }
	   public void setNomeModalAquisicao(String valor){
		      this.getCampo(TabelaModalAquisicao.colunaNomeModalAquisicao).setValor(valor);
	   }
	public RegistroInsumo[] getRegistroInsumossRelacionados(){
		return  (RegistroInsumo[]) TabelaModalAquisicao.RELACIONAMENTO_Insumos.getRegistrosRelacionados(this);
	}
}
