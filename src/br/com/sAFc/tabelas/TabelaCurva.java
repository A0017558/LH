package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOCurva;
public class TabelaCurva extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.CRV";
	
	
	private static TabelaCurva instancia = new TabelaCurva();
	
	
	public static TabelaCurva getInstancia(){return TabelaCurva.instancia;}
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaCodigoCurva = new br.com.sAFc.tabelas.ColunaStringSAFC("CD_CRV",instancia,true,200);
	
	
	public static final RelacionamentosAFc RELACIONAMENTO_Produtos = 
	   new RelacionamentosAFc( "Produtos" , instancia, TabelaProduto.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaProduto.colunaCodigocurva
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoCurva
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaCurva() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroCurva();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroCurva[numeroRegistros];
	   }
	
	
	   public RegistroCurva getNovoRegistroCurva(){
		      return (RegistroCurva)this.getRegistroVazio();
	   }
	
	
	   public RegistroCurva[] getRegistrosCurva(String clausulaWhere){
		      return (RegistroCurva[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroCurva getRegistroCurva(String clausulaWhere){
		      return (RegistroCurva)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroCurva [] getRegistros(SPOCurva spo){
		if(spo==null) return getRegistrosCurva(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaCodigoCurva.condicao(spo.getCodigoCurvaPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroCurva []) getRegistros(sb.toString());
	}
	
}
