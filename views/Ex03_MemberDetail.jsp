<%@page import="kr.or.bit.utils.ConnectionHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/common/Top.jsp"></jsp:include>
<jsp:include page="/common/Left.jsp"></jsp:include>

<%
      /*
          회원 상세 페이지 (id 컬럼 PK)
          1.권한 검사
          2.id 값 받기 (request.getparameter("id")) >> 한글처리
          3.select id,pwd,name,age,gender,email from koreamember where id=?
          4.id primary key (데이터 1건 보장)
          5.화면 출력 UI 구성
      */
/*  
1.관리자만 접근 가능한 페이지
2.로그인한 일반 회원이 주소값을 외워서 ... 접근불가 
3.그러면  회원에 관련되 모든 페이지 상단에는 아래 코드를 ..... : sessionCheck.jsp >> include 
*/


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
<c:set var="member" value="${requestScope.member}"></c:set>

<%--<table
        style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">--%>



<table class="type10" id="non-style">

      <thead>
      <th><h3><b>${member.id}님의 상세페이지</b></h3></th>

      </thead>
            <td>
                  <table class="type11">

                        <tr>
                              <td>아이디</td>
                              <td>${member.id}</td>
                        </tr>
                        <tr>
                              <td>비번</td>
                              <td>${member.pwd}</td>
                        </tr>
                        <tr>
                              <td>이름</td>
                              <td>${member.name}</td>
                        </tr>
                        <tr>
                              <td>나이</td>
                              <td>${member.age}</td>
                        </tr>
                        <tr>
                              <td>성별</td>
                              <td>${member.gender}</td>
                        </tr>
                        <tr>
                              <td>이메일</td>
                              <td>${member.email}</td>
                        </tr>
                        <tr id="non-style1" >
                              <td colspan="2" class="text-center">
                                    <a href="memberList.do"><input type="button" class="btn btn-info btn-fill" value="회원 목록 페이지"></a>

                              </td>
                        </tr>
                  </table>

            </td>


            <jsp:include page="/common/Bottom.jsp"></jsp:include>


</table>
</body>
</html>