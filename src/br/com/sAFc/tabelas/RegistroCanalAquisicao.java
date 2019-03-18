package br.com.sAFc.tabelas; 

public class RegistroCanalAquisicao  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.CanalAquisicaoPersistido{
	public RegistroCanalAquisicao() {
			super(TabelaCanalAquisicao.getInstancia());
	}
	
	
	   public int getCodigoCanalAquisicao(){
		      return this.getCampo(TabelaCanalAquisicao.colunaCodigoCanalAquisicao).getValorInt();
	   }
	   public void setCodigoCanalAquisicao(int valor){
		      this.getCampo(TabelaCanalAquisicao.colunaCodigoCanalAquisicao).setValor(valor);
	   }
	
	
	   public String getCanalAquisicao(){
		      return this.getCampo(TabelaCanalAquisicao.colunaCanalAquisicao).getValorString();
	   }
	   public void setCanalAquisicao(String valor){
		      this.getCampo(TabelaCanalAquisicao.colunaCanalAquisicao).setValor(valor);
	   }
	public RegistroInsumo[] getRegistroInsumossRelacionados(){
		return  (RegistroInsumo[]) TabelaCanalAquisicao.RELACIONAMENTO_Insumos.getRegistrosRelacionados(this);
	}
}
