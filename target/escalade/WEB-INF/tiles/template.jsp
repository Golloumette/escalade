<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
  <head>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="/escalade/css/style.css" />
  </head>
  <body>
  <div class="container-fluid">
        <div class="row">
        <div class="col-lg-12" >
          <tiles:insertAttribute name="header"/>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-4">
          <tiles:insertAttribute name="menu"/>
        </div>
        
        <div class="col-lg-8">
          <tiles:insertAttribute name="body"/>
        </div>
        </div>
      <div class="row">
      <div class="col-lg-12">
        <tiles:insertAttribute name="footer"/>
        </div>
        </div>
     </div>
     <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>