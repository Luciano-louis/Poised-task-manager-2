import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 

public class Poised {
	public static void main (String [] args)throws IOException {
		String User_selection = menu();
		if(User_selection.equalsIgnoreCase("New Project"))
			newProject();
		else if(User_selection.equalsIgnoreCase("View projects"))
			viewProjects();
		else if(User_selection.equalsIgnoreCase("Update Date"))
			updateDate();
		else if(User_selection.equalsIgnoreCase("Update Amount"))
			updateAmount();
		else if(User_selection.equalsIgnoreCase("New customer"))
			newCustomer();
		else if(User_selection.equalsIgnoreCase("View Customers"))
			viewCustomers();
		else if(User_selection.equalsIgnoreCase("New Achitect"))
			newArchitect();
		else if(User_selection.equalsIgnoreCase("View Achitects"))
			viewAchitects();
		else if(User_selection.equalsIgnoreCase("New Contractor"))
			newContractor();
		else if(User_selection.equalsIgnoreCase("View Contractors"))
			viewContractors();
		else if(User_selection.equalsIgnoreCase("Update Contractor"))
			updateContractor();
		else if(User_selection.equalsIgnoreCase("Finalize"))
			finalise();
		else {
			System.out.println("Invalid Selection");	
				}
}
//methods
	//finalize method returns a finalized invoice once everything has been paid by using the project number
	private static void finalise() {
			System.out.println("Please enter the Project number You would like to finalize:");
			Scanner z = new Scanner(System.in);
			String Finalise = z.nextLine();	
			try {
				File tasks = new File ("Tasks.txt");//open text file for use
				Scanner scanIn = new Scanner(tasks);						
				while(scanIn.hasNextLine()) {
					String line = scanIn.nextLine();							
					String[] TaskSplit = line.split(", ");//split Instruction and list of numbers
					String Project_number = TaskSplit[0];
					String Project_name = TaskSplit[1];
					String Building_type = TaskSplit[2];
					String Physical_address = TaskSplit[3];
					String Erf = TaskSplit[4];
					String Total_charge = (TaskSplit[5]);
					String Paid = (TaskSplit[6]);
					String Deadline = TaskSplit[7];
					String Contractor = TaskSplit[8];
					String Customer = TaskSplit[9];
					if(Finalise.equals(Project_number)) {
						System.out.println("Finalised Invoice:");
						System.out.println(Customer + ", as of the time of printing this invoice the total amount owed is: R" + (Integer.parseInt(Total_charge)- Integer.parseInt(Paid)) + "\n");							
					}
			}
		}			
			catch (FileNotFoundException e) {         
			            e.printStackTrace();
					}
			    }
//Method changes information based on what the user would like to replace
	private static void updateContractor() {
		{
			String Switch;
			ArrayList<String> Replace = new ArrayList<String>();	
			System.out.println("Please enter the name of the Contractor you would like to update:");
			Scanner z1 = new Scanner(System.in);
			String Name = z1.nextLine();
			System.out.println("Please enter the what you would like to update: ");
			System.out.println("'Name' - Update the name of an exsisting contractor");
			System.out.println("'Number' - Update the contact number of an exsisting contractor");
			System.out.println("'Email' - Update the Email address of an exsisting contractor");
			System.out.println("'Address' - Update the the physical address of an exsisting contractor");
			Scanner z2 = new Scanner(System.in);
			String Selection = z2.nextLine();
			System.out.println("Please enter the new details to replace the " + Selection);
			Scanner z3 = new Scanner(System.in);
			String Update = z3.nextLine();
			try {
		    	File text = new File ("Contractors.txt");//open text file for use
		    	Scanner scanIn = new Scanner(text);		    				
		    	while(scanIn.hasNextLine()) {
		    		String line = scanIn.nextLine();
					String[] details = line.split(", ");
					String Contractor_name = details[0];
					String Contractor_number = details[1];
					String Contractor_Email = details[2];
					String Contractor_address = details[3];		              
		            if(Name.equals(Contractor_name) && Selection.equals("Name")) {
		            	Switch = Update + ", " + Contractor_number + ", " + Contractor_Email + ", " + Contractor_address;
		                Replace.add(Switch);
		            }else if(Name.equals(Contractor_name) && Selection.equals("Number")){
		                Switch = Contractor_name + ", " + Update + ", " + Contractor_Email + ", " + Contractor_address;
		                Replace.add(Switch);
		            }else if(Name.equals(Contractor_name) && Selection.equals("Email")){
		            	Switch = Contractor_name + ", " + Contractor_number + ", " + Update + ", " + Contractor_address;
		                Replace.add(Switch);
		            }else if(Name.equals(Contractor_name) && Selection.equals("Address")){
		                Switch = Contractor_name + ", " + Contractor_number + ", " + Contractor_Email + ", " + Update;
		                Replace.add(Switch);
		                }
		    		}	
			}
		    catch (FileNotFoundException e) {         
		    	e.printStackTrace();    
		    			}		    					    	    
		    try {
		    	BufferedWriter wr = null;
		        wr = new BufferedWriter(new FileWriter("Contractors.txt"));
		        for (String var : Replace) {
		        wr.write(var);
		        wr.newLine();
		       }wr.close();
		        System.out.println("File succesfully updated and saved as Contractors.txt");
		   }catch (Exception e) {
		   }
		}
	}
//method displays all available contractors stored in the text file
	private static void viewContractors() {
		{
			System.out.println("Current customer details: \n");
			try{
				File f = new File("Contractors.txt");
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
			}
			catch (FileNotFoundException e) {         
				e.printStackTrace();
			}
		}
	}
//method gains new iformation and creates a new contractor in the text file which will also be displayed if the view method is called
	private static void newContractor() throws FileNotFoundException, IOException {
		{	
			System.out.println("Please type the new Contractors name: ");
			Scanner b = new Scanner(System.in);
			String Contractor_name = b.nextLine();
			System.out.println("Please type the new Contractors contact number: ");
			Scanner c = new Scanner(System.in);
			String Contractor_number = c.nextLine();
					
			System.out.println("Please type the new Contractors Email address: ");
			Scanner d = new Scanner(System.in);
			String Contractor_Email = d.nextLine();
					
			System.out.println("Please type the new Contractors physical address: ");
			Scanner e = new Scanner(System.in);
			String Contractor_address = e.nextLine();
			File k=new File("Contractors.txt");   
			FileReader fr=new FileReader(k); 
			BufferedReader br = new BufferedReader(fr);            
			while(br.readLine()!=null){
				New_contractor Name = new New_contractor(Contractor_name,Contractor_number,Contractor_Email,Contractor_address);
				System.out.println("The following has successfully been added to the Contractors file");
			    System.out.println(Name.New_contractor_toString());		      
			    Name.Add_contractor();
			    fr.close();
		        }
		}
	}
	//method displays all Achitects saved in the text file
	private static void viewAchitects() {
		{
				System.out.println("Current Achitect details: \n");
				try{
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
		            }for(View3 p: Task){
		                System.out.println(p.Achitect_toString());
		    		}
		     }
				catch (FileNotFoundException e) {         
		            e.printStackTrace();
				}
		}
	}
