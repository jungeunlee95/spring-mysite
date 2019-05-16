<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/assets/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"> </c:import>
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile"
						src="data:image/jpeg;base64,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">
					<h2>안녕하세요. 고양이의 mysite에 오신 것을 환영합니다.</h2>
					<p>
						이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.<br> 메뉴는 사이트 소개, 방명록, 게시판이 있구요.
						Python 수업 + 데이터베이스 수업 + 웹프로그래밍 수업 배운 거 있는거 없는 거 다 합쳐서 만들어 놓은 사이트
						입니다.<br>
						<br> <a href="${pageContext.servletContext.contextPath}/guestbook">방명록</a>에 글 남기기<br>
					</p>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"> 
			<c:param name="menu" value="main" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"> </c:import>
	</div>
</body>
</html>