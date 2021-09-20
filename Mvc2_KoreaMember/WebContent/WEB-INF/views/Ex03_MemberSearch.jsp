<%@page import="kr.or.bit.utils.Singleton_Helper" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/Top.jsp"></jsp:include>
<jsp:include page="/common/Left.jsp"></jsp:include>
<%--<%
	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin") ){
		//강제로 페이지 이동
		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	}
    
	request.setCharacterEncoding("UTF-8");

%>    --%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/assets/css/member.css">
	<meta charset="UTF-8">
	<title>회원조회</title>

</head>
<body>
<c:set var="member" value="${requestScope.member}"></c:set>

<table class="type10" id="non-style1">
	<thead>
	<th><h3><b>회원리스트</b></h3></th>
	</thead>
	<td>
		<table class="type11">
			<tr>
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
			</tr>
			<tr id="non-style">
				<td>
					<a href="detailMemberView.do"><input type="button" class="btn btn-info btn-fill pull-right" value="회원 목록 페이지"></a>

				</td>
			</tr>
		</table>
	</td>
	<jsp:include page="/common/Bottom.jsp"></jsp:include>
</table>
</body>
</html>