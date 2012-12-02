<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Listar Calificaciones </title>
</head>
<body>
<h1>Listar Calificaciones</h1>

<c:if test="${empty calificaciones}">
	No records found!
</c:if>

<c:if test="${!empty calificaciones}">
	<table style="border: 1px solid #444">
		<tr>
		<td style="width: 100px">Codigo</td>
		<td>${calificaciones.cal_cod}</td>
		</tr>
		
		<tr>
		<td>Codigo Reserva</td>
		<td>${calificaciones.cod_reserva}</td>
		</tr>
		
		<tr>
		<td>Fecha Inicio</td>
		<td>${calificaciones.cal_fecha_ini}</td>
		</tr>
		
		<tr>
		<td>Fecha Fin</td>
		<td>${calificaciones.cal_fecha_fin}</td>
		</tr>
		
		<tr>
		<td>Calificacion Servicio</td>
		<td>${calificaciones.cal_preg1}</td>
		</tr>
		
		<tr>
		<td>Observaciones</td>
		<td>${calificaciones.cal_preg2}</td>
		</tr>
		
		<tr>
		<td>Estado</td>
		<td>${calificaciones.cal_estado}</td>
		</tr>
	</table>
</c:if>

</body>
</html>