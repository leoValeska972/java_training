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
            type="submit" value="Search" class="btn" /> <a
            href="${pageContext.request.contextPath}/patientInit"
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
    
    <c:if test="${empty patientInfoList}">
      <br>
      <br>
      <h2 align="center">No Data Found</h2>
    </c:if>
    
    <!-- check if list is emply or not -->
    <c:if test="${not empty patientInfoList}">
      <h2>PatientInfo List</h2>
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
            <th>Edit</th>
            <th>Delete</th>
            <th>Medical Record</th>
          </tr>
        </thead>
        <tbody>
          <!-- looping and print out all the data -->
          <c:forEach items="${patientInfoList}" var="patientInfo"
            varStatus="loopCount">
            <tr>
              <td align="center"><c:out value="${loopCount.count}" /></td>
              <td align="left">${patientInfo.patientName}</td>
              <td align="center">${patientInfo.patientAge}</td>
              <td align="left">${patientInfo.patientGender}</td>
              <td align="left">${patientInfo.patientAddress}</td>
              <td align="left">${patientInfo.patientPhone}</td>
              <td align="center"><a
                href="<c:url value='editPatientInfo/${patientInfo.patientId}' />"
                class="btn link edit">Edit</a></td>
              <td align="center"><a
                href="<c:url value='deletePatientInfo/${patientInfo.patientId}' />"
                class="btn link delete">Delete</a></td>
              <td align="center"><a
                href="<c:url value='medicalRecordView/${patientInfo.patientId}' />"
                class="btn link med">Medical Record</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
  </section>
</body>
</html>