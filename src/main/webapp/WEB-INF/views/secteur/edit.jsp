 <div class="container">
	<h1>Ajouter un secteur</h1>
		<form method="post" action="update.html">
	
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" required class="form-control"/>
				</div>
				<div class="form-group">
					<label for="descriptif">Descriptif</label>
					<input type="text" name="descriptif" required class="form-control"/>
					</div>
				<div class="form-group">
					<label for="acces">Acces</label>
					<input type="text" name="acces" required class="form-control"/>
					</div>
				<label for="site-select">Choisir un site</label>	
				<select name="site_id" >
				<c:forEach items="${siteBos}" var="siteBo">
				<option value="${siteBo.id}" <c:if test="${siteBo.id eq secteurBo.siteBo.id}"> selected </c:if>>${siteBo.nom}</option></c:forEach>
				</select>
					
				
						<c:if test="${empty secteurBo.id}"><button type="submit" class="btn btn-primary">Ajouter</button></c:if>
			</form>
	
</div>