//method saves a new achitect into the text file
	private static void newArchitect() throws FileNotFoundException, IOException {
		{				
			System.out.println("Please type the new Achitects name: ");
			Scanner b = new Scanner(System.in);
			String Achitect_name = b.nextLine();		
			System.out.println("Please type the new Achitects contact number: ");
			Scanner c = new Scanner(System.in);
			String Achitect_number = c.nextLine();
			System.out.println("Please type the new Achitects Email address: ");
			Scanner d = new Scanner(System.in);
			String Achitect_Email = d.nextLine();
			System.out.println("Please type the new Achitects physical address: ");
			Scanner e = new Scanner(System.in);
			String Achitect_address = e.nextLine();
			File k=new File("Achitects.txt");   
			FileReader fr=new FileReader(k); 
			BufferedReader br = new BufferedReader(fr);            
			while(br.readLine()!=null) { 
				New_Achitect Name = new New_Achitect(Achitect_name,Achitect_number,Achitect_Email,Achitect_address);
				System.out.println("The following has successfully been added to the Achitects file");
				System.out.println(Name.New_Achitect_toString());		      
				Name.Add_Achitect();
				fr.close();
	        }
		}
	}
//Method displays all customers in text file
	private static void viewCustomers() {
		{
			System.out.println("Current customer details: \n");
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
	                System.out.println(p.Customers_toString());
	    			}
	            }
			catch (FileNotFoundException e) {         
	            e.printStackTrace();
			}
		}
	}
//method adds a new customer into text file
	private static void newCustomer() throws FileNotFoundException, IOException {
		{				
			System.out.println("Please type the new customers name: ");
			Scanner b = new Scanner(System.in);
			String Customer_name = b.nextLine();
			System.out.println("Please type the new customers contact number: ");
			Scanner c = new Scanner(System.in);
			String Customer_number = c.nextLine();			
			System.out.println("Please type the new customers Email address: ");
			Scanner d = new Scanner(System.in);
			String Customer_Email = d.nextLine();
			System.out.println("Please type the new customers physical address: ");
			Scanner e = new Scanner(System.in);
			String Customer_address = e.nextLine();
			File k=new File("Tasks.txt");   
			FileReader fr=new FileReader(k); 
			BufferedReader br = new BufferedReader(fr);            
			while(br.readLine()!=null){	     
				New_customer Name = new New_customer(Customer_name,Customer_number,Customer_Email,Customer_address);
				System.out.println("The following has successfully been added to the Tasks file");
				System.out.println(Name.New_Customer_toString());		      
				Name.Add_customer();
				fr.close();
			}
		}
	}
