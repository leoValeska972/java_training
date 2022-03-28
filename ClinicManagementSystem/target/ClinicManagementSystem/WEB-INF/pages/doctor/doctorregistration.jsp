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
  <div class="wrapper">
    <div class="form-registration">
      <form:form
        action="${pageContext.request.contextPath}/addDoctorConfirm"
        modelAttribute="doctorForm" id="form">
        <c:if test="${empty doctorForm.userId}">
          <h2 class="tit-hdr">Doctor Registration</h2>
        </c:if>
        <c:if test="${not empty doctorForm.userId}">
          <h2 class="tit-hdr">Edit Doctor Info</h2>
          <form:hidden path="userId" />
        </c:if>
        <br>
        <div class="inp clearfix">
          <fieldset class="field-set lf">
            <legend>Doctor Name</legend>
            <form:input type="text" path="userName" class="form-inp"
              placeholder="Doctor Name" />
            <br> <i class="err-txt"><form:errors
                path="userName" cssClass="error" /></i>
          </fieldset>
          <fieldset class="field-set rg">
            <legend>Email Address</legend>
            <form:input type="text" path="userEmail" id=""
              class="form-inp" placeholder="Email Address" />
            <br> <i class="err-txt"><form:errors
                path="userEmail" cssClass="error" /></i>
          </fieldset>
        </div>
        <!--/.inp-->
        <div class="inp clearfix">
          <fieldset class="field-set lf">
            <legend>Phone Number</legend>
            <form:input type="text" path="userPhone" id=""
              class="form-inp" placeholder="Doctor's Phone Number" />
            <br> <i class="err-txt"><form:errors
                path="userPhone" cssClass="error" /></i>
          </fieldset>
          <c:if test="${empty doctorForm.userId}">
            <fieldset class="field-set rg">
              <legend>Doctor Password</legend>
              <form:input type="password" path="userPassword" id=""
                class="form-inp" placeholder="Password" />
              <br> <i class="err-txt"><form:errors
                  path="userPassword" cssClass="error" /></i>
            </fieldset>
          </c:if>
          <c:if test="${not empty doctorForm.userId}">
              <form:hidden path="userPassword" />
          </c:if>
        </div>
        <!--/.inp-->
        <div class="inp clearfix">
          <fieldset class="field-set rg">
            <legend>Degree</legend>
            <form:input type="text" path="doctorDegree" id=""
              class="form-inp" placeholder="Doctor's Degree" />
            <br> <i class="err-txt"><form:errors
                path="doctorDegree" cssClass="error" /></i>
          </fieldset>
          <fieldset class="field-set lf">
            <legend>Specialization</legend>
            <form:input type="text" path="doctorSpecialization" id=""
              class="form-inp" placeholder="Doctor's Specialization" />
            <br> <i class="err-txt"><form:errors
                path="doctorSpecialization" cssClass="error" /></i>
          </fieldset>

        </div>
        <!--/.inp-->
        <div class="inp">
          <fieldset class="field-set">
            <legend>Duty Time</legend>
            <form:input type="text" path="doctorDutyTime"
              class="form-inp" id="dutytime" hidden="hidden" />
            <div class="d-time lf">
              <input type="time" class="form-inp time" data-time="start">
            </div>
            <div class="d-time lf">
              <input type="time" class="form-inp time" data-time="end">
            </div>
            <br> <br> <br> <br> <i class="err-txt">
              <form:errors path="doctorDutyTime" cssClass="error" />
            </i>
          </fieldset>
        </div>
        <div class="inp">
          <fieldset class="field-set rel">
            <legend>Duty Day</legend>
            <form:input path="doctorDutyDay" class="form-inp"
              hidden="hidden" id="selector-inp" />
            <div class="form-inp select-field clearfix">
              <div class="selection lf clearfix"></div>
              <span class="select-ico rg fa-usage"></span>
            </div>
            <nav class="selectors">
              <ul class="day-selector clearfix">
                <li class="days lf" data-day="Sunday">Sunday</li>
                <li class="days lf" data-day="Monday">Monday</li>
                <li class="days lf" data-day="Tuesday">Tuesday</li>
                <li class="days lf" data-day="Wendesday">Wendesday</li>
                <li class="days lf" data-day="Thursday">Thursday</li>
                <li class="days lf" data-day="Friday">Friday</li>
                <li class="days lf" data-day="Saturday">Saturday</li>
              </ul>
            </nav>
            <br> <i class="err-txt"><form:errors
                path="doctorDutyDay" cssClass="error" /></i>
          </fieldset>
        </div>
        <!-- /.inp -->
        <div class="center-f">
          <input type="submit" class="btn sub mrg-top" value="Confirm">
          <input type="button" class="btn sub ${btnJs}-btn  mrg-top"
            value="${btnName}"> <input type="button"
            class="btn sub back-btn mrg-top" value="Back">
        </div>
        <!-- /.center-f -->
      </form:form>
    </div>
    <!-- /.form-registration -->
  </div>
  <!-- wrapper -->
</body>
</html>