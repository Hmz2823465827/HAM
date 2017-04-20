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
	<script src='<c:url value="plugin/js/bootstrap-table/bootstrap-table.js"/>'
	type="text/javascript" charset="utf-8"></script>
<script src='<c:url value="plugin/js/bootstrap-treeview.js"/>'
	type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/bootstrap-theme.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/bootstrap.min.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/bootstrap-treeview.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/css/main.css"/>' />

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
						onclick="loadWordRecord()">工作日志</button>
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

			<div class="col-md-9 column" style="background-color: #fff;">

				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">Panel heading</div>
					<!-- <div class="panel-body">
						<p>...</p> -->
				</div>
				<!-- Table -->
				<table class="table tabletable-hover" id="wordRecordTable"
					data-pagination="true" data-show-refresh="true"
					data-show-toggle="true" data-showColumns="true">
					<thead>
						<tr>
							<th data-field="workRecordId">workRecordId</th>
							<th data-field="workRecordDate">workRecordDate</th>
							<th data-field="actualSignIn">actualSignIn</th>
							<th data-field="leaveSignIn">leaveSignIn</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>

	</div>

	</div>
</body>

<script>
	function loadWordRecord() {
		/* 	$.ajax({
				cache : true,
				type : "POST",
				datetype : "json",
				url : "/HAM/employee/loadWordrecord.htmls",
				success : function(data) {
					var dataJson = data.parseJSON();
					if (dataJson.isLogin == true) {
						alter(dataJson.list);
					}
					if (dataJson.isLogin == false) {
						alert(data.errorMsg);
					}

				}
			}); */
		$("#wordRecordTable").bootstrapTable({
			method : "post", //使用get请求到服务器获取数据  
			url : "/HAM/employee/loadWordrecord.htmls", //获取数据的Servlet地址  
			striped : true, //表格显示条纹  
			pagination : true, //启动分页  
			pageSize : 10, //每页显示的记录数  
			pageNumber : 0, //当前第几页  
			pageList : [ 5, 10, 15, 20, 25 ], //记录数可选列表  
			search : false, //是否启用查询  
			showColumns : true, //显示下拉框勾选要显示的列  
			showRefresh : true, //显示刷新按钮  
			sidePagination : "server", //表示服务端请求  
			//设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
			//设置为limit可以获取limit, offset, search, sort, order  
			queryParamsType : "undefined",
			/*queryParams : function queryParams(params) { //设置查询参数  
				var param = {
					pageNumber : params.pageNumber,
					pageSize : params.pageSize,
					orderNum : $("#orderNum").val()
				};
				return param;
			} ,  
				            onLoadSuccess: function(){  //加载成功时执行  
				              layer.msg("加载成功");  
				            },  
				            onLoadError: function(){  //加载失败时执行  
				              layer.msg("加载数据失败", {time : 1500, icon : 2});  
				            }   */
		});
		/* } */
	}
	/* function getTree() {
		var tree = [ {
			text : "信息大厅",
			icon : "glyphicon glyphicon-home",
			selectedIcon : "glyphicon glyphicon-home",
			color : "#000000",
			backColor : "#FFFFFF",
			href : "#node-1",
			state : {
				checked : true,
				expanded : true,
				selected : true
			},
			tags : [ 'available' ],
			nodes : [ {
				text : "child 1",
				nodes : [ {
					text : "Grandchild 1"
				}, {
					text : "Grandchild 2"
				} ]
			}, {
				text : "child 2"
			} ]
		}, {
			text : "parent 2",
			nodes : [ {
				text : "child 1",
				nodes : [ {
					text : "Grandchild 1"
				}, {
					text : "Grandchild 2"
				} ]
			}, {
				text : "child 2"
			} ]
		}, {
			text : "parent 3",
			nodes : [ {
				text : "child 1",
				nodes : [ {
					text : "Grandchild 1"
				}, {
					text : "Grandchild 2"
				} ]
			}, {
				text : "child 2"
			} ]
		}, ];
		return tree;
	} */
	/* 	$('#tree').treeview({
	 data : getTree()
	 }); */
	$(document).ready(function() {
		//调用函数，初始化表格  
		loadWordRecord();

/* 		//当点击查询按钮的时候执行  
		$("#search").bind("click", initTable); */
	});
</script>
</html>