package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the academic_role_tbl database table.
 * 
 */
@Entity
@Table(name="academic_role_tbl")
public class AcademicRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int academicRoleID;

	private String academicRoleName;

	//bi-directional many-to-one association to UserInfo
	@OneToMany(mappedBy="academicRoleTbl")
	private List<UserInfo> userInfoTbls;

	public AcademicRole() {
	}

	public int getAcademicRoleID() {
		return this.academicRoleID;
	}

	public void setAcademicRoleID(int academicRoleID) {
		this.academicRoleID = academicRoleID;
	}

	public String getAcademicRoleName() {
		return this.academicRoleName;
	}

	public void setAcademicRoleName(String academicRoleName) {
		this.academicRoleName = academicRoleName;
	}

	public List<UserInfo> getUserInfoTbls() {
		return this.userInfoTbls;
	}

	public void setUserInfoTbls(List<UserInfo> userInfoTbls) {
		this.userInfoTbls = userInfoTbls;
	}

	public UserInfo addUserInfoTbl(UserInfo userInfoTbl) {
		getUserInfoTbls().add(userInfoTbl);
		userInfoTbl.setAcademicRoleTbl(this);

		return userInfoTbl;
	}

	public UserInfo removeUserInfoTbl(UserInfo userInfoTbl) {
		getUserInfoTbls().remove(userInfoTbl);
		userInfoTbl.setAcademicRoleTbl(null);

		return userInfoTbl;
	}

}