<div class="container">
	<h1> Liste des topos</h1>
	<c:out value="${topo}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>Nom</th><th>Description</th><th>Lieu</th><th>Parution</th><th>Propriétaire</th></tr></thead>
	<tbody><c:forEach items="${topoBos}" var="topoBo">
		<tr>
		<c:if test="${topoBo.disponible == true}">
			
			<td><a href="/escalade/topo/edit.html?id=${topoBo.id}">${topoBo.nom}</a></td>
			<td>${topoBo.description}</td>
			<td>${topoBo.lieu}</td>
			<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${topoBo.dt_parution}"/></td>
			<td>${topoBo.utilisateurBo.nom}</td>
			<td><button type="button" class="btn btn-primary" onclick="window.location='waiting.html'">Reserver</button></td>
			</c:if>
			</tr>
	</c:forEach></tbody>
	
	</table>
	
</div>