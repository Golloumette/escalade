<%@page import="org.openclassroom.escalade.enume.DispoEnum"%>
<div class="container">
<div class=" d-flex justify-content-center " style="max-height: 300px">
<img class="align-self-start" src="/escalade/images/topo.jpg" alt="site"  style="max-height: 300px"   >
</div>
<div class="container">
<div class="row">
<div class=col-lg-12 >
	<h1 style="text-align: center"> Liste des topos</h1>
	<c:set var="disponible" value="<%=DispoEnum.Disponible.getNum() %>"></c:set>
	<c:set var="waiting" value="<%=DispoEnum.Waiting.getNum() %>"></c:set>
	
	${reservationBo.dt_reservation}
	<div class="table table-responsive">
	<table class="table table-hover table-striped">
	
		<thead class="table-info">
	
	<tr>
	
	<th class="table-nom">Nom</th>
	<th class="table-description">Description</th>
	<th class="table-lieu">Lieu</th>
	<th class="table-parution">Parution</th>
	<th class="table-proprietaire">Propriétaire</th>
	<th class="table-dispo">Dispo</th>
	</tr>
		</thead>
	<tbody><c:forEach items="${topoBos}" var="topoBo">
			<tr>
		
		
			
				<td data-label="nom">${topoBo.nom}</td>
				<td data-label="description">${topoBo.description}</td>
				<td data-label="lieu">${topoBo.lieu}</td>
				<td data-label="parution"><fmt:formatDate pattern = "yyyy-MM-dd" value="${topoBo.dt_parution}"/></td>
				<td data-label="proprietaire">${topoBo.utilisateurBo.nom}</td>
				<td data-label="dispo"><c:choose>
				<c:when test="${topoBo.disponible eq disponible}">
				<a class="btn btn-info"  href="/escalade/reservation/waiting.html?topo_id=${topoBo.id}" role="button" >Faire une reservation</a>
				</c:when>
				<c:when test="${topoBo.disponible eq waiting}">
				Reservation a valider
				</c:when>
				<c:otherwise>Reserve</c:otherwise>
				</c:choose></td>
			
				
					
		
			</tr>
			
	</c:forEach>
	
	</tbody>
	
	</table>
</div>
</div>			
</div>
</div>
</div>