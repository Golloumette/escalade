<div class="container">

		<h2>Quel est votre commentaire ?</h2>
 	<form method="post" action="update.html">
 	<input type="hidden" name="site_id" value="${siteBo.id}">
 	<input type="hidden" name="id" value="${commentaireBo.id}">
 	
 		<div class="form-group">
 		<label for="commentaire"></label>
 		
 		<input type="text" name="text" value="${commentaireBo.text}" >
 		</div>
 		${commentaireBo.dt_comment}
 	
 		<button type="submit" class="btn btn-info">Ajouter</button>
	</form>
	</div>