package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_tbl database table.
 * 
 */
@Entity
@Table(name="user_tbl")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	private int hokieId;

	private String nameInBanner;

	private String pid;

	//bi-directional many-to-one association to Items
	@OneToMany(mappedBy="userTbl")
	private List<Items> itemsTbls;

	//bi-directional many-to-one association to UserInfo
	@OneToMany(mappedBy="userTbl")
	private List<UserInfo> userInfoTbls;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getHokieId() {
		return this.hokieId;
	}

	public void setHokieId(int hokieId) {
		this.hokieId = hokieId;
	}

	public String getNameInBanner() {
		return this.nameInBanner;
	}

	public void setNameInBanner(String nameInBanner) {
		this.nameInBanner = nameInBanner;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public List<Items> getItemsTbls() {
		return this.itemsTbls;
	}

	public void setItemsTbls(List<Items> itemsTbls) {
		this.itemsTbls = itemsTbls;
	}

	public Items addItemsTbl(Items itemsTbl) {
		getItemsTbls().add(itemsTbl);
		itemsTbl.setUserTbl(this);

		return itemsTbl;
	}

	public Items removeItemsTbl(Items itemsTbl) {
		getItemsTbls().remove(itemsTbl);
		itemsTbl.setUserTbl(null);

		return itemsTbl;
	}

	public List<UserInfo> getUserInfoTbls() {
		return this.userInfoTbls;
	}

	public void setUserInfoTbls(List<UserInfo> userInfoTbls) {
		this.userInfoTbls = userInfoTbls;
	}

	public UserInfo addUserInfoTbl(UserInfo userInfoTbl) {
		getUserInfoTbls().add(userInfoTbl);
		userInfoTbl.setUserTbl(this);

		return userInfoTbl;
	}

	public UserInfo removeUserInfoTbl(UserInfo userInfoTbl) {
		getUserInfoTbls().remove(userInfoTbl);
		userInfoTbl.setUserTbl(null);

		return userInfoTbl;
	}

}