<%@ page language="java" import="java.sql.*" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Document" %>
<%@ page import="Model.User" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Demo</title>
</head>
<body>

    <center>
        <form method="post" action="UploadServlet" enctype="multipart/form-data">
            Select file to upload :  (max 20Mb)
            <br/><br/>
            <input type="file" name="uploadFile" />
            <br/><br/>
            <input type="submit" value="Upload" />
        </form>
    </center>

<%List data =(List)request.getAttribute("data");

	for(int i = 0; i < data.size(); i+=1) { %>

	<%Document doc = ((Document)data.get(i)); %>
        <a href="#collapseOne" data-parent="#accordion" data-toggle="collapse" class="accordion-toggle"><%= doc.getName() %></a>
		<form action='FileDownloader' method ="POST">
			<input type="submit" name="downloadButton" value="Download" />
			<input type='hidden' name='docUrl' id='D_URL' value=<%=doc.getUrl()%> />
		</form>
		<form action='FileDelete' method ="POST">
			<input type='hidden' name='docUrl' id='D_URL' value=<%=doc.getUrl()%> />
			<input type="submit" name="deleteButton" value="Delete" />
		</form>
  
  <% } %>