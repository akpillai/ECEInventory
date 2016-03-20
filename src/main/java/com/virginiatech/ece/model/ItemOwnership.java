package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_ownership_tbl database table.
 * 
 */
@Entity
@Table(name="item_ownership_tbl")
public class ItemOwnership implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemOwnerID;

	private String itemOwnerCode;

	private String itemOwnerDescription;

	//bi-directional many-to-one association to Items
	@OneToMany(mappedBy="itemOwnershipTbl")
	private List<Items> itemsTbls;

	public ItemOwnership() {
	}

	public int getItemOwnerID() {
		return this.itemOwnerID;
	}

	public void setItemOwnerID(int itemOwnerID) {
		this.itemOwnerID = itemOwnerID;
	}

	public String getItemOwnerCode() {
		return this.itemOwnerCode;
	}

	public void setItemOwnerCode(String itemOwnerCode) {
		this.itemOwnerCode = itemOwnerCode;
	}

	public String getItemOwnerDescription() {
		return this.itemOwnerDescription;
	}

	public void setItemOwnerDescription(String itemOwnerDescription) {
		this.itemOwnerDescription = itemOwnerDescription;
	}

	public List<Items> getItemsTbls() {
		return this.itemsTbls;
	}

	public void setItemsTbls(List<Items> itemsTbls) {
		this.itemsTbls = itemsTbls;
	}

	public Items addItemsTbl(Items itemsTbl) {
		getItemsTbls().add(itemsTbl);
		itemsTbl.setItemOwnershipTbl(this);

		return itemsTbl;
	}

	public Items removeItemsTbl(Items itemsTbl) {
		getItemsTbls().remove(itemsTbl);
		itemsTbl.setItemOwnershipTbl(null);

		return itemsTbl;
	}

}