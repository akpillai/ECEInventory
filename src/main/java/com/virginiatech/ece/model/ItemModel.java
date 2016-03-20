package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_model_tbl database table.
 * 
 */
@Entity
@Table(name="item_model_tbl")
public class ItemModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemModelID;

	private String itemModelName;

	public ItemModel() {
	}

	public int getItemModelID() {
		return this.itemModelID;
	}

	public void setItemModelID(int itemModelID) {
		this.itemModelID = itemModelID;
	}

	public String getItemModelName() {
		return this.itemModelName;
	}

	public void setItemModelName(String itemModelName) {
		this.itemModelName = itemModelName;
	}

}