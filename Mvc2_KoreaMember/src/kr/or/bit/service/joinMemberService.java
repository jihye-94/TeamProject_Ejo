package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;

/*
 
 */
public class joinMemberService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
    	
    	KoreaMember m = new KoreaMember();
    	
    	m.setId(request.getParameter("id"));
    	m.setPwd(request.getParameter("pwd"));
    	m.setName(request.getParameter("mname"));
    	m.setAge(Integer.parseInt(request.getParameter("age")));
    	m.setGender(request.getParameter("gender"));
    	m.setEmail(request.getParameter("email"));
    	m.setIp(request.getRemoteAddr());
    	
    	MemberDao dao = new MemberDao();
    	int result = dao.joinMember(m);
    	
    	String msg = "";
		String url = "";
		if (result > 0) {
			msg = "등록성공";
			url = "Ex02_JDBC_Main.jsp";
		} else {
			msg = "등록실패";
			url = "/WEB-INF/views/Ex02_JDBC_JoinForm.jsp";
		}

		request.setAttribute("board_msg", msg);
		request.setAttribute("board_url", url);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/redirect.jsp");

		return forward;
    }
    
}

























