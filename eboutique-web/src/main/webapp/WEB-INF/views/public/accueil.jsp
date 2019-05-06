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
.main {
         width: 100%;
         height : 25%;
         float: left;
         padding: 0px;
       }

</style>

<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<main class="container">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4">
				   <h2>RECHERCHE</h2><br>
				   <form >
                       <input type="text" name="critere" placeholder="Votre recherche"/><br><br>
                       <input type="submit" value="Rechercher"/>
				   </form>
				</div>
				<div class="col-md-8">
				<!-- Afficher la liste des mobiles -->
				<c:forEach var="produit" items="${allProducts}">
                    <div class="main">
                        <tr>
                            <td align="justify">${produit.libelle}</td> <br>
                            <img src="${produit.image}"  width="50" height="75" /><br>
                            <td align="justify">${produit.prix}</td> <br>
                        </tr>
                    </div>
                </c:forEach>
			</div>
		</div>
	<main>
</body>
</html>