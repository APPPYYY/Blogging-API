<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpringBoot-${title}</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/mycss.css" rel="stylesheet">



<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
</head>
<body>

	<%@ include file="./shared/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<c:if test="${UserClickIndex==true}">
				<%@include file="index.jsp"%>
			</c:if>
			
			


			

			<c:if test="${UserClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>


			<div class="col-md-3">
				<c:if test="${UserClickProduct==true or UserClickCategory==true}">
					<%@ include file="./shared/sidebar.jsp"%>
				</c:if>
			</div>

			<div class="col-md-9">

				

				



			</div>



			<%@include file="./shared/footer.jsp"%>
		</div>


	</div>



	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery.js"></script>

	<script src="js/my.js"></script>
</body>
</html>