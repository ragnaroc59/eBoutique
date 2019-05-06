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

<c:forEach var="produit" items="${products}">
<div class="main">
<tr>
<td align="justify">${produit.libelle}</td> <br>
<img src="${produit.image}"  width="50" height="75" /><br>
<td align="justify">prix : ${produit.prix}</td> <br>
</tr>
</div>
</c:forEach>

</body>
</html>

