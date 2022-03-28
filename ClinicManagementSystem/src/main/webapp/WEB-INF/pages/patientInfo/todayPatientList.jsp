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
        <form action="patientInfoSearch" method="POST" class="lf">
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

    <c:if test="${empty treatingPatient}">
      <br>
      <br>
      <h2 align="center">No Data for Today Patient</h2>
    </c:if>

    <!-- check if list is emply or not -->
    <c:if test="${not empty treatingPatient}">
      <h2>Today PatientInfo List</h2>
      <br>
      <!-- table for showing data -->
      <table id="view" class="cell-border hover responsive nowrap"
        style="width: 100%">
        <thead>
          <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Status</th>
            <th>Medical Record</th>
          </tr>
        </thead>
        <tbody>
          <!-- looping and print out all the data -->
          <c:forEach items="${treatingPatient}" var="treatingPatient"
            varStatus="loopCount">
            <tr>
              <td align="center"><c:out value="${loopCount.count}" /></td>
              <td align="left">${treatingPatient.patientName}</td>
              <td align="center">${treatingPatient.patientAge}</td>
              <td align="left">${treatingPatient.patientGender}</td>
              <td align="left">${treatingPatient.patientAddress}</td>
              <td align="left">${treatingPatient.patientPhone}</td>
              <td align="center"><a
                href="<c:url value='changeStatus/${treatingPatient.patientId}' />"
                class="btn link edit">Treating</a></td>
              <td align="center"><a
                href="<c:url value='medicalRecordView/${treatingPatient.patientId}' />"
                class="btn link med">Medical Record</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
    <br>
    <hr>
    <br>
        <c:if test="${empty finishedPatient}">
      <br>
      <br>
      <h2 align="center">No Finished Patient</h2>
    </c:if>
    
    <c:if test="${not empty finishedPatient}">
      <h2>Finished Treating Patient</h2>
      <br>
      <!-- table for showing data -->
      <table id="view1" class="cell-border hover responsive nowrap"
        style="width: 100%">
        <thead>
          <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Status</th>
            <th>Medical Record</th>
          </tr>
        </thead>
        <tbody>
          <!-- looping and print out all the data -->
          <c:forEach items="${finishedPatient}" var="finishedPatient"
            varStatus="loopCount">
            <tr>
              <td align="center"><c:out value="${loopCount.count}" /></td>
              <td align="left">${finishedPatient.patientName}</td>
              <td align="center">${finishedPatient.patientAge}</td>
              <td align="left">${finishedPatient.patientGender}</td>
              <td align="left">${finishedPatient.patientAddress}</td>
              <td align="left">${finishedPatient.patientPhone}</td>
              <td align="center">${finishedPatient.status}</td>
              <td align="center"><a
                href="<c:url value='medicalRecordView/${finishedPatient.patientId}' />"
                class="btn link med">Medical Record</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
  </section>
</body>
</html>