package br.com.sAFc.gui.campos;

import aplicacao.CampoTabelaSelecionaObjetoGerador;
import br.com.sAFc.gui.base.DecodificadorSAFC;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import br.com.sAFc.interfaces.nucleo.Usuario_IN;
import formularios.AdministradorCamposTabela;
import formularios.CampoDeFormulario;
import formularios.OperadorObjetos;

public class CampoTabelaSelecionaObjetosSAFC extends CampoTabelaSelecionaObjetoGerador {

	public CampoTabelaSelecionaObjetosSAFC(OperadorObjetos operadorObjetos) {
		super(operadorObjetos);
	}
	
	
	
	@Override
	public String getTextoTitulo() {
		if(getUsuario()==null){
			return null;
		}
		return ((OperadorObjetosAbstratoSAFC)getOperadorObjetos()).getTitulo();
	}
	
	public Usuario_IN getUsuario(){
		return ((DecodificadorSAFC)getFormulario().getDecodificadorComandos()).getUsuario();
	}
	
	@Override
	public boolean isBloqueado() {
		return getUsuario()==null;
	}
	
	
	public void getTituloTabela_(StringBuffer sb) {
		CampoDeFormulario[] campos = getCampoAtributoObjetoNegocios();
		AdministradorCamposTabela adm = getAdministradorCamposTabela();
//		String codDif = "__" + contador; //$NON-NLS-1$
		if (adm != null) {
			campos = adm.getCampos();
		}
		String titulo = getTextoTitulo();
		if (titulo != null) {
			int numCols = campos.length + 1;
			if (isBloqueado()) {
				numCols = campos.length;
			}
			sb.append("<tr>"); //$NON-NLS-1$
			sb.append("<th colspan='" + numCols + "' " + getParmsTHTitulo() //$NON-NLS-1$ //$NON-NLS-2$
					+ "  >"); //$NON-NLS-1$

			sb
					.append("<table onclick=\" clicou" //$NON-NLS-1$
					//		+ codDif
							+ "(null,'" //$NON-NLS-1$
							+ getNome()
							+ "',null);\"  cellpadding='0' cellspacing='0' border='0' width='100%' >"); //$NON-NLS-1$
			sb.append("<tr>"); //$NON-NLS-1$
			sb.append("<th align='left' " + getParmsTHTitulo() //$NON-NLS-1$
					+ "  width='5%'  >"); //$NON-NLS-1$
			sb.append("</th>"); //$NON-NLS-1$
			sb.append("</tr>"); //$NON-NLS-1$
		}
//		super.getTituloTabela(sb);
	}
	
	

	
}
