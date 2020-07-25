<div class="container">
	<h1> Liste des sites</h1>
	
	<table class="table table-hover table-striped">
	
	<thead><tr><th>Nom</th><th>Lieu</th></tr>
	<tbody></tbody><c:forEach items="${siteBos}" var="siteBo">
		<input type="hidden" name="id" value="${siteBo.id}">
		<tr>
			
			<td><a href="/escalade/site/edit.html?id=${siteBo.id}"> ${siteBo.nom}</a></td>
			<td>${siteBo.lieu}</td>
			
		</tr>
		
		
	</c:forEach>
	</table>
	<a class="btn btn-info" href="/escalade/site/edit.html" role="button" >Ajouter un site</a>
	
	
</div>