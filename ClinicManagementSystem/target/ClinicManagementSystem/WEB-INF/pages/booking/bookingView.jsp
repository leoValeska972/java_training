<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<title>Patient Info Page</title>
</head>
<body>
  <section class="content-sec">
    <div class="hdr clearfix">
      <div class="action-f rg clearfix">
        <form action="bookingSearch" method="POST" class="lf">
          <input type="text" class="search-inp" name="search"><input
            type="submit" value="Search" class="btn" />
        </form>
      </div>
    </div>

    <c:if test="${not empty msg}">
      <div class="message-field">
        <p>${msg}</p>
        <c:remove var="msg" />
      </div>
    </c:if>

    <c:if test="${empty bookingList}">
      <br>
      <br>
      <h2 align="center">No Data Found</h2>
    </c:if>

    <!-- check if list is emply or not -->
    <c:if test="${not empty bookingList}">
      <h2>Booking List</h2>
      <br>
      <!-- table for showing data -->
      <table id="view" class="cell-border hover responsive nowrap"
        style="width: 100%">
        <thead>
          <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Gender</th>
            <th>Status</th>
            <th>reject Message</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          <!-- looping and print out all the data -->
          <c:forEach items="${bookingList}" var="booking"
            varStatus="loopCount">
            <tr>
              <td align="center"><c:out value="${loopCount.count}" /></td>
              <td align="left">${booking.patientName}</td>
              <td align="center">${booking.contactPhone}</td>
              <td align="left">${booking.patientGender}</td>
              <td align="left">${booking.status}</td>
              <td align="left">${booking.rejectMsg}</td>
              <td align="center"><a
                href="<c:url value='editBooking/${booking.bookingId}' />"
                class="btn link edit">Edit</a></td>
              <td align="center"><a
                href="<c:url value='deleteBooking/${booking.bookingId}' />"
                class="btn link delete">Delete</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
  </section>
</body>
</html>