package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;
import kr.or.bit.utils.ConnectionHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 
 */
public class detailMemberViewByIdService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        
        ActionForward forward = null;
        
        String id = request.getParameter("id");
        
        
        KoreaMember dto = null;
        MemberDao dao = new MemberDao();
    
        try{
            if (session.getAttribute("userid") == null ||
                    !session.getAttribute("userid").equals("admin")){
            
                System.out.println("세션체크");
                //강제로 다른 페이지 이동
                //forward.setPath("/WEB-INF/views/memoview.jsp");
                //out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
                forward.setPath("Ex02_JDBC_Login.jsp"); //TODO 로그인뷰 Path 넣어야
            }else{
                System.out.println("세션체크2");
                dto = dao.getMemoListById(id);
            
                request.setAttribute("member", dto);
                System.out.println("디테일 멤버 " + dto);
                
                forward = new ActionForward();
                
                forward.setRedirect(false);
                System.out.println("서비스 111");
                forward.setPath("/WEB-INF/views/Ex03_MemberDetail.jsp");
                System.out.println("서비스 222");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        

        return forward;
    }
    
}

























