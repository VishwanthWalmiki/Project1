package Emp_Mang;

public interface EmployeeOperations {
	// CRUD Operations
	
	public void createEmployee(Employee emp);
	public void showAllEmployee();
	public void showEmployeeBasedOnId(int id);
	public void updateEmployee(int id,String name);
	public void deleteEmployee(int id);
	
}