//method replaces amount information based on user input
	private static void updateAmount() {
		{
			String Switch;
			ArrayList<String> Replace = new ArrayList<String>();	
			System.out.println("Please enter the Project Number:");
			Scanner z1 = new Scanner(System.in);
			String TaskNum = z1.nextLine();
			System.out.println("Please enter the new Amount paid to date:");
			Scanner z2 = new Scanner(System.in);
			String NewAmount = z2.nextLine();	
			try{
    			File text = new File ("Tasks.txt");	
    			Scanner scanIn = new Scanner(text);	
    			while(scanIn.hasNextLine()) {
    				String line = scanIn.nextLine();
    				String[] TaskSplit = line.split(", ");
    				String Project_number = TaskSplit[0];
    				String Project_name = TaskSplit[1];
    				String Building_type = TaskSplit[2];
    				String Physical_address = TaskSplit[3];
    				String Erf = TaskSplit[4];
    				String Total_charge = TaskSplit[5];
    				String Paid = TaskSplit[6];
    				String Deadline = TaskSplit[7];
    				String Contractor = TaskSplit[8];
    				String Customer = TaskSplit[9];              
    				if(Project_number.equals(TaskNum)) {
    					Switch = Project_number + ", " + Project_name + ", " + Building_type + ", " + Physical_address + ", " + Erf + ", " + Total_charge + ", " + NewAmount + ", " + Deadline + ", " + Contractor + ", " + Customer;
    					Replace.add(Switch);
    				}else {
    					Switch = Project_number + ", " + Project_name + ", " + Building_type + ", " + Physical_address + ", " + Erf + ", " + Total_charge + ", " + Paid + ", " + Deadline + ", " + Contractor + ", " + Customer;
    					Replace.add(Switch);
    				}  
    			}
    		}	
    			catch (FileNotFoundException e) {         
    	            e.printStackTrace();        
    			}try{
                	BufferedWriter wr = null;
                    wr = new BufferedWriter(new FileWriter("Tasks.txt"));
                    for (String var : Replace) {
                        wr.write(var);
                        wr.newLine();
                    }wr.close();
                    System.out.println("File succesfully updated and saved as Tasks.txt");
                } catch (Exception e) {
            }
		}
	}
//method replaces date information based on user input
	private static void updateDate() {
		{
			String Switch;
			ArrayList<String> Replace = new ArrayList<String>();	
			System.out.println("Please enter the Project Number:");
			Scanner z1 = new Scanner(System.in);
			String TaskNum = z1.nextLine();
			System.out.println("Please enter the new date");
			Scanner z2 = new Scanner(System.in);
			String NewDate = z2.nextLine();	
			try{
				File text = new File ("Tasks.txt");//open text file for use
    			Scanner scanIn = new Scanner(text);
    			while(scanIn.hasNextLine()) {
    				String line = scanIn.nextLine();	
    				String[] TaskSplit = line.split(", ");
    				String Project_number = TaskSplit[0];
    				String Project_name = TaskSplit[1];
    				String Building_type = TaskSplit[2];
    				String Physical_address = TaskSplit[3];
    				String Erf = TaskSplit[4];
    				String Total_charge = TaskSplit[5];
    				String Paid = TaskSplit[6];
    				String Deadline = TaskSplit[7];
    				String Contractor = TaskSplit[8];
    				String Customer = TaskSplit[9];
    					              
                if(Project_number.equals(TaskNum)) {
                	Switch = Project_number + ", " + Project_name + ", " + Building_type + ", " + Physical_address + ", " + Erf + ", " + Total_charge + ", " + Paid + ", " + NewDate + ", " + Contractor + ", " + Customer;
                	Replace.add(Switch);
                }else{
                	Switch = Project_number + ", " + Project_name + ", " + Building_type + ", " + Physical_address + ", " + Erf + ", " + Total_charge + ", " + Paid + ", " + Deadline + ", " + Contractor + ", " + Customer;
                	Replace.add(Switch);
                }  
    		}
    	}	
    			catch (FileNotFoundException e){         
    	            e.printStackTrace();
    	            
    }	    
                try {
                	BufferedWriter wr = null;
                    wr = new BufferedWriter(new FileWriter("Tasks.txt"));
                    for (String var : Replace) {
                        wr.write(var);
                        wr.newLine();
                    }wr.close();
                    System.out.println("File succesfully updated and saved as Tasks.txt");
                } catch (Exception e) {
            }
		}
	}
