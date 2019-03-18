package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIALinhaProducao;
import br.com.sAFc.interfaces.gui.SPOLinhaProducao;
import br.com.sAFc.interfaces.nucleo.LinhaProducao_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.persistencia.LinhaProducaoPersistido;




public class LinhaProducao extends ObjetoNegocioSAFC implements LinhaProducao_IN {
	
	
	private LinhaProducaoPersistido linhaProducaoPersistido = null; 
	
	
	public static LinhaProducao_IN[] getLinhaProducao_IN(SPOLinhaProducao spo){
		LinhaProducaoPersistido [] linhaProducaoPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getLinhaProducaoPersistido(spo);
		return getLinhaProducao_IN(linhaProducaoPersistidos);
	}
	public static LinhaProducao_IN getLinhaProducao_INPorIdentficador(String identificador){
		LinhaProducaoPersistido  linhaProducaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getLinhaProducaoPersistidoPorIdentficador(identificador);
		return getUmLinhaProducao_IN(linhaProducaoPersistido);
	}
	
	
	public static LinhaProducao_IN[] getLinhaProducao_IN(LinhaProducaoPersistido [] linhaProducaoPersistidos){
		LinhaProducao_IN[] objs = new LinhaProducao_IN[linhaProducaoPersistidos.length];
		for(int i=0;i<linhaProducaoPersistidos.length;i++){
			objs[i] = new LinhaProducao(linhaProducaoPersistidos[i]);
		}
		return objs;
	}
	
	
	public static LinhaProducao_IN getUmLinhaProducao_IN(LinhaProducaoPersistido linhaProducaoPersistido){
		if(linhaProducaoPersistido==null)return null;
		LinhaProducao_IN obj = new LinhaProducao(linhaProducaoPersistido);
		return obj;
	}
	
	
	public static LinhaProducao_IN criarNovoLinhaProducao_IN(SIALinhaProducao sol){
		LinhaProducaoPersistido  linhaProducaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoLinhaProducaoPersistido();
		LinhaProducao_IN obj = new LinhaProducao(linhaProducaoPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public LinhaProducao(LinhaProducaoPersistido linhaProducaoPersistido){
		super(linhaProducaoPersistido);
		this.linhaProducaoPersistido=linhaProducaoPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.linhaProducaoPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		return this.linhaProducaoPersistido.getNomeLinhaProducao();
	}
	public void atualizar(Object objDados){
		SIALinhaProducao sol  = (SIALinhaProducao) objDados;
		/// [CodigoLinha] autoincremental
		this.linhaProducaoPersistido.setNomeLinhaProducao(sol.getNomeLinhaProducao());
		this.linhaProducaoPersistido.setCapacidadeLinha(sol.getCapacidadeLinha());
		this.linhaProducaoPersistido.salvar();
	}
	
	
	public int getCodigoLinha(){
		return this.linhaProducaoPersistido.getCodigoLinha();
	}
	public String getNomeLinhaProducao(){
		return this.linhaProducaoPersistido.getNomeLinhaProducao();
	}
	public int getCapacidadeLinha(){
		return this.linhaProducaoPersistido.getCapacidadeLinha();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.linhaProducaoPersistido.excluir();
	}
	///1 relacionamentos localizados
	
	
	//Acesso aos objetos gcn Produtos
	public Produto_IN [] getProdutossRelacionados(){
		return Produto.getProduto_IN(this.linhaProducaoPersistido.getRegistroProdutossRelacionados() );
	}
}
