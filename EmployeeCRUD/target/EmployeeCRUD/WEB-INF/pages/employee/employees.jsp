<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<title>Employee Page</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/addEmployee"
        modelAttribute="employeeForm">
        <div class="table-responsive">
            <!-- table for requesting data -->
            <table class="table table-bordered" style="width: 35%">
                <c:if test="${empty employeeForm.eid}">
                    <h1>Add Employee</h1>
                </c:if>
                <c:if test="${not empty employeeForm.eid}">
                    <h1>Edit Employee</h1>
                    <form:hidden path="eid" />
                </c:if>

                <tr>
                    <td>Name :</td>
                    <td><form:input path="ename"
                            required="required" /><br> <form:errors
                            path="ename" style="color:red;" /></td>
                </tr>

                <tr>
                    <td>Age :</td>
                    <td><form:input type="number" path="eage"
                            required="required" /><br> <form:errors
                            path="eage" style="color:red;" /></td>
                </tr>

                <tr>
                    <td>Department :</td>
                    <td><form:input path="edept"
                            required="required" /><br> <form:errors
                            path="edept" style="color:red;" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input
                        type="submit" value="Submit" /></td>
                </tr>
            </table>
        </div>
    </form:form>
    <br>
    <!-- check if list is emply or not -->
    <c:if test="${not empty employeeList}">
        <h1>Employee List</h1>
        <h6>${errorMsg}</h6>
        <c:remove var="errorMsg" />
        <!-- table for showing data -->
        <table class="table table-bordered" style="width: 400px">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Dept</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <!-- looping and print out all the data -->
            <c:forEach items="${employeeList}" var="employee">
                <tr>
                    <td align="center">${employee.eid}</td>
                    <td>${employee.ename}</td>
                    <td align="center">${employee.eage}</td>
                    <td align="center">${employee.edept}</td>
                    <td align="center"><a
                        href="<c:url value='editEmployee/${employee.eid}' />">Edit</a></td>
                    <td align="center"><a
                        href="<c:url value='deleteEmployee/${employee.eid}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>