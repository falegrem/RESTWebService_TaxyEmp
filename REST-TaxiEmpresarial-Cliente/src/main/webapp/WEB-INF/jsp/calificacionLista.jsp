<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calificaciones</title>
</head>
<body>
<h1>Realizar calificación </h1>

<c:url var="addUrl" value="/encuesta/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#00FFFF">
		<tr>
			<th>Codigo Reserva</th>
			<th>Calificacion</th>
			<th>Observaciones</th>
			<th colspan="4"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${calificacion}" var="calificacion">
			<c:url var="editUrl" value="/encuesta/update?cod_reserva=${calificacion.cod_reserva}" />
		<tr>
			<td><c:out value="${calificacion.cod_reserva}" /></td>
			<td><c:out value="${calificacion.cal_preg1}" /></td>
			<td><c:out value="${calificacion.cal_preg2}" /></td>
			<td><a href="${editUrl}">Editar</a></td>
			
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>