package Controller;

import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet(name="playgame",urlPatterns = {"/play"})
public class PlayGameController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();	 
		 Integer userId = (Integer) session.getAttribute("userId");

		    
		    req.setAttribute("userId", userId);
	        if (session.getAttribute("number") == null) {
	            int number = (int) (Math.random() * 10);
	            session.setAttribute("number", number);
	            session.setAttribute("count", 0);
	        }

	        req.getRequestDispatcher("/playgame.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 HttpSession session = req.getSession();
	        int number = (int) session.getAttribute("number");
	        int count = (int) session.getAttribute("count");
	        int id=(int) session.getAttribute("userId");
	        int soDuDoan = Integer.parseInt(req.getParameter("sodudoan"));
	        System.out.println( id+": "+number+" - "+soDuDoan);
	        String message = "";

	        if (soDuDoan == number) {
	            message = "Chúc mừng bạn! Bạn đã đoán đúng.";
	            session.removeAttribute("number"); 
	            session.setAttribute("reset", true);
	            
	            try {
	                URL url = new URL("http://localhost:8080/game/api/diem/themdiem");
	                HttpURLConnection con = (HttpURLConnection) url.openConnection();
	                con.setRequestMethod("POST");
	                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	                con.setDoOutput(true);

	                int diem=count+1;
	                String urlParameters = "userId=" + id + "&diem=" + diem;

	                
	                try (OutputStream os = con.getOutputStream()) {
	                    byte[] input = urlParameters.getBytes("utf-8");
	                    os.write(input, 0, input.length);           
	                }

	                
	                int responseCode = con.getResponseCode();
	                if (responseCode == HttpURLConnection.HTTP_OK) {
	                    System.out.println("Gửi điểm thành công!");
	                } else {
	                    System.out.println("Lỗi khi gửi điểm: " + responseCode);
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            
	        } else if (soDuDoan < number) {
	            message = "Số dự đoán đang nhỏ hơn. Hãy thử lại!";
	        } else {
	            message = "Số dự đoán đang lớn hơn. Hãy thử lại!";
	        }

	        count++;
	        session.setAttribute("count", count);
	        req.setAttribute("message", message);
	        req.setAttribute("attempts", count);
	        req.getRequestDispatcher("/playgame.jsp").forward(req, resp);
	    
	}
}
