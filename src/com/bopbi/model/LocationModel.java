package com.bopbi.model;

public class LocationModel {
	private String name;
	private String description;
	private String location;
	private float[] latlng;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float[] getLatlng() {
		return latlng;
	}
	public void setLatlng(float[] latlng) {
		this.latlng = latlng;
	}
}
