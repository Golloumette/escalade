<div class="container">
	<h1> Liste des reservations</h1>
	<c:out value="${reservation}"/>
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom Topo</th><th>Nom emprunteur</th><th>Date reservation</th><th>Etat de validation</th></tr></thead>
	<tbody><c:forEach items="${reservationBos}" var="reservationBo">
		<tr>
			<td>${reservationBo.id}</td>
			<td>${reservationBo.topoBo.nom }</td>
			<td>${reservationBo.utilisateurBo.nom}</td>
			<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${reservationBo.dt_reservation}"/></td>
			<td>"${reservationBo.valider}"></td>
			
		
			
			
			</tr>
	</c:forEach></tbody>
	
	</table>
	
</div>