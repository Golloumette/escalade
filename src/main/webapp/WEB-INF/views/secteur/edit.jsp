 <div class="container">
	<h1>Ajouter un secteur</h1>
		<form method="post" action="update.html">
		<input type="hidden" name="id" value="${secteurBo.id}">
		<c:if test="${empty secteurBo.id}">Ajouter un secteur</c:if>
		<c:if test="${not empty secteurBo.id}">Modification/Suppression d'un secteur</c:if>
	
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" value="${secteurBo.nom}" required class="form-control"/>
				</div>
				<div class="form-group">
					<label for="descriptif">Descriptif</label>
					<input type="text" name="descriptif" value="${secteurBo.descriptif}" required class="form-control"/>
					</div>
				<div class="form-group">
					<label for="acces">Acces</label>
					<input type="text" name="acces" value="${secteurBo.acces}" required class="form-control"/>
					</div>
				<label for="site-select">Choisir un site</label>	
				<select name="site_id" >
				<c:forEach items="${siteBos}" var="siteBo">
				<option value="${siteBo.id}" <c:if test="${siteBo.id eq secteurBo.siteBo.id}"> selected </c:if>>${siteBo.nom}</option></c:forEach>
				</select>
				
				<c:if test="${not empty secteurBo.id}"><button type="submit" class="btn btn-primary">Modifier</button></c:if>
						<c:if test="${empty secteurBo.id}"><button type="submit" class="btn btn-primary">Ajouter</button></c:if>
		<c:if test="${not empty secteurBo.id }"><button type="button" class="btn btn-primary" onclick="window.location='delete.html?id=${secteurBo.id }'">Supprimer le secteur</button>
		</c:if>
			</form>
	
</div>
