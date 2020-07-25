<div class="container">
	<h1>Liste des voies</h1>
	<c:out value="${voie}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Cotation</th><th>Subdivision</th><th>Equipe</th><th>Secteur</th></tr>
	<tbody></tbody><c:forEach items="${voieBos}" var="voieBo">
		<tr>
			<td>${voieBo.id}</td>
			<td>${voieBo.nom}</td>
			<td>${voieBo.cotation}</td>
			<td>${voieBo.subdivision}</td>
			<td>${voieBo.equipe}</td>
			<td>${voieBo.secteurBo.nom}</td>
			
		</tr>
		</c:forEach>
	</table>
	</div>
	