package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOUnidadeMedida;
public class TabelaUnidadeMedida extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.UN_MDD";
	
	
	private static TabelaUnidadeMedida instancia = new TabelaUnidadeMedida();
	
	
	public static TabelaUnidadeMedida getInstancia(){return TabelaUnidadeMedida.instancia;}
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaSiglaUnidadeMedida = new br.com.sAFc.tabelas.ColunaStringSAFC("SLG_UN_MDD",instancia,true,200);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaNomeUnidadeMedida = new br.com.sAFc.tabelas.ColunaStringSAFC("NM_UN_MDD",instancia,false,200);
	
	
	public static final RelacionamentosAFc RELACIONAMENTO_Insumos = 
	   new RelacionamentosAFc( "Insumos" , instancia, TabelaInsumo.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaInsumo.colunaSiglaunidademedida
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	public static final RelacionamentosAFc RELACIONAMENTO_Produtos = 
	   new RelacionamentosAFc( "Produtos" , instancia, TabelaProduto.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaProduto.colunaSiglaunidademedida
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaSiglaUnidadeMedida,
		colunaNomeUnidadeMedida
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaUnidadeMedida() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroUnidadeMedida();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroUnidadeMedida[numeroRegistros];
	   }
	
	
	   public RegistroUnidadeMedida getNovoRegistroUnidadeMedida(){
		      return (RegistroUnidadeMedida)this.getRegistroVazio();
	   }
	
	
	   public RegistroUnidadeMedida[] getRegistrosUnidadeMedida(String clausulaWhere){
		      return (RegistroUnidadeMedida[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroUnidadeMedida getRegistroUnidadeMedida(String clausulaWhere){
		      return (RegistroUnidadeMedida)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroUnidadeMedida [] getRegistros(SPOUnidadeMedida spo){
		if(spo==null) return getRegistrosUnidadeMedida(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaSiglaUnidadeMedida.condicao(spo.getSiglaUnidadeMedidaPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaNomeUnidadeMedida.condicao(spo.getNomeUnidadeMedidaPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroUnidadeMedida []) getRegistros(sb.toString());
	}
	
}
