package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/*
 
 */
public class memberListService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
    
        ActionForward forward = new ActionForward();
        
        HttpSession session = request.getSession();
        
        try{
            if (session.getAttribute("userid") == null ||
                    !session.getAttribute("userid").equals("admin")) {
                //강제로 다른 페이지 이동
                //forward.setPath("/WEB-INF/views/memoview.jsp");
                //out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
                forward.setPath("Ex02_JDBC_Login.jsp"); //TODO 로그인뷰 Path 넣어야
            }else{
                MemberDao dao = new MemberDao();
                List<KoreaMember> memberlist = dao.getMemberList();
                request.setAttribute("memberlist", memberlist);
                System.out.println("회원리스트 띄우기");
                forward.setRedirect(false);
                forward.setPath("/WEB-INF/views/Ex03_Memberlist.jsp");
            }
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return forward;
    }
    
}

























