package com.yash.ocp.db.model;

import java.io.Serializable;
import java.util.StringJoiner;
import javax.persistence.*;


/**
 * The persistent class for the "Module_Stats" database table.
 * 
 */
@Entity
@Table(name="\"Module_Stats\"")
@NamedQuery(name="Module_Stat.findAll", query="SELECT m FROM ModuleStat m")
public class ModuleStat implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    private long id;
    @Column(name="\"version\"")
    private Integer version;

	@Column(name="\"Config_Map\"")
	private String config_Map;

	@Column(name="\"Cpu_Limit\"")
	private String cpu_Limit;

	@Column(name="\"Release\"")
	private String release;

	@Column(name="\"Cpu_Requests\"")
	private String cpu_Requests;

	@Column(name="\"Dc_Version\"")
	private String dc_Version;

	@Column(name="\"Env_Variables\"")
	private String env_Variables;

	@Column(name="\"Java_Options\"")
	private String java_Options;

	@Column(name="\"Memory_Limit\"")
	private String memory_Limit;

	@Column(name="\"Memory_Requests\"")
	private String memory_Requests;

	@Column(name="\"Module_Name\"")
	private String module_Name;

	@Column(name="\"Replicas\"")
	private int replicas;

	public ModuleStat() {
	}

	public String getConfig_Map() {
		return this.config_Map;
	}

	public void setConfig_Map(String config_Map) {
		this.config_Map = config_Map;
	}

	public String getCpu_Limit() {
		return this.cpu_Limit;
	}

	public void setCpu_Limit(String cpu_Limit) {
		this.cpu_Limit = cpu_Limit;
	}

	public String getCpu_Requests() {
		return this.cpu_Requests;
	}

	public void setCpu_Requests(String cpu_Requests) {
		this.cpu_Requests = cpu_Requests;
	}

	public String getDc_Version() {
		return this.dc_Version;
	}

	public void setDc_Version(String dc_Version) {
		this.dc_Version = dc_Version;
	}

	public String getEnv_Variables() {
		return this.env_Variables;
	}

	public void setEnv_Variables(String env_Variables) {
		this.env_Variables = env_Variables;
	}

	public String getJava_Options() {
		return this.java_Options;
	}

	public void setJava_Options(String java_Options) {
		this.java_Options = java_Options;
	}

	public String getMemory_Limit() {
		return this.memory_Limit;
	}

	public void setMemory_Limit(String memory_Limit) {
		this.memory_Limit = memory_Limit;
	}

	public String getMemory_Requests() {
		return this.memory_Requests;
	}

	public void setMemory_Requests(String memory_Requests) {
		this.memory_Requests = memory_Requests;
	}

	public String getModule_Name() {
		return this.module_Name;
	}

	public void setModule_Name(String module_Name) {
		this.module_Name = module_Name;
	}

	public int getReplicas() {
		return this.replicas;
	}

	public void setReplicas(int replicas) {
		this.replicas = replicas;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return new StringJoiner(", ", ModuleStat.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("version=" + version)
				.add("config_Map='" + config_Map + "'")
				.add("cpu_Limit='" + cpu_Limit + "'")
				.add("release='" + release + "'")
				.add("cpu_Requests='" + cpu_Requests + "'")
				.add("dc_Version='" + dc_Version + "'")
				.add("env_Variables='" + env_Variables + "'")
				.add("java_Options='" + java_Options + "'")
				.add("memory_Limit='" + memory_Limit + "'")
				.add("memory_Requests='" + memory_Requests + "'")
				.add("module_Name='" + module_Name + "'")
				.add("replicas=" + replicas)
				.toString();
	}
}