package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOInsumo;
public class TabelaInsumo extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.ISM";
	
	
	private static TabelaInsumo instancia = new TabelaInsumo();
	
	
	public static TabelaInsumo getInstancia(){return TabelaInsumo.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoInsumo = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_ISM",instancia,true,true);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaNomeInsumo = new br.com.sAFc.tabelas.ColunaStringSAFC("NM_ISM",instancia,false,200);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaSiglaunidademedida = new br.com.sAFc.tabelas.ColunaStringSAFC("SLG_UN_MDD",instancia,false,200);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigotipoinsumo = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_TP_ISM",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigomodalaquisicao = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_MD_AQSC",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigocanalaquisicao = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_CNL_AQSC",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaTempoParaAquisicao = new br.com.sAFc.tabelas.ColunaIntSAFC("TMP_AQSC",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaTempoLiberacao = new br.com.sAFc.tabelas.ColunaIntSAFC("TMP_LIB",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCompraMinima = new br.com.sAFc.tabelas.ColunaIntSAFC("QT_MIN_CMPR",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaUnidadeCompra = new br.com.sAFc.tabelas.ColunaIntSAFC("UND_CMPR",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaValorParaAquisicao = new br.com.sAFc.tabelas.ColunaIntSAFC("VL_AQSC",instancia,false);
	
	
	public static final RelacionamentosAFc RELACIONAMENTO_Insumos = 
	   new RelacionamentosAFc( "Insumos" , instancia, TabelaInsumoProduto.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaInsumoProduto.colunaCodigoinsumo
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoInsumo,
		colunaNomeInsumo,
		colunaSiglaunidademedida,
		colunaCodigotipoinsumo,
		colunaCodigomodalaquisicao,
		colunaCodigocanalaquisicao,
		colunaTempoParaAquisicao,
		colunaTempoLiberacao,
		colunaCompraMinima,
		colunaUnidadeCompra,
		colunaValorParaAquisicao
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaInsumo() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroInsumo();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroInsumo[numeroRegistros];
	   }
	
	
	   public RegistroInsumo getNovoRegistroInsumo(){
		      return (RegistroInsumo)this.getRegistroVazio();
	   }
	
	
	   public RegistroInsumo[] getRegistrosInsumo(String clausulaWhere){
		      return (RegistroInsumo[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroInsumo getRegistroInsumo(String clausulaWhere){
		      return (RegistroInsumo)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroInsumo [] getRegistros(SPOInsumo spo){
		if(spo==null) return getRegistrosInsumo(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaCodigoInsumo.condicao(spo.getCodigoInsumoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaNomeInsumo.condicao(spo.getNomeInsumoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaTempoParaAquisicao.condicao(spo.getTempoParaAquisicaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaTempoLiberacao.condicao(spo.getTempoLiberacaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaCompraMinima.condicao(spo.getCompraMinimaPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaUnidadeCompra.condicao(spo.getUnidadeCompraPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaValorParaAquisicao.condicao(spo.getValorParaAquisicaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroInsumo []) getRegistros(sb.toString());
	}
	
}
