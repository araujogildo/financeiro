package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Papel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id_Papel;
	private String tx_Papel;
	private String tx_Descricao;
	private String tx_Ramo;
	
	public Papel() {
	}

	public Papel(Integer id_Papel, String tx_Papel, String tx_Descricao, String tx_Ramo) {
		this.id_Papel = id_Papel;
		this.tx_Papel = tx_Papel;
		this.tx_Descricao = tx_Descricao;
		this.tx_Ramo = tx_Ramo;
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

	public void setTx_DescrPapel(String tx_Descricao) {
		this.tx_Descricao = tx_Descricao;
	}

	public String getTx_Ramo() {
		return tx_Ramo;
	}

	public void setTx_Ramo(String tx_Ramo) {
		this.tx_Ramo = tx_Ramo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tx_Descricao, tx_Papel, tx_Ramo);
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
				&& Objects.equals(tx_Ramo, other.tx_Ramo);
	}

	@Override
	public String toString() {
		return "Papel [id_Papel=" + id_Papel + ", tx_Papel=" + tx_Papel + ", tx_Descricao=" + tx_Descricao
				+ ", tx_Ramo=" + tx_Ramo + "]";
	}
	
}