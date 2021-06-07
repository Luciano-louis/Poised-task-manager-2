import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class New_customer {
		String Customer_name;
		String Customer_number;
		String Customer_Email;
		String Customer_address;
		
		// Methods
		public New_customer(String Customer_name, String Customer_number, String Customer_Email, String Customer_address) {
			this.Customer_name = Customer_name;
			this.Customer_number = Customer_number;
			this.Customer_Email = Customer_Email;
			this.Customer_address = Customer_address;
		}
		
		public void Add_customer(){
			try {
			String Customer = Customer_name + ", " + Customer_number + ", " + Customer_Email + ", " + Customer_address;
			File Customers =new File("Customers.txt");
			if(!Customers.exists()){
				Customers.createNewFile();
			}
			FileWriter fw = new FileWriter(Customers,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("\r\n");
			bw.append(Customer); 
			bw.close();
			System.out.println("\nThank you");

		  
			}catch(IOException ioe){
		     System.out.println("Exception occurred:");
			 ioe.printStackTrace();
		}
	}
		public String New_Customer_toString() {
			String output = "\nCustomer name: " + Customer_name;
			output += "\n" + Customer_name + "'s current phone number: " + Customer_number;
			output += "\n" + Customer_name + "'s current Email address: " + Customer_Email;
			output += "\n" + Customer_name + "'s current physical address: " + Customer_address;			
			return output;
			}
}
