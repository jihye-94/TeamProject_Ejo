<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<jsp:include page="/common/Left.jsp"></jsp:include>

<jsp:include page="/common/Top.jsp"></jsp:include>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
     $(function() {
          $('#joinForm').submit(function() {
               //alert("가입");
               if ($('#id').val() == "") { // 아이디 검사
                    alert('ID를 입력해 주세요.');
                    $('#id').focus();
                    return false;
               } else if ($('#pwd').val() == "") { // 비밀번호 검사
                    alert('PWD를 입력해 주세요.');
                    $('#pwd').focus();
                    return false;
               } else if ($('#mname').val() == "") { // 이름 검사
                    alert('mname를 입력해 주세요.');
                    $('#mname').focus();
                    return false;
               } else if ($('#age').val() == "") { // 나이 검사
                    alert('age를 입력해 주세요.');
                    $('#age').focus();
                    return false;
               } else if ($('#email').val() == "") { // 우편번호
                    alert('email를 입력해 주세요.');
                    $('#email').focus();
                    return false;
               }
               
          });
     });
</script>

<div class="content">
      <div class="container-fluid">
            <div class="row">
                  <div class="col-md-8">
                        <div class="card">
                              <div class="header">
                                    <h4 class="title">REGISTER</h4>
                              </div>
                              <div class="content">
                                    <form action="${pageContext.request.contextPath}/JoinMember.do" method="post" name="joinForm" id="joinForm">
                                          <div class="row">
                                                <div class="col-md-5">
                                                      <div class="form-group">
                                                            <label>ID</label>
                                                            <input type="text" name="id" id="id" class="form-control" placeholder="UserID" value="">
                                                      </div>
                                                </div>
                                          </div>
                                          
                                          <div class="row">
                                                <div class="col-md-5">
                                                      <div class="form-group">
                                                            <label>PASSWORD</label>
                                                            <input type="password" name="pwd" id="pwd" class="form-control" placeholder="Pwd" value="">
                                                      </div>
                                                </div>
                                          </div>
                                          
                                          <div class="row">
                                                <div class="col-md-4">
                                                      <div class="form-group">
                                                            <label>Name</label>
                                                            <input type="text" name="mname" id="mname" class="form-control" placeholder="Name" value="">
                                                      </div>
                                                </div>
                                                <div class="col-md-2">
                                                      <div class="form-group">
                                                            <label>AGE</label>
                                                            <input type="text" name="age" id="age" maxlength="3" class="form-control" placeholder="Age" value="">
                                                      </div>
                                                </div>
                                          </div>
                                          
                                          <div class="row">
                                                <div class="col-md-4">
                                                      <div class="form-group">
                                                            <label>GENDER</label>
                                                            <br>
                                                            <input type="radio" name="gender" id="gender" value="여"
                                                                   checked>여자
                                                            <input type="radio" name="gender"
                                                                   id="gender" value="남">남자
                                                      </div>
                                                </div>
                                          </div>
                                          
                                          <div class="row">
                                                <div class="col-md-4">
                                                      <div class="form-group">
                                                            <label for="exampleInputEmail1">Email address</label>
                                                            <input type="email" id="email" name="email"  class="form-control" placeholder="Email">
                                                      </div>
                                                </div>
                                          </div>
                                          
                                          <input type="submit" class="btn btn-info btn-fill pull-right" value="회원가입">
                                          <input type="reset" class="btn btn-info btn-fill pull-left" value="취소">
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