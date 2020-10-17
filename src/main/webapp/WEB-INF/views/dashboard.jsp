<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello !!! </h1>
 <table border="2">
 <tr>
            <th>EMP_ID</th>
            <th>FIRST_NAME</th>
            <th>LAST_NAME</th>
            <th>EMAIL</th>
             <th>Action</th> 
           </tr>
 
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
 
                     <td>${employee.empid}</td> 
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.email}</td>
                      <td><a href="${pageContext.request.contextPath}/employee/editEmployee/${employee.empid}.do">Edit</a> 
                          
                        <a href="${pageContext.request.contextPath}/employee/deleteEmployee/${employee.empid}.do">Delete</a></td> 
                </tr>
            </c:forEach>
        </table>
</body>
</html>