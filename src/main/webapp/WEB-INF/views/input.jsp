<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/views/include/bootstrap.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="input-group">
		<span class="input-group-addon" id="basic-addon1">@</span> <input
			type="text" class="form-control" placeholder="Username"
			aria-describedby="basic-addon1">
	</div>

	<div class="input-group">
		<input type="text" class="form-control"
			placeholder="Recipient's username" aria-describedby="basic-addon2">
		<span class="input-group-addon" id="basic-addon2">@example.com</span>
	</div>

	<div class="input-group">
		<span class="input-group-addon">$</span> <input type="text"
			class="form-control" aria-label="Amount (to the nearest dollar)">
		<span class="input-group-addon">.00</span>
	</div>

	<label for="basic-url">Your vanity URL</label>
	<div class="input-group">
		<span class="input-group-addon" id="basic-addon3">https://example.com/users/</span>
		<input type="text" class="form-control" id="basic-url"
			aria-describedby="basic-addon3">
	</div>
</body>
</html>