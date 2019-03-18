package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOPrevisaoVenda;
public class TabelaPrevisaoVenda extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.PRVS_VND";
	
	
	private static TabelaPrevisaoVenda instancia = new TabelaPrevisaoVenda();
	
	
	public static TabelaPrevisaoVenda getInstancia(){return TabelaPrevisaoVenda.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaNumeroPrevisao = new br.com.sAFc.tabelas.ColunaIntSAFC("NR_PRV",instancia,true,true);
	public static final br.com.sAFc.tabelas.ColunaDataSAFC colunaDataPrevisaoVenda = new br.com.sAFc.tabelas.ColunaDataSAFC("DT_PRV_VND",instancia,true);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoproduto = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_PRD",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaQuantidadeProduto = new br.com.sAFc.tabelas.ColunaIntSAFC("QT_PRD_VND",instancia,false);
	
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaNumeroPrevisao,
		colunaDataPrevisaoVenda,
		colunaCodigoproduto,
		colunaQuantidadeProduto
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaPrevisaoVenda() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroPrevisaoVenda();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroPrevisaoVenda[numeroRegistros];
	   }
	
	
	   public RegistroPrevisaoVenda getNovoRegistroPrevisaoVenda(){
		      return (RegistroPrevisaoVenda)this.getRegistroVazio();
	   }
	
	
	   public RegistroPrevisaoVenda[] getRegistrosPrevisaoVenda(String clausulaWhere){
		      return (RegistroPrevisaoVenda[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroPrevisaoVenda getRegistroPrevisaoVenda(String clausulaWhere){
		      return (RegistroPrevisaoVenda)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroPrevisaoVenda [] getRegistros(SPOPrevisaoVenda spo){
		if(spo==null) return getRegistrosPrevisaoVenda(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaNumeroPrevisao.condicao(spo.getNumeroPrevisaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaDataPrevisaoVenda.condicao(spo.getDataPrevisaoVendaPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaQuantidadeProduto.condicao(spo.getQuantidadeProdutoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroPrevisaoVenda []) getRegistros(sb.toString());
	}
	
}
