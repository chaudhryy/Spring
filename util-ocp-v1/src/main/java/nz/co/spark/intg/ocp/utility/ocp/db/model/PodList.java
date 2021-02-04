package nz.co.spark.intg.ocp.utility.ocp.db.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Pod_List" database table.
 * 
 */
@Entity
@Table(name="\"Pod_List\"")
@NamedQuery(name="Pod_List.findAll", query="SELECT p FROM PodList p")
public class PodList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"Created\"")
	private String created;

	@Id
	@Column(name="\"Id\"")
	private int id;

	@Column(name="\"Module_Name\"")
	private String module_Name;

	@Column(name="\"Pod_Name\"")
	private String pod_Name;

	@Column(name="\"Release\"")
	private String release;

	@Column(name="\"Version\"")
	private int version;

	public PodList() {
	}

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModule_Name() {
		return this.module_Name;
	}

	public void setModule_Name(String module_Name) {
		this.module_Name = module_Name;
	}

	public String getPod_Name() {
		return this.pod_Name;
	}

	public void setPod_Name(String pod_Name) {
		this.pod_Name = pod_Name;
	}

	public String getRelease() {
		return this.release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}