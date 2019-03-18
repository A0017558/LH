package br.com.sAFc.tabelas; 

public class RegistroLinhaProducao  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.LinhaProducaoPersistido{
	public RegistroLinhaProducao() {
			super(TabelaLinhaProducao.getInstancia());
	}
	
	
	   public int getCodigoLinha(){
		      return this.getCampo(TabelaLinhaProducao.colunaCodigoLinha).getValorInt();
	   }
	   public void setCodigoLinha(int valor){
		      this.getCampo(TabelaLinhaProducao.colunaCodigoLinha).setValor(valor);
	   }
	
	
	   public String getNomeLinhaProducao(){
		      return this.getCampo(TabelaLinhaProducao.colunaNomeLinhaProducao).getValorString();
	   }
	   public void setNomeLinhaProducao(String valor){
		      this.getCampo(TabelaLinhaProducao.colunaNomeLinhaProducao).setValor(valor);
	   }
	
	   public int getCapacidadeLinha(){
		      return this.getCampo(TabelaLinhaProducao.colunaCapacidadeLinha).getValorInt();
	   }
	   public void setCapacidadeLinha(int valor){
		      this.getCampo(TabelaLinhaProducao.colunaCapacidadeLinha).setValor(valor);
	   }
	public RegistroProduto[] getRegistroProdutossRelacionados(){
		return  (RegistroProduto[]) TabelaLinhaProducao.RELACIONAMENTO_Produtos.getRegistrosRelacionados(this);
	}
}
