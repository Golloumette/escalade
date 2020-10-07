<div class="container">

<div class=" d-flex justify-content-center " style="max-height: 300px">
<img class="align-self-start" src="/escalade/images/site.jpeg" alt="site"  style="max-height: 300px"   >
</div>
	<div class="row">
	<div class="col-lg-12">
	<h1 style="text-align: center"> Liste des sites d'escalades</h1>
	
	<table class="table table-hover table-striped">
	
	<thead class="table-info">
		<tr>
			<th>Nom</th>
			<th>Lieu</th>
			<th>Officiel</th>
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
			<td>Non officiel</td>
			</c:if>
		
				</tr>
	</c:forEach>
	
		
	
	</tbody>
	</table>
	<a class="btn btn-info" href="/escalade/site/edit.html" role="button" >Ajouter un site</a>
		</div>
	</div>
	</div>
