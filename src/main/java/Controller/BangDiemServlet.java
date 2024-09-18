package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.GameService;
import game.common.Constant;

@WebServlet(name="bangdiem",urlPatterns = {Constant.URL_GAME_BANGDIEM})
public class BangDiemServlet extends HttpServlet{
	private GameService sv=new GameService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			getAllDiem(req, resp);
			
		
	}
	
	private void getAllDiem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setAttribute("dsDiem", sv.getDSDiem());		
		req.getRequestDispatcher("/bangdiem.jsp").forward(req, resp);
	}
	
}
