<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="/layouts/classic.jsp" flush="true">
  <tiles:put name="title"  value="Tiles exemple 1" />
  <tiles:put name="header" value="/tiles/banner.jsp" />
  <tiles:put name="footer" value="/tiles/footer.jsp" />
  <tiles:put name="menu"   value="/tiles/menu.jsp" />
  <tiles:put name="body"   value="/tiles/home_body.jsp" />
</tiles:insert>