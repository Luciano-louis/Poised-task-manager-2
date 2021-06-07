import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class New_contractor {
		String Contractor_name;
		String Contractor_number;
		String Contractor_Email;
		String Contractor_address;
		
		// Methods
		public New_contractor(String Contractor_name, String Contractor_number, String Contractor_Email, String Contractor_address) {
			this.Contractor_name = Contractor_name;
			this.Contractor_number = Contractor_number;
			this.Contractor_Email = Contractor_Email;
			this.Contractor_address = Contractor_address;
		}
		
		public void Add_contractor(){
			try {
			String Contractor = Contractor_name + ", " + Contractor_number + ", " + Contractor_Email + ", " + Contractor_address;
			File Contractors =new File("Contractors.txt");
			if(!Contractors.exists()){
				Contractors.createNewFile();
			}
			FileWriter fw = new FileWriter(Contractors,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("\r\n");
			bw.append(Contractor); 
			bw.close();
			System.out.println("\nThank you");

		  
			}catch(IOException ioe){
		     System.out.println("Exception occurred:");
			 ioe.printStackTrace();
		}
	}
		public String New_contractor_toString() {
			String output = "\nContractor name: " + Contractor_name;
			output += "\n" + Contractor_name + "'s current phone number: " + Contractor_number;
			output += "\n" + Contractor_name + "'s current Email address: " + Contractor_Email;
			output += "\n" + Contractor_name + "'s current physical address: " + Contractor_address;			
			return output;
			}
}
