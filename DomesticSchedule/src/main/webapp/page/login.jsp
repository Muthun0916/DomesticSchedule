<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="../css/login.css" %></style>
<script type="text/javascript" src="../js/jquery-3.7.1.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>スケージュールアプリ</title>
</head>
<body>
<div id="header">
<h1>Schedule Management</h1>
</div>
<div id="content">
<font color="red"><c:out value="${loginMsg}"/></font>
<form id="myForm" class="center" method="post">
	<table>
		<tr>
			<th>アカウントID</th>
			<td><input type="text" name="account_id">
			</td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td><input type="password" name="account_password"></td>
		</tr>
	</table>
	<button  id="loginButton">ログイン</button>
	<button  id="createButton">新規作成</button>
</form>
</div>
</body>
</html>