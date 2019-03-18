package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOModalAquisicao;
public class TabelaModalAquisicao extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.MD_AQSC";
	
	
	private static TabelaModalAquisicao instancia = new TabelaModalAquisicao();
	
	
	public static TabelaModalAquisicao getInstancia(){return TabelaModalAquisicao.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoModalAquisicao = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_MD_AQSC",instancia,true,true);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaNomeModalAquisicao = new br.com.sAFc.tabelas.ColunaStringSAFC("NM_MD_AQSC",instancia,false,200);
	
	
	public static final RelacionamentosAFc RELACIONAMENTO_Insumos = 
	   new RelacionamentosAFc( "Insumos" , instancia, TabelaInsumo.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaInsumo.colunaCodigomodalaquisicao
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoModalAquisicao,
		colunaNomeModalAquisicao
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaModalAquisicao() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroModalAquisicao();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroModalAquisicao[numeroRegistros];
	   }
	
	
	   public RegistroModalAquisicao getNovoRegistroModalAquisicao(){
		      return (RegistroModalAquisicao)this.getRegistroVazio();
	   }
	
	
	   public RegistroModalAquisicao[] getRegistrosModalAquisicao(String clausulaWhere){
		      return (RegistroModalAquisicao[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroModalAquisicao getRegistroModalAquisicao(String clausulaWhere){
		      return (RegistroModalAquisicao)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroModalAquisicao [] getRegistros(SPOModalAquisicao spo){
		if(spo==null) return getRegistrosModalAquisicao(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaCodigoModalAquisicao.condicao(spo.getCodigoModalAquisicaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaNomeModalAquisicao.condicao(spo.getNomeModalAquisicaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroModalAquisicao []) getRegistros(sb.toString());
	}
	
}
