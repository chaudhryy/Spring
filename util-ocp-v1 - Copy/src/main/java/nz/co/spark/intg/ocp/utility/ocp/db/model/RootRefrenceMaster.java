package nz.co.spark.intg.ocp.utility.ocp.db.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Root_Refrence_Master" database table.
 * 
 */
@Entity
@Table(name="\"Root_Refrence_Master\"")
@NamedQuery(name="Root_Refrence_Master.findAll", query="SELECT r FROM RootRefrenceMaster r")
public class RootRefrenceMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	public RootRefrenceMaster(int id){
		this.version=id;
	}


	@Id
	private Integer version;

	@Column(name="\"Created\"")
	private String created;

	@Column(name="\"Enviornment\"")
	private String enviornment;

	public RootRefrenceMaster() {
	}

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEnviornment() {
		return this.enviornment;
	}

	public void setEnviornment(String enviornment) {
		this.enviornment = enviornment;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}