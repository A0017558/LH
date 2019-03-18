package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOLinhaProducao;
public class TabelaLinhaProducao extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.LNH_PRDC";
	
	
	private static TabelaLinhaProducao instancia = new TabelaLinhaProducao();
	
	
	public static TabelaLinhaProducao getInstancia(){return TabelaLinhaProducao.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoLinha = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_LNH_PRDC",instancia,true,true);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaNomeLinhaProducao = new br.com.sAFc.tabelas.ColunaStringSAFC("NM_LNH_PRDC",instancia,false,200);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCapacidadeLinha = new br.com.sAFc.tabelas.ColunaIntSAFC("CP_LNH",instancia,false);
	
	
	public static final RelacionamentosAFc RELACIONAMENTO_Produtos = 
	   new RelacionamentosAFc( "Produtos" , instancia, TabelaProduto.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaProduto.colunaCodigolinha
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoLinha,
		colunaNomeLinhaProducao,
		colunaCapacidadeLinha
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaLinhaProducao() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroLinhaProducao();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroLinhaProducao[numeroRegistros];
	   }
	
	
	   public RegistroLinhaProducao getNovoRegistroLinhaProducao(){
		      return (RegistroLinhaProducao)this.getRegistroVazio();
	   }
	
	
	   public RegistroLinhaProducao[] getRegistrosLinhaProducao(String clausulaWhere){
		      return (RegistroLinhaProducao[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroLinhaProducao getRegistroLinhaProducao(String clausulaWhere){
		      return (RegistroLinhaProducao)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroLinhaProducao [] getRegistros(SPOLinhaProducao spo){
		if(spo==null) return getRegistrosLinhaProducao(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaCodigoLinha.condicao(spo.getCodigoLinhaPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaNomeLinhaProducao.condicao(spo.getNomeLinhaProducaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaCapacidadeLinha.condicao(spo.getCapacidadeLinhaPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroLinhaProducao []) getRegistros(sb.toString());
	}
	
}
