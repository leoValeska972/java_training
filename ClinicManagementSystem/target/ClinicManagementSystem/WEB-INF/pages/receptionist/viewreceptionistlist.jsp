<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <section class="content-sec">
    <div class="hdr clearfix">
      <div class="action-f rg clearfix">
        <form action="receptionistSearch" method="POST" class="lf">
          <input type="text" class="search-inp" name="search"><input
            type="submit" value="Search" class="btn" /> <a
            href="${pageContext.request.contextPath}/receptionistInit"
            class="btn link">Add More</a>
        </form>
      </div>
    </div>

    <c:if test="${not empty msg}">
      <div class="message-field">
        <p>${msg}</p>
        <c:remove var="msg"/>
      </div>
    </c:if>
    
    <c:if test="${empty receptionistList}">
      <br>
      <br>
      <h2 align="center">No Data Found</h2>
    </c:if>
    
    <!-- check if list is emply or not -->
    <c:if test="${not empty receptionistList}">
      <h2>Receptionist List</h2>
      <br>
      <!-- table for showing data -->
      <table id="view" class="cell-border hover responsive nowrap"
        style="width: 100%">
        <thead>
          <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          <!-- looping and print out all the data -->
          <c:forEach items="${receptionistList}" var="receptionist"
            varStatus="loopCount">
            <tr>
              <td align="center"><c:out value="${loopCount.count}" /></td>
              <td align="left">${receptionist.userName}</td>
              <td align="center">${receptionist.userPhone}</td>
              <td align="left">${receptionist.userEmail}</td>
              <td align="center"><a
                href="<c:url value='editReceptionist/${receptionist.userId}' />"
                class="btn link edit">Edit</a></td>
              <td align="center"><a
                href="<c:url value='deleteReceptionist/${receptionist.userId}' />"
                class="btn link delete">Delete</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
  </section>
</body>
</html>