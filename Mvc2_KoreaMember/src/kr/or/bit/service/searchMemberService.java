package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

/*
 
 */
public class searchMemberService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
        ActionForward forward = null;
        HttpSession session = request.getSession();
        
        try{
            if (session.getAttribute("userid") == null ||
                    !session.getAttribute("userid").equals("admin")) {
                //강제로 다른 페이지 이동
                //forward.setPath("/WEB-INF/views/memoview.jsp");
                //out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
                forward.setPath("/WEB-INF/views/Ex02_JDBC_Login.jsp"); //TODO 로그인뷰 Path 넣어야
            }else{
                MemberDao dao = new MemberDao();
                System.out.println(request.getParameter("se"));
                
                KoreaMember dto = dao.searchMemberByName(request.getParameter("search"));
                System.out.println(dto);
                request.setAttribute("member", dto);
    
                forward = new ActionForward();
                forward.setRedirect(false);
                forward.setPath("/WEB-INF/views/Ex03_MemberSearch.jsp");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            
        }
        return forward;
    }
    
}

























