package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_access_tbl database table.
 * 
 */
@Entity
@Table(name="role_access_tbl")
public class RoleAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleAccessID;

	private String access;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleID")
	private Role roleTbl;

	public RoleAccess() {
	}

	public int getRoleAccessID() {
		return this.roleAccessID;
	}

	public void setRoleAccessID(int roleAccessID) {
		this.roleAccessID = roleAccessID;
	}

	public String getAccess() {
		return this.access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public Role getRoleTbl() {
		return this.roleTbl;
	}

	public void setRoleTbl(Role roleTbl) {
		this.roleTbl = roleTbl;
	}

}