package com.java.emp.assign;

public class Employee 
{
	private int Emp_Id;
	private String Emp_Name;
	private String Emp_Role;
	private String Emp_Add;
	private String Emp_Dept;
	private String Emp_email;
	private double Emp_Sal;
	
	
	public Employee() 
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int emp_Id, String emp_Name, String emp_Role, String emp_Add, String emp_Dept, String emp_email,
			double emp_Sal) 
	{
		super();
		Emp_Id = emp_Id;
		Emp_Name = emp_Name;
		Emp_Role = emp_Role;
		Emp_Add = emp_Add;
		Emp_Dept = emp_Dept;
		Emp_email = emp_email;
		Emp_Sal = emp_Sal;
	}


	public int getEmp_Id()
	{
		return Emp_Id;
	}


	public void setEmp_Id(int emp_Id)
	{
		Emp_Id = emp_Id;
	}


	public String getEmp_Name()
	{
		return Emp_Name;
	}


	public void setEmp_Name(String emp_Name) 
	{
		Emp_Name = emp_Name;
	}


	public String getEmp_Role() 
	{
		return Emp_Role;
	}


	public void setEmp_Role(String emp_Role)
	{
		Emp_Role = emp_Role;
	}


	public String getEmp_Add() 
	{
		return Emp_Add;
	}


	public void setEmp_Add(String emp_Add) 
	{
		Emp_Add = emp_Add;
	}


	public String getEmp_Dept()
	{
		return Emp_Dept;
	}


	public void setEmp_Dept(String emp_Dept)
	{
		Emp_Dept = emp_Dept;
	}


	public String getEmp_email()
	{
		return Emp_email;
	}


	public void setEmp_email(String emp_email) 
	{
		Emp_email = emp_email;
	}


	public double getEmp_Sal() 
	{
		return Emp_Sal;
	}


	public void setEmp_Sal(double emp_Sal) 
	{
		Emp_Sal = emp_Sal;
	}


	@Override
	public String toString() {
		return "\nEmployee [Emp_Id=" + Emp_Id + ", Emp_Name=" + Emp_Name + ", Emp_Role=" + Emp_Role + ", Emp_Add="
				+ Emp_Add + ", Emp_Dept=" + Emp_Dept + ", Emp_email=" + Emp_email + ", Emp_Sal=" + Emp_Sal + "]";
	}

}
	