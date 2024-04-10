package ktgk2;

public class Employee implements IEmployee{
	
	
	private String ID;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private String employeeType;
    private int employeeCount;
	
    
    public Employee(String iD, String fullName, String birthDay, String phone, String email, String employeeType,
			int employeeCount) {
		ID = iD;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.employeeType = employeeType;
		this.employeeCount = employeeCount;
	}


	public Employee(String string, String string2, String string3, String string4, float float1, String string5) {
		// TODO Auto-generated constructor stub
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmployeeType() {
		return employeeType;
	}


	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}


	public int getEmployeeCount() {
		return employeeCount;
	}


	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
    
	public void showInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Full Name: " + fullName);
        System.out.println("BirthDay: " + birthDay);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Employee Type: " + employeeType);
        System.out.println("Employee Count: " + employeeCount);
    }


	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", fullName=" + fullName + ", birthDay=" + birthDay + ", phone=" + phone
				+ ", email=" + email + ", employeeType=" + employeeType + ", employeeCount=" + employeeCount + "]";
	}


	
    
    


}
