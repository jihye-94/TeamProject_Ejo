package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

/*
 
 */
public class logoutMemberService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
    	 HttpSession session = request.getSession();
         session.invalidate();

         ActionForward forward = new ActionForward();

         forward.setRedirect(false);//TODO false 로 바꿨습니다.
         forward.setPath("/WEB-INF/views/Ex02_JDBC_Login.jsp");

         return forward;
    }
    
}

























