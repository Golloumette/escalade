<div class="container">
	<h1>Liste des voies</h1>
	<c:out value="${longueur}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Cotation</th><th>Subdivision</th><th>Spit</th><th>Voie</th></tr>
	<tbody></tbody><c:forEach items="${longueurBos}" var="longBo">
		<tr>
			<td>${longBo.id}</td>
			<td>${longBo.nom}</td>
			<td>${longBo.cotation}</td>
			<td>${longBo.subdivision}</td>
			<td>${longBo.spit}</td>
			<td>${longBo.voieBo.nom}</td>
			
		</tr>
		</c:forEach>
	</table>
	</div>
	