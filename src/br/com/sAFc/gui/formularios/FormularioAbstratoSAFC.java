package br.com.sAFc.gui.formularios;

import br.com.sAFc.gui.base.DecodificadorSAFC;
import br.com.sAFc.interfaces.gui.UsuarioSAFC;
import br.com.sAFc.interfaces.nucleo.NucleoSAFC;
import br.com.sAFc.interfaces.nucleo.Usuario_IN;
import formularios.DecodificadorComandos;
import formularios.FormularioAbstrato;

public abstract class FormularioAbstratoSAFC extends FormularioAbstrato {

	public static final String nomeGrupoConteudo = "conteudo";
	public static final String nomeGrupoMenu = "menu";
	public static final String nomeGrupoSubmenu = "submenu";
	
	public static final int AREA_PRINCIPAL_LOGO_GRANDE = 1;
	public static final int AREA_PRINCIPAL_LOGO_PEQUENO = 2;
	public static final int AREA_PRINCIPAL_BOX = 3;
	public static final int AREA_PRINCIPAL_ADM_MAPA = 4;
	public static final int AREA_PRINCIPAL_VAZIA = 5;
	public static final int AREA_PRINCIPAL_TEMAS = 6;


	
	
	public FormularioAbstratoSAFC(DecodificadorComandos decodificadorComandos) {
		super(decodificadorComandos);
	}

	@Override
	public boolean isSequencialmenteControlado() {
		return false;
	}
	
	@Override
	public void exec() throws Throwable {
		
	}

	@Override
	public String getAction() {
		return ""; 
	}
	
	public DecodificadorSAFC getDecodificadorSAFC(){
		return (DecodificadorSAFC) getDecodificadorComandos();
	}
	
	public NucleoSAFC getNucleoSAFC(){
		return getDecodificadorSAFC().getNucleoSAFC();
	}
	
	@Override
	public String getNomeGrupoFormularios() {
		return nomeGrupoConteudo;
	}
	
	public void setModoListagem(){
		
	}

	public Usuario_IN getUsuario() {
		return getDecodificadorSAFC().getUsuario();
	}
	
	@Override
	public void quandoDesativar() {
		reset();
	}
	

	public String getTitulo() {
		return "";
	}	
	
	public int getTipoAreaPrincipal(){
		return AREA_PRINCIPAL_LOGO_PEQUENO;
	}
	
	public UsuarioSAFC getUsuarioSAFC() {
		return getDecodificadorSAFC().getUsuarioSAFC();
	}

	
	

}
