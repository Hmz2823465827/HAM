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
 
 		<link rel="stylesheet" href='<c:url value="plugin/css/diycss.css"/>'>
		<link rel="stylesheet" type="text/css"
			href='<c:url value="plugin/bootstrap/css/bootstrap-theme.css"/>'>
		<link rel="stylesheet" type="text/css"
			href='<c:url value="plugin/bootstrap/css/bootstrap.min.css"/>'>
		<link rel="stylesheet" type="text/css"
			href='<c:url value="plugin/bootstrap/css/bootstrap-treeview.css"/>'>
		<link rel="stylesheet" href='<c:url value="plugin/bootstrap-table/src/bootstrap-table.css"/>'>
		<link rel="stylesheet" href='<c:url value="plugin/bootstrap/css/bootstrap-treeview.css"/>'>
		<script src='<c:url value="plugin/jquery-1.11.0.js"/>'></script>
		<script src='<c:url value="plugin/bootstrap/js/bootstrap.min.js"/>'></script>
		<script src='<c:url value="plugin/bootstrap-table/src/bootstrap-table.js"/>'></script>
		<script src='<c:url value="plugin/bootstrap/js/bootstrap-treeview.js"/>'></script>

</head>

	<body>
		<div id="all" class="container-fluid" style="background-color: #fff;">
			<div id="topall" class="container-fluid" style="background-color: #F5F5F5; border: #F1F1F1 2px solid; border-radius: 5px;">

				<div id="top" class="col-md-12 column">
					<div class="navbar-header">
						<a class="navbar-brand">HAM</a>
					</div>
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li>
								<a href="plugin/#">业绩排行</a>
							</li>
							<li>
								<a href="plugin/#">留言板</a>
							</li>

						</ul>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" class="form-control" />
							</div>
							<button type="submit" class="btn btn-default">搜索</button>
						</form>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown">
								<a href="plugin/#" class="dropdown-toggle" data-toggle="dropdown">用户名
								<strong class="caret"></strong>
								</a>
								<ul class="dropdown-menu">
								<li>
									 <a href="#">个人信息</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">登出</a>
								</li>
							</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<div id="board" class="container-fluid" style="padding-left: 0px; padding-right: 0px;
			 background-color: #F5F5F5; border: #F1F1F1 2px solid; border-radius: 5px; margin-top: 12px;">
			 
				<div id="personal" class="col-md-3 column" style="background-color: #;">
					<div id="img1" style="height: 100px; width: 100px; float: left;">
						<img src="plugin/img/img1.jpg" style="border: 1px solid #C1E2B3; border-radius: 50%;
						 height: 80px; width: 80px; margin: 10px;" />
					</div>				
					
 					<div id="information" style="height: 100px; width:100px; float:left;">
 						<div id="job" class = "infospan">
 							<p>职务</p>
 						</div>
 						<div id="grade" class = "infospan" >
 							<p>等级</p>
 						</div>
 						<div id="sign-in" class = "infospan">
 							<button type="button" class="btn btn-warning btn-sm">签到</button>
 						</div>
					</div> 

					<div class="list-group" id = "functions">
						<div id="functiontree" class=""></div>
					<button type="button" class="list-group-item" onclick="showPanel('workrecord')">显示工作日志</button>
						<button type="button" class="list-group-item" onclick="showPanel('house')">房源信息</button>
						<button type="button" class="list-group-item" onclick="showPanel('keycontroller')">钥匙信息</button>
						<button type="button" class="list-group-item" onclick="showPanel('followup')">跟进记录</button>
						<button type="button" class="list-group-item" onclick="showPanel('task')">任务</button> 
					</div>
				</div>

				<div class="col-md-9 column" style="background-color: #fff" id="Panel">
					<div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">显示工作日志</div>
						<div class="panel-body">
							<!-- style="display: table; -->
							<table id="table" class="table table-hover " data-show-columns="true" data-search="true" data-pagination="true"></table>
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
			var panelHeading = $(".panel-heading");
			var panelHeadingVal = panelHeading.html("show   "+tableType);
			$panelDisplay.css("diplay", "none");
			loadTable(tableType);
			$table.css("display", "table");
		}

		function loadTable(tableType) {
			var ajaxUrl = "/HAM/employee/loadSetbyParam.htmls";
			$.ajax({
				cache: true,
				type: "GET",
				data: {setName:tableType},
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

			var task = [{
				field: 'taskId',
				title: '任务编号',
				sortable: true
			}, {
				field: 'planDo',
				title: '计划完成时间',
			}, {
				field: 'publishDate',
				title: '发布时间',
			}, {
				field: 'taskLevel;',
				title: '任务优先级',
			}, {
				field: 'taskInfo',
				title: '任务详情',
			}, {
				field: 'taskStatue',
				title: '任务状态',
			}];

			var keycontroller = [{
				field: 'keyControllId',
				title: '钥匙接管记录编号',
				sortable: true
			}, {
				field: 'isApprove',
				title: '是否批准',
			}, {
				field: 'approveDate',
				title: '接管时间',
			}, {
				field: 'planReturnDate;',
				title: '计划归还时间',
			}, {
				field: 'actualReturnDate',
				title: '实际归还时间',
			}];
			filedlist['workRecord'] = workRecordColumns;
			filedlist['house'] = houseColumns;
			filedlist['task'] = task;
			filedlist['keycontroller'] = keycontroller;

			return filedlist[tableType];
		}

		$(function() {});

		$(function() {
			var defaultData = [{
				text: '通用',
				href: '#parent1',
				tags: ['6'],
				nodes: [{
					text: '通讯录',
					href: '#child1',
					tags: ['0'],
				}, {
					text: '黑名单',
					href: '#child2',
					tags: ['0']
				}, {
					text: '工作日志',
					href: '#child3',
					tags: ['0']
				}, {
					text: '新闻',
					href: '#child4',
					tags: ['0']
				}, {
					text: '考勤统计',
					href: '#child5',
					tags: ['0']
				}, {
					text: '同比环比',
					href: '#child6',
					tags: ['0']
				}]
			}, {
				text: '业务员',
				href: '#parent2',
				tags: ['4'],
				nodes: [{
					text: '房源信息',
					href: '#child7',
					tags: ['0'],
				}, {
					text: '任务',
					href: '#child8',
					tags: ['0']
				}, {
					text: '跟进记录',
					href: '#child9',
					tags: ['0']
				}, {
					text: '钥匙信息',
					href: '#child10',
					tags: ['0']
				}]		
			}, {
				text: '部门经理',
				href: '#parent3',
				tags: ['0']
			}, {
				text: '总经理',
				href: '#parent4',
				tags: ['0']
			}, {
				text: '钥匙管理员',
				href: '#parent5',
				tags: ['0']
			}];
		
			$('#functiontree').treeview({
				data: defaultData
			});
		});
	</script>


</html>