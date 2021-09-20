<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
      <meta charset="utf-8"/>
      <link rel="icon" type="image/png" href="assets/img/favicon.ico">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

      <title>Light Bootstrap Dashboard by Creative Tim</title>

      <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
      <meta name="viewport" content="width=device-width"/>


      <!-- Bootstrap core CSS     -->
      <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>

      <!-- Animation library for notifications   -->
      <link href="assets/css/animate.min.css" rel="stylesheet"/>

      <!--  Light Bootstrap Table core CSS    -->
      <link href="assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


      <!--  CSS for Demo Purpose, don't include it in your project     -->
      <link href="assets/css/demo.css" rel="stylesheet"/>


      <!--     Fonts and icons     -->
      <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
      <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
      <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet"/>
      <style>
            .nav {
                  float : right;
            }
      </style>
</head>

<body>

<div class="wrapper">
      <div class="sidebar wrapper" data-color="purple" data-image="assets/img/sidebar-5.jpg">

            <div class="sidebar-wrapper">
                  <div class="logo">
                        <a href="http://www.creative-tim.com" class="simple-text">
                              2조
                        </a>
                  </div>

                  <ul class="nav">
                        <li>
                              <a href="Ex02_JDBC_Main.jsp">
                                    <i class="pe-7s-graph"></i>
                                    <p>MAIN</p>
                              </a>
                        </li>
                        <c:if test="${empty sessionScope.userid}">
                              <li>
                                    <a href="login_page.do">
                                          <i class="pe-7s-user"></i>
                                          <p>LOGIN</p>
                                    </a>
                              </li>
                        </c:if>
                        <c:if test="${not empty sessionScope.userid}">
                              <li>
                                    <a href="logout.do">
                                          <i class="pe-7s-user"></i>
                                          <p>LOG OUT</p>
                                    </a>
                              </li>
                        </c:if>
                        <li>
                              <a href="Join_page.do">
                                    <i class="pe-7s-note2"></i>
                                    <p>REGISTER</p>
                              </a>
                        </li>
                        <c:if test="${sessionScope.userid =='admin'}">
                        </c:if>
                  </ul>
            </div>
      </div>
      <!--   Core JS Files   -->
      <script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
      <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

      <!--  Charts Plugin -->
      <script src="assets/js/chartist.min.js"></script>

      <!--  Notifications Plugin    -->
      <script src="assets/js/bootstrap-notify.js"></script>

      <!--  Google Maps Plugin    -->
      <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

      <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
      <script src="assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

      <!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
      <script src="assets/js/demo.js"></script>

