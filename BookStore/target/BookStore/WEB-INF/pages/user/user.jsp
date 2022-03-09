<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<title>User Page</title>
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<head>
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
</head>

<body>
  <form:form action="${pageContext.request.contextPath}/user"
    modelAttribute="userForm">
    <div class="table-responsive">
      <!-- table for requesting data -->
      <table class="table table-bordered" style="width: 35%">
        <c:if test="${empty userForm.uid}">
          <h1>Add User</h1>
        </c:if>
        <c:if test="${not empty userForm.uid}">
          <h1>Edit User</h1>
          <form:hidden path="uid" />
        </c:if>

        <tr>
          <td>Name :</td>
          <td><form:input path="uname" required="required" /><br>
            <form:errors path="uname" style="color:red;" /></td>
        </tr>
        <tr>
          <td>Address :</td>
          <td><form:input path="uaddress" required="required" /><br>
            <form:errors path="uaddress" style="color:red;" /></td>
        </tr>

        <tr>
          <td>Phone :</td>
          <td><form:input type="number" path="uph"
              required="required" /><br> <form:errors path="uph"
              style="color:red;" /></td>
        </tr>

        <tr>
          <td>Email :</td>
          <td><form:input path="uemail" required="required" /><br>
            <form:errors path="uemail" style="color:red;" /></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit"
            value="Submit" /></td>
        </tr>
      </table>
    </div>
  </form:form>
  <br>
  <!-- check if list is emply or not -->
  <c:if test="${not empty userList}">
    <h1>User List</h1>
    <h6>${errorMsg}</h6>
    <c:remove var="errorMsg" />
    <!-- table for showing data -->
    <table class="table table-bordered" style="width: 400px">
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
      <!-- looping and print out all the data -->
      <c:forEach items="${userList}" var="user">
        <tr>
          <td align="center">${user.uid}</td>
          <td>${user.uname}</td>
          <td align="center">${user.uaddress}</td>
          <td align="center">${user.uph}</td>
          <td align="center">${user.uemail}</td>
          <td align="center"><a
            href="<c:url value='editEmployee/${user.uid}' />">Edit</a></td>
          <td align="center"><a
            href="<c:url value='deleteEmployee/${user.uid}' />">Delete</a></td>
        </tr>
      </c:forEach>
    </table>
  </c:if>

  <script type="text/javascript">
            $(document).ready(function() {
                $('h6').delay(2000).fadeOut();
            });
        </script>
</body>
</html>