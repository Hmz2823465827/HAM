<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>错误跳转页面</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/bootstrapValidator.min.js"></script>
		<link href="css/bootstrapValidator.min.css" rel="stylesheet" />
		<style>
			#head{
				margin-top: 50px;
				border-bottom: 2px solid darkgray;
			}
		</style>
	</head>

	<body>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column" id="head">
					<h1 class="text-center">
						404 无法打开此页面
					</h1>
				</div>
			</div>
			<br /><br />
			<div class="row clearfix">
				<div class="col-md-3 column">
					
				</div>
				<div class="col-md-4 column">
					<h2>可能原因：</h2>
					<p>1.网络信号差</p>
					<p>2.找不到请求的页面</p>
					<p>3.输入的网址错误</p>
				</div>
				<div class="col-md-4 column">
					<h2>即将跳转：</h2>
					<b> 跳转至登入界面   </b>
					<span id="S" style="color: red;font-size: 20px;"></span>
				</div>
			</div>
		</div>
	
	</body>
	<script type="text/javascript">
		var time=8;//时间，秒
		function Redirect(){
			window.location='login.html';
		}
		var i=0;
		function dis(){
			document.all.S.innerHTML="还剩"+(time-i)+"秒";
			i++;
		}
		timer=setInterval('dis()',1000);//显示时间
		timer=setTimeout('Redirect()',time*1000);//跳转		
	</script>

</html>