<%@page import="kr.or.bit.utils.Singleton_Helper" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/Top.jsp"></jsp:include>

<jsp:include page="/common/Left.jsp"></jsp:include>

<%
	/*
	 1.관리자만 접근 가능한 페이지
	 2.로그인한 일반 회원이 주소값을 외워서 ... 접근불가
	 3.그러면  회원에 관련되 모든 페이지 상단에는 아래 코드를 ..... : sessionCheck.jsp >> include
	*/
	/* if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin") ){
		//강제로 페이지 이동
		//out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
		response.sendRedirect("Ex02_JDBC_Login.jsp");
	} */
%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/assets/css/member.css">
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">

	</style>
</head>
<body>
<div class="textbox">
	<div class=”table-responsive“>
		<table class="type09">
			<tr>
				<td>
					<table>
						<thead>
						<h2>회원리스트</h2>
						<tr>
							<th scope="cols">id</th>
							<th scope="cols">ip</th>
							<th scope="cols">삭제</th>
							<th scope="cols">수정</th>
						</tr>
						</thead>
						<c:set var="memberlist" value="${requestScope.memberlist}"/>
						<c:forEach var="member" items="${memberlist}">
							<tr>
								<td>
									<a href="detailMemberViewById.do?id=${member.id}">${member.id}</a>
								</td>
								<td>${member.ip}</td>
								<td>
									<a href="deleteMember.do?id=${member.id}">[삭제]</a>
								</td>
								<td>
									<a href="editMember.do?id=${member.id}">[수정]</a>
								</td>
							</tr>
						</c:forEach>
					</table>

					<br>
					<form action="searchMember.do" method="post">
						<input type="text" name="search" placeholder="회원명">
						<input type="submit" class="btn btn-info btn-fill pull-right" value="검색하기">
					</form>


					<tr>
					<td>
						<jsp:include page="/common/Bottom.jsp"></jsp:include>
					</td>
					</tr>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>