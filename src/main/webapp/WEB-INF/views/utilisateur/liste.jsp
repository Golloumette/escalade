<div class="container">
	<h1> Liste des utilisateur</h1>
	<c:out value="${utilisateur}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Prenom</th><th>Pseudo</th><th>Adresse</th><th>Code Postal</th><th>Ville</th><th>Mail</th>
	<th>Telephone</th><th>Role</th></tr>
	<tbody></tbody><c:forEach items="${utilisateurBos}" var="utilisateurBo">
		<tr>
			<td>${utilisateurBo.id}</td>
			<td><a href="/escalade/utilisateur/edit.html?id=${utilisateurBo.id}"> ${utilisateurBo.nom}</a></td>
			<td>${utilisateurBo.prenom}</td>
			<td>${utilisateurBo.pseudo}</td>
			<td>${utilisateurBo.adresse}</td>
			<td>${utilisateurBo.postal}</td>
			<td>${utilisateurBo.ville}</td>
			<td>${utilisateurBo.mail}</td>
			<td>${utilisateurBo.tel}</td>
			
			<c:if test="${utilisateurBo.role== 1}">
			<td>utilisateur</td>
			</c:if>
			
			
			<c:if test="${utilisateurBo.role==2}">
			<td>admin</td>
			</c:if>
			
		</tr>
</c:forEach>
</table>
</div>