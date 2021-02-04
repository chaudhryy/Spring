package nz.co.spark.openshift.utility.reg.ocp.db.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Module_Route_Info" database table.
 *
 */
@Entity
@Table(name="\"FuseImageBackupEntity\"")
@NamedQuery(name="FuseImageBackupEntity.findAll", query="SELECT m FROM FuseImageBackupEntity m")
public class FuseImageBackupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    @Column(name="\"Module\"")
	private String module;

    @Column(name="\"Image\"")
    private String image;


	@Column(name="\"Enviornment\"")
	private String enviornment;

	@Column(name="\"Created\"")
	private String creted;

	@Id
	@Column(name="\"Id\"")
	private long id;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getEnviornment() {
        return enviornment;
    }

    public void setEnviornment(String enviornment) {
        this.enviornment = enviornment;
    }

    public String getCreted() {
        return creted;
    }

    public void setCreted(String creted) {
        this.creted = creted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}