package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.KoreaMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 
 */
public class editOkMemberService implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
        
        ActionForward forward = new ActionForward();
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String ip = request.getRemoteAddr();
        
        MemberDao dao = new MemberDao();
        KoreaMember dto = new KoreaMember();
        
        dto.setId(id);
        dto.setPwd(pwd);
        dto.setName(name);
        dto.setAge(age);
        dto.setEmail(email);
        dto.setGender(gender);
        dto.setIp(ip);
        
        int result = dao.updateMember(dto);
    
        System.out.println("수정 dto : " + dto);
        
        String msg = "";
        String url = "";
        
        if (result > 0){
            msg = "수정성공";
            url = "detailMemberView.do";
        }else{
            msg = "수정실패";
            url = "/Ex02_JDBC_Main.jsp";
        }
        
        request.setAttribute("board_msg", msg);
        request.setAttribute("board_url", url);
        
        forward.setRedirect(false);
        forward.setPath("/WEB-INF/views/redirect.jsp");
        
        return forward;
    }
    
}

























