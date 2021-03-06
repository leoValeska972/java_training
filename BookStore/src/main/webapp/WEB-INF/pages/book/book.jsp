<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<title>Book Page</title>
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<head>
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
</head>

<body>
  <form:form action="${pageContext.request.contextPath}/addBook"
    modelAttribute="bookForm">
    <div class="table-responsive">
      <!-- table for requesting data -->
      <table class="table table-bordered tbl">
        <c:if test="${empty bookForm.bid}">
          <h2>Add New Books</h2>
        </c:if>
        <c:if test="${not empty bookForm.bid}">
          <h2>Edit Book</h2>
          <form:hidden path="bid" />
        </c:if>

        <tr>
          <td>Name :</td>
          <td><form:input path="bname" required="required"
              class="textb" /><br> <form:errors path="bname"
              class="error" /></td>
        </tr>
        <tr>
          <td>Author :</td>
          <td><form:input path="bauthor" required="required"
              class="textb" /><br> <form:errors path="bauthor"
              class="error" /></td>
        </tr>
        <tr>
          <td>Publisher :</td>
          <td><form:input path="bpublisher" required="required"
              class="textb" /><br> <form:errors path="bpublisher"
              class="error" /></td>
        </tr>
        <tr>
          <td>ISBN :</td>
          <td><form:input type="number" path="bisbn"
              required="required" class="textb" /><br> <form:errors
              path="bisbn" class="error" /></td>
        </tr>

        <tr>
          <td>Quantity :</td>
          <td><form:input type="number" path="bquantity"
              required="required" class="textb" /><br> <form:errors
              path="bquantity" class="error" /></td>
        </tr>
        <tr>
          <td>Price :</td>
          <td><form:input type="number" path="bprice"
              required="required" class="textb" /><br> <form:errors
              path="bprice" class="error" /></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit"
            value="Submit" /></td>
        </tr>
      </table>
    </div>
  </form:form>

  <h6>${fileErrMsg}</h6>
  <c:remove var="fileErrMsg" />
  <h6 class="download"></h6>
  <p>
    <a href="<c:url value='download' />" class="down">Download</a>
  </p>
  <form action="upload?${_csrf.parameterName}=${_csrf.token}"
    method="post" enctype="multipart/form-data">
    <input type="file" name="file" /><br> <br> <input
      type="submit" value="Submit" />
  </form>
  <br>
  <hr>
  <h6>${errorMsg}</h6>
  <c:remove var="errorMsg" />
  <!-- check if list is emply or not -->
  <c:if test="${not empty bookList}">
    <h2>Book List</h2>
    <!-- table for showing data -->
    <table class="table table-bordered">
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>ISBN</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
      <!-- looping and print out all the data -->
      <c:forEach items="${bookList}" var="book">
        <tr>
          <td align="center">${book.bid}</td>
          <td align="left">${book.bname}</td>
          <td align="left">${book.bauthor}</td>
          <td align="left">${book.bpublisher}</td>
          <td align="left">${book.bisbn}</td>
          <td align="right">${book.bquantity}</td>
          <td align="right">${book.bprice}</td>
          <td align="center"><a
            href="<c:url value='editBook/${book.bid}' />">Edit</a></td>
          <td align="center"><a
            href="<c:url value='deleteBook/${book.bid}' />">Delete</a></td>
        </tr>
      </c:forEach>
    </table>
  </c:if>

  <script type="text/javascript">
            $(document).ready(function() {
                $(".down").click(function() {
                    $(".download").text("Download Successful");
                });
                $("h6").delay(2000).fadeOut();
            });
        </script>
</body>
</html>