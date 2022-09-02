package model.dao;

import java.util.List;
import model.entities.Papel;

public interface PapelDao {

	void insert(Papel obj);
	void update(Papel obj);
	void deleteById(Integer id);
	Papel findById(Integer id);
	List<Papel> findAll();
}
