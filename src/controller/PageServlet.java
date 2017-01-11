package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 模拟数据库数据进行分页
 * @author Administrator
 *
 */
public class PageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//实际使用时，修改此处数据即可
		int sum = 7;
		int pageCount = 3;//每个part多少页
		response.setContentType("text/html");
		int pageNo;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (Exception e) {
			pageNo = 1;
		}
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("sum", sum);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("index3.jsp").forward(request, response);;
	}

}
