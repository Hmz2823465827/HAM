<%-- <%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="javax.security.auth.Subject"%> --%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Subject subject = SecurityUtils.getSubject();
	System.out.println(subject.hasRole("employee"));
%>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>房屋中介管理系统</title>
<link rel="stylesheet" href='<c:url value="plugin/css/diycss.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/bootstrap/css/bootstrap-theme.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/bootstrap/css/bootstrap.min.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="plugin/bootstrap/css/bootstrap-treeview.css"/>'>
<link rel="stylesheet"
	href='<c:url value="plugin/bootstrap-table/src/bootstrap-table.css"/>'>
<link rel="stylesheet"
	href='<c:url value="plugin/bootstrap/css/bootstrap-treeview.css"/>'>
<script src='<c:url value="plugin/jquery-1.11.0.js"/>'></script>
<script src='<c:url value="plugin/bootstrap/js/bootstrap.min.js"/>'></script>
<script
	src='<c:url value="plugin/bootstrap-table/src/bootstrap-table.js"/>'></script>
<script src='<c:url value="plugin/bootstrap/js/bootstrap-treeview.js"/>'></script>

</head>

<body>
	<shiro:hasPermission name="user:del">不具有user:add权限用户显示此内容</shiro:hasPermission>
	<br />
	
	<div id="all" class="container-fluid" style="background-color: #fff;">
		
		<div id="topall" class="container-fluid"
			style="background-color: #F5F5F5; border: #F1F1F1 2px solid; border-radius: 5px;">

			<div id="top" class="col-md-12 column">
				<div class="navbar-header">
					<a class="navbar-brand">HAM</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<shiro:authenticated>
						<ul class="nav navbar-nav">
							<li><a href="plugin/#">业绩排行</a></li>
							<li><a href="plugin/#">留言板</a></li>

						</ul>
					</shiro:authenticated>
					<form class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="plugin/#"
							class="dropdown-toggle">
								${loginEmployee.employeeName} <strong class="caret"></strong>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">个人信息</a></li>
								<li class="divider"></li>
								<li><a href="#">${role}</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>

		<div id="board" class="container-fluid"
			style="padding-left: 0px; padding-right: 0px; background-color: #F5F5F5; border: #F1F1F1 2px solid; border-radius: 5px; margin-top: 12px;">

			<div id="personal" class="col-md-2 column"
				style="background-color: #;">
				<div id="img1" style="height: 100px; width: 100px; float: left;">
					<img src="plugin/img/img1.jpg"
						style="border: 1px solid #C1E2B3; border-radius: 50%; height: 80px; width: 80px; margin: 10px;" />
				</div>

				<div id="information"
					style="height: 100px; width: 100px; float: left;">
					<div id="depart" class="infospan">
						<p>部门</p>
					</div>
					<div id="duties" class="infospan"></div>
					<div id="sign-in" class="infospan">
						<button type="button" class="btn btn-warning btn-sm">签到</button>
					</div>
				</div>
				<div id="functions">
				<shiro:hasRole name="employee">
					<div class="list-group roleTree" id="employeeTree"></div>
				</shiro:hasRole>
				<shiro:hasRole name="departManage">
					<div class="list-group roleTree " id="departManageTree"></div>
				</shiro:hasRole>
				<shiro:hasRole name="manager">
					<div class="list-group roleTree " id="managerTree"></div>
				</shiro:hasRole>
				<shiro:hasRole name="admin">
					<div class="list-group roleTree " id="adminTree"></div>
				</shiro:hasRole>
				</div>
			</div>
			
			<div class="col-md-10 column" style="background-color: #fff" id="Panel">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">显示工作日志</div>
					<div class="panel-body" style="display: none">
					
						<!-- style="display: table; -->
						 <div id="toolbar">
						    <button id="add" type="button" class="btn btn-default">
						        <i class="glyphicon glyphicon-plus"></i>
						    </button>					        
					         <button id="remove" type="button" class="btn btn-default">
						        <i class="glyphicon glyphicon-trash"></i>
						    </button>
						</div>
						
						<table id="table" class="table table-hover"  data-toolbar="#toolbar"
						  data-search="true" data-show-columns="true" data-show-export="true"
						  ></table>
						  
					</div>
		
				</div>
			<!-- Table -->
			<!--  -->
			</div>
		</div>
	</div>
</body>

