package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOProduto;
public class TabelaProduto extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.PRD";
	
	
	private static TabelaProduto instancia = new TabelaProduto();
	
	
	public static TabelaProduto getInstancia(){return TabelaProduto.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoProduto = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_PRD",instancia,true,true);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaNomeProduto = new br.com.sAFc.tabelas.ColunaStringSAFC("NM_PRD",instancia,false,200);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigolinha = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_LNH_PRDC",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaSiglaunidademedida = new br.com.sAFc.tabelas.ColunaStringSAFC("SLG_UN_MDD",instancia,false,200);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaLotePadrao = new br.com.sAFc.tabelas.ColunaIntSAFC("LT_PRD",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaApresentacao = new br.com.sAFc.tabelas.ColunaStringSAFC("TX_APST",instancia,false,200);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaFatorAjusteProdutividade = new br.com.sAFc.tabelas.ColunaIntSAFC("FT_AJST_PRDC",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaValorParaVenda = new br.com.sAFc.tabelas.ColunaIntSAFC("VL_VND",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigodestinacao = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_DSTN",instancia,false);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaCodigocurva = new br.com.sAFc.tabelas.ColunaStringSAFC("CD_CRV",instancia,false,200);
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaPoliticaEstoque = new br.com.sAFc.tabelas.ColunaIntSAFC("PLT_ESTQ",instancia,false);
	
	
	public static final RelacionamentosAFc RELACIONAMENTO_Produtos = 
	   new RelacionamentosAFc( "Produtos" , instancia, TabelaInsumoProduto.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaInsumoProduto.colunaCodigoproduto
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	public static final RelacionamentosAFc RELACIONAMENTO_PrevisoesVenda = 
	   new RelacionamentosAFc( "PrevisoesVenda" , instancia, TabelaPrevisaoVenda.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaPrevisaoVenda.colunaCodigoproduto
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	public static final RelacionamentosAFc RELACIONAMENTO_Lotes = 
	   new RelacionamentosAFc( "Lotes" , instancia, TabelaLoteProducao.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaLoteProducao.colunaCodigoproduto
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoProduto,
		colunaNomeProduto,
		colunaCodigolinha,
		colunaSiglaunidademedida,
		colunaLotePadrao,
		colunaApresentacao,
		colunaFatorAjusteProdutividade,
		colunaValorParaVenda,
		colunaCodigodestinacao,
		colunaCodigocurva,
		colunaPoliticaEstoque
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaProduto() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroProduto();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroProduto[numeroRegistros];
	   }
	
	
	   public RegistroProduto getNovoRegistroProduto(){
		      return (RegistroProduto)this.getRegistroVazio();
	   }
	
	
	   public RegistroProduto[] getRegistrosProduto(String clausulaWhere){
		      return (RegistroProduto[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroProduto getRegistroProduto(String clausulaWhere){
		      return (RegistroProduto)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroProduto [] getRegistros(SPOProduto spo){
		if(spo==null) return getRegistrosProduto(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaCodigoProduto.condicao(spo.getCodigoProdutoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaNomeProduto.condicao(spo.getNomeProdutoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaLotePadrao.condicao(spo.getLotePadraoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaApresentacao.condicao(spo.getApresentacaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaFatorAjusteProdutividade.condicao(spo.getFatorAjusteProdutividadePesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaValorParaVenda.condicao(spo.getValorParaVendaPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaPoliticaEstoque.condicao(spo.getPoliticaEstoquePesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroProduto []) getRegistros(sb.toString());
	}
	
}
