<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    @media screen and (min-width : 991px) {
        .navbar-header {
            float : right;
        }
    }

    .navbar-header {
        clear : both
    }

</style>
<div class="main-panel">
    <nav class="navbar navbar-default navbar-fixed">
        <div class="container-fluid">
            <div class="navbar-header">

                <ul class="nav navbar-nav navbar-left">
                    <li class="active">
                        <a href="Ex02_JDBC_Main.jsp">
                            <p><i class="pe-7s-graph"></i> MAIN</p>
                        </a>
                    </li>
                    <c:if test="${empty sessionScope.userid}">
                        <li>
                            <a href="login_page.do">
                                <p><i class="pe-7s-user"></i>LOGIN</p>
                            </a>
                        </li>
                    </c:if>


                    <li>
                        <a href="Join_page.do">
                            <p><i class="pe-7s-note2"></i> REGISTER</p>
                        </a>
                    </li>

                    <c:if test="${not empty sessionScope.userid}">
                        <li>
                            <a href="logout.do">
                                <p><i class="pe-7s-user"></i>LOG OUT</p>

                            </a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
