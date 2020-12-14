<div class="container">

<div>
<c:if test="${not empty siteBo}">
	<h1>${siteBo.nom}</h1>
	<h3><c:out value="${secteur}"/></h3>
	
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Descriptif</th><th>Acces</th><th>Les voie/Les longueurs</th></tr></thead>
	<tbody><c:forEach items="${secteurBos}" var="secteurBo">
		<tr>
			<td>${secteurBo.id}</td>
			<td><a href="/escalade/secteur/edit.html?id=${secteurBo.id}"> ${secteurBo.nom}</a></td>
			<td>${secteurBo.descriptif}</td>
			<td>${secteurBo.acces}</td>
			<td>
			<table>
			<c:forEach items="${secteurBo.voieBos}" var="voieBo">
			<tr>
				<td>
				<a href="/escalade/voie/edit.html?id=${voieBo.id}"> ${voieBo.nom}</a>
				</td>
				<td>
					<table>
					<c:forEach items="${voieBo.longueurBos}" var="longueurBo">
						<tr>	
							<td><a href="/escalade/longueur/edit.html?id=${longueurBo.id}">${longueurBo.nom}</a></td>
					   </tr>
					</c:forEach>
					</table>
				</td>
			</tr>
			
		
		</c:forEach>
		</table>
		</td>
			</tr>
			</c:forEach>
		</tbody>
		
		</table >
		<c:if test="${not empty siteBo.commentaireBos}">
		<h3>Commentaires</h3>
		<table class="table table-sm">
		<thead><tr><th>Grimpeur</th><th>Commentaire</th></thead>
		<tbody><c:forEach items="${commentaireBos}" var="commentaireBo">
		<tr><td>${commentaireBo.utilisateurBo.nom}</td>
		<td>${commentaireBo.text} <i class="fas fa-trash-alt" onclick="window.location='/escalade/commentaire/delete.html?id=${commentaireBo.id}'"></i>
		<a href="/escalade/commentaire/edit.html?id=${commentaireBo.id}"><i class="fas fa-edit" ></i></a>
		</td>
		</tr>
		</c:forEach>
		
	
		 </tbody>
		 </table>
		  </c:if>
		<a class="btn btn-info" href="/escalade/commentaire/edit.html?site_id=${siteBo.id}" role="button">Ajouter un commentaire</a>  
		<a class="btn btn-info" href="/escalade/secteur/edit.html?site_id=${siteBo.id}" role="button" >Ajouter un secteur</a>
		<a class="btn btn-info" href="/escalade/voie/edit.html?site_id=${siteBo.id}" role="button">Ajouter une voie</a>
		<a class="btn btn-info" href="/escalade/longueur/edit.html?site_id=${siteBo.id}" role="button">Ajouter une longueur</a>
		
		
		
	</c:if>	
		</div>
		
		<div>
		<form method="post" action="update.html">
		<input type= "hidden" name="id" value="${siteBo.id}">
		<c:if test="${empty siteBo.id}"><h1>Ajouter un site</h1></c:if>
		<c:if test="${not empty siteBo.id}"><h1>Modification/Suppression du site</h1></c:if>
	
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" value="${siteBo.nom}" required class="form-control"/>
				</div>
				<div class="form-group">
					<label for="lieu">Lieu</label>
					<input type="text" name="lieu" value="${siteBo.lieu}" required class="form-control"/>
				</div>
				<div class="form-group">
				<label for="officiel">Officialiser un site</label>	
				<select name="officiel"  >
				<option value="false">non officiel</option>	
				<c:if test="${utilisateurBo.role == 2}">	
				<option value="true">site officiel</option>
				</c:if>	
				</select>
				</div>
			
				
					<c:if test="${empty siteBo.id}"><button type="submit" class="btn btn-info">Ajouter</button></c:if>
					<c:if test="${not empty siteBo.id}"><button type="submit" class="btn btn-info">Modifier le site</button></c:if>
				
	<c:if test="${not empty siteBo.id}">
				<button type="button" class="btn btn-info" onclick="window.location='delete.html?id=${siteBo.id}'">Supprimer le site</button>
	</c:if>
					
			</form>
	
</div>
	</div>
	