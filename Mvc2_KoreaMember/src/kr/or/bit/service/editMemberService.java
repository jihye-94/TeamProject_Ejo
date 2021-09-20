package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;
import kr.or.bit.utils.ConnectionHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 
 */
public class editMemberService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
        ActionForward forward = null;
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        try{
            if (session.getAttribute("userid") == null ||
                    !session.getAttribute("userid").equals("admin")) {
                //강제로 다른 페이지 이동
                //forward.setPath("/WEB-INF/views/memoview.jsp");
                //out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
                forward.setPath("Ex02_JDBC_Login.jsp"); //TODO 로그인뷰 Path 넣어야
            }else{
                System.out.println("에딧 멤버 서비스 id  +"+id);
                MemberDao dao = new MemberDao();
                KoreaMember dto = dao.getMemoListById(id);
                request.setAttribute("member", dto);
    
                forward = new ActionForward();
                forward.setRedirect(false);
                forward.setPath("/WEB-INF/views/Ex03_MemberEdit.jsp");
    
            }
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return forward;
        
        
        
        //        try{
//
//            if (session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")){
//                //강제로 페이지 이동
//                out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
//            }
//
//            request.setCharacterEncoding("UTF-8");
//            String id = request.getParameter("id");
//
//
//            conn = ConnectionHelper.getConnection("oracle");
//            String sql = "SELECT ID,PWD,NAME,AGE,TRIM(GENDER),EMAIL FROM KOREAMEMBER WHERE ID=?";
//            pstmt = conn.prepareStatement(sql);
//
//            pstmt.setString(1, id);
//
//            rs = pstmt.executeQuery();
//
//            //while(rs.next())
//            rs.next(); //1건 데이터가 있다면 전제조건
//            return null;
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }finally{
//            ConnectionHelper.close(rs);
//            ConnectionHelper.close(conn);
//            ConnectionHelper.close(pstmt);
//
//        }
    }
    
}

























