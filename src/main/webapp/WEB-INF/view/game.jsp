<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Game</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
<div class="grid">
    <div class="space" id="0" onclick="set(0)">
        <span class="figure"></span>
    </div>
    <div class="space" id="1" onclick="set(1)">
        <span class="figure"></span>
    </div>
    <div class="space" id="2" onclick="set(2)">
        <span class="figure"></span>
    </div>
    <div class="space" id="3" onclick="set(3)">
        <span class="figure"></span>
    </div>
    <div class="space" id="4" onclick="set(4)">
        <span class="figure"></span>
    </div>
    <div class="space" id="5" onclick="set(5)">
        <span class="figure"></span>
    </div>
    <div class="space" id="6" onclick="set(6)">
        <span class="figure"></span>
    </div>
    <div class="space" id="7" onclick="set(7)">
        <span class="figure"></span>
    </div>
    <div class="space" id="8" onclick="set(8)">
        <span class="figure"></span>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/core.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js"/>"></script>
</body>
</html>