<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイントップ</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<main>
	<!--エラー時の表示処理-->
		<c:if test="${not empty login.errorMsg}">
			<p style="color:red;"><c:out value="${login.errorMsg}" /></p>
		</c:if>
		<div class="rogin-buttons">
			</form>
			<form action="LoginServlet" method="post" name="next" value="login">
			 <input type="hidden" name="next" value="login" >
				ログインネーム<br>
				<input class="text-box" type="text" name="name" value="" required><br>
				パスワード<br>
				<input class="text-box" type="password" name="password" value="" required><br>
				<input type="submit" value="ログイン" class="menu-btn">
			</form>
</div>
</body>
</html>