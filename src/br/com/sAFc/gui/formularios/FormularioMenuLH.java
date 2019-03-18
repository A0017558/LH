package br.com.sAFc.gui.formularios;

import br.com.lh.foms.FormularioProdutoInsumo;
import br.com.sAFc.gui.base.HTML_Obj;
import br.com.sAFc.gui.campos.CampoFormularioSAFC;
import formularios.DecodificadorComandos;
import formularios.HTML;
import formularios.ListaIdentificada;

public class FormularioMenuLH extends FormularioAbstratoSAFC {

	private HTML_Obj html = new HTML_Obj(){
		public String getHTML() {
			return "<!-- !id='campoSelecionaFormulario' -->";
		};
	};
	
	private CampoFormularioSAFC campoSelecionaFormulario = new CampoFormularioSAFC(this,false,CampoFormularioSAFC.TIPO_SELECT){
		public String getParmsHTML() {
			return " onchange=\"this.form.action='?EX='+this.value;this.form.submit()\";";
		};
		
	};
	
	
	public FormularioMenuLH(DecodificadorComandos decodificadorComandos) {
		super(decodificadorComandos);
		campoSelecionaFormulario.setValoresPossiveis(ObForm.opcoes);
	}

	
	@Override
	public String getNomeGrupoFormularios() {
		return nomeGrupoMenu;
	}
	
	public CampoFormularioSAFC getCampoSelecionaFormulario() {
		return campoSelecionaFormulario;
	}
	
	@Override
	public HTML getHtml() {
		return html;
	}
}class ObForm  implements ListaIdentificada{

	public static final ObForm [] opcoes = new ObForm[]{
		new ObForm(null,"Selecione..."),
		new ObForm(FormularioCanalAquisicao.class,"Canal"),
		new ObForm(FormularioCurva.class,"Curva"),
		new ObForm(FormularioDestinacao.class,"Destinação"),
		new ObForm(FormularioInsumo.class,"Insumo"),
		new ObForm(FormularioLinhaProducao.class,"Linha"),
		new ObForm(FormularioLoteProducao.class,"Lote"),
		new ObForm(FormularioModalAquisicao.class,"Modal"),
		new ObForm(FormularioPrevisaoVenda.class,"Previsão de Venda"),
		new ObForm(FormularioProdutoInsumo.class,"Produto"),
		new ObForm(FormularioTipoInsumo.class,"Tipo Insumo"),
		new ObForm(FormularioUnidadeMedida.class,"Unidade de Medida")
	};
	
	@SuppressWarnings("rawtypes")
	private Class classeForm =null;
	private String nome  =null;
	
	
	@SuppressWarnings({ "rawtypes" })
	private ObForm(Class classeForm, String nome ) {
		super();
		this.classeForm = classeForm;
		this.nome = nome;
	}

	@Override
	public String getCodigoIdentificadorLista() {
		if(classeForm==null){
			return "";
		}
		return classeForm.getName();
	}

	@Override
	public String getTituloLista() {
		return nome;
	}

}
