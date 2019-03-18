package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIAModalAquisicao;
import br.com.sAFc.interfaces.gui.SPOModalAquisicao;
import br.com.sAFc.interfaces.nucleo.Insumo_IN;
import br.com.sAFc.interfaces.nucleo.ModalAquisicao_IN;
import br.com.sAFc.interfaces.persistencia.ModalAquisicaoPersistido;




public class ModalAquisicao extends ObjetoNegocioSAFC implements ModalAquisicao_IN {
	
	
	private ModalAquisicaoPersistido modalAquisicaoPersistido = null; 
	
	
	public static ModalAquisicao_IN[] getModalAquisicao_IN(SPOModalAquisicao spo){
		ModalAquisicaoPersistido [] modalAquisicaoPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getModalAquisicaoPersistido(spo);
		return getModalAquisicao_IN(modalAquisicaoPersistidos);
	}
	public static ModalAquisicao_IN getModalAquisicao_INPorIdentficador(String identificador){
		ModalAquisicaoPersistido  modalAquisicaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getModalAquisicaoPersistidoPorIdentficador(identificador);
		return getUmModalAquisicao_IN(modalAquisicaoPersistido);
	}
	
	
	public static ModalAquisicao_IN[] getModalAquisicao_IN(ModalAquisicaoPersistido [] modalAquisicaoPersistidos){
		ModalAquisicao_IN[] objs = new ModalAquisicao_IN[modalAquisicaoPersistidos.length];
		for(int i=0;i<modalAquisicaoPersistidos.length;i++){
			objs[i] = new ModalAquisicao(modalAquisicaoPersistidos[i]);
		}
		return objs;
	}
	
	
	public static ModalAquisicao_IN getUmModalAquisicao_IN(ModalAquisicaoPersistido modalAquisicaoPersistido){
		if(modalAquisicaoPersistido==null)return null;
		ModalAquisicao_IN obj = new ModalAquisicao(modalAquisicaoPersistido);
		return obj;
	}
	
	
	public static ModalAquisicao_IN criarNovoModalAquisicao_IN(SIAModalAquisicao sol){
		ModalAquisicaoPersistido  modalAquisicaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoModalAquisicaoPersistido();
		ModalAquisicao_IN obj = new ModalAquisicao(modalAquisicaoPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public ModalAquisicao(ModalAquisicaoPersistido modalAquisicaoPersistido){
		super(modalAquisicaoPersistido);
		this.modalAquisicaoPersistido=modalAquisicaoPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.modalAquisicaoPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		return this.modalAquisicaoPersistido.getNomeModalAquisicao();
	}
	public void atualizar(Object objDados){
		SIAModalAquisicao sol  = (SIAModalAquisicao) objDados;
		/// [CodigoModalAquisicao] autoincremental
		this.modalAquisicaoPersistido.setNomeModalAquisicao(sol.getNomeModalAquisicao());
		this.modalAquisicaoPersistido.salvar();
	}
	
	
	public int getCodigoModalAquisicao(){
		return this.modalAquisicaoPersistido.getCodigoModalAquisicao();
	}
	public String getNomeModalAquisicao(){
		return this.modalAquisicaoPersistido.getNomeModalAquisicao();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.modalAquisicaoPersistido.excluir();
	}
	///1 relacionamentos localizados
	
	
	//Acesso aos objetos gcn Insumos
	public Insumo_IN [] getInsumossRelacionados(){
		return Insumo.getInsumo_IN(this.modalAquisicaoPersistido.getRegistroInsumossRelacionados() );
	}
}
