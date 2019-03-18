package br.com.sAFc.gui.base;

import util.HashTableControlavel;
import br.com.sAFc.interfaces.nucleo.Usuario_IN;

public class PoolUsuariosLogados extends HashTableControlavel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6390662301091765081L;
	private static PoolUsuariosLogados instancia = new PoolUsuariosLogados("PoolUsuarios",3600,60*3,PoolUsuariosLogados.LIMPEZA_TIMEOUT_ACESSO_OBJETO );
	
	public static Usuario_IN getUsuario(String id){
		return  (Usuario_IN) instancia.get(id);
	}
	
	public static void setUsuario(String id,Usuario_IN usu){
		instancia.put(id, usu);
	}
	public static void removeUsuario(String id){
		instancia.remove(id);
	}
	
	private PoolUsuariosLogados(String nome, int timeout,
			int intervaloVerificacao, int tipoLimpeza) {
		super(nome, timeout, intervaloVerificacao, tipoLimpeza);
	}
	
}
