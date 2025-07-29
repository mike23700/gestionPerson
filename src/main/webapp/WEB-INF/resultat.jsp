<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat</title>
</head>
<body>
    <c:choose>
        <c:when test="${success}">
            <h2><c:out value="${message}"/></h2>
            <p>Nom : <c:out value="${personne.nom}"/></p>
            <p>Prénom : <c:out value="${personne.prenom}"/></p>
        </c:when>
        <c:otherwise>
            <h2><c:out value="${message}" /></h2>
        </c:otherwise>
    </c:choose>

</body>
</html>
