package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role_tbl database table.
 * 
 */
@Entity
@Table(name="role_tbl")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleID;

	private String roleName;

	//bi-directional many-to-one association to RoleAccess
	@OneToMany(mappedBy="roleTbl")
	private List<RoleAccess> roleAccessTbls;

	//bi-directional many-to-one association to UserInfo
	@OneToMany(mappedBy="roleTbl")
	private List<UserInfo> userInfoTbls;

	public Role() {
	}

	public int getRoleID() {
		return this.roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<RoleAccess> getRoleAccessTbls() {
		return this.roleAccessTbls;
	}

	public void setRoleAccessTbls(List<RoleAccess> roleAccessTbls) {
		this.roleAccessTbls = roleAccessTbls;
	}

	public RoleAccess addRoleAccessTbl(RoleAccess roleAccessTbl) {
		getRoleAccessTbls().add(roleAccessTbl);
		roleAccessTbl.setRoleTbl(this);

		return roleAccessTbl;
	}

	public RoleAccess removeRoleAccessTbl(RoleAccess roleAccessTbl) {
		getRoleAccessTbls().remove(roleAccessTbl);
		roleAccessTbl.setRoleTbl(null);

		return roleAccessTbl;
	}

	public List<UserInfo> getUserInfoTbls() {
		return this.userInfoTbls;
	}

	public void setUserInfoTbls(List<UserInfo> userInfoTbls) {
		this.userInfoTbls = userInfoTbls;
	}

	public UserInfo addUserInfoTbl(UserInfo userInfoTbl) {
		getUserInfoTbls().add(userInfoTbl);
		userInfoTbl.setRoleTbl(this);

		return userInfoTbl;
	}

	public UserInfo removeUserInfoTbl(UserInfo userInfoTbl) {
		getUserInfoTbls().remove(userInfoTbl);
		userInfoTbl.setRoleTbl(null);

		return userInfoTbl;
	}

}