package br.com.sAFc.gui.base;

import java.util.Vector;

import br.com.sAFc.interfaces.gui.UsuarioSAFC;
import br.com.sAFc.interfaces.nucleo.Usuario_IN;

public class UsuarioWebSAFC implements UsuarioSAFC {

	private Vector<String> mensagens = new Vector<String>();
	private Usuario_IN usuario = null;
	
	public UsuarioWebSAFC(Usuario_IN usuario) {
		super();
		this.usuario = usuario;
	}

	public UsuarioWebSAFC() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addMensagem(String texto) {
		this.mensagens.add(texto);
	}
	
	public String [] getMensagens(){
		String r[]  = new String[mensagens.size()];
		mensagens.copyInto(r);
		mensagens.clear();
		return r;
	}

}
