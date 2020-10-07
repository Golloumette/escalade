<div class="container">
	<h1> Liste des topos</h1>
	<c:out value="${topo}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Description</th><th>Lieu</th><th>Parution</th><th>Dispo</th><th>Propriétaire</th></tr></thead>
	<tbody><c:forEach items="${topoBos}" var="topoBo">
		<tr>
			<td>${topoBo.id}</td>
			<td><a href="/escalade/topo/edit.html?id=${topoBo.id}">${topoBo.nom}</a></td>
			<td>${topoBo.description}</td>
			<td>${topoBo.lieu}</td>
			<td>${topoBo.dt_parution}</td>
			<c:if test="${topoBo.disponible == true}">
			<td>oui</td>
			</c:if>
			<c:if test="${topoBo.disponible == false}">
			<td>non</td>
			</c:if>
			<td>${topoBo.utilisateurBo.nom}</td>
			
			
			</tr>
	</c:forEach></tbody>
	
	</table>
</div>