<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>房屋中介管理系统</title>
<script src='<c:url value="plugin/js/jquery-2.1.0.js"/>'
	type="text/javascript" charset="utf-8"></script>
<script src='<c:url value="plugin/js/bootstrap.js"/>'
	type="text/javascript" charset="utf-8"></script>
<script
	src='<c:url value="plugin/js/bootstrap-table/bootstrap-table.js"/>'
	type="text/javascript" charset="utf-8"></script>
<script src='<c:url value="plugin/js/bootstrap-treeview.js"/>'
	type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/bootstrap-theme.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/bootstrap.min.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/bootstrap-treeview.css"/>' />


</head>

<body>
	<div id="all" class="container-fluid" style="background-color: #fff;">
		<div id="topall" class="container-fluid"
			style="background-color: #F5F5F5; border: #F1F1F1 2px solid; border-radius: 5px;">

			<div id="top" class="col-md-12 column">
				<div class="navbar-header">
					<a class="navbar-brand">HAM</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="plugin/#">Link</a></li>
						<li><a href="plugin/#">Link</a></li>

					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="plugin/#">Link</a></li>
						<li class="dropdown"><a href="plugin/#"
							class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong
								class="caret"></strong></a></li>
					</ul>
				</div>
			</div>
		</div>

		<div id="board" class="container-fluid"
			style="padding-left: 0px; padding-right: 0px; background-color: #F5F5F5; border: #F1F1F1 2px solid; border-radius: 5px; margin-top: 12px;">
			<div id="personal" class="col-md-3 column"
				style="background-color: #;">
				<div id="img1" style="height: 100px; width: 100px; float: left;">
					<img href="plugin/#"
						src="plugin/img/u=4036572830,3153629768&fm=23&gp=0.jpg"
						style="border: 1px solid #C1E2B3; border-radius: 50%; height: 80px; width: 80px; margin: 10px;" />

				</div>
				<div id="information" style="height: 100px; text-align: center;">
					<button type="button" class="btn btn-warning btn-sm"
						style="margin-top: 32px; margin-left: 100px;">签到</button>
				</div>

				<div class="list-group">
					<button type="button" class="list-group-item"
						onclick="showWordRecord()">工作日志</button>
					<button type="button" class="list-group-item">Dapibus ac
						facilisis in</button>
					<button type="button" class="list-group-item">Morbi leo
						risus</button>
					<button type="button" class="list-group-item">Porta ac
						consectetur ac</button>
					<button type="button" class="list-group-item">Vestibulum
						at eros</button>
				</div>
			</div>

			<div class="col-md-9 column" style="background-color: #fff;display:none;"
				id="wordRecordPanel">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">显示工作日志</div>
					<div class="panel-body">
						<table id="wordRecordTable" class="table table-hover"
							data-toggle="table" data-search="true" data-pagination="true">
							<thead>
								<tr>
									<th data-field="workRecordId">workRecordId</th>
									<th data-field="workRecordDate">worRecordDate</th>
									<th data-field="leaveSignIn">leaveSignIn</th>
									<th data-field="actualSignIn">leaveSignIn</th>
								</tr>
							</thead>
						</table>
					</div>

				</div>
				<!-- Table -->
				<!--  -->

			</div>
		</div>
</body>

<script>
	function showWordRecord() {
		var $wordRecordPanel = $('#wordRecordPanel');
		//$wordRecordPanel.
		$wordRecordPanel.css("display", "inherit");
		loadWordRecord();

	}

	function loadWordRecord() {
		$
				.ajax({
					cache : true,
					type : "GET",
					datetype : "json",
					url : "/HAM/employee/loadWordrecordAll.htmls",
					success : function(data) {
						var dataJson = eval('(' + data + ')');

						if (dataJson.isDone == true) {

							$("#wordRecordTable").bootstrapTable('load',
									dataJson.list);
						}
						if (dataJson.isLogin == false) {
							alert(data.errorMsg);
						}

					}
				});
	}

	$(document).ready(function() {
	});
</script>
</html>