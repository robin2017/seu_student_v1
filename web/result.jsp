<%@ page import="java.util.*" %>
<html>
<head>
<meta charset="utf-8">
<title>东南大学学生</title>
</head>
<body>
<h1 align="center">东南大学学生信息</h1>
<p>
<% 
  ArrayList styles = (ArrayList)request.getAttribute("styles");
  Iterator it = styles.iterator();
  while(it.hasNext()) {
    out.print("<br>try " + it.next());
  }
%>
</body>
</html>