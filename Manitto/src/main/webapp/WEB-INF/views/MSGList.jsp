<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h1>메세지</h1>
<div class="container">
		<h2 style="text-align: center;">쪽지함</h2>
		<table class="table">
			<tr>
				<th>보낸사람</th>
				<th>내용</th>
			</tr>

				<c:forEach items="${msgList}" var="item"  >
					<tr>
						<td>${item.id2}</td>
						<td>${item.content}</td>
					</tr>
				</c:forEach>

		</table>

	</div>

</body>
</html>
