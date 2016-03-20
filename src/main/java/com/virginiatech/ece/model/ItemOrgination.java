package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_orgination_tbl database table.
 * 
 */
@Entity
@Table(name="item_orgination_tbl")
public class ItemOrgination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemOrignCode;

	private String itemOrignTitle;

	public ItemOrgination() {
	}

	public int getItemOrignCode() {
		return this.itemOrignCode;
	}

	public void setItemOrignCode(int itemOrignCode) {
		this.itemOrignCode = itemOrignCode;
	}

	public String getItemOrignTitle() {
		return this.itemOrignTitle;
	}

	public void setItemOrignTitle(String itemOrignTitle) {
		this.itemOrignTitle = itemOrignTitle;
	}

}