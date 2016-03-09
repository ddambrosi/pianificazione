<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="it">
<head>
	<title>Spring MVC</title>
	<jsp:include page="../fragments/head.jsp" />
</head>
<jsp:include page="../fragments/nav.jsp" />
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