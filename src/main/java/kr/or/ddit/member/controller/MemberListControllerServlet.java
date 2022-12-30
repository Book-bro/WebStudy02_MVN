package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/member/memberList.do")
public class MemberListControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String pageParam = req.getParameter("page");
	   
	   int currentPage = 1;
	   //파라미터가 숫자로만 구성되어 있는지 확인
	   if(StringUtils.isNumeric(pageParam)) {
		   currentPage = Integer.parseInt(pageParam);
	   }
	   
	   
	   PagingVO<MemberVO> pagingVO = new PagingVO<>(4,2);
	   pagingVO.setCurrentPage(currentPage);
	  
	   List<MemberVO> memberList = service.retrieveMemberList(pagingVO);
	   req.setAttribute("pagingVO", pagingVO);
      
	   log.info("paging data : {}", pagingVO);
      
	   String viewName = "member/memberList";

	   new InternalResourceViewResolver("/WEB-INF/views/",".jsp").resolveView(viewName, req, resp);
	}
}	