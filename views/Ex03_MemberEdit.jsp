<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page import="kr.or.bit.utils.Singleton_Helper" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/Top.jsp"></jsp:include>
<jsp:include page="/common/Left.jsp"></jsp:include>
<%--<%--%>
<%--	/* --%>
<%--	회원정보 수정하기--%>
<%--	1.DB 쿼리 : 2개 (수정정보 : select , 수정정보반영 : update)--%>
<%--	 1.1 : select * from koreamember where id=?--%>
<%--	 1.2 : update koreamember set ename=? where id=?		 --%>
<%--	2.화면 1개(기존에 입력내용 보여주는 것)-> 처리 1개 (수정처리)--%>
<%--	 2.1  DB select 한 결과 화면 출력 --%>
<%--	   <input type="text" value="rs.getString(id)">--%>
<%--	      수정안하고 .. 화면 .. 전송(x) : <td>rs.getString("id")</td>--%>
<%--	      수정안하고 .. 화면 .. 전송   : <input type="text" value="rs.getString(id)" name="id" readonly>--%>
<%--	      수정하고 ..화면  ..전송   :  <input type="text" value="rs.getString(id)"  name="id">--%>
<%--	--%>
<%--	*/--%>
<%--	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin") ){--%>
<%--		//강제로 페이지 이동--%>
<%--		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");--%>
<%--	}--%>
<%--	--%>
<%--    request.setCharacterEncoding("UTF-8");--%>
<%--	String id = request.getParameter("id");--%>
<%--	--%>
<%--	--%>
<%--	--%>
<%--	Connection conn = null;--%>
<%--	PreparedStatement pstmt = null;--%>
<%--	ResultSet rs = null;--%>
<%--	try{--%>
<%--		conn = Singleton_Helper.getConnection("oracle");--%>
<%--		String sql="select id,pwd,name,age,trim(gender),email from koreamember where id=?";--%>
<%--		pstmt = conn.prepareStatement(sql);--%>
<%--		--%>
<%--		pstmt.setString(1,id);--%>
<%--		--%>
<%--		rs = pstmt.executeQuery(); --%>
<%--		--%>
<%--		//while(rs.next())--%>
<%--		rs.next(); //1건 데이터가 있다면 전제조건--%>
<%--%>	--%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/assets/css/member.css">
	<meta charset="UTF-8">
	<title>Insert title here</title>

</head>
<body>

<table class="type10 non-style" >
	<thead>
	<th><h3><b>회원수정</b></h3></th>

	</thead>

	<td>
		<form action="editMemberOk.do" method="post">
			<c:set var="member" value="${requestScope.member}"/>


			<table class="type11">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" class="TB" value="${member.id}" hidden>${member.id}
					</td>
				</tr>
				<tr>
					<td>비번</td>
					<td>
						<input type="text" name="pwd" class="TB" value="${member.pwd}"  style="background-color:lightgoldenrodyellow">
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" class="TB" value="${member.name}" style="background-color:lightgoldenrodyellow">
					</td>
				</tr>
				<tr>
					<td>나이</td>
					<td>
						<input type="text" name="age" class="TB" value="${member.age}" style="background-color:lightgoldenrodyellow">
					</td>
				</tr>
				<tr>

					<td>성별</td>
					<td>

						<input type="radio" name="gender" id="gender" value="여"
						<c:if test="${member.gender=='여'}">
						       checked
						</c:if>>여자


						<input type="radio" name="gender" id="gender" value="남"
						<c:if test="${member.gender=='남'}">
						       checked
						</c:if>>남자

					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="email" class="TB bg-color" value="${member.email}" style="background-color:lightgoldenrodyellow">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="non-style text-center">
						<input type="submit" class="btn btn-info btn-fill" value="수정하기" style="background-color: #3b5998; border-color:#3b5998;">
						<a href="memberList.do"><input type="button" class="btn btn-info btn-fill" value="회원 목록 페이지">&nbsp;</a>

                   </td>
                </tr>
			</table>


		</form>
	</td>
	</tr>


	<jsp:include page="/common/Bottom.jsp"></jsp:include>


</table>

</body>
</html>

