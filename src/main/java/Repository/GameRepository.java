package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.MySqlConnection;
import game.model.diemso;
import game.model.users;

public class GameRepository {
	public int diemSo(int id_user,int soLan) {
		int isDone=0;
		Connection connection =MySqlConnection.getConnection();
		String query="insert into diemso(id_user,diem) values(?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, soLan);
			isDone = preparedStatement.executeUpdate();	      	       
			
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
		return isDone;
	}
	public List<diemso> getDSDiem() {
		List<diemso> dsDiem=new ArrayList<>();
		Connection connection =MySqlConnection.getConnection();
		String query="select u.hoten,d.diem,d.created_time from users u, diemso d where u.id=d.id_user order by d.diem ASC limit 20";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next()) {
				diemso diem=new diemso();
				diem.setHoten(resultSet.getString("hoten"));
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
	}
}
