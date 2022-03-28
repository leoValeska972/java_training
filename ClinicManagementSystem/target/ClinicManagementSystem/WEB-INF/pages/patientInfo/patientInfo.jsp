<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<title>Patient Info Page</title>
</head>

<body>
  <div class="wrapper">
    <div class="form-registration">
      <form:form
        action="${pageContext.request.contextPath}/addPatientInfoConfirm"
        modelAttribute="patientInfoForm" id="form">
        <c:if test="${empty patientInfoForm.patientId}">
          <h2 class="tit-hdr">Patient Registration</h2>
        </c:if>
        <c:if test="${not empty patientInfoForm.patientId}">
          <h2 class="tit-hdr">Edit Patient Info</h2>
          <form:hidden path="patientId" />
        </c:if>
        <br>
        <div class="inp clearfix">
          <fieldset class="field-set lf">
            <legend>Name</legend>
            <form:input type="text" path="patientName" class="form-inp"
              placeholder="Patient Name" /><br>
            <i class="err-txt"><form:errors path="patientName"
                class="error" /></i>
          </fieldset>
          <fieldset class="field-set rg">
            <legend>Age</legend>
            <form:input type="number" path="patientAge" class="form-inp"
              placeholder=" Patient Age" /><br>
            <i class="err-txt"><form:errors path="patientAge"
                class="error" /></i>
          </fieldset>
        </div>
        <div class="inp clearfix">
          <fieldset class="field-set lf">
            <legend>Phone Number</legend>
            <form:input type="text" path="patientPhone"
              class="form-inp" placeholder="Patient's Phone Number" /><br>
            <i class="err-txt"><form:errors path="patientPhone"
                class="error" /></i>
          </fieldset>
          <fieldset class="field-set rg">
            <legend>Address</legend>
            <form:input type="text" path="patientAddress"
              class="form-inp" placeholder="Patient Address" /><br>
            <i class="err-txt"><form:errors path="patientAddress"
                class="error" /></i>
          </fieldset>
        </div>
        <div class="center-f">
          <div class="mrg">
            Gender :
            <form:radiobutton path="patientGender" value="Male" />
            Male
            <form:radiobutton path="patientGender" value="Female" />
            Female <br> <i class="err-txt"><form:errors
                path="patientGender" class="error" /></i>
          </div>
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