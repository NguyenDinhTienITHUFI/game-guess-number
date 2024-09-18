package Service;

import java.util.List;

import Repository.GameRepository;
import game.model.diemso;

public class GameService {
	private GameRepository gameRepository=new GameRepository();
	public boolean diemSo(int id_user,int soLan){
		return gameRepository.diemSo(id_user, soLan)>0;
	}
	public List<diemso>getDSDiem(){
		return gameRepository.getDSDiem();
	}
}
