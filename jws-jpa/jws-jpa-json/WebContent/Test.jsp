<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.assign.orm.dao.*,
    edu.neu.cs5200.assign.orm.model.*,
    java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing File</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<div class="cont">
<%
SiteDAO DAO= new SiteDAO();
List<Site> SITES= DAO.findAllSites();
%>
<h1>SITES</h1>

<table class="table">
<%
 for(Site site: SITES)
 {
%> <tr>	 
<td> <%= site.getName()%> </td>
</tr>
 <%
  }
%>
</table>
</div>

</body>
</html>