package br.com.sAFc.tabelas; 

public class RegistroTipoInsumo  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.TipoInsumoPersistido{
	public RegistroTipoInsumo() {
			super(TabelaTipoInsumo.getInstancia());
	}
	
	
	   public int getCodigoTipoInsumo(){
		      return this.getCampo(TabelaTipoInsumo.colunaCodigoTipoInsumo).getValorInt();
	   }
	   public void setCodigoTipoInsumo(int valor){
		      this.getCampo(TabelaTipoInsumo.colunaCodigoTipoInsumo).setValor(valor);
	   }
	
	
	   public String getNomeTipoInsumo(){
		      return this.getCampo(TabelaTipoInsumo.colunaNomeTipoInsumo).getValorString();
	   }
	   public void setNomeTipoInsumo(String valor){
		      this.getCampo(TabelaTipoInsumo.colunaNomeTipoInsumo).setValor(valor);
	   }
	public RegistroInsumo[] getRegistroInsumossRelacionados(){
		return  (RegistroInsumo[]) TabelaTipoInsumo.RELACIONAMENTO_Insumos.getRegistrosRelacionados(this);
	}
}
