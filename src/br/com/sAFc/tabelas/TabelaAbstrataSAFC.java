package br.com.sAFc.tabelas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import loginterface.LogMensagens;
import tabelas.Campo;
import tabelas.Coluna;
import tabelas.ColunaData;
import tabelas.ColunaInteiros;
import tabelas.ColunaString;
import tabelas.ColunaTimestamp;
import tabelas.Registro;
import tabelas.Tabela;
import tabelas.UsuarioDB;
import util.Messages;

public abstract class TabelaAbstrataSAFC<Reg extends RegistroSAFC> extends Tabela<Reg> {

	
	
	
	

	public TabelaAbstrataSAFC() {
		super();
	}

	public TabelaAbstrataSAFC(String nome) {
		super(HSQL_DB_LH.getInstancia(), nome);
	}

	@Override
	public UsuarioDB getUsuarioDB() {
		return new UsuarioDB("ususafc", "");
	}
	
	@Override
	public Reg[] getRegistros() {

		try {
			return super.getRegistros();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public synchronized Reg[] getRegistros(String clausulaWhere,Tabela[] tabelasRelacionadas){
		try{
			return super.getRegistros(clausulaWhere, tabelasRelacionadas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Reg getRegistro(String clausulaWhere) {

		try {
			return super.getRegistro(clausulaWhere);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public synchronized Reg[] getRegistros(String clausulaWhere){

		try {
			return super.getRegistros(clausulaWhere);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Reg getRegistroPorChaveReduzida(String chaveReduida){
		try {
			if(chaveReduida==null || chaveReduida.trim().length()==0){
				return null;
			}
			return super.getRegistroPorChaveReduzida(chaveReduida);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() throws SQLException {
		return super.getConnection(getUsuarioDB());
	}
	
	@Override
	public String getNome() {
		String nm = super.getNome();
		int posPonto = nm.indexOf(".");
		if(posPonto>0){
			nm= nm.substring(posPonto+1);
		}
		return nm;
	}

	@Override
	public void criarSe() {
		try {
			super.criarSe();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
	}
	
	public void exclusaSe(){
		StringBuffer sb = new StringBuffer();
		sb.append("DROP TABLE "+getNome()+"");
		
		LogMensagens.getLogMensagens().addMensagem(":"+sb.toString());
		System.out.println(":"+sb.toString());
		try {
			Connection conn =  getConnection(getUsuarioDB());
	        Statement st = null;
	        st = conn.createStatement();   
	        int i = st.executeUpdate(sb.toString());    
	        if (i == -1) {
	            System.out.println("db error : " + sb.toString());
	        }
	        st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public String getInsertSQLPprepareStatement(Coluna []  colunas){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into "+this.getNome()+" (");
		boolean virgula = false;
		for (int i = 0; i < colunas.length; i++) {
			if(virgula){
				sb.append(","); //$NON-NLS-1$
			}
			sb.append(colunas[i].getNome());
			virgula=true;
		}
		sb.append(") values (");		
		for (int i = 0; i < colunas.length; i++) {
			if(virgula){
				sb.append(","); //$NON-NLS-1$
			}
			sb.append(" ? ");
			virgula=true;
		}

		return sb.toString();

	}
	public String getUpdateSQLPprepareStatement(Coluna []  colunas, Campo[] camposChave){
		StringBuffer sb = new StringBuffer();
		sb.append("update "+this.getNome()+" set ");
		boolean virgula = false;
		for (int i = 0; i < colunas.length; i++) {
			if(virgula){
				sb.append(", "); 
			}
			sb.append(colunas[i].getNome()+"=? ");
			virgula=true;
		}
		virgula=false;
		sb.append(" where ");		
		for (int i = 0; i < camposChave.length; i++) {
			if(virgula){
				sb.append(", "); 
			}
			sb.append(" ");
			sb.append(camposChave[i].getNome()+"=? ");
			virgula=true;
		}
		return sb.toString();
	}
	
	public void carregarPreparedStatement(Registro r,PreparedStatement stmt,Coluna []  colunas, Campo[] camposChave) throws SQLException{
		int i = 0;
		for ( ;i < colunas.length; i++) {
			Coluna col = colunas[i];
			if(col instanceof ColunaString){
				stmt.setString(i+1, r.getCampo(col).getValorString());
			}else if(col instanceof ColunaInteiros){
				stmt.setInt(i+1, r.getCampo(col).getValorInt());
			}else if(col instanceof ColunaData){
				Date d = new Date(r.getCampo(col).getValorGregorianCalendar().getTimeInMillis());
				stmt.setDate(i+1, d);
			}else if(col instanceof ColunaTimestamp){
				Timestamp t = new Timestamp(r.getCampo(col).getValorGregorianCalendar().getTimeInMillis());
				stmt.setTimestamp(i+1, t);
			}else{
				throw new RuntimeException("Tipo coluna não reconhecido");
			}			
		}
		for ( ;camposChave!=null&& i < camposChave.length; i++) {
			Coluna col = camposChave[i].getColuna();
			if(col instanceof ColunaString){
				stmt.setString(i+1, r.getCampo(col).getValorString());
			}else if(col instanceof ColunaInteiros){
				stmt.setInt(i+1, r.getCampo(col).getValorInt());
			}else if(col instanceof ColunaData){
				Date d = new Date(r.getCampo(col).getValorGregorianCalendar().getTimeInMillis());
				stmt.setDate(i+1, d);
			}else if(col instanceof ColunaTimestamp){
				Timestamp t = new Timestamp(r.getCampo(col).getValorGregorianCalendar().getTimeInMillis());
				stmt.setTimestamp(i+1, t);
			}else{
				throw new RuntimeException("Tipo coluna não reconhecido");
			}			
		}
	}

	@Override
	public Campo getCOUNT(Coluna coluna, String clausulaWhere) {
		
		return super.getCOUNT(new ColunaInteiros("*", this, false), clausulaWhere);
	}
	
	public synchronized String atualizarRegistro_(Registro registro)throws SQLException{		
		//Retirar os comentarios do logmensagens quando as tabelas forem testadas na produção.
		//String where = registro.getIdentificadorChavePrimaria();
		//System.out.println("Atualizando registro... "+where);
		Coluna [] cols = getColunas();
		Campo [] camposChave = getCamposChave();
		String sql = getUpdateSQLPprepareStatement(cols, camposChave);// registro.getSQLUpdate();
		
		//String sqlUndo = null;
		
		//Connection conn = this.bancoDeDados.getConnection(this.getUsuarioDB());
		Connection conn = this.getConnection(this.getUsuarioDB());		
		if(conn==null){
			LogMensagens.getLogMensagens().addMensagem("Sem conexão para trabalho"); 
			return null;
		}		
		PreparedStatement stmt = null;
		LogMensagens.getLogMensagens().addMensagem("SQL update:"+sql); 
	
		stmt = conn.prepareStatement(sql);
		carregarPreparedStatement(registro, stmt, cols, camposChave);
		if(!registro.executandoUpdate()){
			return Messages.getString("Tabela.5"); //$NON-NLS-1$
		}
		//long tempo = -1;
		try{
			LogMensagens.getLogMensagens().addMensagem("Executando update="+sql); //$NON-NLS-1$
			//long antes = (new java.util.Date()).getTime();
			stmt.executeUpdate(sql);
			//long depois = (new java.util.Date()).getTime();
			//tempo = depois-antes;

		}catch(SQLException e){
			LogMensagens.getLogMensagens().addMensagemErro("Erro na query:"+sql,e); //$NON-NLS-1$
			throw new RuntimeException("Erro na query:"+sql ,e); //$NON-NLS-1$
		}finally{
		//	LogMensagens.getLogMensagens().addMensagem("Fechando conexões");
			stmt.close();
			fecharConn(conn);
		}
		registro.atualizarIdentificadorChavePrimaria();
		
		//if(sqlUndo!=null)getBancoDeDados().addLogUndo("[tempo=+"+tempo+"ms "+sql+"] "+sqlUndo); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//		getBancoDeDados().addLogUndo("[tempo=+"+tempo+"ms "+sql+"] ");
		return sql;
	}

	public synchronized String salvarNovoRegistro_(Registro registro)throws SQLException{
		//Retirar os comentários do LogMensagens quando as tabelas da produção forem testadas.
		Coluna [] cols = getColunas();
		String sql = getInsertSQLPprepareStatement(cols);
		
		//Connection conn = this.bancoDeDados.getConnection(this.getUsuarioDB());
		Connection conn = this.getConnection(this.getUsuarioDB());		
		if(conn==null){
			LogMensagens.getLogMensagens().addMensagem(Messages.getString("Tabela.6")); //$NON-NLS-1$
			return null;
		}		
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(sql);
		if(!registro.executandoInsert()){
			LogMensagens.getLogMensagens().addMensagem(Messages.getString("Tabela.7")); //$NON-NLS-1$
			return Messages.getString("Tabela.8"); //$NON-NLS-1$
		}
		//long tempo = -1;
		try{
			LogMensagens.getLogMensagens().addMensagem("Executando insert="+sql); //$NON-NLS-1$
			//long antes = (new java.util.Date()).getTime();
			stmt.executeUpdate(sql);
			//long depois = (new java.util.Date()).getTime();
			//tempo = depois-antes;
		}catch(SQLException e){
		//	LogMensagens.getLogMensagens().addMensagemErro("Erro na query:"+query,e);
			stmt.close();
			fecharConn(conn);
			throw new RuntimeException("Erro na query:"+sql+" "+e.toString()+ e.getMessage() ,e); //$NON-NLS-1$ //$NON-NLS-2$
		}
		stmt.close();
		fecharConn(conn);
		registro.setNovo(false);
		registro.atualizarIdentificadorChavePrimaria();
		
//		String sqlUndo = null;
//		if(isRollBackAtivo()){
//			String where = registro.getIdentificadorChavePrimaria();
//			sqlUndo = "[tempo=+"+tempo+"ms "+sql+"] delete from "+this.getNome()+" where "+where+""; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
//		}else{
//			sqlUndo = "[tempo=+"+tempo+"ms "+sql+"]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//		}
//		if(sqlUndo!=null)getBancoDeDados().addLogUndo(sqlUndo);		
		return sql;
	}

	private void fecharConn(Connection conn){
		
	}
	
	public String getListaNomeCompletoCampos(String qualificador){
		String listC = null;
		Coluna coluna[] = this.getColunas();
		listC = " "; 
		for (int i = 0; i < coluna.length; i++) {
			if(i>0){
				listC+=", "; 
			}
			String nColuna = qualificador+"."+coluna[i].getNome();  
			listC+=nColuna;
		}
		return listC;
	}
	
	public void addAndToSb(StringBuffer sb,String c ){
		if(c!=null && c.trim().length()>0){
			if(sb.length()>0){
				sb.append(" and ");
			}
			sb.append(c);
		}			
	}
	public String print(){
		Registro [] regs= getRegistros(); 
		StringBuffer sb = new StringBuffer();
		System.out.println(regs.length+" Registros...");
		for (int j = 0; j < regs.length; j++) {
			RegistroSAFC registro =  (RegistroSAFC) regs[j];
			sb.append(registro.print());
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
