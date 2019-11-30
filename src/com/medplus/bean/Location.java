package com.medplus.bean;

public class Location {
	private double lattitude;
	public Location(String storename, String place, double distance) {
		super();
		this.storename = storename;
		this.place = place;
		this.distance = distance;
	}
	private double longitude;
	private String storename;
	public String getStorename() {
		return storename;
	}


	public void setStorename(String storename) {
		this.storename = storename;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}
	private String place;
	private double distance;

	
	public double getLattitude() {
		return lattitude;
	}


	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	
	public Location(double lattitude, double longitude) {
		super();
		this.lattitude = lattitude;
		this.longitude = longitude;
	}
	
}


	
	
	