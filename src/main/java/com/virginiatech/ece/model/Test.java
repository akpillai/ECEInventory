package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	private String col_Acq_Date;

	private String col_Amt;

	private String col_Asset_Type;

	private String col_Atyp_Title;

	private String col_Bldg;

	private String col_Condition_State;

	private String col_Custodian;

	private String col_Description;

	private String col_Designation;

	@Column(name="col_extra_1")
	private String colExtra1;

	private String col_Last_Inv_Date;

	private String col_Manufacturer;

	private String col_Model;

	private String col_Orgn_Code;

	private String col_Orgn_Title;

	private String col_Owner;

	private String col_Ownership;

	private String col_PO;

	@Id
	private String col_Ptag;

	private String col_Room;

	private String col_Schev_Year;

	private String col_Serial_Number;

	private String col_Sort_Room;

	private String col_Tag_Type;

	public Test() {
	}

	public String getCol_Acq_Date() {
		return this.col_Acq_Date;
	}

	public void setCol_Acq_Date(String col_Acq_Date) {
		this.col_Acq_Date = col_Acq_Date;
	}

	public String getCol_Amt() {
		return this.col_Amt;
	}

	public void setCol_Amt(String col_Amt) {
		this.col_Amt = col_Amt;
	}

	public String getCol_Asset_Type() {
		return this.col_Asset_Type;
	}

	public void setCol_Asset_Type(String col_Asset_Type) {
		this.col_Asset_Type = col_Asset_Type;
	}

	public String getCol_Atyp_Title() {
		return this.col_Atyp_Title;
	}

	public void setCol_Atyp_Title(String col_Atyp_Title) {
		this.col_Atyp_Title = col_Atyp_Title;
	}

	public String getCol_Bldg() {
		return this.col_Bldg;
	}

	public void setCol_Bldg(String col_Bldg) {
		this.col_Bldg = col_Bldg;
	}

	public String getCol_Condition_State() {
		return this.col_Condition_State;
	}

	public void setCol_Condition_State(String col_Condition_State) {
		this.col_Condition_State = col_Condition_State;
	}

	public String getCol_Custodian() {
		return this.col_Custodian;
	}

	public void setCol_Custodian(String col_Custodian) {
		this.col_Custodian = col_Custodian;
	}

	public String getCol_Description() {
		return this.col_Description;
	}

	public void setCol_Description(String col_Description) {
		this.col_Description = col_Description;
	}

	public String getCol_Designation() {
		return this.col_Designation;
	}

	public void setCol_Designation(String col_Designation) {
		this.col_Designation = col_Designation;
	}

	public String getColExtra1() {
		return this.colExtra1;
	}

	public void setColExtra1(String colExtra1) {
		this.colExtra1 = colExtra1;
	}

	public String getCol_Last_Inv_Date() {
		return this.col_Last_Inv_Date;
	}

	public void setCol_Last_Inv_Date(String col_Last_Inv_Date) {
		this.col_Last_Inv_Date = col_Last_Inv_Date;
	}

	public String getCol_Manufacturer() {
		return this.col_Manufacturer;
	}

	public void setCol_Manufacturer(String col_Manufacturer) {
		this.col_Manufacturer = col_Manufacturer;
	}

	public String getCol_Model() {
		return this.col_Model;
	}

	public void setCol_Model(String col_Model) {
		this.col_Model = col_Model;
	}

	public String getCol_Orgn_Code() {
		return this.col_Orgn_Code;
	}

	public void setCol_Orgn_Code(String col_Orgn_Code) {
		this.col_Orgn_Code = col_Orgn_Code;
	}

	public String getCol_Orgn_Title() {
		return this.col_Orgn_Title;
	}

	public void setCol_Orgn_Title(String col_Orgn_Title) {
		this.col_Orgn_Title = col_Orgn_Title;
	}

	public String getCol_Owner() {
		return this.col_Owner;
	}

	public void setCol_Owner(String col_Owner) {
		this.col_Owner = col_Owner;
	}

	public String getCol_Ownership() {
		return this.col_Ownership;
	}

	public void setCol_Ownership(String col_Ownership) {
		this.col_Ownership = col_Ownership;
	}

	public String getCol_PO() {
		return this.col_PO;
	}

	public void setCol_PO(String col_PO) {
		this.col_PO = col_PO;
	}

	public String getCol_Ptag() {
		return this.col_Ptag;
	}

	public void setCol_Ptag(String col_Ptag) {
		this.col_Ptag = col_Ptag;
	}

	public String getCol_Room() {
		return this.col_Room;
	}

	public void setCol_Room(String col_Room) {
		this.col_Room = col_Room;
	}

	public String getCol_Schev_Year() {
		return this.col_Schev_Year;
	}

	public void setCol_Schev_Year(String col_Schev_Year) {
		this.col_Schev_Year = col_Schev_Year;
	}

	public String getCol_Serial_Number() {
		return this.col_Serial_Number;
	}

	public void setCol_Serial_Number(String col_Serial_Number) {
		this.col_Serial_Number = col_Serial_Number;
	}

	public String getCol_Sort_Room() {
		return this.col_Sort_Room;
	}

	public void setCol_Sort_Room(String col_Sort_Room) {
		this.col_Sort_Room = col_Sort_Room;
	}

	public String getCol_Tag_Type() {
		return this.col_Tag_Type;
	}

	public void setCol_Tag_Type(String col_Tag_Type) {
		this.col_Tag_Type = col_Tag_Type;
	}

}