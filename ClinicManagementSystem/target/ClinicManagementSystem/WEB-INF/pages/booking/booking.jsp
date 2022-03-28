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
        action="${pageContext.request.contextPath}/addBookingConfirm"
        modelAttribute="bookingForm" id="form">
        <c:if test="${empty bookingForm.bookingId}">
          <h2 class="tit-hdr">Book An Appointment</h2>
          <br>
          <div class="inp clearfix">
            <fieldset class="field-set lf">
              <legend>Name</legend>
              <form:input type="text" path="patientName"
                class="form-inp" placeholder="Patient Name" />
              <br> <i class="err-txt"><form:errors
                  path="patientName" class="error" /></i>
            </fieldset>
            <fieldset class="field-set rg">
              <legend>Phone</legend>
              <form:input type="text" path="contactPhone"
                class="form-inp" placeholder=" Contact Phone" />
              <br> <i class="err-txt"><form:errors
                  path="contactPhone" class="error" /></i>
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
        </c:if>

        <c:if test="${not empty bookingForm.bookingId}">
          <h2 class="tit-hdr">Edit Booking Info</h2>
          <br>
          <div class="center-f">
              Status : 
            <form:hidden path="bookingId" />
            <form:select path="status" class="select-status">
              <form:option value="Pending" label="Pending" />
              <form:option value="Accepted" label="Accepted" />
              <form:option value="Rejected" label="Rejected" />
            </form:select>
            <br>
            <fieldset class="field-set reject-msg">
              <legend>Reject Message</legend>
              <form:textarea path="rejectMsg"
                class="edit-inp" placeholder="Reject Message"
                rows="3" cols="10" />
              <br> <i class="err-txt"><form:errors
                  path="rejectMsg" class="error" /></i>
            </fieldset>
            <br>
            <input type="submit" class="btn sub" value="Confirm">
            <input type="button" class="btn sub ${btnJs}-btn"
              value="${btnName}"> <input type="button"
              class="btn sub back-btn" value="Back">
          </div>
        </c:if>
      </form:form>
    </div>
    <!-- /.form-registration -->
  </div>
</body>
</html>