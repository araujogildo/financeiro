package model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.PapelDao;
import model.entities.Papel;

public class PapelDaoJDBC implements PapelDao {

	private Connection conn;
	
	public PapelDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Papel findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM papel WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Papel obj = new Papel();
				
				obj.setId_Papel(rs.getInt("Id_Papel"));
				obj.setTx_Papel(rs.getString("Papel"));
				obj.setTx_Descricao(rs.getString("Descricao"));
				obj.setTx_RamoNegocios(rs.getString("RamoNegocios"));
				obj.setDt_Cadastro(rs.getString("Dt_Cadastro"));
				obj.setId_Resp(rs.getInt("IdResp"));
				
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Papel> findAll() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM papel ORDER BY papel");
			rs = st.executeQuery();

			List<Papel> list = new ArrayList<>();

			while (rs.next()) {
				Papel obj = new Papel();
				
				obj.setId_Papel(rs.getInt("Id_Papel"));
				obj.setTx_Papel(rs.getString("Papel"));
				obj.setTx_Descricao(rs.getString("Descricao"));
				obj.setTx_RamoNegocios(rs.getString("Ramo_Negocios"));			
				obj.setDt_Cadastro(sdf.format(rs.getDate("Dt_Cadastro")).concat(" " + rs.getTime("Dt_Cadastro")));
				obj.setId_Resp(rs.getInt("Id_Resp"));
				
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(Papel obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO papel " +
				"(Papel, RamoNegocios, Dt_Cadastro, Id_Resp) " +
				"VALUES " +
				"(?, ?, ?, ?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getTx_Papel());
			st.setString(2, obj.getTx_RamoNegocios());
			st.setString(3, obj.getDt_Cadastro());
			st.setInt(4, obj.getId_Resp());

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId_Papel(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Papel obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE papel " +
				"SET Papel = ?, Descricao = ?, RamoNegocios = ?, Dt_Cadastro = ?, Id_Resp = ? " +
				"WHERE Id_Papel = ?");

			st.setString(1, obj.getTx_Papel());
			st.setString(2, obj.getTx_Descricao());
			st.setString(3, obj.getTx_RamoNegocios());
			st.setString(4, obj.getDt_Cadastro());
			st.setInt(5, obj.getId_Resp());
			
			st.setInt(6, obj.getId_Papel(0));

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM papel WHERE Id_Papel = ?");

			st.setInt(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}
}
