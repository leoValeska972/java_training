<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet"
  href="<%=request.getContextPath()%>/resources/plugins/css/responsive.dataTables.min.css" />
<link rel="stylesheet"
  href="<%=request.getContextPath()%>/resources/plugins/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
  href="<%=request.getContextPath()%>/resources/plugins/fontawesome/css/all.min.css" />
<link rel="stylesheet"
  href="<%=request.getContextPath()%>/resources/css/reset.css" />
<link rel="stylesheet"
  href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
  <!-- header -->
  <header id="header">
    <tiles:insertAttribute name="header" />
  </header>
  <!-- body -->
  <div class="main-container">
    <tiles:insertAttribute name="body" />
  </div>
  <!-- footer -->
  <footer id="footer">
    <tiles:insertAttribute name="footer" />
  </footer>
  <script
    src="<%=request.getContextPath()%>/resources/plugins/js/jquery-3.6.0.js"></script>
  <script
    src="<%=request.getContextPath()%>/resources/plugins/js/datatables.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
</body>
</html>