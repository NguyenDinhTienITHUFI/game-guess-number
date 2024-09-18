package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.GameService;
import Service.UserService;
import game.common.Constant;

@WebServlet(name="index",urlPatterns = {Constant.URL_INDEX})
public class Index extends HttpServlet{
	private UserService sv=new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			getAllDiem(req, resp);
			
		
	}
	
	private void getAllDiem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		 HttpSession session = req.getSession();
	       int id=(int) session.getAttribute("userId");
		req.setAttribute("dsDiem", sv.getDSDiemByUser(id));		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
}
