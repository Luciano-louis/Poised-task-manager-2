import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class View_all_customers {
	public static void main(String[] args){
	try {
        File f = new File("Customers.txt");
        Scanner sc = new Scanner(f);

        List<View1> Task = new ArrayList<View1>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] details = line.split(", ");
            String Customer_name = details[0];
            String Customer_number = details[1];
            String Customer_Email = details[2];
            String Customer_address = details[3];
            View1 p = new View1(Customer_name,Customer_number,Customer_Email,Customer_address);
            Task.add(p);  
        }for(View1 p: Task){
            System.out.println(p.toString());
        }
    } catch (FileNotFoundException e) {         
        e.printStackTrace();
    }
	}
}

class View1{

private String Customer_name;
private String Customer_number;
private String Customer_Email;
private String Customer_address;

public View1(String Customer_name,String Customer_number, String Customer_Email, String Customer_address){
    this.Customer_name = Customer_name;
	this.Customer_number = Customer_number;
    this.Customer_Email = Customer_Email;
    this.Customer_address = Customer_address;	    
}
public String Customers_toString(){
return "Customers name: "+ this.Customer_name  + "\n"
		+ "Customers number: "+ this.Customer_number + "\n"
		+ "Customers Email address: " + this.Customer_Email + "\n"
		+ "Customers Physical address: " + this.Customer_address + "\n";
}
}



