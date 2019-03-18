package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOCanalAquisicao;
public class TabelaCanalAquisicao extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.CNL_AQSC";
	
	
	private static TabelaCanalAquisicao instancia = new TabelaCanalAquisicao();
	
	
	public static TabelaCanalAquisicao getInstancia(){return TabelaCanalAquisicao.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoCanalAquisicao = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_CNL_AQSC",instancia,true,true);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaCanalAquisicao = new br.com.sAFc.tabelas.ColunaStringSAFC("NM_CNL_AQSC",instancia,false,200);
	
	
	public static final RelacionamentosAFc RELACIONAMENTO_Insumos = 
	   new RelacionamentosAFc( "Insumos" , instancia, TabelaInsumo.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaInsumo.colunaCodigocanalaquisicao
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoCanalAquisicao,
		colunaCanalAquisicao
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaCanalAquisicao() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroCanalAquisicao();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroCanalAquisicao[numeroRegistros];
	   }
	
	
	   public RegistroCanalAquisicao getNovoRegistroCanalAquisicao(){
		      return (RegistroCanalAquisicao)this.getRegistroVazio();
	   }
	
	
	   public RegistroCanalAquisicao[] getRegistrosCanalAquisicao(String clausulaWhere){
		      return (RegistroCanalAquisicao[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroCanalAquisicao getRegistroCanalAquisicao(String clausulaWhere){
		      return (RegistroCanalAquisicao)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroCanalAquisicao [] getRegistros(SPOCanalAquisicao spo){
		if(spo==null) return getRegistrosCanalAquisicao(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaCodigoCanalAquisicao.condicao(spo.getCodigoCanalAquisicaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaCanalAquisicao.condicao(spo.getCanalAquisicaoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroCanalAquisicao []) getRegistros(sb.toString());
	}
	
}
