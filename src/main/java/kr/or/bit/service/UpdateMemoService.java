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
    	
		String id = request.getParameter("id");
    	String email = request.getParameter("email");
    	String content = request.getParameter("memo");
			
		memodao dao = new memodao();
		memo m = dao.updateMemo(id, email, content);
		
		//int result = dao.updateMemo(id, email, content);
		
		request.setAttribute("updatdMemo", m);
		
//		String msg = "";
//		String url = "";
//
//		if (result > 0) {
//			msg = "수정성공";
//			url = "MemoList.memo";
//		} else {
//			msg = "수정실패";
//			url = "updateMemo.memo";
//		}
//
//		request.setAttribute("board_msg", msg);
//		request.setAttribute("board_url", url);

		ActionForward forward  = new ActionForward();
		forward.setRedirect(false); // forward
		forward.setPath("/WEB-INF/views/updateMemo.jsp");

		return forward;
	}

}
