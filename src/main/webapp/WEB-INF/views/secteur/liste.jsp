 <div class="container">
	<h1>Liste des secteurs</h1>
	<c:out value="${secteur}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Descriptif</th><th>Acces</th><th>Nom du Site</th></tr>
	<tbody></tbody><c:forEach items="${secteurBos}" var="secteurBo">
		<tr>
			<td>${secteurBo.id}</td>
			<td>${secteurBo.nom}</td>
			<td>${secteurBo.descriptif}</td>
			<td>${secteurBo.acces}</td>
			<td>${secteurBo.siteBo.nom}</td>
			
		</tr>
		</c:forEach>
	</table>
	</div>
	