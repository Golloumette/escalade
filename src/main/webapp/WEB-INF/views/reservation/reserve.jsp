 <div class="container">
<h1 style="text-align: center"> Mes reservations</h1>
	
	<table class="table table-hover table-striped">
	
	<thead>
	<tr>
	<th class="reserve-nom">Nom du topo</th>
	<th class="reserve-proprietaire">Nom du propriétaire</th>
	<th class="reserve-prenom">Prenom</th>
	<th class="reserve-telephone">Telephone</th>
	<th class="reserve-mail">Mail</th>
	</tr>
	<tbody></tbody><c:forEach items="${reservationBos}" var="reservationBo">
		
		<tr>
			
			<td data-label="Nom">${reservationBo.topoBo.nom}</td>
			<td data-label="Proprietaire">${reservationBo.topoBo.utilisateurBo.nom}</td>
			<td data-label="Prénom">${reservationBo.topoBo.utilisateurBo.prenom}</td>
			<td data-label="Téléphone">${reservationBo.topoBo.utilisateurBo.tel}</td>
			<td data-label="Mail">${reservationBo.topoBo.utilisateurBo.mail}</td>
	
		</tr>
		
		
	</c:forEach>
	</table>

<a class="btn btn-info" href="/escalade/topo/edit.html" role="button" >Ajouter un topo</a>
</div>