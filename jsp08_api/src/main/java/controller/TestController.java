package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TestService;


@WebServlet("*.test")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private TestService testService = new TestService();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		//컨텍스트 패스
		String path = request.getContextPath();
		if(uri.contains("pasing")) {
			String year = request.getParameter("year");
			int cnt = testService.testParsing(year);
			String msg = URLEncoder.encode(cnt+"건 저장","utf-8");
			response.sendRedirect(path+"/view/test.jsp?msg="+msg);
		
		}else if(uri.contains("list")) {
			//조회
			String districtName = request.getParameter("districtName");
			List<Map<String, String>> list = testService.selectList(districtName);
			System.out.println(list);
			
			//forward 방식 이동
			request.setAttribute("list", list);
			request.getRequestDispatcher("/view/test.jsp")
				.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
