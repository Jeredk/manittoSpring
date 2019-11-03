<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" %>

<html lang="en">

	<div >

		<form method="post" action="SendMSG">
			보내는사람:<input type="text" name="RECEIVER" value="${RECEIVER}"> 
			받는사람:<input type="text" name="SENDER" value="${SENDER}"><br>
			  
			
				
			<b>내용:<textarea name="CONTENT" class="form-control" rows="5"></textarea></b>
			
			<input type="submit" value="전송" class="btn btn-success" style="float: right; margin-top: 5px">
		</form>
	</div>
</body>

<script>
$('input:submit').click(function() {
	$.ajax({
		url: 'SendMSG',
		type: 'post',
		data: $('form').serialize(),
		success: function(res) {
			alert('쪽지 발송 완료');
			self.close();
		}
	})
	return false;
});
</script>
</html>