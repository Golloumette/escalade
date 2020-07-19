<div class="container">
	<h1>Liste des secteurs</h1>
	<c:out value="${secteur}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Descriptif</th><th>Acces</th></tr>
	<tbody></tbody><c:forEach items="${secteurBos}" var="secteurBo">
		<tr>
			<td>${siteBo.id}</td>
			<td>${siteBo.nom}</td>
			<td>${siteBo.descriptif}</td>
			<td>${siteBo.acces}</td>
			
		</tr>
		</c:forEach>
	</table>
	</div>
	<div>
		<form method="post" action="update.html">
	<h1>Ajouter un secteur</h1>
	
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" required class="form-control"/>
				</div>
				<div class="form-group">
					<label for="descriptif">Descriptif</label>
					<input type="text" name="descriptif" required class="form-control"/>
					</div>
				
					
				
						<button type="submit" class="btn btn-primary">Ajouter</button>
			</form>
	
</div>
nom
descriptif
acces
