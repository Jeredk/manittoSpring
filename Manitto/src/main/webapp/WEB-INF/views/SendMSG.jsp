<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" %>

<html lang="en">

	<div >

		<form method="post" action="SendMSG">
			<input type="hidden" name="id" value="${toUser}" readonly="readonly"> 
			<input type="hidden" name="id2" value="${fromUser}"><br>  
				<b>받는사람:${toUser}</b><br>
				
			<textarea name="msgcontent" class="form-control" rows="5"></textarea>
			
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