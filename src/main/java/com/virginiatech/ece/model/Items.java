package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the items_tbl database table.
 * 
 */
@Entity
@Table(name="items_tbl")
public class Items implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemID;

	private String activeStatus;

	private String comments;

	private String condition;

	private String description;

	private String designation;

	private String lastInventoryDate;

	private int pTag;

	private String purchaseAmount;

	private String purchaseDate;

	private String purchaseOrder;

	private String schevYear;

	private String serialNumber;

	private String tagType;

	//bi-directional many-to-one association to AssetType
	@ManyToOne
	@JoinColumn(name="assetTypeId")
	private AssetType assetTypeTbl;

	//bi-directional many-to-one association to ItemOwnership
	@ManyToOne
	@JoinColumn(name="ownershipID")
	private ItemOwnership itemOwnershipTbl;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="currentLocationId")
	private Location locationTbl;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="currentCustodianId")
	private User userTbl;

	public Items() {
	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLastInventoryDate() {
		return this.lastInventoryDate;
	}

	public void setLastInventoryDate(String lastInventoryDate) {
		this.lastInventoryDate = lastInventoryDate;
	}

	public int getPTag() {
		return this.pTag;
	}

	public void setPTag(int pTag) {
		this.pTag = pTag;
	}

	public String getPurchaseAmount() {
		return this.purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getSchevYear() {
		return this.schevYear;
	}

	public void setSchevYear(String schevYear) {
		this.schevYear = schevYear;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getTagType() {
		return this.tagType;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

	public AssetType getAssetTypeTbl() {
		return this.assetTypeTbl;
	}

	public void setAssetTypeTbl(AssetType assetTypeTbl) {
		this.assetTypeTbl = assetTypeTbl;
	}

	public ItemOwnership getItemOwnershipTbl() {
		return this.itemOwnershipTbl;
	}

	public void setItemOwnershipTbl(ItemOwnership itemOwnershipTbl) {
		this.itemOwnershipTbl = itemOwnershipTbl;
	}

	public Location getLocationTbl() {
		return this.locationTbl;
	}

	public void setLocationTbl(Location locationTbl) {
		this.locationTbl = locationTbl;
	}

	public User getUserTbl() {
		return this.userTbl;
	}

	public void setUserTbl(User userTbl) {
		this.userTbl = userTbl;
	}

}