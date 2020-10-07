<div class="container-fluid">
<nav class="col navbar navbar-expand-lg navbar-light" style="background-color: #805231;">
<a class="navbar-brand" > Les amis de l'escalade </a> 
  <i class="fas fa-mountain"></i>
	 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
 	 </button>
 				<div class="collapse navbar-collapse" id="navbarSupportedContent">		
				<ul class="navbar-nav mr-auto">
		<li class="nav-item active">
                <a class="nav-link " href="/escalade/accueil.html">Accueil <i class="fas fa-mountain"> </i></a>
              </li>  
             
       <li class="nav-item active">
       
                <a class="nav-link " href="/escalade/site/liste.html">Site <i class="fas fa-mountain"> </i></a>
 
              </li>
       <li class="nav-item active" >
                <a class="nav-link" href="/escalade/utilisateur/ajouter.html">Inscription <i class="fas fa-mountain"> </i></a>
          </li>
        <li class="nav-item active" >
                <a class="nav-link"   href="/escalade/topo/liste.html">Liste des topos <i class="fas fa-mountain"> </i></a>
          </li>
          
           <c:if test="${not empty pageContext.request.userPrincipal}" >
          <li class="nav-item active">
                <a class="nav-link" href="/escalade/utilisateur/liste.html">Liste des utilisateurs <i class="fas fa-mountain"> </i></a>
          </li>      
          <li class="nav-item active">
                <a class="nav-link" href="/escalade/topo/mestopos.html">Mes topos <i class="fas fa-mountain"> </i></a>
          </li>
           </c:if>
          
	</ul>
	
	 <c:if test="${empty pageContext.request.userPrincipal}">
        
        <form action="${pageContext.request.contextPath}/login.html" method="post">
        
        <div>
        <label>Login:    </label>
        <input type="text" name="username"/>
       
       
        <label>Password:</label>
        <input type="password" name="password"/>
      
   
        <input type="submit" value="login"/>
        </div>
        
        </form>
        
        </c:if>
        
        </div>
        <div>
        <c:if test="${not empty pageContext.request.userPrincipal}" >
        
        
        <a class="btn btn-info" href="${pageContext.request.contextPath}/logout.html" role="button">Deconnexion</a>
        </c:if>
</div>
</nav>
</div>

    
  		
  	