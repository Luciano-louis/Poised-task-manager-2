import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class New_project {
		int Project_num;
		String Project_name;
		String Building_type;
		String Physical_address;
		int Erf;
		float Total_charge;
		float Paid;
		String Deadline;
		String Contractor;
		String Customer;
		
		// Methods
		public New_project(int Project_num, String Project_name, String Building_type, String Physical_address, int Erf, float Total_charge, float Paid, String deadline, String Contractor, String Customer) {
			this.Project_num = Project_num;
			this.Project_name = Project_name;
			this.Building_type = Building_type;
			this.Physical_address = Physical_address;
			this.Erf = Erf;
			this.Total_charge = Total_charge;
			this.Paid = Paid;
			this.Deadline = deadline;
			this.Contractor = Contractor;
			this.Customer = Customer;
	   }
		public void Add_project(){
			try {
			String Project = Project_num + ", " + Project_name + ", " + Building_type + ", " + Physical_address + ", " + Erf + ", " + Total_charge + ", " + Paid + ", " + Deadline + ", " + Contractor + ", " + Customer;
			File Tasks =new File("Tasks.txt");
			if(!Tasks.exists()){
				   Tasks.createNewFile();
			}
			FileWriter fw = new FileWriter(Tasks,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("\r\n");
			bw.append(Project); 
			bw.close();
			System.out.println("\nThank you");

		  
			}catch(IOException ioe){
		     System.out.println("Exception occurred:");
			 ioe.printStackTrace();
		}
	}
			
			public String New_project_toString() {
			String output = "\nProject Number: " + Project_num;
			output += "\nProject Name: " + Project_name;
			output += "\nBuilding type: " + Building_type;
			output += "\nAddress: " + Physical_address;
			output += "\nErf: " + Erf;
			output += "\nTotal charge: R" + Total_charge;
			output += "\nAmount paid thus far: R" + Paid;
			output += "\nProject deadline: " + Deadline;
			output += "\nContractor assigned to project: " + Contractor;
			output += "\nCustomer: " + Customer;
			return output;
			}
}

