<div class="container">

<div class=" d-flex justify-content-center " style="max-height: 300px">
<img class="align-self-start" src="/escalade/images/site.jpeg" alt="site"  style="max-height: 300px"   >
</div>
<div class="container">
	<div class="row">
	<div class="col-lg-12">
	<h1 style="text-align: center"> Liste des sites d'escalades</h1>
	<div class="form-group">
	<form action="/escalade/site/search.html" method="post" >
	<input type="text" class="form-control" name="nom" title="Rechercher un site" placeholder="Rechercher un site"  >
	<input type="submit" value="Rechercher" class= "btn btn-info" >
			<div class="ml-2 input-group-text text-white" style="background-color: #805231;"  data-toggle="collapse" data-target="#advancedSearch"  aria-controls="advancedSearch">
		<i data-toggle="tooltip" data-placement="bottom" title="Voir la recherche avancée"   class="fas fa-search-plus"></i>
			</div>
	 
			<div class="collapse" id="advancedSearch">
                <div class="card card-body mb-3">
                    <div class="row">
                        <div class="col-12 col-lg-4">
                            <div class="form-group">
                                <label class="font-weight-bold">Lieu</label>
                                <input type="text" class="form-control" name="lieu"  >
                            </div>
                        </div>
                      	 <div class="col-12 col-lg-4">
                            	<div class="form-group">
                                <label class="font-weight-bold" for="site-select">Nombre de secteur</label>
                                <select class="form-control"  name="secteur">
                                	 <option value="1">1-5</option>
									<option value="2">5-10</option>
									<option value="3">10+</option>
                                </select>
                            	</div>
                       	</div>
                        <div class="col-12 col-lg-4">
                            <div class="form-group">
                                <label class="font-weight-bold" for="site-select">Cotation</label>
                                <select class="form-control"  name="cotation">
                                  	 <option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
                                    
                                </select>
                            </div>
                        </div>
                        <input type="submit" value="Rechercher" class= "btn btn-info" >
                        
                        </div>
                   </div>
              </div> 
                    </form>
                        </div>
     <div class="container">                   
	<table class="table table-hover table-striped">
	
	<thead class="table-info">
		<tr>
			<th>Nom</th>
			<th>Lieu</th>
			<th style="text-align:center;">Officiel</th>
		</tr>
	</thead>	
	<tbody>
	
		<c:forEach items="${siteBos}" var="siteBo">
		<input type="hidden" name="id" value="${siteBo.id}">
		<tr>
			
			<td><a href="/escalade/site/edit.html?id=${siteBo.id}"> ${siteBo.nom}</a></td>
			<td>${siteBo.lieu}</td>
			
			<c:if test="${siteBo.officiel == true}" >
			<td style="text-align: center;"><i class="far fa-smile-beam " style="color:#2EA925;" ></i></td>
			</c:if>
			<c:if test="${siteBo.officiel == false}">
			<td style="text-align: center;"><i class="far fa-frown" style="color:#DE311F"></i></td>
			</c:if>
		
				</tr>
	</c:forEach>
	
		
	
	</tbody>
	</table>
	<a class="btn btn-info" href="/escalade/site/edit.html" role="button" >Ajouter un site</a>
		</div>
		
		</div>
	</div>
	</div>
	</div>
