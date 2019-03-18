package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIATipoInsumo;
import br.com.sAFc.interfaces.gui.SPOTipoInsumo;
import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.TipoInsumo_IN;
import br.com.sAFc.interfaces.persistencia.TipoInsumoPersistido;




public class TipoInsumo extends ObjetoNegocioSAFC implements TipoInsumo_IN {
	
	
	private TipoInsumoPersistido tipoInsumoPersistido = null; 
	
	
	public static TipoInsumo_IN[] getTipoInsumo_IN(SPOTipoInsumo spo){
		TipoInsumoPersistido [] tipoInsumoPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getTipoInsumoPersistido(spo);
		return getTipoInsumo_IN(tipoInsumoPersistidos);
	}
	public static TipoInsumo_IN getTipoInsumo_INPorIdentficador(String identificador){
		TipoInsumoPersistido  tipoInsumoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getTipoInsumoPersistidoPorIdentficador(identificador);
		return getUmTipoInsumo_IN(tipoInsumoPersistido);
	}
	
	
	public static TipoInsumo_IN[] getTipoInsumo_IN(TipoInsumoPersistido [] tipoInsumoPersistidos){
		TipoInsumo_IN[] objs = new TipoInsumo_IN[tipoInsumoPersistidos.length];
		for(int i=0;i<tipoInsumoPersistidos.length;i++){
			objs[i] = new TipoInsumo(tipoInsumoPersistidos[i]);
		}
		return objs;
	}
	
	
	public static TipoInsumo_IN getUmTipoInsumo_IN(TipoInsumoPersistido tipoInsumoPersistido){
		if(tipoInsumoPersistido==null)return null;
		TipoInsumo_IN obj = new TipoInsumo(tipoInsumoPersistido);
		return obj;
	}
	
	
	public static TipoInsumo_IN criarNovoTipoInsumo_IN(SIATipoInsumo sol){
		TipoInsumoPersistido  tipoInsumoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoTipoInsumoPersistido();
		TipoInsumo_IN obj = new TipoInsumo(tipoInsumoPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public TipoInsumo(TipoInsumoPersistido tipoInsumoPersistido){
		super(tipoInsumoPersistido);
		this.tipoInsumoPersistido=tipoInsumoPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.tipoInsumoPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		return this.tipoInsumoPersistido.getNomeTipoInsumo();
	}
	public void atualizar(Object objDados){
		SIATipoInsumo sol  = (SIATipoInsumo) objDados;
		/// [CodigoTipoInsumo] autoincremental
		this.tipoInsumoPersistido.setNomeTipoInsumo(sol.getNomeTipoInsumo());
		this.tipoInsumoPersistido.salvar();
	}
	
	
	public int getCodigoTipoInsumo(){
		return this.tipoInsumoPersistido.getCodigoTipoInsumo();
	}
	public String getNomeTipoInsumo(){
		return this.tipoInsumoPersistido.getNomeTipoInsumo();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.tipoInsumoPersistido.excluir();
	}
	///1 relacionamentos localizados
	
	
	//Acesso aos objetos gcn Insumos
	public Insumo_IN [] getInsumossRelacionados(){
		return Insumo.getInsumo_IN(this.tipoInsumoPersistido.getRegistroInsumossRelacionados() );
	}
}
