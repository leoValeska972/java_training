<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeCRUD</title>
</head>
<body>
  <!-- header -->
  <header id="header">
    <tiles:insertAttribute name="header" />
  </header>
  <!-- menu -->
  <div style="float: left; padding: 10px; width: 15%;">
    <tiles:insertAttribute name="menu" />
  </div>
  <!-- body -->
  <div class="main-container"
    style="float: left; padding: 10px; width: 80%; border-left: 1px solid pink;">
    <tiles:insertAttribute name="body" />
  </div>
  <!-- footer -->
  <footer id="footer" style="clear: both">
    <tiles:insertAttribute name="footer" />
  </footer>
</body>
</html>