<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="it">
<head>
<!-- CSS file -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/EasyAutocomplete-1.3.3/easy-autocomplete.min.css">
<script
	src="${pageContext.request.contextPath}/webjars/jquery/1.11.1/jquery.js">
</script>
<script
	src="${pageContext.request.contextPath}/resources/EasyAutocomplete-1.3.3/jquery.easy-autocomplete.js"></script>
<script>


</script>
<title>Spring MVC</title>
</head>
<body>
	<table>
	<tr>
	 <th>Mese</th>
	 </tr>
	 <c:forEach items="${lista}" var = "item">
	     <tr>
			<td><a href="${pageContext.request.contextPath}/edit/v2?month=${item.month}&userid=Admin"><c:out value="${item.month}" /></a></td>
		</tr>
	 </c:forEach>
	</table>
</body>
</html>
