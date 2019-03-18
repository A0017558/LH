package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIADestinacao;
import br.com.sAFc.interfaces.gui.SPODestinacao;
import br.com.sAFc.interfaces.nucleo.Destinacao_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.persistencia.DestinacaoPersistido;




public class Destinacao extends ObjetoNegocioSAFC implements Destinacao_IN {
	
	
	private DestinacaoPersistido destinacaoPersistido = null; 
	
	
	public static Destinacao_IN[] getDestinacao_IN(SPODestinacao spo){
		DestinacaoPersistido [] destinacaoPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getDestinacaoPersistido(spo);
		return getDestinacao_IN(destinacaoPersistidos);
	}
	public static Destinacao_IN getDestinacao_INPorIdentficador(String identificador){
		DestinacaoPersistido  destinacaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getDestinacaoPersistidoPorIdentficador(identificador);
		return getUmDestinacao_IN(destinacaoPersistido);
	}
	
	
	public static Destinacao_IN[] getDestinacao_IN(DestinacaoPersistido [] destinacaoPersistidos){
		Destinacao_IN[] objs = new Destinacao_IN[destinacaoPersistidos.length];
		for(int i=0;i<destinacaoPersistidos.length;i++){
			objs[i] = new Destinacao(destinacaoPersistidos[i]);
		}
		return objs;
	}
	
	
	public static Destinacao_IN getUmDestinacao_IN(DestinacaoPersistido destinacaoPersistido){
		if(destinacaoPersistido==null)return null;
		Destinacao_IN obj = new Destinacao(destinacaoPersistido);
		return obj;
	}
	
	
	public static Destinacao_IN criarNovoDestinacao_IN(SIADestinacao sol){
		DestinacaoPersistido  destinacaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoDestinacaoPersistido();
		Destinacao_IN obj = new Destinacao(destinacaoPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public Destinacao(DestinacaoPersistido destinacaoPersistido){
		super(destinacaoPersistido);
		this.destinacaoPersistido=destinacaoPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.destinacaoPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		return this.destinacaoPersistido.getNomeDestinacao();
	}
	public void atualizar(Object objDados){
		SIADestinacao sol  = (SIADestinacao) objDados;
		/// [CodigoDestinacao] autoincremental
		this.destinacaoPersistido.setNomeDestinacao(sol.getNomeDestinacao());
		this.destinacaoPersistido.salvar();
	}
	
	
	public int getCodigoDestinacao(){
		return this.destinacaoPersistido.getCodigoDestinacao();
	}
	public String getNomeDestinacao(){
		return this.destinacaoPersistido.getNomeDestinacao();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.destinacaoPersistido.excluir();
	}
	///1 relacionamentos localizados
	
	
	//Acesso aos objetos gcn Produtos
	public Produto_IN [] getProdutossRelacionados(){
		return Produto.getProduto_IN(this.destinacaoPersistido.getRegistroProdutossRelacionados() );
	}
}
