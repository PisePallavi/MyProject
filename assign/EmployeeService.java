package com.java.emp.assign;

public interface EmployeeService
{
	public String addEmployee(Employee Emp);
	public boolean deleteEmployee(DeleteCriteria criteria,String empId);
	public Employee updateEmployee(int empId ,Employee newValues);
	public Employee[] listEmployee();
	public double agrFunctionsEmployee(AgrFunction function);
	public Employee[] searchEmployee(SearchCriteria type,String val);
	public double salarytorole(String role);
	public Employee[] salaryRange(double sal1, double sal2);
}

enum DeleteCriteria
{
	Id,
	Role
}

enum AgrFunction
{
	Max,
	Min,
	Avg,
	CompnyCost,
}

enum SearchCriteria
{
	Id,
	Role,
	Dept
}