package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOLoteProducao;
public class TabelaLoteProducao extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.LTE_PRDC";
	
	
	private static TabelaLoteProducao instancia = new TabelaLoteProducao();
	
	
	public static TabelaLoteProducao getInstancia(){return TabelaLoteProducao.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoLote = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_LTE_PRDC",instancia,true,true);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoproduto = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_PRD",instancia,false);
	
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoLote,
		colunaCodigoproduto
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaLoteProducao() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroLoteProducao();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroLoteProducao[numeroRegistros];
	   }
	
	
	   public RegistroLoteProducao getNovoRegistroLoteProducao(){
		      return (RegistroLoteProducao)this.getRegistroVazio();
	   }
	
	
	   public RegistroLoteProducao[] getRegistrosLoteProducao(String clausulaWhere){
		      return (RegistroLoteProducao[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroLoteProducao getRegistroLoteProducao(String clausulaWhere){
		      return (RegistroLoteProducao)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroLoteProducao [] getRegistros(SPOLoteProducao spo){
		if(spo==null) return getRegistrosLoteProducao(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaCodigoLote.condicao(spo.getCodigoLotePesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroLoteProducao []) getRegistros(sb.toString());
	}
	
}
