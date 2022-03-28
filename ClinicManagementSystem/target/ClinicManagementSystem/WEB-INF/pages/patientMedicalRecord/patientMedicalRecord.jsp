<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<title>Patient MedicalRecord Page</title>
</head>

<body>
  <div class="wrapper">
    <div class="form-registration">
      <form:form
        action="${pageContext.request.contextPath}/addPatientMedicalRecordConfirm"
        modelAttribute="patientMedicalRecordForm" id="form">
        <c:if
          test="${empty patientMedicalRecordForm.patientMedicalRecordId}">
          <h2 class="tit-hdr">Add New Patient Medical Record</h2>
        </c:if>
        <c:if
          test="${not empty patientMedicalRecordForm.patientMedicalRecordId}">
          <h2 class="tit-hdr">Edit Patient Medical Record</h2>
          <form:hidden path="patientMedicalRecordId" />
        </c:if>
        <form:hidden path="patientId" />
        <div class="inp clearfix">
          <fieldset class="field-set lf">
            <legend>Medicine Record</legend>
            <form:textarea path="medicalRecord" class="form-inp"
              placeholder="Medical Record" rows="5" cols="20" /><br>
            <i class="err-txt"><form:errors path="medicalRecord"
                class="error" /></i>
          </fieldset>
          <fieldset class="field-set rg">
            <legend>Medicine</legend>
            <form:textarea path="medicine" class="form-inp"
              placeholder="Medicine" rows="5" cols="20" /><br>
            <i class="err-txt"><form:errors path="medicine"
                class="error" /></i>
          </fieldset>
        </div>
        <div class="inp clearfix">
          <fieldset class="field-set lf">
            <legend>Cost</legend>
            <form:input type="Number" path="cost" class="form-inp"
              placeholder="Cost" /><br>
            <i class="err-txt"><form:errors path="cost"
                class="error" /></i>
          </fieldset>
          <fieldset class="field-set rg">
            <legend>Remark</legend>
            <form:textarea path="remark" class="form-inp"
              placeholder="Remark" rows="5" cols="20" /><br>
            <i class="err-txt"><form:errors path="remark"
                class="error" /></i>
          </fieldset>
        </div>
        <div class="center-f">
          <input type="submit" class="btn sub" value="Confirm">
          <input type="button" class="btn sub ${btnJs}-btn"
            value="${btnName}"> <input type="button"
            class="btn sub back-btn" value="Back">
        </div>
        <!-- /.center-f -->
      </form:form>
    </div>
    <!-- /.form-registration -->
  </div>
</body>
</html>