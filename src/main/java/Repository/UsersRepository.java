package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import config.MySqlConnection;
import game.model.diemso;
import game.model.users;

public class UsersRepository {
	public int checkLogin(String username, String password) {
		
		int isLogin=0;
		Connection connection =MySqlConnection.getConnection();
		String query="select * from users u where u.username=? and u.password=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
	        
	       
	        if (resultSet.next()) {
	            isLogin = resultSet.getInt("id"); 
	            
	            
	        } else {
	            isLogin = 0; 
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection !=null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isLogin;
	}
	public int registerUser(String username, String password, String hoten,int age)
	{
		int isInsert=0;
		Connection connection =MySqlConnection.getConnection();
		String query="insert into users(username,password,hoten,age) values(?,?,?,?);";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, hoten);
			preparedStatement.setInt(4, age);
			isInsert = preparedStatement.executeUpdate();
	        
	       
	       
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection !=null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isInsert;
	}
	public List<diemso> getDSDiemByUser(int id_user) {
		List<diemso> dsDiem=new ArrayList<>();
		Connection connection =MySqlConnection.getConnection();
		String query="select d.diem,d.created_time from users u, diemso d where  u.id= ? and u.id=d.id_user order by d.diem ASC";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id_user);
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next()) {
				diemso diem=new diemso();
				diem.setHoten("");
				diem.setDiem(resultSet.getInt("diem"));
				diem.setCreated_time(resultSet.getTimestamp("created_time"));
				dsDiem.add(diem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection !=null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dsDiem;
}}
