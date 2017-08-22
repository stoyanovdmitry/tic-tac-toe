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
    <div class="space" id="0" onclick="step(0)">
        <span class="figure"></span>
    </div>
    <div class="space" id="1" onclick="step(1)">
        <span class="figure"></span>
    </div>
    <div class="space" id="2" onclick="step(2)">
        <span class="figure"></span>
    </div>
    <div class="space" id="3" onclick="step(3)">
        <span class="figure"></span>
    </div>
    <div class="space" id="4" onclick="step(4)">
        <span class="figure"></span>
    </div>
    <div class="space" id="5" onclick="step(5)">
        <span class="figure"></span>
    </div>
    <div class="space" id="6" onclick="step(6)">
        <span class="figure"></span>
    </div>
    <div class="space" id="7" onclick="step(7)">
        <span class="figure"></span>
    </div>
    <div class="space" id="8" onclick="step(8)">
        <span class="figure"></span>
    </div>
</div>
<span id="playerID"></span>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/core.js"/>"></script>
</body>
</html>