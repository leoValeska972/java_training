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
        <form action="doctorSearch" method="POST" class="lf">
          <input type="text" class="search-inp" name="search"><input
            type="submit" value="Search" class="btn" /> <a
            href="${pageContext.request.contextPath}/doctorInit"
            class="btn link">Add More</a>
        </form>
      </div>
    </div>

    <c:if test="${not empty msg}">
      <div class="message-field">
        <p>${msg}</p>
        <c:remove var="msg" /> 
      </div>
    </c:if>
    <c:forEach items="${doctorList }" var="doctor">
      <div class="doc-detail-field">
        <div class="box clearfix">
          <div class="doc-prof lf">
            <img
              src="${pageContext.request.contextPath}/resources/img/doctor.svg"
              alt="doctor profile">
          </div>
          <div class="doc-detail rg">
            <div class="dd-f">
              <b>Name</b> : <span>${doctor.userName}</span>
            </div>
            <div class="dd-f">
              <b>Phone Number</b> : <span>${doctor.userPhone }</span>
            </div>
            <div class="dd-f">
              <b>Email Address</b> : <span>${doctor.userEmail }</span>
            </div>
            <div class="dd-f">
              <b>Degree</b> : <span>${doctor.doctorDegree }</span>
            </div>
            <div class="dd-f">
              <b>Specialization</b> : <span>${doctor.doctorSpecialization }</span>
            </div>
            <div class="dd-f">
              <b>Duty Day</b> : <span>${doctor.doctorDutyDay }</span>
            </div>
            <div class="dd-f">
              <b>Duty Time</b> : <span>${doctor.doctorDutyTime }</span>
            </div>
            <div class="dd-f">
              <a
                href="${pageContext.request.contextPath }/editDoctor/${doctor.userId}"
                class="btn link edit">Edit</a> <a
                href="${pageContext.request.contextPath }/deleteDoctor/${doctor.userId}"
                class="link btn delete">Delete</a>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </section>
</body>
</html>