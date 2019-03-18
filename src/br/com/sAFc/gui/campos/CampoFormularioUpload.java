package br.com.sAFc.gui.campos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import server.ServidorWeb;
import br.com.sAFc.gui.formularios.FormularioAbstratoSAFC;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.Usuario_IN;
import br.com.sAFc.tabelas.TabelaControleNumeroArquivo;
import formularios.CampoDeFormularioInputStream;

public class CampoFormularioUpload extends CampoDeFormularioInputStream {

	
	private String nomeDesignado = null;
	private OperadorObjetosAbstratoSAFC operadorObjetos = null;
	
	public CampoFormularioUpload(OperadorObjetosAbstratoSAFC operadorObjetos) {
		super(operadorObjetos.getFormularioAbstratoSAFC(), false);
		this.operadorObjetos = operadorObjetos;
	}

	
	public static String getFileLocation(){
		return  ServidorWeb.getFileLocation()+File.separatorChar;
	}
	
	
	@Override
	public OutputStream getOutputStream() {
		String fl = getFileLocation();// ServidorWeb.getFileLocation()+File.separatorChar;
		String nm = getValorString();
		int posPonto = nm.lastIndexOf(".");
		this.nomeDesignado = "_"+TabelaControleNumeroArquivo.getProximoNumero()+"_"+nm.substring(posPonto);
		String nmArq = fl+nomeDesignado;
		File f = new File(fl+nomeDesignado);
		for(int i=1;f.exists();){
			nmArq = fl+i+"_"+nm;
			setValor(i+"_"+nm);
		} 
		try {
			return new FileOutputStream(nmArq);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public String getNomeDesignado() {
		return nomeDesignado;
	}


	

	public void setNomeDesignado(String nomeDesignado) {
		this.nomeDesignado = nomeDesignado;
	}
	public Usuario_IN getUsuario(){
		return ((FormularioAbstratoSAFC)getFormulario()).getDecodificadorSAFC().getUsuario();			
	}
	@Override
	public boolean isBloqueado() {
		if(!getFormulario().isBloqueado()){
			return super.isBloqueado();
		}
		if(getUsuario()==null){
			return true;
		} 
		return super.isBloqueado();
	}
	@SuppressWarnings("rawtypes")
	@Override
	public boolean isHabilitado(){
//		if(true){
//			return false;
//		}
		OperadorObjetosAbstratoSAFC op =  getOperadorObjetos();
		if(op!=null && op.isModoListagem()){
			return false;
		}
		return super.isHabilitado();
	}
	
	@SuppressWarnings("rawtypes")
	public OperadorObjetosAbstratoSAFC getOperadorObjetos() {
		return operadorObjetos;
	}
}
