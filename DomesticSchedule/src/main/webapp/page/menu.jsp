<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール管理アプリ</title>
<c:url var="logout" value="/logoutAuthorize"/>
</head>
<body>
<h1>スケージュールアプリ</h1>
<a href="${logout}">ログアウト</a>
<h2><c:out value="${greeting}"/>、<c:out value="${account.username}"/>さん</h2>
<ul>
	<li><a>スケージュール共有</a></li>
	<li>お風呂出席管理</li>
</ul>
</body>
</html>