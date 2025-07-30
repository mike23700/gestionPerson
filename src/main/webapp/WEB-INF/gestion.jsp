<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion des personnes</title>
</head>
<body>
    <h2>Gérer les personnes</h2>
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <!-- Formulaire de recherche -->
    <form method="post" action="${pageContext.request.contextPath}/gestion">
        <input type="hidden" name="action" value="rechercher" />
        <label for="nomR">Rechercher par nom :</label>
        <input type="text" name="nom" id="nomR" required />
        <input type="submit" value="Rechercher" />
    </form>

    <!-- Formulaire de suppression manuelle -->
    <form method="post" action="${pageContext.request.contextPath}/gestion">
        <input type="hidden" name="action" value="supprimer" />
        <label for="nomS">Supprimer par nom :</label>
        <input type="text" name="nom" id="nomS" required />
        <input type="submit" value="Supprimer" />
    </form>

    <!-- Bouton pour lister -->
    <form method="post" action="${pageContext.request.contextPath}/gestion">
        <input type="hidden" name="action" value="liste" />
        <input type="submit" value="Lister toutes les personnes" />
    </form>

    <!-- Affichage d'une personne -->
    <c:if test="${not empty personne}">
        <h3>Résultat de la recherche :</h3>
        <p><strong>Nom :</strong> ${personne.nom}</p>
        <p><strong>Prénom :</strong> ${personne.prenom}</p>
    </c:if>

    <!-- Liste des personnes -->
    <c:if test="${not empty liste}">
        <h3>Liste des personnes :</h3>
        <table border="1" cellpadding="5">
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Action</th>
            </tr>
            <c:forEach var="p" items="${liste}">
                <tr>
                    <td>${p.nom}</td>
                    <td>${p.prenom}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/gestion" style="display:inline">
                            <input type="hidden" name="action" value="supprimer" />
                            <input type="hidden" name="nom" value="${p.nom}" />
                            <input type="submit" value="Supprimer" onclick="return confirm('Supprimer ${p.nom} ?')" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br>
    <a href="${pageContext.request.contextPath}/person">← Retour à l'ajout</a>
</body>
</html>
