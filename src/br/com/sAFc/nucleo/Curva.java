package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIACurva;
import br.com.sAFc.interfaces.gui.SPOCurva;
import br.com.sAFc.interfaces.nucleo.Curva_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.persistencia.CurvaPersistido;




public class Curva extends ObjetoNegocioSAFC implements Curva_IN {
	
	
	private CurvaPersistido curvaPersistido = null; 
	
	
	public static Curva_IN[] getCurva_IN(SPOCurva spo){
		CurvaPersistido [] curvaPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getCurvaPersistido(spo);
		return getCurva_IN(curvaPersistidos);
	}
	public static Curva_IN getCurva_INPorIdentficador(String identificador){
		CurvaPersistido  curvaPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getCurvaPersistidoPorIdentficador(identificador);
		return getUmCurva_IN(curvaPersistido);
	}
	
	
	public static Curva_IN[] getCurva_IN(CurvaPersistido [] curvaPersistidos){
		Curva_IN[] objs = new Curva_IN[curvaPersistidos.length];
		for(int i=0;i<curvaPersistidos.length;i++){
			objs[i] = new Curva(curvaPersistidos[i]);
		}
		return objs;
	}
	
	
	public static Curva_IN getUmCurva_IN(CurvaPersistido curvaPersistido){
		if(curvaPersistido==null)return null;
		Curva_IN obj = new Curva(curvaPersistido);
		return obj;
	}
	
	
	public static Curva_IN criarNovoCurva_IN(SIACurva sol){
		CurvaPersistido  curvaPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoCurvaPersistido();
		Curva_IN obj = new Curva(curvaPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public Curva(CurvaPersistido curvaPersistido){
		super(curvaPersistido);
		this.curvaPersistido=curvaPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.curvaPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		return this.curvaPersistido.getCodigoCurva();
	}
	public void atualizar(Object objDados){
		SIACurva sol  = (SIACurva) objDados;
		this.curvaPersistido.setCodigoCurva(sol.getCodigoCurva());
		this.curvaPersistido.salvar();
	}
	
	
	public String getCodigoCurva(){
		return this.curvaPersistido.getCodigoCurva();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.curvaPersistido.excluir();
	}
	///1 relacionamentos localizados
	
	
	//Acesso aos objetos gcn Produtos
	public Produto_IN [] getProdutossRelacionados(){
		return Produto.getProduto_IN(this.curvaPersistido.getRegistroProdutossRelacionados() );
	}
}
