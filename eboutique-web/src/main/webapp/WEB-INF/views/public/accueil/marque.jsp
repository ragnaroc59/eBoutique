<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<head>
<spring:url value="/assets/bootstrap/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="/assets/css/styles.css" var="main" />
<link rel="stylesheet" href="${bootstrap}">
<link rel="stylesheet" href="${main}">
</head>
<style>
.displayed {
    display: block;
    margin-left: auto;
    margin-right: auto
    }
.main {
         width: 10%;
         height : 25%;
         float: left;
         padding: 0px;
         border: 1px solid red;
       }

</style>

<body>
<jsp:include page="../../common/header.jsp"></jsp:include>
    <main class="container">
    <c:forEach var="produit" items="${products}">
        <div class="main">
            <tr>
                <td align="justify">${produit.libelle}</td> <br>
                <img class ="displayed" src="${produit.image}"  width="50" height="75" /><br>
                <td align="justify">${produit.prix}</td> <br>
            </tr>
        </div>
    </c:forEach>
<main>
</body>
</html>

