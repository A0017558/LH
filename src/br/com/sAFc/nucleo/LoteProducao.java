package br.com.sAFc.nucleo; 


import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIALoteProducao;
import br.com.sAFc.interfaces.gui.SPOLoteProducao;
import br.com.sAFc.interfaces.nucleo.LoteProducao_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.persistencia.LoteProducaoPersistido;
import br.com.sAFc.interfaces.persistencia.ProdutoPersistido;




public class LoteProducao extends ObjetoNegocioSAFC implements LoteProducao_IN {
	
	
	private LoteProducaoPersistido loteProducaoPersistido = null; 
	
	
	public static LoteProducao_IN[] getLoteProducao_IN(SPOLoteProducao spo){
		LoteProducaoPersistido [] loteProducaoPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getLoteProducaoPersistido(spo);
		return getLoteProducao_IN(loteProducaoPersistidos);
	}
	public static LoteProducao_IN getLoteProducao_INPorIdentficador(String identificador){
		LoteProducaoPersistido  loteProducaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getLoteProducaoPersistidoPorIdentficador(identificador);
		return getUmLoteProducao_IN(loteProducaoPersistido);
	}
	
	
	public static LoteProducao_IN[] getLoteProducao_IN(LoteProducaoPersistido [] loteProducaoPersistidos){
		LoteProducao_IN[] objs = new LoteProducao_IN[loteProducaoPersistidos.length];
		for(int i=0;i<loteProducaoPersistidos.length;i++){
			objs[i] = new LoteProducao(loteProducaoPersistidos[i]);
		}
		return objs;
	}
	
	
	public static LoteProducao_IN getUmLoteProducao_IN(LoteProducaoPersistido loteProducaoPersistido){
		if(loteProducaoPersistido==null)return null;
		LoteProducao_IN obj = new LoteProducao(loteProducaoPersistido);
		return obj;
	}
	
	
	public static LoteProducao_IN criarNovoLoteProducao_IN(SIALoteProducao sol){
		LoteProducaoPersistido  loteProducaoPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoLoteProducaoPersistido();
		LoteProducao_IN obj = new LoteProducao(loteProducaoPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public LoteProducao(LoteProducaoPersistido loteProducaoPersistido){
		super(loteProducaoPersistido);
		this.loteProducaoPersistido=loteProducaoPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.loteProducaoPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		//TODO implementar.
		return "Não implementado!";
	}
	public void atualizar(Object objDados){
		SIALoteProducao sol  = (SIALoteProducao) objDados;
		/// [CodigoLote] autoincremental
		Produto_IN  objProduto = sol.getProduto();
		if(objProduto==null){
			this.loteProducaoPersistido.setCodigoproduto(0);
		}
		else{
			this.loteProducaoPersistido.setCodigoproduto(objProduto.getCodigoProduto());
		}
		
		this.loteProducaoPersistido.salvar();
	}
	
	
	public int getCodigoLote(){
		return this.loteProducaoPersistido.getCodigoLote();
	}
	public int getCodigoproduto(){
		return this.loteProducaoPersistido.getCodigoproduto();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.loteProducaoPersistido.excluir();
	}
	///1 relacionamentos localizados
	
	
	//Acesso ao objeto Produto
	public Produto_IN getProduto(){
		ProdutoPersistido op = this.loteProducaoPersistido.getRegistroProdutoRelacionado();
		if(op==null)return null;
		return new Produto(op);
	}
}
