<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
<link rel="stylesheet"
  href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
  <!-- header -->
  <header id="header">
    <tiles:insertAttribute name="header" />
  </header>
  <!-- menu -->
  <div class="tmenu">
    <tiles:insertAttribute name="menu" />
  </div>
  <!-- body -->
  <div class="main-container">
    <tiles:insertAttribute name="body" />
  </div>
  <!-- footer -->
  <footer id="footer">
    <tiles:insertAttribute name="footer" />
  </footer>
</body>
</html>