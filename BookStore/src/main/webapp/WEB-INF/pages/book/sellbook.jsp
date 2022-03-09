<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<title>Book Page</title>
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
  <form:form action="${pageContext.request.contextPath}/addSellBook"
    modelAttribute="sbForm">
    <div class="table-responsive">
      <!-- table for requesting data -->
      <table class="table table-bordered tbl">
        <c:if test="${empty sbForm.sbid}">
          <h2>Sell Books</h2>
        </c:if>
        <c:if test="${not empty sbForm.sbid}">
          <h2>Edit Sold Book</h2>
          <form:hidden path="sbid" />
        </c:if>

        <tr>
          <td>Book ID :</td>
          <td><form:input path="bid" required="required"
              class="textb" /><br> <form:errors path="bid"
              class="error" /></td>
        </tr>
        <tr>
          <td>Quantity :</td>
          <td><form:input type="number" path="sbquan"
              required="required" class="textb" /><br> <form:errors
              path="sbquan" class="error" /></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit"
            value="Submit" /></td>
        </tr>
      </table>
    </div>
  </form:form>
  <br>
  <hr>
  <br>
  <h6>${errorMsg}</h6>
  <c:remove var="errorMsg" />
  <!-- check if list is emply or not -->
  <c:if test="${not empty sbList}">
    <h2>Sold Book List</h2>
    <!-- table for showing data -->
    <table class="table table-bordered">
      <tr>
        <th>ID</th>
        <th>Book Name</th>
        <th>Date</th>
        <th>Quantity</th>
        <th>Total Price</th>
      </tr>
      <!-- looping and print out all the data -->
      <c:forEach items="${sbList}" var="sb">
        <tr>
          <td align="center">${sb.sbid}</td>
          <td align="left">${sb.bname}</td>
          <td align="left">${sb.sbdate}</td>
          <td align="left">${sb.sbquan}</td>
          <td align="left">${sb.sbtprice}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>

  <!-- To make error message disappear over time -->
  <script type="text/javascript">
            $(document).ready(function() {
                $('h6').delay(2000).fadeOut();
            });
        </script>
</body>
</html>