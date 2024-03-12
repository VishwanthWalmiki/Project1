package Emp_Mang;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("welcome to employee management Application");
        Scanner scan = new Scanner(System.in);
        EmployeeOperations eo=new EmployeeOperationImpl();
        
        System.out.println("selection the below option to perfrom wanted task \n"
        		+ "1. Add Employee \n"
        		+ "2. Show All Employee \n"
        		+ "3. Show Employee Based on Id \n"
        		+ "4. Update the Employee \n"
        		+ "5. Delete the Employee ");
       
		do {
			 System.out.println("select your choice");
				int n =scan.nextInt();
		switch(n){  
			    //getting input miss match exception
			case 1:
				Employee e=new Employee();
				System.out.println("enter the employee id");
				int id=scan.nextInt();
				System.out.println("enter the employee Name");
				String name=scan.next();
				System.out.println("enter the employee age");
				int age=scan.nextInt();
                System.out.println("enter the employee salary");
				double salary=scan.nextDouble();
				e.setId(id);
				e.setName(name);
				e.setAge(age);
				e.setSalary(salary);
				eo.createEmployee(e);
				break;
			case 2 :
				eo.showAllEmployee();
				break;
			case 3: System.out.println("enter the Employeee id you want to see details");
				int empid=scan.nextInt();
				eo.showEmployeeBasedOnId(empid);
			     break;
			case 4:System.out.println("enter the id of the employee you want to update");
			       int empi=scan.nextInt();
			       System.out.println("enter the new name you want to update");
				   String g=scan.next();
				   eo.updateEmployee(empi,g);
				break;
			case 5: System.out.println("enter th id to delete th employee");
			      int d=scan.nextInt();
			      eo.deleteEmployee(d);
			break;
			default: System.out.println("invalid choice select correct choice");
				break;
			}
			
		}
		while(true);
		
	
}
}
