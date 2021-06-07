import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class View_Contractors {
	public static void main(String[] args){
	try {
        File f = new File("Customers.txt");
        Scanner sc = new Scanner(f);
        List<View2> Task = new ArrayList<View2>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] details = line.split(", ");
            String Contractor_name = details[0];
            String Contractor_number = details[1];
            String Contractor_Email = details[2];
            String Contractor_address = details[3];
            View2 p = new View2(Contractor_name,Contractor_number,Contractor_Email,Contractor_address);
            Task.add(p);    
        }for(View2 p: Task){
            System.out.println(p.Contractors_toString());
        }
    }catch (FileNotFoundException e) {         
        e.printStackTrace();
    }
}
}
class View2{

private String Contractor_name;
private String Contractor_number;
private String Contractor_Email;
private String Contractor_address;

public View2(String Contractor_name,String Contractor_number, String Contractor_Email, String Contractor_address){
    this.Contractor_name = Contractor_name;
	this.Contractor_number = Contractor_number;
    this.Contractor_Email = Contractor_Email;
    this.Contractor_address = Contractor_address;	    
}
public String Contractors_toString(){
return "Contractors name: "+ this.Contractor_name  + "\n"
		+ "Contractors number: "+ this.Contractor_number + "\n"
		+ "Contractors Email address: " + this.Contractor_Email + "\n"
		+ "Contractors Physical address: " + this.Contractor_address + "\n";
}
}

