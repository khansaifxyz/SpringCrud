<%@page import="org.springframework.http.server.reactive.ContextPathCompositeHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<link
	href="/CRUDSpringMVC/resources/css/bootstrap.min.css"
	rel="stylesheet" />
	
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>
<script type="text/javascript" src="/CRUDSpringMVC/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function(){
	$("#loginBean").on('submit',function(){
		$("#userID").val("Enter The Value");
		$("#userpass").prop("type","text");
		$("#userpass").val("Enter UserPassword");
		});
	
}); */


</script>
<div class="container">
		<div class="col-5">
			<div class="card"
				style="box-shadow: 2px 4px 10px 0px #BBB;">
				<div class="card-header">Sing In your account</div>
				<form:form id="loginBean" action="/CRUDSpringMVC/employee/save.do" modelAttribute="loginBean" method="post">
					
					<div class="card-body">

						<div class="row">
							<div class="col-12  form-group">
								<label class="label" for="userid">User ID</label>
								<form:input path="userID" class="form-control" id="userID" />
								<form:errors path="userID" class="error" id="errorID"/>
							</div>

						</div>
						<div class="row">
							<div class="col-12   form-group">
								<label class="label" for="userpass">Password</label>
								<form:password  path="userpass" class="form-control" id="userpass" />
								<form:errors path="userpass" class="error"/>
								<a class="btn-link"
									href="/CRUDSpringMVC/employee/register.do">register
									new employees</a>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12   form-group">
								<input type="submit" style="float: right;" id="submitbtn" value="login"
									class="btn btn-primary" />

							</div>
						</div>

					</div>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>