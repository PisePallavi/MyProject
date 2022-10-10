package com.java.emp.assign;

import java.util.Arrays;
import java.util.Iterator;

public class EmplServiceImpl implements EmployeeService
{
	static Employee []empArray = new Employee[0];
	static int counter = 0;

	static
	{
		empArray  = new Employee[5];
		empArray[counter++] = new Employee(101,"Pallavi", "Developer", "Pune", "Computer", "p@gmail.com",500.00);
		empArray[counter++] = new Employee(102,"Tushar", "Tester", "Kolhapur", "Electronic", "t@gmail.com",400.00);
		empArray[counter++] = new Employee(103,"Tanvi", "Developer", "Sangli", "Mechnical", "ta@gmail.com",500.00);
		empArray[counter++] = new Employee(104,"Prasad", "TeamLeader", "Mumbai", "Computer", "pr@gmail.com",900.00);
		empArray[counter++] = new Employee(105,"Tanu", "ProjectLeader", "Pune", "Biotech", "tanu@gmail.com",800.00);
	}
	
	
	@Override
	public String addEmployee(Employee Emp) 
	{
		// TODO Auto-generated method stub
		if(Emp!=null)
		{
			for (Employee employee : empArray) 
			{
				if (employee!=null &&employee.getEmp_Id()==Emp.getEmp_Id())
				{
					System.out.println("....Duplicate Employee....");
					return "...Duplicate Employee...";
				}
			}
			empArray = Arrays.copyOf(empArray, empArray.length+1);
			empArray[counter++] = Emp;
			System.out.println("....Employee Added....");
		}
		
		System.out.println("....Problem In Adding Employee....");
		return "Problem In Adding Employee";
	}
	
	@Override
	public boolean deleteEmployee(DeleteCriteria criteria, String empId) 
	{
		Employee temp[] = new Employee[0];
		int index = 0;					
		boolean flag = false;
		
		switch (criteria)
		{
			case Id:
				for (Employee employee : empArray) 
				{
					if(employee!=null&&employee.getEmp_Id()==Integer.parseInt(empId))
					{
						flag = true;
						System.out.println("...Employee Deleted...");
						continue;
					}
					else
					{
						temp = Arrays.copyOf(temp, temp.length+1);
						temp[index++]=employee;
					}
					
				}
				if(!flag)
				{
				System.out.println("...Employee Not Found...");
				}
				break;
				
			case Role:
				for (Employee employee : empArray) 
				{
					if(employee!=null && employee.getEmp_Role().equals(empId))
					{
							flag = true;
							continue;
					}
					else
					{
						temp = Arrays.copyOf(temp, temp.length+1);
						System.out.println("...Employee Deleted...");
						temp[index++] = employee;
					}
				}
				System.out.println("...Employee Not Found...");
				break;
			default:
				break;
		}
		
		if(flag) {
			empArray = temp;
			counter = index;
		}
		
		return false;
	}

	@Override
	public Employee updateEmployee(int empId, Employee newValues)
	{
		// TODO Auto-generated method stub
		for (Employee employee : empArray)
		{
			if(employee!=null && employee.getEmp_Id()==empId)
			{	
				employee.setEmp_Id(newValues.getEmp_Id());
				employee.setEmp_Name(newValues.getEmp_Name());
				employee.setEmp_Add(newValues.getEmp_Add());
				employee.setEmp_Role(newValues.getEmp_Role());
				employee.setEmp_Dept(newValues.getEmp_Dept());
				employee.setEmp_email(newValues.getEmp_email());
				employee.setEmp_Sal(newValues.getEmp_Sal());
				System.out.println("Employee Updated Suceessfully...");
				return employee;
			}
		}
		return null;
	}

	public boolean IsEmployeeExist(int empId)
	{
		boolean EmployeeExist = false;
		
		for (Employee employee : empArray)
		{
			if(employee!=null && employee.getEmp_Id()==empId)
			{
				EmployeeExist = true;
			}
		}		
		return EmployeeExist;
	}
	
