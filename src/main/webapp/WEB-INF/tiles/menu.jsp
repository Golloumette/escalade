<div class="container">
	<div class="row">
		<div class="col-1">
			<ul class="nav">
				<li class="nav-item">
    
    <h4>MENU</h4>
  <li> <a class="btn btn-info" href="/escalade/accueil.html" role="button" >Accueil</a></li>
  <li> <a class="btn btn-info" href="/escalade/utilisateur/ajouter.html" role="button" >Inscription</a></li>
   <li>   <a class="btn btn-info" href="/escalade/site/liste.html" role="button" >Site</a></li>
   <li>  <a class="btn btn-info" href="/escalade/topo/liste.html" role="button" >Topo</a></li>
    <li>  <a class="btn btn-info" href="/escalade/utilisateur/liste.html" role="button" >Liste utilisateur</a></li>
 
   
   </ul>
     <div class="login-show">
     <h4>CONNEXION</h4>
     	        <input type="text" placeholder="pseudo">
				<input type="password" placeholder="password">
				<input type="button" value="Connexion">
		
			</div>
		<div>
		<form action="${pageContext.request.contextPath}/login" method="post">
		<div>
		<label>login:</label>
		<input type="text" name="pseudo"/>
		</div>
		<div>
		<label>Password</label>
		<input type="password" name="password"/>
		</div>
		<div>
		<input type="submit" value="login"/>
		</div>
		
		</form>
		</div>

</div>
      </div>
    </div>
   
