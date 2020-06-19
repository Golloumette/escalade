<div class="container">
	<h1> Liste des sites</h1>
	<c:out value="${site}"/>
	<table><tr><th>ID</th><th>Nom</th><th>Lieu</th><th>Commentaires</th></tr>
	<c:forEach items="${siteBos}" var="siteBo">
		<tr>
			<td>${siteBo.id}</td>
			<td>${siteBo.nom}</td>
			<td>${siteBo.lieu}</td>
			<td>${siteBo.commentaire}</td>
		</tr>
		
		
	</c:forEach>
	</table>
</div>