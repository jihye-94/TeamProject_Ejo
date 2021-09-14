package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;

public class DeleteMemoService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		
		memodao dao = new memodao();
		int result = dao.deleteMemo(id);
		
		request.setAttribute("deleteMemo", result);

		String msg = "";
		String url = "";

		if (result > 0) {
			msg = "삭제성공";
			url = "MemoList.memo";
		} else {
			msg = "삭제실패";
			url = "detailMemo.memo";
		}

		request.setAttribute("board_msg", msg);
		request.setAttribute("board_url", url);

		ActionForward forward  = new ActionForward();
		forward.setRedirect(false); // forward
		forward.setPath("/WEB-INF/views/redirect.jsp");

		return forward;

	}

}
