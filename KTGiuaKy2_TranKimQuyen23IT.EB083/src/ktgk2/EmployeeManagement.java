package ktgk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
	 private List<Employee> employees;

	    public EmployeeManagement() {
	        employees = new ArrayList<>();
	    }

	    public void addEmployee(Employee employee) {
	        employees.add(employee);
	    }

	    public void deleteEmployee(Employee employee) {
	        employees.remove(employee);
	    }

	    public void showAllEmployees() {
	        for (Employee employee : employees) {
	            employee.showInfo();
	            System.out.println("--------------------");
	        }
	    }
	    
	    
	    public void Menu()
		{
			System.out.println("Thong tin quan nhan vien");
			boolean check = true;
			Scanner sc = new Scanner(System.in);
			int selected;
			
			while (check) {
				System.out.println("Chuc nang");
				System.out.println("1. Tao nhan vien");
				System.out.println("2. Cap nhat thong tin nhan vien");
				System.out.println("3. Xoa nhan vien");
				System.out.println("4. Hien Thi thong tin nhan vien");
				System.out.println("5. Thoat");
				
				System.out.print("Vui long nhap lua chon cua ban:");
				selected = sc.nextInt();
				
			
			
	    
	    
			}}
}