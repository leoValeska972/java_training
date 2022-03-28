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
    modelAttribute="sellBookForm">
    <div class="table-responsive">
      <!-- table for requesting data -->
      <table class="table table-bordered tbl">
        <c:if test="${empty sellBookForm.sellbid}">
          <h2>Sell Books</h2>
        </c:if>
        <c:if test="${not empty sellBookForm.sellbid}">
          <h2>Edit Sold Book</h2>
          <form:hidden path="sellbid" />
        </c:if>

        <tr>
          <td>Book ID :</td>
          <td><form:input path="bid" required="required"
              class="textb" /><br> <form:errors path="bid"
              class="error" /></td>
        </tr>
        <tr>
          <td>Quantity :</td>
          <td><form:input type="number" path="sellbquantity"
              required="required" class="textb" /><br> <form:errors
              path="sellbquantity" class="error" /></td>
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
  <c:if test="${not empty sellBookList}">
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
      <c:forEach items="${sellBookList}" var="sb">
        <tr>
          <td align="center">${sb.sellbid}</td>
          <td align="left">${sb.bname}</td>
          <td align="left">${sb.sellbdate}</td>
          <td align="left">${sb.sellbquantity}</td>
          <td align="left">${sb.sellbtprice}</td>
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