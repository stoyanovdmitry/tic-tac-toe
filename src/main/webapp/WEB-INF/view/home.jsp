<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
<div class="buttons">
    <a href="<c:url value="/start"/>" class="button start-button">Start Game</a>
    <a href="<c:url value="/find"/>" class="button find-button">Find Game</a>
    <c:if test="${requestScope.containsValue('gameNotFound')}">
        <span class="error">Can't find empty game. Please try again or start new game</span>
    </c:if>
</div>
</body>
</html>