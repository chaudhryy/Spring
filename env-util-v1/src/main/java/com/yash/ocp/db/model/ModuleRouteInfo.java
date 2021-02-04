package com.yash.ocp.db.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Module_Route_Info" database table.
 * 
 */
@Entity
@Table(name="\"Module_Route_Info\"")
@NamedQuery(name="Module_Route_Info.findAll", query="SELECT m FROM ModuleRouteInfo m")
public class ModuleRouteInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"host\"")
	private String host;

	@Column(name="\"HaProxyTimeout\"")
	private String haProxyTimeout;

	@Column(name="\"port\"")
	private String port;

	@Id
	@Column(name="\"id\"")
	private int id;

	@Column(name="\"Module_Name\"")
	private String module_Name;

	@Column(name="\"Type\"")
	private String type;

	@Column(name="\"Url\"")
	private String url;

	@Column(name="\"Version\"")
	private int version;

	public ModuleRouteInfo() {
	}

	public String getHaProxyTimeout() {
		return this.haProxyTimeout;
	}

	public void setHaProxyTimeout(String haProxyTimeout) {
		this.haProxyTimeout = haProxyTimeout;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}