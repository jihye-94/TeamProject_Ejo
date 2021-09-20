package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;

/*
 
 */
public class loginMemberService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
    	 String id = request.getParameter("id");
         String pwd = request.getParameter("pwd");

         ActionForward forward = new ActionForward();
         MemberDao memberDao = new MemberDao();
         KoreaMember koreaMember = memberDao.loginMember(id, pwd);

         if (koreaMember != null) {
             HttpSession session = request.getSession();
             session.setAttribute("userid", id);
             System.out.println(id);
             
             forward.setRedirect(true);
             forward.setPath("Ex02_JDBC_Main.jsp");
         } else {
             forward.setRedirect(false);
             forward.setPath("Ex02_JDBC_JoinForm.jsp");
         }

         return forward;
    }
    
}

























