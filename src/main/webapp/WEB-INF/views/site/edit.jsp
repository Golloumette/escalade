<div class="container">
	<h1>Ajout/Modifications des sites d'escalade</h1>
	<c:out value="${secteur}"/>
	<c:if test="${not empty secteurBos}">
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Descriptif</th><th>Acces</th></tr>
	<tbody></tbody><c:forEach items="${secteurBos}" var="secteurBo">
		<tr>
			<td>${secteurBo.id}</td>
			<td><a href="/escalade/secteur/edit.html?id=${secteurBo.id}"> ${secteurBo.nom}</a></td>
			<td>${secteurBo.descriptif}</td>
			<td>${secteurBo.acces}</td>
			
		</tr>
		</c:forEach>
	</table>
	</c:if>
	</div>
	<div>
		<form method="post" action="update.html">
		<input type= "hidden" name="id" value="${siteBo.id}">
		<c:if test="${empty siteBo.id}"><h1>Ajouter un site</h1></c:if>
		<c:if test="${not empty siteBo.id}"><h1>Modifier le site</h1></c:if>
	
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" value="${siteBo.nom}" required class="form-control"/>
				</div>
				<div class="form-group">
					<label for="lieu">Lieu</label>
					<input type="text" name="lieu" value="${siteBo.lieu}" required class="form-control"/>
					</div>
					<c:if test="${empty siteBo.id}"><button type="submit" class="btn btn-primary">Ajouter</button></c:if>
					<c:if test="${not empty siteBo.id}"><button type="submit" class="btn btn-primary">Modifier</button>
					<a class="btn btn-info" href="/escalade/secteur/edit.html?id=${siteBo.id}" role="button" >Ajouter un secteur</a></c:if>
	<c:if test="${not empty siteBo.id}">
				<button type="button" class="btn btn-primary" onclick="window.location='delete.html?id=${siteBo.id}'">Supprimer le site</button>
			</c:if>
					
			</form>
	
</div>