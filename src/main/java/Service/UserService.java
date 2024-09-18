package Service;

import java.util.List;

import Repository.UsersRepository;
import game.model.diemso;

public class UserService {
	private UsersRepository repository=new UsersRepository();
	public int login(String username, String password) {
	    return repository.checkLogin(username, password);  
	}
	public boolean registerUser(String username, String password,String hoten, int age) {
		return repository.registerUser(username, password, hoten, age)>0;
	}
	public List<diemso> getDSDiemByUser(int id){
		return repository.getDSDiemByUser(id);
	}

}
