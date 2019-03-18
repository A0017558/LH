package br.com.sAFc.tabelas; 

public class RegistroInsumo  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.InsumoPersistido{
	public RegistroInsumo() {
			super(TabelaInsumo.getInstancia());
	}
	
	
	   public int getCodigoInsumo(){
		      return this.getCampo(TabelaInsumo.colunaCodigoInsumo).getValorInt();
	   }
	   public void setCodigoInsumo(int valor){
		      this.getCampo(TabelaInsumo.colunaCodigoInsumo).setValor(valor);
	   }
	
	
	   public String getNomeInsumo(){
		      return this.getCampo(TabelaInsumo.colunaNomeInsumo).getValorString();
	   }
	   public void setNomeInsumo(String valor){
		      this.getCampo(TabelaInsumo.colunaNomeInsumo).setValor(valor);
	   }
	
	   public String getSiglaunidademedida(){
		      return this.getCampo(TabelaInsumo.colunaSiglaunidademedida).getValorString();
	   }
	   public void setSiglaunidademedida(String valor){
		      this.getCampo(TabelaInsumo.colunaSiglaunidademedida).setValor(valor);
	   }
	
	   public int getCodigotipoinsumo(){
		      return this.getCampo(TabelaInsumo.colunaCodigotipoinsumo).getValorInt();
	   }
	   public void setCodigotipoinsumo(int valor){
		      this.getCampo(TabelaInsumo.colunaCodigotipoinsumo).setValor(valor);
	   }
	
	   public int getCodigomodalaquisicao(){
		      return this.getCampo(TabelaInsumo.colunaCodigomodalaquisicao).getValorInt();
	   }
	   public void setCodigomodalaquisicao(int valor){
		      this.getCampo(TabelaInsumo.colunaCodigomodalaquisicao).setValor(valor);
	   }
	
	   public int getCodigocanalaquisicao(){
		      return this.getCampo(TabelaInsumo.colunaCodigocanalaquisicao).getValorInt();
	   }
	   public void setCodigocanalaquisicao(int valor){
		      this.getCampo(TabelaInsumo.colunaCodigocanalaquisicao).setValor(valor);
	   }
	
	   public int getTempoParaAquisicao(){
		      return this.getCampo(TabelaInsumo.colunaTempoParaAquisicao).getValorInt();
	   }
	   public void setTempoParaAquisicao(int valor){
		      this.getCampo(TabelaInsumo.colunaTempoParaAquisicao).setValor(valor);
	   }
	
	   public int getTempoLiberacao(){
		      return this.getCampo(TabelaInsumo.colunaTempoLiberacao).getValorInt();
	   }
	   public void setTempoLiberacao(int valor){
		      this.getCampo(TabelaInsumo.colunaTempoLiberacao).setValor(valor);
	   }
	
	   public int getCompraMinima(){
		      return this.getCampo(TabelaInsumo.colunaCompraMinima).getValorInt();
	   }
	   public void setCompraMinima(int valor){
		      this.getCampo(TabelaInsumo.colunaCompraMinima).setValor(valor);
	   }
	
	   public int getUnidadeCompra(){
		      return this.getCampo(TabelaInsumo.colunaUnidadeCompra).getValorInt();
	   }
	   public void setUnidadeCompra(int valor){
		      this.getCampo(TabelaInsumo.colunaUnidadeCompra).setValor(valor);
	   }
	
	   public int getValorParaAquisicao(){
		      return this.getCampo(TabelaInsumo.colunaValorParaAquisicao).getValorInt();
	   }
	   public void setValorParaAquisicao(int valor){
		      this.getCampo(TabelaInsumo.colunaValorParaAquisicao).setValor(valor);
	   }
	public RegistroInsumoProduto[] getRegistroInsumossRelacionados(){
		return  (RegistroInsumoProduto[]) TabelaInsumo.RELACIONAMENTO_Insumos.getRegistrosRelacionados(this);
	}
	public RegistroUnidadeMedida getRegistroUnidadeMedidaRelacionado(){
		return  (RegistroUnidadeMedida) TabelaUnidadeMedida.RELACIONAMENTO_Insumos.getRegistroRelacionado(this);
	}
	public RegistroTipoInsumo getRegistroTipoInsumoRelacionado(){
		return  (RegistroTipoInsumo) TabelaTipoInsumo.RELACIONAMENTO_Insumos.getRegistroRelacionado(this);
	}
	public RegistroModalAquisicao getRegistroModalAquisicaoRelacionado(){
		return  (RegistroModalAquisicao) TabelaModalAquisicao.RELACIONAMENTO_Insumos.getRegistroRelacionado(this);
	}
	public RegistroCanalAquisicao getRegistroCanalAquisicaoRelacionado(){
		return  (RegistroCanalAquisicao) TabelaCanalAquisicao.RELACIONAMENTO_Insumos.getRegistroRelacionado(this);
	}
}
