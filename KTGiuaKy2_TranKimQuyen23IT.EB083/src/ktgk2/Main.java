package ktgk2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;





public class Main {
	public static void main(String args[]) {
		EmployeeManagement qlnv = new EmployeeManagement();
		qlnv.Menu();	
	}
	
	public void showData(List<Employee> employee1) {
		List<Employee> listStudent = new ArrayList<>();
		listStudent = employee1;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		listStudent.forEach((employee) -> {
			
			tableModel.addRow(new Object[] { employee.getID(), employee.getFullName(), employee.getBirthDay(), 
					employee.getPhone(), employee.getEmail() });
		});
	}
}