<div class="container">
	<h1> Liste des topos</h1>
	<input type="hidden" name="topo_id" value="${topoBo.id}">
	<c:out value="${topoBo}"/>
	
	
	${reservationBo.dt_reservation}
	
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Description</th><th>Lieu</th><th>Parution</th><th>Propriétaire</th><th>Dispo</th></tr></thead>
	<tbody><c:forEach items="${topoBos}" var="topoBo">
		<tr>
		
		
			<td>${topoBo.id}</td>
			<td><a href="/escalade/topo/edit.html?id=${topoBo.id}">${topoBo.nom}</a></td>
			<td>${topoBo.description}</td>
			<td>${topoBo.lieu}</td>
			<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${topoBo.dt_parution}"/></td>
			<td>${topoBo.utilisateuBo.nom}</td>	
			<td> oui <a class="btn btn-info"  href="/escalade/reservation/waiting.html?topo_id=${topoBo.id}" role="button" >Reserver</a></td>
			<td>"${topoBo.disponible}"></td>
			<td>reserve</td>
			

			
		
			</tr>
			
	</c:forEach></tbody>
	
	</table>
	
			
</div>