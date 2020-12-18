<div class="container">
<div class=" d-flex justify-content-center " style="max-height: 300px">
<img class="align-self-start" src="/escalade/images/grimpeur.jpg" alt="site"  style="max-height: 300px"   >
</div>
<div class="container">
<div class="row">
<div class=col-lg-12 >
	<h1 style="text-align: center"> Liste des utilisateurs</h1>
	<c:out value="${utilisateur}"/>
	
	<div class="table table-responsive">
	<table class="table table-hover table-striped">
	
	<thead class="table-info">
	<tr>
	<th class="table-nom">Nom</th>
	<th class="table-prenom">Prenom</th>
	<th class="table-pseudo">Pseudo</th>
	<th class="table-adresse">Adresse</th>
	<th class="table-postal">Code Postal</th>
	<th class="table-ville">Ville</th>
	<th class="table-mail">Mail</th>
	<th class="table-telephone">Telephone</th>
	<th class="table-role">Role</th>
	</tr>
	 </thead>
	 
		<tbody><c:forEach items="${utilisateurBos}" var="utilisateurBo">
		<tr>
			
			<td data-label="nom"><a href="/escalade/utilisateur/edit.html?id=${utilisateurBo.id}"> ${utilisateurBo.nom}</a></td>
			<td data-label="prenom">${utilisateurBo.prenom}</td>
			<td data-label="pseudo">${utilisateurBo.pseudo}</td>
			<td data-label="adresse">${utilisateurBo.adresse}</td>
			<td data-label="postal">${utilisateurBo.postal}</td>
			<td data-label="ville">${utilisateurBo.ville}</td>
			<td data-label="mail">${utilisateurBo.mail}</td>
			<td data-label="telephone">${utilisateurBo.tel}</td>
			
			<c:if test="${utilisateurBo.role== 1}">
			<td data-label="role">utilisateur</td>
			</c:if>
			
			
			<c:if test="${utilisateurBo.role==2}">
			<td>admin</td>
			</c:if>
			
		</tr>
		
			</c:forEach>
	</tbody>
</table>
</div>
</div>
</div>
</div>
</div>



