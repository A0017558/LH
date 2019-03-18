package br.com.sAFc.tabelas; 


import tabelas.Coluna;
import tabelas.Registro;
import br.com.sAFc.interfaces.gui.SPOTipoInsumo;
public class TabelaTipoInsumo extends br.com.sAFc.tabelas.TabelaAbstrataSAFC {
	
	
	private static String nome = "safc.TP_ISM";
	
	
	private static TabelaTipoInsumo instancia = new TabelaTipoInsumo();
	
	
	public static TabelaTipoInsumo getInstancia(){return TabelaTipoInsumo.instancia;}
	public static final br.com.sAFc.tabelas.ColunaIntSAFC colunaCodigoTipoInsumo = new br.com.sAFc.tabelas.ColunaIntSAFC("CD_TP_ISM",instancia,true,true);
	public static final br.com.sAFc.tabelas.ColunaStringSAFC colunaNomeTipoInsumo = new br.com.sAFc.tabelas.ColunaStringSAFC("NM_TP_ISM",instancia,false,200);
	
	
	public static final RelacionamentosAFc RELACIONAMENTO_Insumos = 
	   new RelacionamentosAFc( "Insumos" , instancia, TabelaInsumo.getInstancia()){
		   private Coluna [] colunasDestino = new Coluna[]{
			TabelaInsumo.colunaCodigotipoinsumo
		};
		public Coluna [] getColunasDestino(){
			return colunasDestino;
		}
	};
	
	
	
	private static Coluna[] colunas = new Coluna[]{
		colunaCodigoTipoInsumo,
		colunaNomeTipoInsumo
	   };
	
	
	   public Coluna[] getColunas(){
		      return colunas;
	   }
	
	
	   private TabelaTipoInsumo() {
		      super(nome);
	   }
	
	
	   public Registro getRegistroVazio() {
		      return new RegistroTipoInsumo();
	   }
	
	
	   public Registro[] getRegistrosVazios(int numeroRegistros) {
		      return new RegistroTipoInsumo[numeroRegistros];
	   }
	
	
	   public RegistroTipoInsumo getNovoRegistroTipoInsumo(){
		      return (RegistroTipoInsumo)this.getRegistroVazio();
	   }
	
	
	   public RegistroTipoInsumo[] getRegistrosTipoInsumo(String clausulaWhere){
		      return (RegistroTipoInsumo[])this.getRegistros(clausulaWhere);
	   }
	
	
	   public RegistroTipoInsumo getRegistroTipoInsumo(String clausulaWhere){
		      return (RegistroTipoInsumo)this.getRegistro(clausulaWhere);
	   }
	
	
	public RegistroTipoInsumo [] getRegistros(SPOTipoInsumo spo){
		if(spo==null) return getRegistrosTipoInsumo(null);
		StringBuffer sb = new StringBuffer();
		String c = null;
		c = colunaCodigoTipoInsumo.condicao(spo.getCodigoTipoInsumoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		c = colunaNomeTipoInsumo.condicao(spo.getNomeTipoInsumoPesquisa());
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}
		return (RegistroTipoInsumo []) getRegistros(sb.toString());
	}
	
}
