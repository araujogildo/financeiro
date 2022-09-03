package model.services;

import java.util.List;
import model.dao.DaoFactory;
import model.dao.PapelDao;
import model.entities.Papel;

public class PapelService {
	
	//declarando uma injeção de dependencia
	private PapelDao dao = DaoFactory.createPapelDao();
		
	public List<Papel> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Papel obj) {
		if(obj.getId_Papel().equals("")) {
			dao.insert(obj);
		}else {
			dao.update(obj);
		}
	}
	
	public void remove(Papel obj) {
		dao.deleteById(Integer.parseInt(obj.getId_Papel()));
	}
}
