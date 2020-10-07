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
			<c:if test="${topoBo.disponible == true}">
			<td>oui</td>
			</c:if>
			<c:if test="${topoBo.disponible == false}">
			<td>non</td>
			</c:if>
			
		</tr>
		
		
	</c:forEach>
	</table>

<a class="btn btn-info" href="/escalade/topo/edit.html" role="button" >Ajouter un topo</a>
</div>