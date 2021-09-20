package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;

/*
 
 */
public class deleteMemberService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
    	ActionForward forward = null;
    	System.out.println(request.getParameter("id"));
		try {
			
			forward = new ActionForward();
			forward.setRedirect(false); //forward
			 //세션 다르면은 ㅃㅃㅇ 
			if (session.getAttribute("userid") == null ||
	    		!session.getAttribute("userid").equals("admin")) {
	    		//강제로 다른 페이지 이동
				//forward.setPath("/WEB-INF/views/memoview.jsp");
	    		//out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	    		forward.setPath("Ex02_JDBC_Login.jsp"); //TODO 로그인뷰 Path 넣어야  
	    	}else {
	    		MemberDao dao = new MemberDao();
	    		//TODO Path 확인해서 수정
				int result = dao.deleteMember(request.getParameter("id"));
				if(result>0) {
					forward.setPath("detailMemberView.do"); //멤버리스트 화면
				}else {
					forward.setPath("deleteMember.do?id="+request.getParameter("id")); //Delete 화면
				}				
	    	}
						 
		}catch (Exception e) {
			System.out.println("deleteMemberService " + e.getMessage());
		}
		return forward;
    }
    
}

























