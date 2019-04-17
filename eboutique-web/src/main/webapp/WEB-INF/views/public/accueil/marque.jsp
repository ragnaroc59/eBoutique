<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<body>

<c:forEach var="produit" items="${products}">
<tr>
Produit : <td>${produit.libelle}</td> <br>
Prix : <td>${produit.prix}</td> <br>
</tr>
</c:forEach>

</body>
</html>

