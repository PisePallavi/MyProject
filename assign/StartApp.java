package com.java.emp.assign;

import java.util.Arrays;
import java.util.Scanner;

import com.assignement.Employee;

import myAssignment.newEmp;

public class StartApp {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		EmplServiceImpl service = new EmplServiceImpl();
		while(true)
		{
			
		System.out.println("\n----------------------------------------------Starting the Application-------------------------------------------------------------");
		System.out.println(""
				+ "1. Add Employee \n" //done
				+ "2. Delete Employee \n"//done
				+ "3. Update Employee \n"//done
				+ "4. Search Employee \n"//done
				+ "5. List Employee \n" //done
				+ "6. Aggrigate Function\n"//done
				+ "8. Salary to Particular Role\n"//done
				+ "9. Find Employees From Salary\n"
				+ "7. Exit\n"//done
				+ "");
		
		int choice =0;
		try
		{
		System.out.println("Enter your Choice :");
		choice = Integer.parseInt(sc.next());
		}
		catch (NumberFormatException e)
		{
			System.out.println(".....Invalid Choice.....");
			// TODO: handle exception
		}
		switch (choice)
			{
				case 1:
					try
					{
						System.out.println("Enter Employee Id :");
						int eid = Integer.parseInt(sc.next());
						System.out.println("Enter Employee Name :");
						String nm = sc.next();
						System.out.println("Enter Employee Role :");
						String role = sc.next();
						System.out.println("Enter Employee Address :");
						String add =sc.next();
						System.out.println("Enter Employee Department :");
						String dept = sc.next();
						System.out.println("Enter Employee Email :");
						String email = sc.next();
						System.out.println("Enter Employee Salary :");
						double sal = sc.nextDouble();
						
						com.java.emp.assign.Employee employee = new com.java.emp.assign.Employee(eid, nm, role, add, dept, email, sal);
						service.addEmployee(employee);
						
					}
					catch (NumberFormatException e)
					{
						// TODO: handle exception
						System.out.println("Enter Valid Inputs");
					}
					catch (Exception e) 
					{
						System.out.println("Invalid Inputs");
						// TODO: handle exception
					}
					
					break;
		
				case 2:
					int cnt2 = 1;
					for (DeleteCriteria val : DeleteCriteria.values()) 
					{
						System.out.println(cnt2 +" . " + val);
						cnt2++;
					}
					System.out.println("Select Your Choice For Delete  : ");
					
					int ch1 = Integer.parseInt(sc.next());
					
					switch (ch1) 
					{
						case 1:
							System.out.println("Enter Employee Id for Delete : ");
							int delId = Integer.parseInt(sc.next());
							service.deleteEmployee(DeleteCriteria.Id, delId+"");
							break;
						case 2:
							System.out.println("Enter Employee Role for Delete : ");
							String rl = sc.next();
							service.deleteEmployee(DeleteCriteria.Role, rl);
							break;
		
						default:
							break;
					}
					break;
		
				case 3:
					System.out.println("....Update Employee....");
					try
					{
						System.out.println("Enter Employee Id for update..");
						int upeid = Integer.parseInt(sc.next());
						
						if(service.IsEmployeeExist(upeid))
						{
							System.out.println("Enter Employee Name to be updated");
							String upnm = sc.next();
							System.out.println("Enter Employee Role to be updated :");
							String uprole = sc.next();
							System.out.println("Enter Employee Address to be updated:");
							String upadd =sc.next();
							System.out.println("Enter Employee Department to be updated:");
							String updept = sc.next();
							System.out.println("Enter Employee Email to be updated:");
							String upemail = sc.next();
							System.out.println("Enter Employee Salary to updated:");
							double upsal = sc.nextDouble();
							com.java.emp.assign.Employee upemp = new com.java.emp.assign.Employee(upeid, upnm, uprole,upadd, updept, upemail,upsal);					
							service.updateEmployee(upeid, upemp);
						}
						else
						{
							System.out.println("Employee not found:");
						}
					}
					catch (Exception e)
					{
						System.out.println("Invalid ID..");
						// TODO: handle exception
					}
					break;
			
				case 4:
						int cnt = 1;
						for (SearchCriteria search : SearchCriteria.values())
						{
							System.out.println(cnt +" . " + search);
							cnt++;  
						}
						System.out.println("Select Search Type :");
						int searchtype = Integer.parseInt(sc.next());
						com.java.emp.assign.Employee []tempEmployee = null;
						
						switch (searchtype) 
						{
						case 1:
							System.out.println("Enter Employee Id for Search :");
							int seid = Integer.parseInt(sc.next());
							tempEmployee = service.searchEmployee(SearchCriteria.Id, seid+"");
							break;
							
						case 2:
							System.out.println("Enter Employee Role for Search :");
							String srole = sc.next();
							tempEmployee = service.searchEmployee(SearchCriteria.Role, srole);
							break;
							
						case 3:
							System.out.println("Enter Employee Department for Search :");
							String sdept = sc.next();
							tempEmployee = service.searchEmployee(SearchCriteria.Dept, sdept);
							break;

						default:
							break;
						}
						
						if( tempEmployee.length>=1) {
							System.out.println(Arrays.toString(tempEmployee));
						}else {
							System.out.println("No Employee with Given Criteria..");
						}
						break;
			
				case 5:
					System.out.println("----List of All Employee is----");
					com.java.emp.assign.Employee[]emp = service.listEmployee();
					System.out.println(Arrays.toString(emp));
					break;
			
				case 6:
					int cnt6 = 1;
					for (AgrFunction fn : AgrFunction.values()) 
					{
						System.out.println(cnt6 + ":" + fn);
						cnt6++;
					}
					try
					{
					System.out.println("\nSelect Aggreagte Function ");
					int aggfn = Integer.parseInt(sc.next());
					double result = 0;
					
					switch (aggfn)
					{
					case 1:
						result = service.agrFunctionsEmployee(AgrFunction.Max);
						System.out.println("Maximum Salary of Employee is : " +result);
						break;
					case 2:
						result = service.agrFunctionsEmployee(AgrFunction.Min);
						System.out.println("Minimum Salary of Employee is : " +result);
						break;
					case 3:
						result =service.agrFunctionsEmployee(AgrFunction.Avg);
						System.out.println("Avarage Salary Of Employee is : " +result);
						break;
					case 4:
						result =service.agrFunctionsEmployee(AgrFunction.CompnyCost);
						System.out.println("CompnyCost Is : " +result);
						break;

					default:
						System.out.println("Invalid Choice");
						break;
					}
					
					
					}
					catch (NumberFormatException e) 
					{
						System.out.println("Enter Valid choice for Aggregate Function");
						// TODO: handle exception
					}
					break;
				case 7:
					System.out.println("------------------------------------------------Stopping the Application-------------------------------------------------------------");
					System.exit(0);
					break;

				case 8:
					System.out.println("\n Finding Salary to Role");
					System.out.println("Enter Employee Role");
					String role = sc.next();
					if(service.IsRoleExist(role))
					{
					System.out.println(role + ":" + service.salarytorole(role));
					}
					else
					{
						System.out.println("Entered role is invalid");
					}
					break;
					
					case 9:
						System.out.println("\n....Finding Employees From Salary Range....");
						
						System.out.println("Enter From Salary");
						double frmsal = sc.nextDouble();
						System.out.println("Enter to Salary");
						double tosal = sc.nextDouble();
						com.java.emp.assign.Employee[]Rangesal = service.salaryRange(frmsal, tosal);
						if(Rangesal!=null)
						{
						System.out.println(Arrays.toString(service.salaryRange(frmsal, tosal)));
						}
						else 
						{
							System.out.println("Employees Not Exist For Given Salary Range");
						}
						
						break;
					
				default:
					break;
			}
		}
	}

}
