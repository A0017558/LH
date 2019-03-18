package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOInsumoProduto;
public class TabelaInsumoProduto extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.ISM_PRD";
	
	
	private static TabelaInsumoProduto instancia = new TabelaInsumoProduto();
	
	
	public static TabelaInsumoProduto getInstancia(){return TabelaInsumoProduto.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoproduto = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_PRD",instancia,true,true){
		public String getNomeColunaTabelaOrigem() {
			return TabelaProduto.colunaCodigoProduto.getNome();
		};
	};
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoinsumo = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_ISM",instancia,true,true){
		public String getNomeColunaTabelaOrigem() {
			return TabelaInsumo.colunaCodigoInsumo.getNome();
		};
	};
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaQuantidadeInsumoporUnidadeProduto = new br.com.sAFc.tabelas.ColunaIntSAFC("QT_ISM_UND_PRD",instancia,false);
	
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoproduto,
		colunaCodigoinsumo,
		colunaQuantidadeInsumoporUnidadeProduto
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaInsumoProduto() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroInsumoProduto();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroInsumoProduto[numeroRegistros];
	   }
	
	
	   public RegistroInsumoProduto getNovoRegistroInsumoProduto(){
		      return (RegistroInsumoProduto)this.getRegistroVazio();
	   }
	
	
	   public RegistroInsumoProduto[] getRegistrosInsumoProduto(String clausulaWhere){
		      return (RegistroInsumoProduto[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroInsumoProduto getRegistroInsumoProduto(String clausulaWhere){
		      return (RegistroInsumoProduto)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroInsumoProduto [] getRegistros(SPOInsumoProduto spo){
		if(spo==null) return getRegistrosInsumoProduto(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaQuantidadeInsumoporUnidadeProduto.condicao(spo.getQuantidadeInsumoporUnidadeProdutoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroInsumoProduto []) getRegistros(sb.toString());
	}
	
}
