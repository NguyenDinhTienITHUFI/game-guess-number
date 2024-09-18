package Api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Service.GameService;
import game.common.Constant;
import game.model.diemso;
import game.payload.ResponseData;

@WebServlet(name="diemSo",urlPatterns = {Constant.URL_DIEMSO_THEMDIEM,Constant.URL_DIEMSO_DSDIEM})
public class DiemApi extends HttpServlet{
	private GameService gameService=new GameService();
	private Gson gson=new Gson();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath=req.getServletPath();
		switch (urlPath) {
		case Constant.URL_DIEMSO_DSDIEM:
			dsDiem(req,resp);
			break;
		
		default:
			break;
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath=req.getServletPath();
		switch (urlPath) {
		case Constant.URL_DIEMSO_THEMDIEM:
			themDiem(req,resp);
			break;
		case Constant.URL_DIEMSO_DSDIEM:
			dsDiem(req,resp);
			break;
		
		default:
			break;
		}
	}
	
	private void themDiem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int id=Integer.parseInt(req.getParameter("userId"));
		int diem=Integer.parseInt(req.getParameter("diem"));
		ResponseData data=new ResponseData();
		boolean isDone=gameService.diemSo(id,diem);
		data.setSuccess(isDone);
		data.setData(" ok");
		data.setDescription(" ");
		
		String json = gson.toJson(data);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    PrintWriter printWriter = resp.getWriter();
	    printWriter.print(json);
	    printWriter.flush();
	}
	
	private void dsDiem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ResponseData data=new ResponseData();
		List<diemso> dsDiem=gameService.getDSDiem();
		data.setSuccess(true);
		data.setData(dsDiem);
		data.setDescription(" ");
		
		String json = gson.toJson(data);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    PrintWriter printWriter = resp.getWriter();
	    printWriter.print(json);
	    printWriter.flush();
	}
	
}
