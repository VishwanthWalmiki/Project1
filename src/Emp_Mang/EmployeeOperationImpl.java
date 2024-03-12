package Emp_Mang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class EmployeeOperationImpl implements EmployeeOperations {
    Connection con;
	@Override
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		con=DbConnector.CreateDbConnection();
		String query="insert into employee values(?,?,?,?)";
		try {
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1, emp.getId());
			psmt.setString(2,emp.getName() );
			psmt.setDouble(3, emp.getSalary());
			psmt.setInt(4, emp.getAge());
			
			int cnt=psmt.executeUpdate();
			if(cnt>0) {
				System.out.println("emp details updated successfully");
				}
			else {
				System.out.println("emp details execution failed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showAllEmployee() {
		// TODO Auto-generated method stub
		con=DbConnector.CreateDbConnection();
		String query="select * from employee";
		System.out.println("Employement Details");
		System.out.format("%s\t%s\t%s\t%s\n","ID","NAME","SALARY     ","AGE");
		try {
			Statement stmt= con.createStatement();
			ResultSet result=stmt.executeQuery(query);
			
			while(result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1),result.getString(2),
						result.getDouble(3),result.getInt(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void showEmployeeBasedOnId(int id) {
		// TODO Auto-generated method stub
		con=DbConnector.CreateDbConnection();
		String query="select * from employee where empid="+id;
		try {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(query);
			while(result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1),result.getString(2),
						result.getDouble(3),result.getInt(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(int id, String name) {
		// TODO Auto-generated method stub
		con=DbConnector.CreateDbConnection();
		String query="update employee set empname=? where empid=?";
		try {
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, name);
			psmt.setInt(2,id);
			int cnt=psmt.executeUpdate();
			if(cnt!=0) {
				System.out.println("employee details updated successfully");
			}
			else {
				System.out.println("emp details not updated");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		con=DbConnector.CreateDbConnection();
		String query="delete from employee where empid=?";
		try {
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1,id);
			int cnt=psmt.executeUpdate();
			if(cnt!=0) {
				System.out.println("employe deleted  successfully");
			}
			else {
				System.out.println("emp  not deleted");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
