<%@ page isELIgnored="false"  %>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>

<style>
.selectOption{
  padding: 8px;
}
</style>

<header class="header-section">
	<div class="header-top">
		<div class="container">
			<div class="row pt-4 pb-4">
				<div class="col-xl-12 col-lg-12 text-center ">E-Boutique</div>
				<div class="col-xl-6 col-lg-5"></div>
				<div class="col-xl-4 col-lg-5"></div>
			</div>
		</div>
	</div>
	<nav class="main-navbar">
		<div class="container">
			<nav class="nav">
               <c:forEach var="marque" items="${marques}">
                 <a class="nav-link" href="http://localhost:8090/eboutique-web/accueil/${marque.libelle}">${marque.libelle}</a>
               </c:forEach>
			</nav>
		</div>
	</nav>
</header>