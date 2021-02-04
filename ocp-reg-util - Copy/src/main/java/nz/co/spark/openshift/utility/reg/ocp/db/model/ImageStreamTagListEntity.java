package nz.co.spark.openshift.utility.reg.ocp.db.model;

import java.io.Serializable;
import java.util.StringJoiner;
import javax.persistence.*;


/**
 * The persistent class for the "Module_Route_Info" database table.
 *
 */
@Entity
@Table(name="\"ImageStreamTagListEntity\"")
@NamedQuery(name="ImageStreamTagListEntity.findAll", query="SELECT m FROM ImageStreamTagListEntity m")
public class ImageStreamTagListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    @Column(name="\"Name\"")
	private String name;

    @Column(name="\"Image\"")
    private String image;


	@Column(name="\"CreationTimeStamp\"")
	private String creationTimeStamp;

	@Id
	@Column(name="\"Id\"")
	private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(String creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ImageStreamTagListEntity.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("image='" + image + "'")
                .add("creationTimeStamp='" + creationTimeStamp + "'")
                .add("id=" + id)
                .toString();
    }
}