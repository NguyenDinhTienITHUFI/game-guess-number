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

import Service.UserService;
import game.common.Constant;
import game.model.diemso;
import game.payload.ResponseData;

@WebServlet(name="userApi",urlPatterns = {Constant.URL_USERS_LOGIN,Constant.URL_USERS_REGISTER,Constant.URL_USERS_DSDIEMBYUSER})
public class UsersApi extends HttpServlet{
	private UserService service=new UserService();
	private Gson gson=new Gson();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath=req.getServletPath();
		switch (urlPath) {
		case Constant.URL_USERS_DSDIEMBYUSER:
			dsDiemByUser(req,resp);
			break;
		
		default:
			break;
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String urlPath=req.getServletPath();
		switch (urlPath) {
		case Constant.URL_USERS_LOGIN:
			login(req,resp);
			break;
		case Constant.URL_USERS_REGISTER:
			reg(req,resp);
			break;
		
		default:
			break;
		}
	}
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String username = req.getParameter("username");
		    String password = req.getParameter("password");
		    
		    
		    int userId = service.login(username, password);
		    
		    if (userId >0) { 
		        
		        HttpSession session = req.getSession();
		        session.setAttribute("userId", userId);
		        
		        // Send success response
		        ResponseData data = new ResponseData();
		        data.setSuccess(true);
		        data.setData(userId);
		        String json = new Gson().toJson(data);
		        resp.setContentType("application/json");
		        resp.setCharacterEncoding("UTF-8");
		        PrintWriter printWriter = resp.getWriter();
		        printWriter.print(json);
		        printWriter.flush();
		    } else {
		        // Login failed
		        ResponseData data = new ResponseData();
		        data.setSuccess(false);
		        data.setData("Invalid credentials");
		        String json = new Gson().toJson(data);
		        resp.setContentType("application/json");
		        resp.setCharacterEncoding("UTF-8");
		        PrintWriter printWriter = resp.getWriter();
		        printWriter.print(json);
		        printWriter.flush();
		    }
		}
	private void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String hoten=req.getParameter("hoten");
		int age=Integer.parseInt(req.getParameter("age"));
		ResponseData data=new ResponseData();
		boolean isReg=service.registerUser(username, password,hoten,age);
		data.setSuccess(isReg);
		data.setData(" ok");
		data.setDescription(" ");
		
		String json = gson.toJson(data);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    PrintWriter printWriter = resp.getWriter();
	    printWriter.print(json);
	    printWriter.flush();
	}
	private void dsDiemByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResponseData data=new ResponseData();
		 HttpSession session = req.getSession();
	        int id=(int)session.getAttribute("userId");
		List<diemso> dsDiem=service.getDSDiemByUser(id);
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