	@Override
	public Employee[] listEmployee() 
	{
		// TODO Auto-generated method stub
		return empArray;
	}

	@Override
	public double agrFunctionsEmployee(AgrFunction function)
	{
		// TODO Auto-generated method stub
		double result = 0.0;
		int actualLength = 0;
		for (Employee employee : empArray)
		{
			if(employee!=null)
			{
				actualLength++;
			}
		}
		if(empArray!=null && empArray.length>0)
		{
			switch (function) 
			{
			case Avg:
				double tsum = 0.0;
				for (Employee employee : empArray)
				{
					if(employee!=null) 
					{
						tsum += employee.getEmp_Sal();
						//tsum = tsum + product.getProdPrice();
					}
				}
				result = tsum/actualLength;
				break;
				
			case Max:
				double maxsal = 0.0;
				
				for (Employee employee : empArray)
				{
					if(employee!=null && employee.getEmp_Sal()>maxsal)
					{
						maxsal=employee.getEmp_Sal();
					}
				}
				result=maxsal;
				break;
				
			case Min:
				double minsal = empArray[0].getEmp_Sal();
				for (Employee employee : empArray)
				{
					if (employee!=null && employee.getEmp_Sal()<=minsal)
					{
						minsal = employee.getEmp_Sal();
					}
				}
				result=minsal;
				break;
			}
		}
		
		return result;
	}

	@Override
	public Employee[] searchEmployee(SearchCriteria type, String val)
	{
		// TODO Auto-generated method stub
		System.out.println("Search Type is " +type+ ":" +val);
		Employee []temEmp = new Employee[0];
		int index =0;
		
		if(empArray!=null && empArray.length>0)
		{
			switch (type) 
			{
			case Id:
				for (Employee employee : empArray)
				{
					if(employee!=null && employee.getEmp_Id()==Integer.parseInt(val))
					{
						temEmp = Arrays.copyOf(temEmp, temEmp.length+1);
						temEmp[index++]=employee;
						break;
					}
				}
				break;
				
			case Role:
				for (Employee employee : empArray)
				{
					if(employee!=null && employee.getEmp_Role().equals(val))
					{
						temEmp = Arrays.copyOf(temEmp, temEmp.length+1);
						temEmp[index++]=employee;
						
					}
				}
				
				break;
				
			case Dept:
	
				for (Employee employee : empArray)
				{
					if(employee!=null && employee.getEmp_Dept().equals(val))
					{
						temEmp = Arrays.copyOf(temEmp, temEmp.length+1);
						temEmp[index++]=employee;
						
					}
				}
				break;

			default:
				break;
			}
		}
		
 		
		return temEmp;
	}

	@Override
	public double salarytorole(String role) 
	{
		// TODO Auto-generated method stub
		double empsal=0.0;
		for (Employee employee : empArray) 
		{
			if(employee!=null && employee.getEmp_Role().toUpperCase().equals(role.toUpperCase()))
			{
				empsal = employee.getEmp_Sal();
				return empsal;
			}
		}
		return empsal;
	}
	
	public boolean IsRoleExist(String role)
	{
		boolean RoleExist = false;
		
		for (Employee employee : empArray) 
		{
			if(employee!=null && employee.getEmp_Role().toUpperCase().equals(role.toUpperCase()))
			{
				RoleExist = true;
			}
		}
		return RoleExist;
	}

	@Override
	public Employee[] salaryRange(double fromsal1, double tosal2)
	{
		Employee []temp = new Employee[0];
		int index=0;
		boolean IsEmpExistForRange = false;
		for (Employee employee : empArray) 
		{
			if (employee!=null && employee.getEmp_Sal()>=fromsal1 && employee.getEmp_Sal()<=tosal2)
			{
				IsEmpExistForRange = true;
				temp = Arrays.copyOf(temp, temp.length+1);
				temp[index++]=employee;
			}
		}
		// TODO Auto-generated method stub
		if(IsEmpExistForRange)
		{
		return temp;
		}
		else
			return null;
	}

}