<script>
		
		//角色为employee时的ul
		var anonyUl = {
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
			};
	
		 var employeeUl = [anonyUl, {
			text: '任务',
			href: '#parent2',
			tags: ['2'],
			nodeId:22,
			role:'employee',
			nodes: [{
				text: '查看任务',
				href: '#child7',
				tags: ['0'],
			}, {
				text: '申请完成任务',
				href: '#child8',
				tags: ['0']
			}]		
		}, {
			text: '房源信息',
			href: '#parent3',
			tags: ['0'],
			role:'employee'
		}, {
			text: '跟进记录',
			href: '#parent4',
			tags: ['0']
		}, {
			text: '钥匙信息',
			href: '#parent5',
			tags: ['0']
		},{
			text:'房屋管理',
			href:'#parent6',
			tags:['0']
		},{
			text:'权限管理',
			href:'#parent6',
			tags:['0']
		}]; 

		 var departManageUl=[anonyUl, {
			text: '任务',
			href: '#parent2',
			tags: ['2'],
			nodeId:22,
			role:'employee',
			nodes: [{
				text: '查看任务',
				href: '#child7',
				tags: ['0'],
			}, {
				text: '申请完成任务',
				href: '#child8',
				tags: ['0']
			},{
				text: '发布任务',
				href: '#child8',
				tags: ['0']
			}]		
		}, {
			text: '员工管理',
			href: '#parent3',
			tags: ['0']
		}, {
			text:'房屋管理',
			href:'#parent6',
			tags:['0']
		},{
			text:'权限管理',
			href:'#parent6',
			tags:['0']
		}]; 
 
		 var managerUl = 
				[anonyUl,
					{
						text:'部门管理',
						href:'#parent6',
						tags:['0']
					},{
						text:'权限管理',
					}];
		
		var adminUl = [{
			text:'用户管理'
		}];

		var $table = $('#table'),
	    $remove = $('#remove'),
	    $add = $('#add'),
        selections = [];
		var $panelDisplay = $('.panel-body');
		$panelDisplay.css("diplay", "none");

		function ajaxrequest(ajaxUrl,data,functions){
			
			$.ajax({
				cache: true,
				type: "GET",
				data: {id:data},
				 datetype: "json", 
				url: ajaxUrl,
				success:functions
			});			
		}

		function showPanel(tableType) {							
			var panelHeading = $(".panel-heading");
			var panelHeadingVal = panelHeading.html("show  "+tableType);			
			loadTable(tableType);
			$panelDisplay.css("display", "panel-body");
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
                field: 'state',
                checkbox: true,
                align: 'center',
            },{
				field: 'houseId',
				title: '房屋编号',
				sortable: true,
				align: 'center',
			}, {
				field: 'rentStatue',
				title: '是否出租',
				align: 'center',
			}, {
				field: 'saleStatue',
				title: '是否出售',
				align: 'center',
			}, {
				field: 'houseArea',
				title: '房屋面积',
				align: 'center',
			}, {
				field: 'clientName',
				title: '房主姓名',
				align: 'center',
			}, {
				field: 'clientPhone',
				title: '房主联系方式',
				align: 'center',
			},{
                field: 'operate',
                title: '操作',
                align: 'center',
                events: operateEvents,
                formatter: operateFormatter
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
			filedlist['workrecords'] = workRecordColumns;
			filedlist['houses'] = houseColumns;
			filedlist['tasks'] = task;
			filedlist['keycontrolls'] = keycontroller;

			 $remove.click(function () {
	            var ids = getIdSelections();
	            alert(ids);
	            $table.bootstrapTable('remove', {
	                field: 'id',
	                values: ids
	            });
	            /* $remove.prop('disabled', true); */
		     });

			return filedlist[tableType];
		}


		function getIdSelections() {
	        return $.map($table.bootstrapTable('getSelections'), function (row) {
	            return row.id
	        });
		}

		function operateFormatter(value, row, index) {
	        return [
	            '<a class="like" href="javascript:void(0)" title="Like">',
	            '<i class="glyphicon glyphicon-heart"></i>',
	            '</a>  ',
	            '<a class="remove" href="javascript:void(0)" title="Remove">',
	            '<i class="glyphicon glyphicon-remove"></i>',
	            '</a>'
	        ].join('');
	    }
	    
	    window.operateEvents = {
	        'click .like': function (e, value, row, index) {
	            alert('You click like action, row: ' + JSON.stringify(row));
	        },
	        'click .remove': function (e, value, row, index) {
		        var ajaxUrl = "/HAM/house/del.htmls";
		        var data = row.houseId;
	        	ajaxrequest(ajaxUrl,data,functions);
	        	function functions(data){
			        alert(row.houseId+"号房删除成功！");
			        $table.bootstrapTable('remove', {
		                field: 'houseId',
		                values: [row.houseId]
		            });
				}
	        }
	    };

		$(function() {	
			 setTimeout(function () {
		     	$table.bootstrapTable('resetView');
		     }, 200);
							
			$('#employeeTree').treeview({
				data:employeeUl
			});	
					
			$('#managerTree').treeview({
				data:managerUl
			});

			
 			function setTableType(data){
				switch(data.text){
					case "工作日志":
						return "workrecords";
						break;
					case "查看任务":
						return "tasks";
						break;
					case "房源信息":
						return "houses";
						break;
					case "钥匙信息":
						return "keycontrolls";
						break;
				}
			} 

			$('#employeeTree').on('nodeSelected',function(event, data) {
				var tableType = setTableType(data);
			    showPanel(tableType);
			});

			function setEmployeePosition(data){
				switch(data){
					case 0:
						return "试用人员";
						break;
					case 1:
						return "正式员工";
						break;
					case 2:
						return "经理";
						break;
					case 3:
						return "总经理";
						break;
				}			
			}
			
		/* 	${'#functiontree'}.treeview('checkAll', { silent: true }); */
		/* var node = $('#tree').treeview('checkNode', [ 22, { silent: true } ]);
		node.getAttribute("role"); */
		/* addRoleToLi(); */
		/* node. */
			/* $('#functiontree').treeview('checkAll', { silent: true }); */
			/* var functionTree = $('#functiontree').treeview('checkNode', [ '1', { state.role: 'employee' } ]); */
		
		document.getElementById("duties").innerHTML = setEmployeePosition(${loginEmployee.employeePosition});	
		
 		});
		</script>
</html>