<div class="container">
	<h1>Modifications des utilisateurs d'escalade</h1>

	<form method="post" action="update.html">
		<input type="hidden" name="id" value="${utilisateurBo.id}">
		<h1>Gérer un site</h1>

		<div class="form-group">
			<label for="nom">Nom</label> <input type="text" name="nom"
				value="${utilisateurBo.nom}" class="form-control" />
		</div>
		<div class="form-group">
			<label for="prenom">Prénom</label> <input type="text" name="prenom"
				value="${utilisateurBo.prenom}" class="form-control" />
		</div>

		<div class="form-group">
			<label for="pseudo">Pseudo</label> <input type="text" name="pseudo"
				value="${utilisateurBo.pseudo}" class="form-control" />
		</div>

		<div class="form-group">
			<label for="mdp">Mot de passe</label> <input type="password"
				name="mdp" value="${utilisateurBo.mdp}" class="form-control" />
		</div>

		<div class="form-group">
			<label for="adresse">Adresse</label> <input type="text"
				name="adresse" value="${utilisateurBo.adresse}" class="form-control" />
		</div>

		<div class="form-group">
			<label for="postal">Code Postal</label> <input type="text"
				name="postal" value="${utilisateurBo.postal}" class="form-control" />
		</div>

		<div class="form-group">
			<label for="ville">Ville</label> <input type="text" name="ville"
				value="${utilisateurBo.ville}" class="form-control" />
		</div>

		<div class="form-group">
			<label for="mail">Email</label> <input type="email" name="mail"
				value="${utilisateurBo.mail}" class="form-control" />
		</div>
		<div class="form-group">
			<label for="tel">Telephone</label> <input type="tel" name="tel"
				value="${utilisateurBo.tel}" class="form-control" />
		</div>

		<c:if test="${empty utilisateurBo.id}">
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</c:if>
		<c:if test="${not empty utilisateurBo.id}">
			<button type="submit" class="btn btn-primary">Modifier</button>
		</c:if>
		
			<c:if test="${not empty utilisateurBo.id}">
				<button type="button" class="btn btn-primary" onclick="window.location='delete.html?id=${utilisateurBo.id}'">Supprimer</button>
			</c:if>
	
	</form>

</div>