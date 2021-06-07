import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class New_Achitect {
	String Achitect_name;
	String Achitect_number;
	String Achitect_Email;
	String Achitect_address;
	
	// Methods
	public New_Achitect(String Achitect_name, String Achitect_number, String Achitect_Email, String Achitect_address) {
		this.Achitect_name = Achitect_name;
		this.Achitect_number = Achitect_number;
		this.Achitect_Email = Achitect_Email;
		this.Achitect_address = Achitect_address;
	}
	
	public void Add_Achitect(){
		try {
		String Achitect = Achitect_name + ", " + Achitect_number + ", " + Achitect_Email + ", " + Achitect_address;
		File Achitects =new File("Achitects.txt");
		if(!Achitects.exists()){
			Achitects.createNewFile();
		}
		FileWriter fw = new FileWriter(Achitects,true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.append("\r\n");
		bw.append(Achitect); 
		bw.close();
		System.out.println("\nThank you");

	  
		}catch(IOException ioe){
	     System.out.println("Exception occurred:");
		 ioe.printStackTrace();
	}
}
	public String New_Achitect_toString() {
		String output = "\nAchitect name: " + Achitect_name;
		output += "\n" + Achitect_name + "'s current phone number: " + Achitect_number;
		output += "\n" + Achitect_name + "'s current Email address: " + Achitect_Email;
		output += "\n" + Achitect_name + "'s current physical address: " + Achitect_address;			
		return output;
		}
}
