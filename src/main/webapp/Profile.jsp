<%--
  Created by IntelliJ IDEA.
  User: Prajwal
  Date: 12/4/2016
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
First name<c:out value="${foreignProfile.getFirstName()}"/><br>
Last Name<c:out value="${foreignProfile.getLastName()}"/><br>
T number<c:out value="${foreignProfile.getTnumber()}"/><br>
Department<c:out value="${foreignProfile.getDepartment()}"/><br>
Program<c:out value="${foreignProfile.getProgram()}"/><br>
G pa<c:out value="${foreignProfile.getGpa()}"/><br>
S kills<c:out value="${foreignProfile.getSkills()}"/><br>
P rojects<c:out value="${foreignProfile.getProjects()}"/><br>
I nterest<c:out value="${foreignProfile.getInterest()}"/><br>
</body>
</html>
