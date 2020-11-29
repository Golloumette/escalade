 <div class="container">
<h1><p class="text-center"> Mes reservations</p></h1>
	
	<table class="table table-hover table-striped">
	
	<thead><tr><th>Nom du topo</th><th>Nom du propriétaire</th><th>Prenom</th><th>Telephone</th><th>Mail</th></tr>
	<tbody></tbody><c:forEach items="${reservationBos}" var="reservationBo">
		
		<tr>
			
			<td>${reservationBo.topoBo.nom}</td>
			<td>${reservationBo.topoBo.utilisateurBo.nom}</td>
			<td>${reservationBo.topoBo.utilisateurBo.prenom}</td>
			<td>${reservationBo.topoBo.utilisateurBo.tel}</td>
			<td>${reservationBo.topoBo.utilisateurBo.mail}</td>
	
		</tr>
		
		
	</c:forEach>
	</table>

<a class="btn btn-info" href="/escalade/topo/edit.html" role="button" >Ajouter un topo</a>
</div>