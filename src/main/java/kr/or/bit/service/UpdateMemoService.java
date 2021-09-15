package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;

public class UpdateMemoService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		System.out.println(request.getParameter("id"));
		try {
			 memodao dao = new memodao();
			 memo m= dao.detailMemo(request.getParameter("id"));
			 request.setAttribute("detailMemo", m);
			 
			 forward = new ActionForward();
			 forward.setRedirect(false); //forward
			 forward.setPath("/WEB-INF/views/updateMemo.jsp");
			 
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
		
	}
}
