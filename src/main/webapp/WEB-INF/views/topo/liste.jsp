<%@page import="org.openclassroom.escalade.enume.DispoEnum"%>
<div class="container">
	<h1> Liste des topos</h1>
	<c:set var="disponible" value="<%=DispoEnum.Disponible.getNum() %>"></c:set>
	<c:set var="waiting" value="<%=DispoEnum.Waiting.getNum() %>"></c:set>
	
	${reservationBo.dt_reservation}
	
	<table class="table table-hover table-striped">
	
	<thead><tr><th>ID</th><th>Nom</th><th>Description</th><th>Lieu</th><th>Parution</th><th>Propriétaire</th><th>Dispo</th></tr></thead>
	<tbody><c:forEach items="${topoBos}" var="topoBo">
		<tr>
		
		
			<td>${topoBo.id}</td>
			<td>${topoBo.nom}</td>
			<td>${topoBo.description}</td>
			<td>${topoBo.lieu}</td>
			<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${topoBo.dt_parution}"/></td>
			<td>${topoBo.utilisateurBo.nom}</td>
			<td><c:choose>
			<c:when test="${topoBo.disponible eq disponible}">
			<a class="btn btn-info"  href="/escalade/reservation/waiting.html?topo_id=${topoBo.id}" role="button" >Faire une reservation</a>
			</c:when>
			<c:when test="${topoBo.disponible eq waiting}">
			Reservation a valider
			</c:when>
			<c:otherwise>Reserve</c:otherwise>
				</c:choose></td>
			
				
					
		
			</tr>
			
	</c:forEach></tbody>
	
	</table>
	
			
</div>