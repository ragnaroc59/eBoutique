<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
	<main class="container">

<c:forEach items="${products}" var="phone">
    <tr>
       ${fn:length(products)}
        <td>Phone IdBis: ${phone.id} <br></td>
        <td>Phone libelle: "${phone.libelle}"</td>
    </tr>
</c:forEach>

<main>
</body>
</html>