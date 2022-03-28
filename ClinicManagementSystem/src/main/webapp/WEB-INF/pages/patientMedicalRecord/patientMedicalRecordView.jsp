<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<title>Patient MedicalRecord Page</title>
</head>
<body>
  <section class="content-sec">
    <div class="hdr clearfix">
      <div class="action-f rg clearfix">
        <c:if test="${empty all}">
          <form action="${pageContext.request.contextPath}/recordSearch"
            method="POST" class="lf">
            <input type="text" class="search-inp" name="record"><input
              type="submit" value="Search" class="btn" /> <a
              href="${pageContext.request.contextPath}/addPatientMedicalRecord/${pid}"
              class="btn link">Add More</a>
          </form>
        </c:if>
        <c:if test="${not empty all}">
          <form
            action="${pageContext.request.contextPath}/recordSearchAll"
            method="POST" class="lf">
            <input type="text" class="search-inp" name="record"><input
              type="submit" value="Search" class="btn" />
          </form>

        </c:if>
      </div>
    </div>

    <c:if test="${not empty msg}">
      <div class="message-field">
        <p>${msg}</p>
        <c:remove var="msg" />
      </div>
    </c:if>

    <c:if test="${empty patientMedicalRecordList}">
      <br>
      <br>
      <h2 align="center">No Data Found</h2>
    </c:if>

    <!-- check if list is emply or not -->
    <c:if test="${not empty patientMedicalRecordList}">
      <h2>Patient Medical Record List</h2>
      <br>
      <c:if test="${empty all}">
        <h4>Patient Name&emsp;&emsp;: ${name}</h4>
        <h4>Patient Age&emsp;&emsp;&emsp;: ${age}</h4>
        <h4>Patient Gender&emsp;&nbsp;: ${gender}</h4>
        <br>
      </c:if>
      <!-- table for showing data -->
      <table id="view" class="cell-border hover responsive nowrap"
        style="width: 100%">
        <thead>
          <tr>
            <th>No.</th>
            <c:if test="${not empty all}">
              <th>Patient Name</th>
            </c:if>
            <th>Treatment Date</th>
            <th>medical record</th>
            <th>medicine</th>
            <th>cost</th>
            <th>remark</th>
            <c:if test="${empty all}">
              <th>Edit</th>
              <th>Delete</th>
            </c:if>
          </tr>
        </thead>
        <tbody>
          <!-- looping and print out all the data -->
          <c:forEach items="${patientMedicalRecordList}"
            var="patientMedicalRecord" varStatus="loopCount">
            <c:set var="pid" value="${patientMedicalRecord.patientId}" />
            <tr>
              <td align="center"><c:out value="${loopCount.count}" /></td>
              <c:if test="${not empty all}">
                <td align="left">${patientMedicalRecord.patientName}</td>
              </c:if>
              <td align="left">${patientMedicalRecord.recordDateTime}</td>
              <td align="left">${patientMedicalRecord.medicalRecord}</td>
              <td align="left">${patientMedicalRecord.medicine}</td>
              <td align="right">${patientMedicalRecord.cost}</td>
              <td align="left">${patientMedicalRecord.remark}</td>
              <c:if test="${empty all}">
                <td align="center"><a
                  href="${pageContext.request.contextPath}/editPatientMedicalRecord/${patientMedicalRecord.patientMedicalRecordId}"
                  class="btn link edit">Edit</a></td>
                <td align="center"><a
                  href="${pageContext.request.contextPath}/deletePatientMedicalRecord/${patientMedicalRecord.patientMedicalRecordId}"
                  class="btn link delete">Delete</a></td>
              </c:if>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
  </section>
</body>
</html>