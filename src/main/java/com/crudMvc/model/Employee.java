package com.crudMvc.model;

public class Employee 
{
	private int empId;
	private String empFirstName;
	private String empLastName;
	private String empMobile;
	private int empSalary;
	private String empEmail;
	private String empAddress;
	public Employee() {
		super();
	}
	
	public Employee(String empFirstName, String empLastName, String empMobile, int empSalary, String empEmail,
			String empAddress) {
		super();
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empMobile = empMobile;
		this.empSalary = empSalary;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
	}

	public Employee(int empId, String empFirstName, String empLastName, String empMobile, int empSalary,
			String empEmail, String empAddress) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empMobile = empMobile;
		this.empSalary = empSalary;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	
	
}
