package kr.or.bit.controller;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("*.do")
public class FrontMemoController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    
    public FrontMemoController(){
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url_Command = requestURI.substring(contextPath.length());
        
        Action action = null;
        ActionForward forward = null;
        
        if (url_Command.equals("/JoinMember.do")){ //글쓰기 처리
            
            //UI+로직
            action = new joinMemberService();
            forward = action.execute(request, response);
            
            /////////////예솔 추가
        }else if (url_Command.equals("/Join_page.do")){

            action = new JoinPageService();
            forward = action.execute(request, response);
            
            ////////////서정
        }else if (url_Command.equals("/login_page.do")){
            System.out.println("/login_page.do 실행중 컨트롤러");
            action = new LoginPageService();
            forward = action.execute(request, response);
        }else if (url_Command.equals("/login.do")){ //
            
            action = new loginMemberService();
            forward = action.execute(request, response);
            System.out.println("로그인 실행");
            
        }else if (url_Command.equals("/logout.do")){
            
            action = new logoutMemberService();
            forward = action.execute(request, response);
            System.out.println("로그아웃 실행");
            
            
        }else if (url_Command.equals("/deleteMember.do")){
            
            action = new deleteMemberService();
            forward = action.execute(request, response);
            System.out.println("deleteMemberService 실행");
            
        }else if (url_Command.equals("/detailMemberView.do")){
            
            action = new detailMemberService();
            
            forward = action.execute(request, response);
            System.out.println("detailMemberService 실행");
            
        }else if (url_Command.equals("/searchMember.do")){
            
            action = new searchMemberService();
            forward = action.execute(request, response);
            System.out.println("searchMember 실행");
            
        }else if (url_Command.equals("/editMember.do")){
            
            action = new editMemberService();
            forward = action.execute(request, response);
            System.out.println("editMember 실행");
            
        }else if (url_Command.equals("/editMemberOk.do")){
            action = new editOkMemberService();
            forward = action.execute(request, response);
            System.out.println("editMemberOk 실행");
            
        }else if (url_Command.equals("/detailMemberViewById.do")){
            action = new detailMemberViewByIdService();
            System.out.println("서비스 333");
            forward = action.execute(request, response);
            System.out.println("서비스 444");
            System.out.println("detailMemberViewById 실행");
            
        }else if (url_Command.equals("/memberList.do")){
            action = new memberListService();
            forward = action.execute(request, response);
            
        }
        
        if (forward != null){
            if (forward.isRedirect()){ //true
                response.sendRedirect(forward.getPath());
            }else{ //false (모든 자원 ) 사용
                //UI
                //UI + 로직
                //forward url 주소 변환 없어 View 내용을 받을 수 있다
                RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
                dis.forward(request, response);
            }
        }
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doProcess(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doProcess(request, response);
    }
    
}
