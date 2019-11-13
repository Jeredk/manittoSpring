<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <!-- Include meta tag to ensure proper rendering and touch zooming -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Include jQuery Mobile stylesheets -->
  <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
  <!-- Include the jQuery library -->
  <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
  <!--
   Include the jQuery Mobile library -->
  <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

</head>
<body>
<div >

		<form method="post" action="SendMSG">
			Receiver:<input type="text" name="RECEIVER" value="${RECEIVER}"> 
			Sender:<input type="text" name="SENDER" value="${SENDER}"><br>
			  
			
				
			<b>content:<textarea name="CONTENT" class="form-control" rows="5"></textarea></b>
			
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




