<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%> 
<html>
<head>
		<meta charset="UTF-8">
		<title>HouseAgencyManagement</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href='<c:url value="js/bootstrap/css/bootstrap.min.css"/>'>
		<link rel="stylesheet" href='<c:url value="js/bootstrap/css/bootstrap-theme.min.css"/>'>
		<link rel="stylesheet" href='<c:url value="js/bootstrap/css/bootstrapValidator.min.css"/>'>
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src='<c:url value="js/bootstrap/js/bootstrap.min.js"/>'></script>
		<script src='<c:url value="js/bootstrap/js/bootstrapValidator.min.js"/>'></script>
<style>
			* {
				margin: 0;
				padding: 0;
			}
			
			#head {
				height: 200px;
			}
			
			#text1 {
				display: block;
				margin-top: 60px;
				font-size: 80px;
			}
			
			#middle {
				height: 300px;
			}
			
			#buttom1 {
				margin-left: 87px;
			}
			
			#foot {
				height: 200px;
			}
			
			.form-horizontal {
				margin-top: 20px;
			}
		</style>

	</head>
<body>
<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix" id="head">
						<div class="col-md-12 column">
							<h1 class="text-center" id="text1">
								HAM
			                </h1>
							<h4 class="text-center">
								为提供便捷的房屋中介管理.
			                </h4>
						</div>
					</div>
					<div class="row clearfix" id="middle">
						<div class="col-md-4 column">
						</div>
						<div class="col-md-4 column">
							<div class="tabbable" id="tabs-448824">
								<ul class="nav nav-tabs">
									<li class="active" id="buttom1">
										<a href="#panel-657465" data-toggle="tab">登陆</a>
									</li>
									<li>
										<a href="#panel-489011" data-toggle="tab">注册</a>
									</li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="panel-657465">
										<form class="form-horizontal" role="form" id="form1">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-2 control-label">用户:</label>
												<div class="col-sm-10">
													<input class="form-control" id="inputEmail3" type="text" placeholder="请输入用户名" name="id"/>
												</div>
											</div>
											<div class="form-group">
												<label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
												<div class="col-sm-10">
													<input class="form-control" id="inputPassword3" type="password" placeholder="请输入密码" name="passWord"/>
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
													<button type="submit" class="btn btn-block btn-default btn-primary" id="Login">登陆</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-4 column">
						</div>
					</div>
					<div class="row clearfix" id="foot">
						<div class="col-md-12 column">
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	/*$("#Login").click(function(e){
			  $.ajax({
				cache:true,
			    datetype:"json",
			    data:$("#form1").serializeArray(),
			    url:"/localhost:8081/springmvc_hibernate_demo/user/login",

			});  */
			/* $.post("springmvc_hibernate_demo/user/login",$("#form1").serializeArray(),
					function(result){alert("test");}) */
   			/* $("#form1").attr({"action":"/springmvc_hibernate_demo/user/login.htmls","method":"POST"}).submit();
			}) */
			
			$("#Login").click(function(e){
				e.preventDefault();
				$.ajax({
					cache:true,
				    type:"POST",
				    datetype:"json",
				    data:$("#form1").serializeArray(),
				    url:"/HAM/employee/get.htmls",
				    success:function(){
				    	/* if(data.isLogin==true){
				    		window.setTimeout("loginsuccess()", 500);
				    	}
				    	if(data.isLogin==false){
				    		alert(data.errorMsg);
				    	} */
				    	$("#form1").attr({"action":"/HAM/employee/login.htmls","method":"GET"}).submit();

				    }
				});
			});
			
			function loginsuccess(){
				$("#form1").attr({"action":"/springmvc_hibernate_demo/user/toIndex.htmls","method":"POST"}).submit();
			};
	</script>
</html>
