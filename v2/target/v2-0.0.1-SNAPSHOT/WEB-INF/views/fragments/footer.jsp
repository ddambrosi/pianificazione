<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
	<hr>
	<footer>
		<p>Qualcosa da inserire nel footer</p>
	</footer>
</div>

<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${bootstrapJs}"></script>


