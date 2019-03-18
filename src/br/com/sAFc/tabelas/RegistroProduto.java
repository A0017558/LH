package br.com.sAFc.tabelas; 

public class RegistroProduto  extends br.com.sAFc.tabelas.RegistroSAFC implements br.com.sAFc.interfaces.persistencia.ProdutoPersistido{
	public RegistroProduto() {
			super(TabelaProduto.getInstancia());
	}
	
	
	   public int getCodigoProduto(){
		      return this.getCampo(TabelaProduto.colunaCodigoProduto).getValorInt();
	   }
	   public void setCodigoProduto(int valor){
		      this.getCampo(TabelaProduto.colunaCodigoProduto).setValor(valor);
	   }
	
	
	   public String getNomeProduto(){
		      return this.getCampo(TabelaProduto.colunaNomeProduto).getValorString();
	   }
	   public void setNomeProduto(String valor){
		      this.getCampo(TabelaProduto.colunaNomeProduto).setValor(valor);
	   }
	
	   public int getCodigolinha(){
		      return this.getCampo(TabelaProduto.colunaCodigolinha).getValorInt();
	   }
	   public void setCodigolinha(int valor){
		      this.getCampo(TabelaProduto.colunaCodigolinha).setValor(valor);
	   }
	
	   public String getSiglaunidademedida(){
		      return this.getCampo(TabelaProduto.colunaSiglaunidademedida).getValorString();
	   }
	   public void setSiglaunidademedida(String valor){
		      this.getCampo(TabelaProduto.colunaSiglaunidademedida).setValor(valor);
	   }
	
	   public int getLotePadrao(){
		      return this.getCampo(TabelaProduto.colunaLotePadrao).getValorInt();
	   }
	   public void setLotePadrao(int valor){
		      this.getCampo(TabelaProduto.colunaLotePadrao).setValor(valor);
	   }
	
	   public String getApresentacao(){
		      return this.getCampo(TabelaProduto.colunaApresentacao).getValorString();
	   }
	   public void setApresentacao(String valor){
		      this.getCampo(TabelaProduto.colunaApresentacao).setValor(valor);
	   }
	
	   public int getFatorAjusteProdutividade(){
		      return this.getCampo(TabelaProduto.colunaFatorAjusteProdutividade).getValorInt();
	   }
	   public void setFatorAjusteProdutividade(int valor){
		      this.getCampo(TabelaProduto.colunaFatorAjusteProdutividade).setValor(valor);
	   }
	
	   public int getValorParaVenda(){
		      return this.getCampo(TabelaProduto.colunaValorParaVenda).getValorInt();
	   }
	   public void setValorParaVenda(int valor){
		      this.getCampo(TabelaProduto.colunaValorParaVenda).setValor(valor);
	   }
	
	   public int getCodigodestinacao(){
		      return this.getCampo(TabelaProduto.colunaCodigodestinacao).getValorInt();
	   }
	   public void setCodigodestinacao(int valor){
		      this.getCampo(TabelaProduto.colunaCodigodestinacao).setValor(valor);
	   }
	
	   public String getCodigocurva(){
		      return this.getCampo(TabelaProduto.colunaCodigocurva).getValorString();
	   }
	   public void setCodigocurva(String valor){
		      this.getCampo(TabelaProduto.colunaCodigocurva).setValor(valor);
	   }
	
	   public int getPoliticaEstoque(){
		      return this.getCampo(TabelaProduto.colunaPoliticaEstoque).getValorInt();
	   }
	   public void setPoliticaEstoque(int valor){
		      this.getCampo(TabelaProduto.colunaPoliticaEstoque).setValor(valor);
	   }
	public RegistroInsumoProduto[] getRegistroProdutossRelacionados(){
		return  (RegistroInsumoProduto[]) TabelaProduto.RELACIONAMENTO_Produtos.getRegistrosRelacionados(this);
	}
	public RegistroPrevisaoVenda[] getRegistroPrevisoesVendasRelacionados(){
		return  (RegistroPrevisaoVenda[]) TabelaProduto.RELACIONAMENTO_PrevisoesVenda.getRegistrosRelacionados(this);
	}
	public RegistroLoteProducao[] getRegistroLotessRelacionados(){
		return  (RegistroLoteProducao[]) TabelaProduto.RELACIONAMENTO_Lotes.getRegistrosRelacionados(this);
	}
	public RegistroUnidadeMedida getRegistroUnidadeMedidaRelacionado(){
		return  (RegistroUnidadeMedida) TabelaUnidadeMedida.RELACIONAMENTO_Produtos.getRegistroRelacionado(this);
	}
	public RegistroLinhaProducao getRegistroLinhaProducaoRelacionado(){
		return  (RegistroLinhaProducao) TabelaLinhaProducao.RELACIONAMENTO_Produtos.getRegistroRelacionado(this);
	}
	public RegistroDestinacao getRegistroDestinoRelacionado(){
		return  (RegistroDestinacao) TabelaDestinacao.RELACIONAMENTO_Produtos.getRegistroRelacionado(this);
	}
	public RegistroCurva getRegistroCurvaRelacionado(){
		return  (RegistroCurva) TabelaCurva.RELACIONAMENTO_Produtos.getRegistroRelacionado(this);
	}
}
