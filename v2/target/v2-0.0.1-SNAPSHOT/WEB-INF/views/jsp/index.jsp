<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="it">
<head>
<script src = "/webjars/jquery/1.11.1/jquery.js"> </script>
<script src = "/webjars/jquery-ui/1.11.4/jquery-ui.js"> </script>
<script>
$( document ).ready(function() {
	  console.log("ok");
	});

</script>
<title>Spring MVC</title>
</head>
<body>
	<table>
		<tr>
			<td>Risorsa</td>
			<td>Attività</td>
			<td>Progetto</td>
			<td>Tariffa</td>
			<td>Valuta</td>
			<td>Consolidato mese 1</td>
			<td>Prodotto mese 1</td>
			<td>Consolidato mese 2</td>
			<td>Prodotto mese 2</td>
			<td>Consolidato mese 3</td>
			<td>Prodotto mese 3</td>
		</tr>
		
		<c:forEach items="${list}" var="item">
	<tr>
			<td>${item.employeeDesc}</td>
			<td>${item.activityType}</td>
			<td>${item.projectDesc}</td>
			<td>${item.price}</td>
			<td>${item.currency}</td>
			<td>${item.cons0}</td>
			<td>${item.prod0}</td>
			<td>${item.cons1}</td>
			<td>${item.prod1}</td>
			<td>${item.cons2}</td>
			<td>${item.prod2}</td>
		</tr> 
		</c:forEach>
	</table>
	<form>
		Risorsa : <input type="Text" size=35> <br>Matricola : <input
			type="text" size=40 readonly disabled> <br> Business
		Unit : <input type="text" size=10 readonly disabled> <br>
		Progetto: <input type="text" size=30><br> Attività: <input
			type="text" size=30 readonly disabled><br> Valuta: <input
			type="text" size=30 readonly disabled><br> Cliente: <input
			type="text" size=30 readonly disabled><br> Tariffa: <input
			type="text"size 30><br> Consolidato mese 1: <input
			type="text"size 30><br> Prodotto mese 1: <input
			type="text"size 30><br> Consolidato mese 2: <input
			type="text"size 30><br> Prodotto mese 2: <input
			type="text"size 30><br> Consolidato mese 3: <input
			type="text"size 30><br> Prodotto mese 3: <input
			type="text"size 30><br>
	</form>
</body>
</html>