package br.com.sAFc.nucleo; 


import java.util.GregorianCalendar;

import br.com.sAFc.acc.AcopladorCamadasSAFC;
import br.com.sAFc.interfaces.gui.SIAPrevisaoVenda;
import br.com.sAFc.interfaces.gui.SPOPrevisaoVenda;
import br.com.sAFc.interfaces.nucleo.PrevisaoVenda_IN;
import br.com.sAFc.interfaces.nucleo.Produto_IN;
import br.com.sAFc.interfaces.persistencia.PrevisaoVendaPersistido;
import br.com.sAFc.interfaces.persistencia.ProdutoPersistido;




public class PrevisaoVenda extends ObjetoNegocioSAFC implements PrevisaoVenda_IN {
	
	
	private PrevisaoVendaPersistido previsaoVendaPersistido = null; 
	
	
	public static PrevisaoVenda_IN[] getPrevisaoVenda_IN(SPOPrevisaoVenda spo){
		PrevisaoVendaPersistido [] previsaoVendaPersistidos = AcopladorCamadasSAFC.getConstrutorPersistencia().getPrevisaoVendaPersistido(spo);
		return getPrevisaoVenda_IN(previsaoVendaPersistidos);
	}
	public static PrevisaoVenda_IN getPrevisaoVenda_INPorIdentficador(String identificador){
		PrevisaoVendaPersistido  previsaoVendaPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getPrevisaoVendaPersistidoPorIdentficador(identificador);
		return getUmPrevisaoVenda_IN(previsaoVendaPersistido);
	}
	
	
	public static PrevisaoVenda_IN[] getPrevisaoVenda_IN(PrevisaoVendaPersistido [] previsaoVendaPersistidos){
		PrevisaoVenda_IN[] objs = new PrevisaoVenda_IN[previsaoVendaPersistidos.length];
		for(int i=0;i<previsaoVendaPersistidos.length;i++){
			objs[i] = new PrevisaoVenda(previsaoVendaPersistidos[i]);
		}
		return objs;
	}
	
	
	public static PrevisaoVenda_IN getUmPrevisaoVenda_IN(PrevisaoVendaPersistido previsaoVendaPersistido){
		if(previsaoVendaPersistido==null)return null;
		PrevisaoVenda_IN obj = new PrevisaoVenda(previsaoVendaPersistido);
		return obj;
	}
	
	
	public static PrevisaoVenda_IN criarNovoPrevisaoVenda_IN(SIAPrevisaoVenda sol){
		PrevisaoVendaPersistido  previsaoVendaPersistido = AcopladorCamadasSAFC.getConstrutorPersistencia().getNovoPrevisaoVendaPersistido();
		PrevisaoVenda_IN obj = new PrevisaoVenda(previsaoVendaPersistido);
		obj.atualizar(sol);
		return obj;
	}
	
	
	public PrevisaoVenda(PrevisaoVendaPersistido previsaoVendaPersistido){
		super(previsaoVendaPersistido);
		this.previsaoVendaPersistido=previsaoVendaPersistido;
	}
	
	public String getCodigoIdentificadorLista() {
		return this.previsaoVendaPersistido.getCodigoIdentificadorRegistro();
	}
	
	public String getTituloLista() {
		//TODO implementar.
		return "Não implementado!";
	}
	public void atualizar(Object objDados){
		SIAPrevisaoVenda sol  = (SIAPrevisaoVenda) objDados;
		/// [NumeroPrevisao] autoincremental
		this.previsaoVendaPersistido.setDataPrevisaoVenda(sol.getDataPrevisaoVenda());
		this.previsaoVendaPersistido.setQuantidadeProduto(sol.getQuantidadeProduto());
		Produto_IN  objProduto = sol.getProduto();
		if(objProduto==null){
			this.previsaoVendaPersistido.setCodigoproduto(0);
		}
		else{
			this.previsaoVendaPersistido.setCodigoproduto(objProduto.getCodigoProduto());
		}
		
		this.previsaoVendaPersistido.salvar();
	}
	
	
	public int getNumeroPrevisao(){
		return this.previsaoVendaPersistido.getNumeroPrevisao();
	}
	public GregorianCalendar getDataPrevisaoVenda(){
		return this.previsaoVendaPersistido.getDataPrevisaoVenda();
	}
	public int getCodigoproduto(){
		return this.previsaoVendaPersistido.getCodigoproduto();
	}
	public int getQuantidadeProduto(){
		return this.previsaoVendaPersistido.getQuantidadeProduto();
	}
	
	public void excluir(Object objetoDadosAtualizacao) {
		this.previsaoVendaPersistido.excluir();
	}
	///1 relacionamentos localizados
	
	
	//Acesso ao objeto Produto
	public Produto_IN getProduto(){
		ProdutoPersistido op = this.previsaoVendaPersistido.getRegistroProdutoRelacionado();
		if(op==null)return null;
		return new Produto(op);
	}
}
