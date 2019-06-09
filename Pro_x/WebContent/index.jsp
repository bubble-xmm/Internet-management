<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK"></meta>

		<title>登陆首页</title>
		 <link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css"></link>
		 <link rel="stylesheet" type="text/css" href="./Wopop_files/style.css"></link>
		 <link rel="stylesheet" type="text/css" href="./Wopop_files/userpanel.css"></link>
		 <link rel="stylesheet" type="text/css" href="./Wopop_files/jquery.ui.all.css"></link>
	</head>

	<body class="login" mycollectionplug="bind">
	<form action="${path }/ulogin.html">
		<div class="login_m">
			<div class="login_logo" width="350" height="210"></div>
			<div class="login_boder" style="margin-top: 250px;">
				<div class="login_padding" id="login_model">

					<h2>USERNAME</h2>
					<label>
						<input type="text" id="username" class="txt_input txt_input2" onfocus="if (value ==&#39;Account number&#39;){value =&#39;&#39;}"
						 onblur="if (value ==&#39;&#39;){value=&#39;Account number&#39;}" value="Account number" name="login" ></input>
					</label>
					<h2>PASSWORD</h2>
					<label>
						<input type="password" name="pw" id="userpwd" class="txt_input" onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}"
						 onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}" value="******" ></input>
					</label>

					<p class="forgot"><a id="iforget" href="${path }/404.jsp">Forgot your password or Register new users?</a></p>
					<div class="rem_sub">
						<div class="rem_sub_l">
							<input type="checkbox" name="checkbox" id="save_me"></input>
							<label for="checkbox">Remember me</label>
						</div>
						<label>
							<input type="submit" class="sub_button" name="button" id="button" value="SIGN-IN" style="opacity: 0.7;" ></input>
						</label>
					</div>
				</div>
			</div>
			<!--login_boder end-->
		</div>
		<!--login_m end-->
		<br /><br /><br /><br />
		<p align="center">${msg } </p>
		</form>
	</body>
</html>