//method displays all projects in text file
	private static void viewProjects() {
		{
			System.out.println("Current list of Projects: \n");
			ArrayList<String> Taskfix = new ArrayList<String>();		
			try{
				File text = new File ("Tasks.txt");//open text file being referenced
				Scanner scanIn = new Scanner(text);
				while(scanIn.hasNextLine()) {
					String line = scanIn.nextLine();	
					String[] TaskSplit = line.split(", ");//split Information accordingly
					String Project_number = TaskSplit[0];
					String Project_name = TaskSplit[1];
					String Building_type = TaskSplit[2];
					String Physical_address = TaskSplit[3];
					String Erf = TaskSplit[4];
					String Total_charge = TaskSplit[5];
					String Paid = TaskSplit[6];
					String Deadline = TaskSplit[7];
					String Contractor = TaskSplit[8];
					String Customer = TaskSplit[9];
					System.out.println("Project number:" + TaskSplit[0] +"\n" + "Project Name:" + TaskSplit[1] +"\n" + "Building Type:" + TaskSplit[2] +"\n" +					
										"Physical Address: " + TaskSplit[3] +"\n" + "Erf number:" + TaskSplit[4] +"\n" + "Total amount charged:" + TaskSplit[5] +"\n" +
										"Amount paid thus far:" + TaskSplit[6] +"\n" + "Set deadline:" + TaskSplit[7] +"\n" + "Hired Contractor:" + TaskSplit[8] +"\n" +
										"Customer Name:" + TaskSplit[9] +"\n");//Display Projects in a easy to read format
				}
			}	
			catch (FileNotFoundException e) {         
	            e.printStackTrace();
			}
	    }
	}
//method adds a new project into the text file
	private static void newProject() throws FileNotFoundException, IOException {
		{
			 
			System.out.println("Please type the project name: ");
			Scanner b = new Scanner(System.in);
			String Project_name = b.nextLine();
			
			System.out.println("Please type the building type: ");
			Scanner c = new Scanner(System.in);
			String Building_type = c.nextLine();
			
			System.out.println("Please type the address: ");
			Scanner d = new Scanner(System.in);
			String Physical_address = d.nextLine();

			System.out.println("Please type the Erf number: ");
			Scanner e = new Scanner(System.in);
			int Erf = e.nextInt();
			
			System.out.println("Please type the total amount charged: ");
			Scanner f = new Scanner(System.in);
			float Total_charge = f.nextFloat();
			
			System.out.println("Please type the total amount paid thus far: ");
			Scanner g = new Scanner(System.in);
			float Paid = g.nextFloat();
			
			System.out.println("Please type the project Due date");
			Scanner j = new Scanner(System.in);
			String Deadline = j.nextLine();
			
			System.out.println("Please type the Contractors name");
			Scanner h = new Scanner(System.in);
			String Contractor = h.nextLine();
			
			System.out.println("Please type the Customer name");
			Scanner i = new Scanner(System.in);
			String Customer = i.nextLine();
				 
			BufferedReader reader = new BufferedReader(new FileReader("Tasks.txt"));
			int lines = 0;
			while (reader.readLine() != null) lines++;
			reader.close();
			File k=new File("Tasks.txt"); 
			int Project_num=0;    
			FileReader fr=new FileReader(k); 
			BufferedReader br = new BufferedReader(fr);            
			while(br.readLine()!=null){
				Project_num = lines + 1;       
			}fr.close();
			New_project Name = new New_project(Project_num, Project_name, Building_type, Physical_address, Erf, Total_charge, Paid, Deadline, Contractor, Customer);
			System.out.println("The following has successfully been added to the Tasks file");
			System.out.println(Name.New_project_toString());
			Name.Add_project();
		    }//Obtain information and add the new task to the text file
	}
//method displays the menu and directs based on user input
	private static String menu() {
		System.out.println("Welcome to the Poised task manager");
		System.out.println("Main menu, Please type:");
		System.out.println("'New Project' - To add a new project");
		System.out.println("'View projects' - To view all projects");
		System.out.println("'Update Date' - To change the due date of a project");
		System.out.println("'Update Amount' - To update the amount that has been paid to date");
		System.out.println("'New customer' - To add a new customer details to database");
		System.out.println("'View Customers' - To view all customers details currently in database");
		System.out.println("'New Achitect' - To add a new Achitect details to database");
		System.out.println("'View Achitects' - To view all Achitects details currently in database");
		System.out.println("'New Contractor' - To add a new Contractor details to database");
		System.out.println("'View Contractors' - To view all Contractors details currently in database");
		System.out.println("'Finalize' - Generate a Invoice for exsiting projects");//Menu options
		System.out.println("");

		Scanner a = new Scanner(System.in);
		String User_selection = a.nextLine();
		return User_selection;
	} 
}
//end
