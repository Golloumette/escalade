<div class="container">
	<h1> Liste des topos</h1>
	<c:out value="${topo}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Description</th><th>Lieu</th><th>Parution</th><th>Dispo</th></tr></thead>
	<tbody><c:forEach items="${topoBos}" var="topoBo">
		<tr>
			<td>${topoBo.id}</td>
			<td>${topoBo.nom}</td>
			<td>${topoBo.description}</td>
			<td>${topoBo.lieu}</td>
			
			</tr>
	</c:forEach></tbody>
	
	</table>
</div>