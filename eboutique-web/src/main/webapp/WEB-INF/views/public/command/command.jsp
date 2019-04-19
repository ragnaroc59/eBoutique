<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<html>
<head>
<spring:url value="/assets/bootstrap/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="/assets/css/styles.css" var="main" />
<link rel="stylesheet" href="${bootstrap}">
<link rel="stylesheet" href="${main}">
</head>

<body>
<jsp:include page="../../common/header.jsp"></jsp:include>

<c:forEach var="command" items="${commands}">
    <div class="main">
        <tr>
            <td align="justify">Date:${command.dateCreation}</td> <br>
            <td>
                <c:forEach var="ligne" items="${command.lignes}">
                    ${ligne.produit.libelle} /
                    Quantite : ${ligne.quantite} /
                    Prix: ${ligne.produit.prix}
                    <img src="${ligne.produit.image}"  width="50" height="50"/> <br>
                </c:forEach>
            </td>
        </tr>
    </div>
</c:forEach>

</body>
</html>

