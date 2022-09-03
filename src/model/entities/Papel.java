package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Papel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id_Papel;
	private String tx_Papel;
	private String tx_Descricao;
	private String tx_RamoNegocios;
	private String dt_Cadastro;
	private Integer id_Resp;
	
	public Papel() {
	}
	
	public Papel(String id_Papel, String tx_Papel, String tx_Descricao, String tx_RamoNegocios, String dt_Cadastro,
			Integer id_Resp) {
		this.id_Papel = id_Papel;
		this.tx_Papel = tx_Papel;
		this.tx_Descricao = tx_Descricao;
		this.tx_RamoNegocios = tx_RamoNegocios;
		this.dt_Cadastro = dt_Cadastro;
		this.id_Resp = id_Resp;
	}

	public String getId_Papel() {
		return id_Papel;
	}

	public void setId_Papel(String id_Papel) {
		this.id_Papel = id_Papel;
	}

	public String getTx_Papel() {
		return tx_Papel;
	}

	public void setTx_Papel(String tx_Papel) {
		this.tx_Papel = tx_Papel;
	}

	public String getTx_Descricao() {
		return tx_Descricao;
	}

	public void setTx_Descricao(String tx_Descricao) {
		this.tx_Descricao = tx_Descricao;
	}

	public String getTx_RamoNegocios() {
		return tx_RamoNegocios;
	}

	public void setTx_RamoNegocios(String tx_RamoNegocios) {
		this.tx_RamoNegocios = tx_RamoNegocios;
	}

	public String getDt_Cadastro() {
		return dt_Cadastro;
	}

	public void setDt_Cadastro(String dt_Cadastro) {
		this.dt_Cadastro = dt_Cadastro;
	}

	public Integer getId_Resp() {
		return id_Resp;
	}

	public void setId_Resp(Integer id_Resp) {
		this.id_Resp = id_Resp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tx_Descricao, tx_Papel, tx_RamoNegocios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Papel other = (Papel) obj;
		return Objects.equals(tx_Descricao, other.tx_Descricao) && Objects.equals(tx_Papel, other.tx_Papel)
				&& Objects.equals(tx_RamoNegocios, other.tx_RamoNegocios);
	}

	@Override
	public String toString() {
		return "Papel [id_Papel=" + id_Papel + ", tx_Papel=" + tx_Papel + ", tx_Descricao=" + tx_Descricao
				+ ", tx_RamoNegocios=" + tx_RamoNegocios + ", dt_Cadastro=" + dt_Cadastro + ", id_Resp=" 
				+ id_Resp + "]";
	}
}