package model.dao;

import db.DB;
import model.impl.PapelDaoJDBC;

public class DaoFactory {

	public static PapelDao createPapelDao() {
		return new PapelDaoJDBC(DB.getConnection());
	}
}
