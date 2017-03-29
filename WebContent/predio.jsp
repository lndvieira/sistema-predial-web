<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="model.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Empresa</title>
</head>
<body>
<%Empresa empresa = (Empresa)request.getAttribute("empresa"); %>
Razao Social: <%=empresa.getRazaoSocial() %><br>
CNPJ: <%=empresa.getCnpj() %><br>
Temperatura do ar: <%=empresa.getTemperatura() %>
Conjunto: <%=empresa.getConjunto() %><br>
Horario de Entrada: <%=empresa.getHoraFuncionamento() %><br>
Horario do Ar: <%=empresa.getHoraArCondicionado() %><br>
</body>
</html>