<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulaire Personne</title>
</head>
<body>
    <h2>Entrer les informations de la personne</h2>
    <form method="post" action="${pageContext.request.contextPath}/person">
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom" required ><br><br>

        <label for="prenom">Prénom :</label>
        <input type="text" name="prenom" id="prenom" required ><br><br>

        <input type="submit" value="Envoyer">
    </form>
</body>
</html>
