 <div class="container">
<h1><p class="text-center"> Mes topos</p></h1>
	
	<table class="table table-hover table-striped">
	
	<thead><tr><th>Nom</th><th>Description</th><th>Lieu</th><th>Date de parution</th><th>Disponible</th></tr>
	<tbody></tbody><c:forEach items="${topoBos}" var="topoBo">
		
		<tr>
			
			<td><a href="/escalade/topo/edit.html?id=${topoBo.id}">${topoBo.nom}</a></td>
			<td>${topoBo.description}</td>
			<td>${topoBo.lieu}</td>
			<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${topoBo.dt_parution}"/></td>
			<c:if test="${topoBo.disponible == 0}">
			<td>disponible</td>
			</c:if>
			<c:if test="${topoBo.disponible == 1}">
			<td><a class="btn btn-info" href="/escalade/reservation/update.html?topo_id=${topoBo.id}" role="button" >Valider la reservation</a></td>
			</c:if>
			<c:if test="${topoBo.disponible == 2}">
			<td>indisponible</td>
			
			</c:if>
			<td>
			<ul><c:forEach items="${topoBo.reservationBos}" var="reservationBo">
			<li>${reservationBo.id}</li>
			
			
			</c:forEach></ul> </td>
		</tr>
		
		
	</c:forEach>
	</table>

<a class="btn btn-info" href="/escalade/topo/edit.html" role="button" >Ajouter un topo</a>
</div>