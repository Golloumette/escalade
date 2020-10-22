<form method="post" action="update.html">
<input type= "hidden" name="id" value="${topoBo.id}"  >
	<h1>Ajouter un topo</h1>
	
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" value="${topoBo.nom}" required class="form-control"/>
				</div>
				<div class="form-group">
					<label for="lieu">Lieu</label>
					<input type="text" name="lieu" value="${topoBo.lieu}" required class="form-control"/>
					</div>
				<div class="form-group">
					<label for="description">Description</label>
					<input type="text" name="description" value="${topoBo.description}" required class="form-control"/>
					</div>
				<div class="form-group">
					<label for="dt_parution">Date de parution</label>
					<input type="date" name="dt_parution" value="${topoBo.dt_parution}" required class="form-control"/>
					</div>
				<div class="form-group">
					<label for="disponible">Disponible</label>
					<select name="disponible" value="${topoBo.disponible}">
					<option value="0">oui</option>
					<option value="2">non</option>
					</select>
					
					<c:if test="${empty topoBo.id}"><button type="submit" class="btn btn-primary">Ajouter</button></c:if>
					<c:if test="${not empty topoBo.id}"><button type="submit" class="btn btn-primary">Modifier le topo</button></c:if>
					<c:if test="${not empty topoBo.id}">
				<button type="button" class="btn btn-primary" onclick="window.location='delete.html?id=${topoBo.id}'">Supprimer le topo</button>
			</c:if>
					</div>
						
						
			</form>
	
