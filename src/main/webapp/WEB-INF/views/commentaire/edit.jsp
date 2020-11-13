<div class="container">

		<h2>Quel est votre commentaire ?</h2>
 	<form method="post" action="update.html">
 	<input type="hidden" name="id" value="${commentaireBo.id}">
 	<input type="hidden" name="site_id" value="${siteBo.id}">
 	<input type="hidden" name="idSite" value="${commentaireBo.siteBo.id}">
 	
 		<div class="form-group">
 		<label for="commentaire"></label>
 		
 		<input type="text" name="text" value="${commentaireBo.text}" >
 		
 		<input type="hidden" name="date" value="${commentaireBo.dt_comment}">
 	
 		<c:if test="${empty commentaireBo.id}"><button type="submit" class="btn btn-info">Ajouter</button></c:if>
 		<c:if test="${not empty commentaireBo.id}"><button type="submit" class="btn btn-info">Modifier</button></c:if>
 		</div>
	</form>
	</div>