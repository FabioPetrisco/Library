<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library - Home page</title>
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp"%>
<div class="categorie">
    <c:forEach items="${categorie}" var="categoria">
        <div class="categoria">
            <h1>${categoria.nome}</h1>

        </div>

    </c:forEach>
</div>
</body>
</html>