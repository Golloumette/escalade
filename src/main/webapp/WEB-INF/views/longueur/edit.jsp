<div class="container">

		<form method="post" action="update.html">
		<input type="hidden" name="id" value="${longueurBo.id}">
	<h1 style="text-align: center"><c:if test="${empty longueurBo.id}">Ajouter une longueur</c:if></h1>
	<h1 style="text-align: center"><c:if test="${not empty longueurBo.id}">Infos sur la longueur</c:if></h1>
	<c:if test="${utilisateurBo.role == 2 }"><h1 style="text-align: center" >Modifier/Supprimer une longueur</h1></c:if>
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" value="${longueurBo.nom}" required class="form-control"/>
				</div>
				<div >
				
				<label for="site-select">Choisir la cotation</label>	
				<select name="cotation">
		 	    <option value="${longueurBo.cotation}">${longueurBo.cotation}</option>
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
				<select name="subdivision">
			    <option value="${longueurBo.subdivision}">${longueurBo.subdivision}</option>
				<option value="a">a</option>
				<option value="b">b</option>
				<option value="c">c</option>
				<option value="+">+</option>
				
				</select>
				</div>
				
				<div>
				<label for="spit">Information sur le spit</label>	
				<input type="text" name="spit" value="${longueurBo.spit}" required class="form-control"/>
				</div>
				
				<label for="site-select">Choisir une voie</label>	
				<select name="voie_id" >
				<c:forEach items="${voieBos}" var="voieBo">
				<option value="${voieBo.id}" <c:if test="${voieBo.id eq longueurBo.voieBo.id}"> selected </c:if>>${voieBo.nom}</option></c:forEach>
				</select>
					
				<c:if test="${empty longueurBo.id}"><button type="submit" class="btn btn-primary">Ajouter</button></c:if>
				<c:if test="${utilisateurBo.role == 2 }">
						<c:if test="${not empty longueurBo.id}"><button type="submit" class="btn btn-primary">Modifier</button></c:if>
						
						<c:if test="${not empty longueurBo.id }"><button type="button" class="btn btn-primary" onclick="if (confirm('Voulez-vous supprimer cette longueur ?')){window.location='delete.html?id=${longueurBo.id }';}">Supprimer la longueur</button>
						</c:if>
		</c:if>
		
			</form>
	
</div>