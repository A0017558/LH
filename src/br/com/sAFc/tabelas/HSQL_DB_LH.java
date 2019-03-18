package br.com.sAFc.tabelas;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import loginterface.LogMensagens;
import tabelas.BD_HSQLDB;
import tabelas.UsuarioDB;
import util.GregorianCalendarAutoApresentavel;

public class HSQL_DB_LH extends BD_HSQLDB {

	
	private static HSQL_DB_LH instancia=  new HSQL_DB_LH();
	
	private Connection conn = null;
	
	public static HSQL_DB_LH getInstancia() {
		return instancia;
	}
	
	
	public HSQL_DB_LH() {
		super();
	}


	@Override
	public String getFile() {
//		return "C:\\gerador\\dbx2_safc";
		return "C:\\wsafc\\dbx2_lh";
	}
	
	@Override
	public Connection getConexaoControlada(UsuarioDB usuario)
			throws SQLException {
		this.conn = super.getConexaoControlada(usuario);
		return conn;
	}
	@Override
	public Connection getConexaoEmSessao(UsuarioDB usuario) throws SQLException {
		this.conn = super.getConexaoEmSessao(usuario);
		return conn;
	}
	
	@Override
	public String getFormatoTimestampt(GregorianCalendar gc) {
		if(gc==null){
			LogMensagens.getLogMensagens().addMensagem("getFormatoTimestampt GregorianCalendar gc=null");			 //$NON-NLS-1$
			return null;
		}
		String dia = completaZeros(String.valueOf(gc.get(GregorianCalendar.DATE)),2);
		String mes = completaZeros(String.valueOf(gc.get(GregorianCalendar.MONTH)+1),2);
		String ano = completaZeros(String.valueOf(gc.get(GregorianCalendar.YEAR)),4);
		String hora = completaZeros(String.valueOf(gc.get(GregorianCalendar.HOUR_OF_DAY)),2);
		String minuto = completaZeros(String.valueOf(gc.get(GregorianCalendar.MINUTE)),2);
		String segundo = completaZeros(String.valueOf(gc.get(GregorianCalendar.SECOND)),2);

		if(gc instanceof  GregorianCalendarAutoApresentavel){
			String milhonesimo = String.valueOf(((GregorianCalendarAutoApresentavel)gc).getMilhonesimoDeSegundo());
			return ano+"-"+mes+"-"+dia+" "+hora+":"+minuto+":"+segundo;//+"."+miliSegundo;//+milhonesimo;		
					

		}else{
			return ano+"-"+mes+"-"+dia+" "+hora+":"+minuto+":"+segundo;//+"."+miliSegundo;		 
		}
	}
	
	@Override
	public String getFormatoDate(GregorianCalendar gc) {
		if(gc==null){
			LogMensagens.getLogMensagens().addMensagem("getFormatoDate GregorianCalendar gc=null");			 //$NON-NLS-1$
			return null;
		}
		String dia = completaZeros(String.valueOf(gc.get(GregorianCalendar.DATE)),2);
		String mes = completaZeros(String.valueOf(gc.get(GregorianCalendar.MONTH)+1),2);
		String ano = completaZeros(String.valueOf(gc.get(GregorianCalendar.YEAR)),4);
		return ano+"-"+mes+"-"+dia;
	}
	
	
	@Override
	public GregorianCalendarAutoApresentavel getGregorianCalendar(String data){
		
		try {
			return new GregorianCalendarAutoApresentavel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private String completaZeros(String string,int comprimento){
		while(string.length()<comprimento){
			string = "0"+string; //$NON-NLS-1$
		}
		return string;
	}
	
	private String completaZerosDireita(String string,int comprimento){
		while(string.length()<comprimento){
			string+="0"; //$NON-NLS-1$
		}
		return string;
	}	

	
	public void fecharConn(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
}
