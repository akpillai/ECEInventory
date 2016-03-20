package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asset_type_tbl database table.
 * 
 */
@Entity
@Table(name="asset_type_tbl")
public class AssetType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int assetTypeId;

	private String assetTypeCode;

	private String title;

	//bi-directional many-to-one association to Items
	@OneToMany(mappedBy="assetTypeTbl")
	private List<Items> itemsTbls;

	public AssetType() {
	}

	public int getAssetTypeId() {
		return this.assetTypeId;
	}

	public void setAssetTypeId(int assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public String getAssetTypeCode() {
		return this.assetTypeCode;
	}

	public void setAssetTypeCode(String assetTypeCode) {
		this.assetTypeCode = assetTypeCode;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Items> getItemsTbls() {
		return this.itemsTbls;
	}

	public void setItemsTbls(List<Items> itemsTbls) {
		this.itemsTbls = itemsTbls;
	}

	public Items addItemsTbl(Items itemsTbl) {
		getItemsTbls().add(itemsTbl);
		itemsTbl.setAssetTypeTbl(this);

		return itemsTbl;
	}

	public Items removeItemsTbl(Items itemsTbl) {
		getItemsTbls().remove(itemsTbl);
		itemsTbl.setAssetTypeTbl(null);

		return itemsTbl;
	}

}