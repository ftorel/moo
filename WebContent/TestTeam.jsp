<%@ page language="java" import="java.sql.*" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <%List data =(List)request.getAttribute("data");
    for(int i = 0; i < data.size(); i+=1) { %>
    
    <div class="panel panel-primary">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a href="#collapseOne" data-parent="#accordion" data-toggle="collapse" class="accordion-toggle"><%=data.get(i)%></a>
      </h4>
    </div>
    <div class="panel-collapse in" id="collapseOne">
      <div class="panel-body">Listing des membres du groupe 1.</div>
    </div>
  </div>
    
    <% } %>

</body>
</html>