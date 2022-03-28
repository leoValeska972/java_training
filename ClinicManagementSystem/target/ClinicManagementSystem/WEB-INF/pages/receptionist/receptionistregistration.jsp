<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div class="wrapper">
    <div class="form-registration">
      <form:form
        action="${pageContext.request.contextPath}/addReceptionistConfirm"
        modelAttribute="receptionistForm" id="form">
        <c:if test="${empty receptionistForm.userId}">
          <h2 class="tit-hdr">Receptionist Registration</h2>
        </c:if>
        <c:if test="${not empty receptionistForm.userId}">
          <h2 class="tit-hdr">Edit Receptionist Info</h2>
          <form:hidden path="userId" />
        </c:if>
        <br>
        <div class="inp clearfix">
          <fieldset class="field-set lf">
            <legend>Receptionist Name</legend>
            <form:input type="text" path="userName" class="form-inp"
              placeholder="Receptionist Name" />
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

        <c:if test="${empty receptionistForm.userId}">
          <div class="inp clearfix">
            <fieldset class="field-set lf">
              <legend>Password</legend>
              <form:input type="password" path="userPassword" id=""
                class="form-inp" placeholder="Password" />
              <br> <i class="err-txt"><form:errors
                  path="userPassword" cssClass="error" /></i>
            </fieldset>
            <fieldset class="field-set rg">
              <legend>Phone Number</legend>
              <form:input type="text" path="userPhone" id=""
                class="form-inp" placeholder="Phone Number" />
              <br> <i class="err-txt"><form:errors
                  path="userPhone" cssClass="error" /></i>
            </fieldset>
          </div>
        </c:if>
        <!--/.inp-->
        <div class="center-f">
          <c:if test="${not empty receptionistForm.userId}">
            <fieldset class="field-set">
              <legend>Phone Number</legend>
              <form:input type="text" path="userPhone" id=""
                class="form-inp fix" placeholder="Phone Number" />
              <br> <i class="err-txt"><form:errors
                  path="userPhone" cssClass="error" /></i>
            </fieldset>
            <form:hidden path="userPassword"/>
          </c:if>
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