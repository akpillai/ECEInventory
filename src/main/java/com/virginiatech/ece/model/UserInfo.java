package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_info_tbl database table.
 * 
 */
@Entity
@Table(name="user_info_tbl")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userInfoID;

	private String email;

	private String firstName;

	private String lastName;

	//bi-directional many-to-one association to AcademicRole
	@ManyToOne
	@JoinColumn(name="academicRoleID")
	private AcademicRole academicRoleTbl;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleID")
	private Role roleTbl;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID")
	private User userTbl;

	public UserInfo() {
	}

	public int getUserInfoID() {
		return this.userInfoID;
	}

	public void setUserInfoID(int userInfoID) {
		this.userInfoID = userInfoID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AcademicRole getAcademicRoleTbl() {
		return this.academicRoleTbl;
	}

	public void setAcademicRoleTbl(AcademicRole academicRoleTbl) {
		this.academicRoleTbl = academicRoleTbl;
	}

	public Role getRoleTbl() {
		return this.roleTbl;
	}

	public void setRoleTbl(Role roleTbl) {
		this.roleTbl = roleTbl;
	}

	public User getUserTbl() {
		return this.userTbl;
	}

	public void setUserTbl(User userTbl) {
		this.userTbl = userTbl;
	}

}