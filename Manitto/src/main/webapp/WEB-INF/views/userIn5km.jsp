<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>userIn5km</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>

<body>
<h1>주변 사람들</h1>
<c:forEach items="${userList}" var="user">
<li>user</li>

</c:forEach>

</body>
</html>
