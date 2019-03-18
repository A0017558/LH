package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIACanalAquisicao;
import br.com.sAFc.interfaces.gui.SPOCanalAquisicao;
import br.com.sAFc.interfaces.nucleo.CanalAquisicao_IN;
import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.persistencia.CanalAquisicaoPersistido;




public class CanalAquisicao extends ObjetoNegocioSAFC implements CanalAquisicao_IN {
	
	
	private CanalAquisicaoPersistido canalAquisicaoPersistido = null; 
	
	
	public static CanalAquisicao_IN[] getCanalAquisicao_IN(SPOCanalAquisicao spo){
		CanalAquisicaoPersistido [] canalAquisicaoPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getCanalAquisicaoPersistido(spo);
		return getCanalAquisicao_IN(canalAquisicaoPersistidos);
	}
	public static CanalAquisicao_IN getCanalAquisicao_INPorIdentficador(String identificador){
		CanalAquisicaoPersistido  canalAquisicaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getCanalAquisicaoPersistidoPorIdentficador(identificador);
		return getUmCanalAquisicao_IN(canalAquisicaoPersistido);
	}
	
	
	public static CanalAquisicao_IN[] getCanalAquisicao_IN(CanalAquisicaoPersistido [] canalAquisicaoPersistidos){
		CanalAquisicao_IN[] objs = new CanalAquisicao_IN[canalAquisicaoPersistidos.length];
		for(int i=0;i<canalAquisicaoPersistidos.length;i++){
			objs[i] = new CanalAquisicao(canalAquisicaoPersistidos[i]);
		}
		return objs;
	}
	
	
	public static CanalAquisicao_IN getUmCanalAquisicao_IN(CanalAquisicaoPersistido canalAquisicaoPersistido){
		if(canalAquisicaoPersistido==null)return null;
		CanalAquisicao_IN obj = new CanalAquisicao(canalAquisicaoPersistido);
		return obj;
	}
	
	
	public static CanalAquisicao_IN criarNovoCanalAquisicao_IN(SIACanalAquisicao sol){
		CanalAquisicaoPersistido  canalAquisicaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoCanalAquisicaoPersistido();
		CanalAquisicao_IN obj = new CanalAquisicao(canalAquisicaoPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public CanalAquisicao(CanalAquisicaoPersistido canalAquisicaoPersistido){
		super(canalAquisicaoPersistido);
		this.canalAquisicaoPersistido=canalAquisicaoPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.canalAquisicaoPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		return this.canalAquisicaoPersistido.getCanalAquisicao();
	}
	public void atualizar(Object objDados){
		SIACanalAquisicao sol  = (SIACanalAquisicao) objDados;
		/// [CodigoCanalAquisicao] autoincremental
		this.canalAquisicaoPersistido.setCanalAquisicao(sol.getCanalAquisicao());
		this.canalAquisicaoPersistido.salvar();
	}
	
	
	public int getCodigoCanalAquisicao(){
		return this.canalAquisicaoPersistido.getCodigoCanalAquisicao();
	}
	public String getCanalAquisicao(){
		return this.canalAquisicaoPersistido.getCanalAquisicao();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.canalAquisicaoPersistido.excluir();
	}
	///1 relacionamentos localizados
	
	
	//Acesso aos objetos gcn Insumos
	public Insumo_IN [] getInsumossRelacionados(){
		return Insumo.getInsumo_IN(this.canalAquisicaoPersistido.getRegistroInsumossRelacionados() );
	}
}
