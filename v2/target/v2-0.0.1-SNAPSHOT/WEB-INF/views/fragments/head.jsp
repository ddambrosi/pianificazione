<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />

	<!-- CSS file -->
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/EasyAutocomplete-1.3.3/easy-autocomplete.min.css">
	
	<script src="${pageContext.request.contextPath}/webjars/jquery/1.11.1/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/EasyAutocomplete-1.3.3/jquery.easy-autocomplete.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/table.js"></script>	
