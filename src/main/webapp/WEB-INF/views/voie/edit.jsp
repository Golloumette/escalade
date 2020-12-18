 <div class="container">
 	<div class="row">
		<div class="col-lg-12">
		<form method="post" action="update.html">
		<input type="hidden" name="id" value="${voieBo.id}">
		<h1 style="text-align: center"><c:if test="${empty voieBo.id}">Ajouter une voie</c:if></h1>
		<h1 style="text-align: center"><c:if test="${not empty voieBo.id}">Infos sur la voie</c:if></h1>
		<c:if test="${utilisateurBo.role == 2}"><h1 style="text-align: center">Modifier/Supprimer une voie</h1></c:if>
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" name="nom" value="${voieBo.nom}" required class="form-control"/>
				</div>
				<div>
				<label for="site-select">Choisir la cotation</label>	
				<select name="cotation">				
				<option value="${voieBo.cotation}">${voieBo.cotation}</option>	
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
				<option value="${voieBo.subdivision}">${voieBo.subdivision}</option>
				<option value="a">a</option>
				<option value="b">b</option>
				<option value="c">c</option>
				<option value="+">+</option>
				
				</select>
				</div>
				
				<div>
				<label for="site-select">Est ce qu'il s'agit d'un site equipe ?</label>	
				<select name="equipe" >
				<option value="${voieBo.equipe}">${voieBo.equipe}</option>
				<option value="true">oui</option>
				<option value="false">non</option>
					
				</select>
				</div>
				
				<label for="site-select">Choisir un secteur</label>	
				<select name="secteur_id" >
				<c:forEach items="${secteurBos}" var="secteurBo">
				<option value="${secteurBo.id}" <c:if test="${secteurBo.id eq voieBo.secteurBo.id}"> selected </c:if>>${secteurBo.nom}</option></c:forEach>
				</select>
			
				
					<div>
				
						<c:if test="${empty voieBo.id}"><button type="submit" class="btn btn-primary">Ajouter</button></c:if>
						<c:if test="${utilisateurBo.role ==2}">
						<c:if test="${not empty voieBo.id}"><button type="submit" class="btn btn-primary">Modifier la voie</button></c:if>
						<c:if test="${not empty voieBo.id}"><button type="button" class="btn btn-primary" onclick="if(confirm('Voulez vous supprimer la voie ?')){window.location='delete.html?id=${voieBo.id}';}">Supprimer la voie</button>
				</c:if>
				</c:if>
				  </div>
		</form>
			
			</div>
	</div>
</div>