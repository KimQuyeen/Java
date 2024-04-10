package ktgk2;

public class Experience extends Employee{
	 private int expInYear;
	 private String proSkill;

	    public Experience(String ID, String fullName, String birthDay, String phone, String email, String employeeType, int employeeCount, int expInYear, String proSkill) {
	        super(ID, fullName, birthDay, phone, email, employeeType, employeeCount);
	        this.expInYear = expInYear;
	        this.proSkill = proSkill;
	    }
	    
	    

	    public int getExpInYear() {
			return expInYear;
		}



		public void setExpInYear(int expInYear) {
			this.expInYear = expInYear;
		}



		public String getProSkill() {
			return proSkill;
		}



		public void setProSkill(String proSkill) {
			this.proSkill = proSkill;
		}



		public void showInfo() {
	        super.showInfo();
	        System.out.println("Experience in year: " + expInYear);
	        System.out.println("Professional Skill: " + proSkill);
	    }



		@Override
		public String toString() {
			return "Experience [expInYear=" + expInYear + ", proSkill=" + proSkill + "]";
		}
		
		

}
