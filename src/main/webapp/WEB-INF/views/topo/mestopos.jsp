 <div class="container">
 
<h1 style="text-align: center"> Mes topos</h1>
	
	
	<table class="table table-hover table-striped">
	
	<thead><tr>
	<th class="topo-nom">Nom</th>
	<th class="topo-description">Description</th>
	<th class="topo-lieu">Lieu</th>
	<th class="topo-parution">Date de parution</th>
	<th class="topo-dispo">Disponible</th>
	</tr>
	<tbody></tbody><c:forEach items="${topoBos}" var="topoBo">
		
		<tr>
			
			<td data-label="nom"><a href="/escalade/topo/edit.html?id=${topoBo.id}">${topoBo.nom}</a></td>
			<td data-label="description">${topoBo.description}</td>
			<td data-label="lieu">${topoBo.lieu}</td>
			<td data-label="parution"><fmt:formatDate pattern = "yyyy-MM-dd" value="${topoBo.dt_parution}"/></td>
			<c:if test="${topoBo.disponible == 0}">
			<td data-label="dispo">disponible</td>
			</c:if>
			<c:if test="${topoBo.disponible == 1}">
			<td><a class="btn btn-info" href="/escalade/reservation/update.html?topo_id=${topoBo.id}" role="button" >Valider la reservation</a></td>
			</c:if>
			<c:if test="${topoBo.disponible == 2}">
			<td>indisponible</td>
			
			</c:if>
			
		</tr>
		
		
	</c:forEach>
	</table>

<a class="btn btn-info" href="/escalade/topo/edit.html" role="button" >Ajouter un topo</a>
</div>