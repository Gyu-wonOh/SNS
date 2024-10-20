<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instagram Home</title>
<style>
	a img{
		width :280px;
		height : 100px;
	}
	#head{
		border:1px;
		height:150px;
	}
	#title{
		font-size:18pt;
	}
	#row{
		display:flex;
		padding:20px 40px 40px 0px;
	}
	#side{
		margin:50px;
	}
	#main{
		border:1px solid lightgray;
		border-radius:5px;
		width:500px;
		text-align : center;
		
		padding:10px;
	}
	.form{
		border-top: 1px solid lightgray;
		border-bottom: 1px solid lightgray;
	
	}
	#login{
		border : 0px;
		border-radius:5px;
		position:relative;
		background-color:lightblue;
		color:white;
		width:200px;
		height: 50px;
		margin:10px 0px 5px 0px;
	}
	#join{
	border : 0px;
		border-radius:5px;
		position:relative;
		background-color:lightgreen;
		color:white;
		width:200px;
		height: 50px;
		margin:5px 0px 10px 0px;
		}
	input{
		width:200px;
		height:20px;
		margin:10px;
	}
	#footer{
		position:fixed;
		bottom: 0; /* 화면 하단에 위치하도록 설정 */
    	left: 50%; /* 왼쪽에서 50% 이동 */
    	transform: translateX(-50%); /* 왼쪽에서 50% 이동한 위치에서 다시 왼쪽으로 절반 만큼 이동 */
    	text-align: center; /* 텍스트 가운데 정렬 */
    	width: 100%; /* 전체 너비 */
	}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	/* var result ='${msg}'
	if(result=='success'){
		alert("성공적으로 처리되었습니다.")
	}else if(result=='fail'){
		alert("please check again your ID or PW");
	} */
	$(document).ready(function(){
		var result ='${msg}'
			if(result=='success'){
				alert("성공적으로 처리되었습니다.");
				cosole.log(result);
			}else if(result=='fail'){
				alert("please check again your ID or PW");
				console.log(result);
			}
		var formObj = $(".form"); // select the form
		$("#login").on("click",function(){
			formObj.attr("action","/ex/main/login");
			formObj.attr("method","post");
			formObj.submit();
		});
		$("#nickname").on("focus",function(){
			$("this").val("");
		})
		$("#password").on("focus",function(){
			$("this").val("");
		})
	});
</script>
</head>
<body>
	<div id = "head">
		<a href="/ex/main/home"><img src='/ex/resources/img/instagram_logo.PNG'></a>
	</div>
	<hr>
	<div id = "row">
		<div id = "side"><img src='/ex/resources/img/social.jpg'></div>
		<div id = "main">
			<br><br><br>
			Enjoy our contents <br>after login with your account!<br><br>
			<form class="form" method="post">
				nickname <input type="text" name="nickname" placeholder='insert your nickname'><br>
				password <input type="password" name="password" placeholder='insert your password'>
			</form>
			<button type="button" id="login">log-in</button><br>
			<a href="/ex/main/join"><button id="join">join</button></a>
			<br><br>
			<div id= "add-function">forget your <a href="/ex/user/findAccount">account</a>/<a href="/ex/user/findPassword">password</a>?</div>
		</div>
	</div>
	<hr/>
	<div id="footer">
		made by Gyu-won,Oh
	</div>
</body>
</html>