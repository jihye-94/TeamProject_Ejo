<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/Left.jsp"></jsp:include>

<jsp:include page="/common/Top.jsp"></jsp:include>
<!-- 지혜지혜 -->
<style>

      #mainimg {
            width       : 50%;
            margin      : 0 auto;
      }
      
      #mainimg > img {
            width  : 100%;
            margin : 0 auto;
      }

</style>
<div class="content">
      <div class="container-fluid" id="mainimg">
            <img src="images/main.png">
            <c:if test="${sessionScope.userid !=null}">
                  ${sessionScope.userid}회원님 안녕하세요^^<br>
                  <c:if test="${sessionScope.userid=='admin'}">

                        <a href="memberList.do"><input type="button" class="btn btn-info btn-fill pull-right" value="회원관리"></a>
                  </c:if>

            </c:if>
      </div>
</div>

<div>
      <jsp:include page="/common/Bottom.jsp"></jsp:include>
</div>

<script type="text/javascript">
      $(document).ready(function() {

            demo.initChartist();

            $.notify({
                  icon: 'pe-7s-gift',
                  message: "Welcome to 2조 <br> 회원가입 페이지에 오신걸 환영합니다:)"

            }, {
                  type: 'info',
                  timer: 4000
            });

      });
</script>