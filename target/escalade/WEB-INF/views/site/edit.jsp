<div class="container">
	<h1>Ajout/Modifications des sites d'escalade</h1>
	<c:out value="${site}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Lieu</th></tr>
	<tbody></tbody><c:forEach items="${siteBos}" var="siteBo">
		<tr>
			<td>${siteBo.id}</td>
			<td>${siteBo.nom}</td>
			<td>${siteBo.lieu}</td>
			
		</tr>
		</c:forEach>
	</table>
	</div>
	<div>
		<form method="post" action="update.html">
	<h1>Ajouter un site</h1>
	
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" required class="form-control"/>
				</div>
				<div class="form-group">
					<label for="lieu">Lieu</label>
					<input type="text" name="lieu" required class="form-control"/>
					</div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
			</form>
	
</div>