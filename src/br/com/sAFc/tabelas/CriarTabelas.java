package br.com.sAFc.tabelas;

public class CriarTabelas {

	public CriarTabelas() {

	}
	public static void main(String[] args) {
		TabelaCanalAquisicao.getInstancia().criarSe();
		TabelaCurva.getInstancia().criarSe();
		TabelaDestinacao.getInstancia().criarSe();
		TabelaInsumo.getInstancia().criarSe();
		TabelaInsumoProduto.getInstancia().criarSe();
		TabelaLinhaProducao.getInstancia().criarSe();
		TabelaLoteProducao.getInstancia().criarSe();
		TabelaModalAquisicao.getInstancia().criarSe();
		TabelaPrevisaoVenda.getInstancia().criarSe();
		TabelaProduto.getInstancia().criarSe();
		TabelaTipoInsumo.getInstancia().criarSe();
		TabelaUnidadeMedida.getInstancia().criarSe();
	}
}
