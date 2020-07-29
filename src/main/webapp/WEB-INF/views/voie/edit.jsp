 <div class="container">
	<h1>Ajouter une voie</h1>
		<form method="post" action="update.html">
	
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" required class="form-control"/>
				</div>
				<div>
				<label for="site-select">Choisir la cotation</label>	
				<select name="cotation" >
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				
				</select>
				</div>
				
				<div>
				<label for="site-select">Choisir la subdivision</label>	
				<select name="subdivision" >
				<option value="a">a</option>
				<option value="b">b</option>
				<option value="c">c</option>
				<option value="+">+</option>
				
				</select>
				</div>
				
				<div>
				<label for="site-select">Est ce qu'il s'agit d'un site equipe ?</label>	
				<select name="equipe" >
				<option value="oui">oui</option>
				<option value="non">non</option>
				
				</select>
				</div>
				
				<label for="site-select">Choisir un secteur</label>	
				<select name="secteur_id" >
				<c:forEach items="${secteurBos}" var="secteurBo">
				<option value="${secteurBo.id}" <c:if test="${secteurBo.id eq voieBo.secteurBo.id}"> selected </c:if>>${secteurBo.nom}</option></c:forEach>
				</select>
					
				
						<c:if test="${empty secteurBo.id}"><button type="submit" class="btn btn-primary">Ajouter</button></c:if>
		
		
			</form>
	
</div>