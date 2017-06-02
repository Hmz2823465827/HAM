<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>HouseAgencyManagement</title>
<%@ include file="/WEB-INF/views/include/bootstrap.jsp"%>
<script type="text/javascript" src="static/js/md5.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${ctx}/plugin/css/welcome/welcome.css" rel="stylesheet"/>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix" id="head">
					<div class="col-md-12 column">
						<h1 class="text-center" id="text1">HAM</h1>
						<h4 class="text-center">为提供便捷的房屋中介管理.</h4>
					</div>
				</div>
				<div class="row clearfix" id="middle">
					<div class="col-md-4 column"></div>
					<div class="col-md-4 column">
						<div class="tabbable" id="tabs-448824">
							<ul class="nav nav-tabs">
								<li class="active" id="buttom1"><a href="#panel-657465"
									data-toggle="tab">登陆</a></li>
								<li><a href="#panel-489011" data-toggle="tab">注册</a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="panel-657465">
									<form class="form-horizontal" role="form" id="form1">
										<div class="form-group">
											<label for="input1" class="col-sm-2 control-label">用户:</label>
											<div class="col-sm-10">
												<input class="form-control" id="input1" type="text"
													placeholder="请输入用户名" name="employeeId" />
											</div>
										</div>
										<div class="form-group">
											<label for="input2" class="col-sm-2 control-label">密码:</label>
											<div class="col-sm-10">
												<input class="form-control" id="input2" type="password"
													placeholder="请输入密码" name="passWord" />
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<div class="checkbox">
													<label><input type="checkbox" />记住密码</label>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="submit"
													class="btn btn-block btn-default btn-primary"
													id="LoginButton">登陆</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 column"></div>
				</div>
				<div class="row clearfix" id="foot">
					<div class="col-md-12 column"></div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#LoginButton").click(function(e) {
		e.preventDefault();

		$.ajax({
			cache : true,
			type : "POST",
			datetype : "json",
			data : $("#form1").serializeArray(),
			url : "/HAM/index/login.htmls",
			success : function(dataJson) {
				if (dataJson.isLogin == true) {
					window.setTimeout("loginsuccess()", 500);
				}
				if (dataJson.isLogin == false) {
					alert(data.errorMsg);
				}

			}
		});
	});

	function loginsuccess() {
		$("#form1").attr({
			"action" : "/HAM/index/toIndex.htmls",
			"method" : "POST"
		}).submit();
	};
</script>
</html>
