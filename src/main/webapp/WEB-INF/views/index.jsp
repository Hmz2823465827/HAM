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
<%-- <script src='<c:url value="plugin/js/jquery-2.1.0.js"/>'
	type="text/javascript" charset="utf-8"></script>
<script src='<c:url value="plugin/js/bootstrap.js"/>'
	type="text/javascript" charset="utf-8"></script>
<script
	src='<c:url value="plugin/js/bootstrap-table/bootstrap-table.js"/>'
	type="text/javascript" charset="utf-8"></script>
<script src='<c:url value="plugin/js/bootstrap-treeview.js"/>'
	type="text/javascript" charset="utf-8"></script>
 --%>
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/bootstrap-theme.css"/>' charset="utf-8"/>
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/bootstrap.min.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/bootstrap-treeview.css"/>' />
<link rel="stylesheet" href='<c:url value="plugin/bootstrap/css/bootstrap.min.css"/>'>
		<link rel="stylesheet" href='<c:url value="plugin/bootstrap-table/src/bootstrap-table.css"/>'>
		<script src='<c:url value="plugin/jquery-1.11.0.js"/>'></script>
		<script src='<c:url value="plugin/bootstrap/js/bootstrap.min.js"/>'></script>
		<script src='<c:url value="plugin/bootstrap-table/src/bootstrap-table.js"/>'></script>

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
					<img 
						src="plugin/img/img1.jpg"
						style="border: 1px solid #C1E2B3; border-radius: 50%; height: 80px; width: 80px; margin: 10px;" />

				</div>
				<div id="information" style="height: 100px; text-align: center;">
					<button type="button" class="btn btn-warning btn-sm"
						style="margin-top: 32px; margin-left: 100px;">签到</button>
				</div>

				<div class="list-group">
					<button type="button" class="list-group-item"
						onclick="showPanel('workRecord')">显示工作日志</button>
					<button type="button" class="list-group-item"
						onclick="showPanel('house')">房源信息</button>
					<button type="button" class="list-group-item">Morbi leo
						risus</button>
					<button type="button" class="list-group-item">Porta ac
						consectetur ac</button>
					<button type="button" class="list-group-item">Vestibulum
						at eros</button>
				</div>
			</div>

			<div class="col-md-9 column" style="background-color: #fff"
				id="Panel">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">显示工作日志</div>
					<div class="panel-body">
					<!-- style="display: table; -->
						<table id="table" class="table table-hover " 
							data-show-columns="true" data-search="true" 
							data-pagination="true"></table>
					</div>

				</div>
				<!-- Table -->
				<!--  -->

			</div>

			<!--			<div class="col-md-9 column" style="background-color: #fff;display: none;"
				id="housePanel">
				<div class="panel panel-default">
					
					<div class="panel-heading">显示工作日志</div>
					<div class="panel-body">
						<table id="houseTable" class="table table-hover"
							data-toggle="table" data-search="true" data-pagination="true" >
							<thead>
								<tr>
									<th data-field="houseId">房屋编号</th>
									<th data-field="rentStatue">是否出租</th>
									<th data-field="saleStatue">是否出售</th>
									<th data-field="houseArea">房屋面积</th>
									<th data-field="clientName">房主姓名</th>
									<th data-field="clientPhone">房主联系方式</th>
								</tr>
							</thead>
						</table>
					</div>

				</div>-->
			<!-- Table -->
			<!--  -->

		</div>

	</div>
</body>

<script>

		function showPanel(tableType) {
			var $table = $('#table');
 			var $panelDisplay = $('.table');
 			var display = $table.css("display");
			$panelDisplay.css("diplay", "none");  
			loadTable(tableType);
 			$table.css("display", "table");
		}

		function loadTable(tableType) {
			var ajaxUrl = "/HAM/employee/load" + tableType + "All.htmls";
			$.ajax({
				cache: true,
				type: "GET",
				datetype: "json",
				url: ajaxUrl,
				success: function(data) {
					var dataJson = eval('(' + data + ')');
					if(dataJson.isDone == true) {
						var $table = $('#table');
						var columns = initTable(tableType, $table);
						$table.bootstrapTable('destroy').bootstrapTable({
							columns: columns,
							data: dataJson.list
						});
					}
					if(dataJson.isLogin == false) {
						alert(data.errorMsg);
					}

				}
			});

		}

		function initTable(tableType, $table) {
			var filedlist = new Object();
			var houseColumns = [{
				field: 'houseId',
				title: '房屋编号',
				sortable: true
			}, {
				field: 'rentStatue',
				title: '是否出租',
			}, {
				field: 'saleStatue',
				title: '是否出售',
			}, {
				field: 'houseArea',
				title: '房屋面积',
			}, {
				field: 'clientName',
				title: '房主姓名',
			}, {
				field: 'clientPhone',
				title: '房主联系方式',
			}];
			var workRecordColumns = [{
				field: 'workRecordId',
				title: '考勤编号',
				sortable: true
			}, {
				field: 'workRecordDate',
				title: '考勤日期',
			}, {
				field: 'actualSignIn',
				title: '上班打卡时间',
			}, {
				field: 'leaveSignIn',
				title: '下班打卡时间',
			}];

			filedlist['workRecord'] = workRecordColumns;
			filedlist["house"] = houseColumns;
			return filedlist[tableType];
		}



		$(function() {});
	</script>


</html>