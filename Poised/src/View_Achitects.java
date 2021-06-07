import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View_Achitects {
	public static void main(String[] args){
	try {
        File f = new File("Achitects.txt");
        Scanner sc = new Scanner(f);

        List<View3> Task = new ArrayList<View3>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] details = line.split(", ");
            String Achitect_name = details[0];
            String Achitect_number = details[1];
            String Achitect_Email = details[2];
            String Achitect_address = details[3];
            View3 p = new View3(Achitect_name,Achitect_number,Achitect_Email,Achitect_address);
            Task.add(p);    
        }
        	for(View3 p: Task){
        		System.out.println(p.Achitect_toString());
        }
    } catch (FileNotFoundException e) {         
        e.printStackTrace();
    }
	}
}
class View3{
private String Achitect_name;
private String Achitect_number;
private String Achitect_Email;
private String Achitect_address;

public View3(String Achitect_name,String Achitect_number, String Achitect_Email, String Achitect_address){
    this.Achitect_name = Achitect_name;
	this.Achitect_number = Achitect_number;
    this.Achitect_Email = Achitect_Email;
    this.Achitect_address = Achitect_address;	    
}
public String Achitect_toString(){
return "Achitects name: "+ this.Achitect_name  + "\n"
		+ "Achitects number: "+ this.Achitect_number + "\n"
		+ "Achitects Email address: " + this.Achitect_Email + "\n"
		+ "Achitects Physical address: " + this.Achitect_address + "\n";
}
}

