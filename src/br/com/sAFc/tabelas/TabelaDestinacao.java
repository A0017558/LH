package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPODestinacao;
public class TabelaDestinacao extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.DSTN";
	
	
	private static TabelaDestinacao instancia = new TabelaDestinacao();
	
	
	public static TabelaDestinacao getInstancia(){return TabelaDestinacao.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoDestinacao = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_DSTN",instancia,true,true);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaNomeDestinacao = new br.com.sAFc.tabelas.ColunaStringSAFC("NM_DSTB",instancia,false,200);
	
	
	public static final RelacionamentosAFc RELACIONAMENTO_Produtos = 
	   new RelacionamentosAFc( "Produtos" , instancia, TabelaProduto.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaProduto.colunaCodigodestinacao
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoDestinacao,
		colunaNomeDestinacao
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaDestinacao() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroDestinacao();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroDestinacao[numeroRegistros];
	   }
	
	
	   public RegistroDestinacao getNovoRegistroDestinacao(){
		      return (RegistroDestinacao)this.getRegistroVazio();
	   }
	
	
	   public RegistroDestinacao[] getRegistrosDestinacao(String clausulaWhere){
		      return (RegistroDestinacao[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroDestinacao getRegistroDestinacao(String clausulaWhere){
		      return (RegistroDestinacao)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroDestinacao [] getRegistros(SPODestinacao spo){
		if(spo==null) return getRegistrosDestinacao(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaCodigoDestinacao.condicao(spo.getCodigoDestinacaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaNomeDestinacao.condicao(spo.getNomeDestinacaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroDestinacao []) getRegistros(sb.toString());
	}
	
}
