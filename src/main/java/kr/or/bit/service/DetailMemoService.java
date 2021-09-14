package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;

public class DetailMemoService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		
		try {
			
		     String id = request.getParameter("id");
			 memodao dao = new memodao();
			 memo detailMemolist = dao.detailMemo(id);
			 request.setAttribute("detailMemo", detailMemolist);
			 
			 forward = new ActionForward();
			 forward.setRedirect(false); //forward
			 forward.setPath("/WEB-INF/views/detailView.jsp");
			 
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
		
	}

}
