<div class="container">
	<h1> Liste des sites</h1>
	<c:out value="${site}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Lieu</th></tr>
	<tbody></tbody><c:forEach items="${siteBos}" var="siteBo">
		<tr>
			<td>${siteBo.id}</td>
			<td>${siteBo.nom}</td>
			<td>${siteBo.lieu}</td>
			
		</tr>
		
		
	</c:forEach>
	</table>
	<a class="btn btn-info" href="/escalade/site/edit.html" role="button" >Ajouter un site</a>
	
	
</div>