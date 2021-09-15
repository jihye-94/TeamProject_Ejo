package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;

public class UpdateMemoOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    	
    	String id = request.getParameter("id");
    	String email = request.getParameter("email");
    	String content = request.getParameter("content");
    	
    	//memo m = new memo();  //권장사항
    	//m.setId(id);
    	System.out.println(request.getParameter("id"));
    	memodao dao = new memodao(); //POINT
    	memo m = new memo();
    	m.setId(id);
    	m.setEmail(email);
    	m.setContent(content);
    	
    	System.out.println("upD ok m / " + m);
		int result = dao.updateMemo(m);
		System.out.println("upD ok result / " + result);
		 	String msg="";
		 	String url="";
		    if(result > 0){
		    	msg ="수정성공";
		    	url ="detailView.memo?id="+id;
		    }else{
		    	msg="수정실패";
		    	url="memo.html";
		    }
		    
		    request.setAttribute("board_msg",msg);
		    request.setAttribute("board_url", url);
		
		    ActionForward forward = new ActionForward();
		    forward.setRedirect(false);
		    forward.setPath("/WEB-INF/views/redirect.jsp");
		    
		return forward;
	}

}
