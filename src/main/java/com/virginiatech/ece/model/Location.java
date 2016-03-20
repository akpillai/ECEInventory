package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location_tbl database table.
 * 
 */
@Entity
@Table(name="location_tbl")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int locationID;

	private String active;

	private String address;

	private String building;

	private String locationName;

	private String room;

	//bi-directional many-to-one association to Items
	@OneToMany(mappedBy="locationTbl")
	private List<Items> itemsTbls;

	public Location() {
	}

	public int getLocationID() {
		return this.locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public List<Items> getItemsTbls() {
		return this.itemsTbls;
	}

	public void setItemsTbls(List<Items> itemsTbls) {
		this.itemsTbls = itemsTbls;
	}

	public Items addItemsTbl(Items itemsTbl) {
		getItemsTbls().add(itemsTbl);
		itemsTbl.setLocationTbl(this);

		return itemsTbl;
	}

	public Items removeItemsTbl(Items itemsTbl) {
		getItemsTbls().remove(itemsTbl);
		itemsTbl.setLocationTbl(null);

		return itemsTbl;
	}

}