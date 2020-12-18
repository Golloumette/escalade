<div class="container">
	<div class="row">
		<div class="col-lg-12">
	<c:if test="${not empty siteBo}">
	<h1 style="text-align: center">${siteBo.nom}</h1>
	<h3 style="text-align: center"><c:out value="${secteur}"/></h3>
	
	<table class="table table-hover table-striped">
	
	<thead>
	<tr>
	<th class="site-nom">Nom</th>
	<th class="site-descriptif">Descriptif</th>
	<th class="site-acces">Acces</th>
	<th class="site-voie">Les voie/Longueurs</th>
	
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${secteurBos}" var="secteurBo">
			<tr>
			<td data-label="Nom du secteur"><a href="/escalade/secteur/edit.html?id=${secteurBo.id}"> ${secteurBo.nom}</a></td>
			<td data-label="Description">${secteurBo.descriptif}</td>
			<td data-label="Acces">${secteurBo.acces}</td>
			<td data-label="Voie et Longueurs ">
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
		<h3>Commentaires</h3><a href="/escalade/voie/edit.html?id=${voieBo.id}"> ${voieBo.nom}</a>
		
		<table class="table table-sm">
		<thead>
		<tr>
		<th class="commentaire-grimpeur">Grimpeur</th>
		<th class="commentaire-text">Commentaire</th>
		</thead>
		<tbody>
		<c:forEach items="${commentaireBos}" var="commentaireBo">
		<tr>
		<td data-label="Grimpeur">${commentaireBo.utilisateurBo.nom}</td>
		<td data-label="Commentaire">${commentaireBo.text} <c:if test="${utilisateurBo.role == 2}">	<i class="fas fa-trash-alt" onclick="window.location='/escalade/commentaire/delete.html?id=${commentaireBo.id}'"></i>
		<a href="/escalade/commentaire/edit.html?id=${commentaireBo.id}"><i class="fas fa-edit" ></i></a></c:if>
		</td>
		</tr>
		</c:forEach>
		
	
		 </tbody>
		 </table>
		  </c:if>
		  <div class="row">
		  	<div class="col-sm-10">
		<a class="btn btn-info" href="/escalade/commentaire/edit.html?site_id=${siteBo.id}" role="button">Ajouter un commentaire</a>  
		<a class="btn btn-info" href="/escalade/secteur/edit.html?site_id=${siteBo.id}" role="button" >Ajouter un secteur</a>
		</div>
		</div>
		<div class="row">
		<div class="col-sm-10">
		<a class="btn btn-info" href="/escalade/voie/edit.html?site_id=${siteBo.id}" role="button">Ajouter une voie</a>
		<a class="btn btn-info" href="/escalade/longueur/edit.html?site_id=${siteBo.id}" role="button">Ajouter une longueur</a>
		</div>
		</div>
		
	</c:if>	
	</div>
	</div>
		</div>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<form method="post" action="update.html">
			<input type= "hidden" name="id" value="${siteBo.id}">
			<c:if test="${empty siteBo.id}"><h1 style="text-align: center">Ajouter un site</h1></c:if>
			<c:if test="${utilisateurBo.role == 2}">	
			<c:if test="${not empty siteBo.id}"><h1 style="text-align: center">Modifier/Supprimer un site</h1></c:if>
			</c:if>
					<div class="form-group">
					<label for="nom">Nom du site</label>
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
					<c:if test="${utilisateurBo.role ==2 }">
					<c:if test="${not empty siteBo.id}"><button type="submit" class="btn btn-info">Modifier le site</button>
				   </c:if>
					<c:if test="${not empty siteBo.id}"><button type="button" class="btn btn-info" onclick="window.location='delete.html?id=${siteBo.id}'">Supprimer le site</button>
					</c:if>
					</c:if>
			</form>

	</div>
</div>
</div>