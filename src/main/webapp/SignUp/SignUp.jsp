<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
	div{
		
		line-height: 30px;
	}
	botton:hover {
		transition: 0.7s;
		background-color:#002ead;
	}
	#button{
		border: 1px solid green;
		background-color: rgba(0,0,0,0);
		color: green;
		padding: 3px;
		margin-left: 15px;
	}
	#button:hover {
		background-color: rgba(0,200,0,0.5);
		box-shadow: 0px 0px 0.5px 0.5px rgb(0,0,0);
	}
	#button:active {
      transform: scale(0.98);
      box-shadow: 3px 2px 22px 1px rgba(0, 0, 0, 0.24);
    }
     input[type="text"], input[type="password"] {
      padding: 5px;
      margin: 5px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      
   }
</style>
</head>
<body>
	<h2>Sign Up</h2>
	<h1 align="center" style="background-color: #ADFF2F;">기본 정보 입력</h1> <br><br>
	<div style="float: left; text-align: right;width: 40%; margin-right: 20px;line-height: 36px ">
		이메일 <br>
		비밀번호 <br>
		비밀번호 확인 <br>
		이름 <br>
		생년월일 <br>
		전화번호
	</div>
	<div style="float: left; text-align: left; margin-left: 5px; width: 40%">
		<form action="../SignUp/SignUpController.do">
			<input type="text" name="email" size="10"/> @ <input type="text" name="email" size="15" required />
			<input type="submit" value="중복확인" id="button" required /> <br>
			<input type="password" name="password" required /> <br>
			<input type="password" name="password" required /> <br>
			<input type="text" name="name" size="10" required /> <br>
			<input type="date" name="birth" required /> <br>
			<input type="text" name="phone" class="tel" maxlength="13" placeholder="숫자만 입력하세요.(-제외)" required />
			<input type="submit" value="인증하기" id="button" /> <br><br><br>
			<input type="button" value="NEXT" id="button" onclick="location='SignUp2.jsp'"/>
		</form>
	</div>
</body>
</html>







