<div class="container">
	<h1>Ajouter une longueur</h1>
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
				<label for="spit">Information sur le spit</label>	
				<input type="text" name="spit" required class="form-control"/>
				</div>
				
				<label for="site-select">Choisir une voie</label>	
				<select name="voie_id" >
				<c:forEach items="${voieBos}" var="voieBo">
				<option value="${voieBo.id}" <c:if test="${voieBo.id eq longueurBo.voieBo.id}"> selected </c:if>>${voieBo.nom}</option></c:forEach>
				</select>
					
				
						<c:if test="${empty voieBo.id}"><button type="submit" class="btn btn-primary">Ajouter</button></c:if>
		
		
			</form>
	
</div>