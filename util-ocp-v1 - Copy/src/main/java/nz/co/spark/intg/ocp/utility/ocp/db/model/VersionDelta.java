package nz.co.spark.intg.ocp.utility.ocp.db.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Version_Delta" database table.
 * 
 */
@Entity
@Table(name="\"Version_Delta\"")
@NamedQuery(name="Version_Delta.findAll", query="SELECT v FROM VersionDelta v")
public class VersionDelta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer version;

	@Lob
	@Column(name="\"Difference_Report\"")
	private Object difference_Report;

	@Column(name="\"Type\"")
	private int type;

	public VersionDelta() {

	}

	public Object getDifference_Report() {
		return this.difference_Report;
	}

	public void setDifference_Report(Object difference_Report) {
		this.difference_Report = difference_Report;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}