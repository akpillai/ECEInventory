package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_manufacturer_tbl database table.
 * 
 */
@Entity
@Table(name="item_manufacturer_tbl")
public class ItemManufacturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemManufacturerID;

	private String itemManufacturerName;

	public ItemManufacturer() {
	}

	public int getItemManufacturerID() {
		return this.itemManufacturerID;
	}

	public void setItemManufacturerID(int itemManufacturerID) {
		this.itemManufacturerID = itemManufacturerID;
	}

	public String getItemManufacturerName() {
		return this.itemManufacturerName;
	}

	public void setItemManufacturerName(String itemManufacturerName) {
		this.itemManufacturerName = itemManufacturerName;
	}

}