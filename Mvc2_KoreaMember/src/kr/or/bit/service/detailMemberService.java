package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;

import java.util.ArrayList;

public class detailMemberService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ActionForward forward = null;
		ArrayList<KoreaMember> memberlist = new ArrayList<>();
		MemberDao dao = new MemberDao();
		System.out.println("디테일멤버서비스 userid : "+session.getAttribute("userid"));
		
		try {
			forward = new ActionForward();
			forward.setRedirect(false); //forward
			 //세션 다르면은 ㅃㅃㅇ
			if (session.getAttribute("userid") == null ||
	    		!session.getAttribute("userid").equals("admin")) {
				
				System.out.println("세션체크");
	    		//강제로 다른 페이지 이동
				//forward.setPath("/WEB-INF/views/memoview.jsp");
	    		//out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	    		forward.setPath("Ex02_JDBC_Login.jsp"); //TODO 로그인뷰 Path 넣어야
	    	}else {
				System.out.println("세션체크2");
				memberlist = dao.getMemberList();
				
				System.out.println("세션체크3");
				request.setAttribute("memberlist", memberlist);
				System.out.println("디테일 멤버 "+ memberlist);
				forward.setPath("/WEB-INF/views/Ex03_Memberlist.jsp");
	    	}
						
		}catch (Exception e) {
			System.out.println("detailMemberService " + e.getMessage());
		}
		return forward;
	}

}
