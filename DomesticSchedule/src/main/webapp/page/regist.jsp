<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録</title>
<c:url var="regist" value="/registAccount"/>
</head>
<body>
<h1>アカウント登録</h1>
<font color="red"><c:out value="${message}"/></font>
<form action="${regist}" method="post">
<p>ユーザー名<input type="text" name="username"></p>
<p>ユーザーID<input type="text" name="user_id"></p>
<p>パスワード<input type="password" name="password1"></p>
<p>確認用パスワード<input type="password" name="password2"></p>
<button>登録</button>
</form>
</body>
</html>