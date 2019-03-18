<%@page import="br.com.sAFc.gui.formularios.FormularioMenuLH"%>
<%@page import="br.com.sAFc.gui.formularios.FormularioAbstratoSAFC"%>
<%@page import="br.com.sAFc.gui.base.DecodificadorSAFC"%><%@page 
import="formularios.PoolDecodificadores"%><%@ page 
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%
	DecodificadorSAFC dec =  
	(DecodificadorSAFC) PoolDecodificadores.getDedodificador(DecodificadorSAFC.class.getName(), session.getId());
dec.decodificarComandos(request);
dec.setFormularioAtivo(FormularioAbstratoSAFC.nomeGrupoMenu, FormularioMenuLH.class);

String r = dec.getCodigoHTML("");
%><%=r%>