<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="/common/Left.jsp"></jsp:include>

	<jsp:include page="/common/Top.jsp"></jsp:include>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Login Page</h4>
                            </div>
                            <div class="content">
                                <form action="${pageContext.request.contextPath}/login.do" method="post" name="loginForm" id="joinForm">
                                    <div class="row">                                   
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>ID</label>
                                                <input type="text" name="id" id="id" class="form-control" placeholder="UserId" value="">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>PASSWORD</label>
                                                <input type="password" name="pwd" id="pwd" class="form-control" placeholder="Pwd" value="">
                                            </div>
                                        </div>
                                    </div>

                                  
                                    <input  type="submit" value="로그인" class="btn btn-info btn-fill pull-right">
                                    <input type="reset" value="취소" class="btn btn-info btn-fill pull-left">
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
         <div>
        <jsp:include page="/common/Bottom.jsp"></jsp:include>
        </div>