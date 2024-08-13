<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケージュールアプリ</title>
<c:url var="regist" value="/page/regist.jsp"/>
<c:url var="login" value="/loginAuthorize"/>
</head>
<body>
<font color="red"><c:out value="${message}"/></font>
<form action="${login}" method="post">
	<p>アカウントID:</p>
	<input type="text" name="account_id">
	<p>パスワード</p>
	<input type="password" name="account_password">
	<button>確定</button>
</form>
<a href="${regist}">新規登録</a>
</body>
</html>