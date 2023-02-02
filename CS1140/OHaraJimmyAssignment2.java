import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class OHaraJimmyAssignment2 {

	public static void main(String[] args) throws IOException {
		
		//creating file reader and a reference to the file
		File fileName = new File("Disasters.txt");
		
		Scanner fileInput = new Scanner(fileName);
		
		
		//reading the first number in the file to determine length and creating array
		int arrayNum = fileInput.nextInt();
		Disaster[] array = new Disaster[arrayNum];
	
		
		
		//Finding out what type each disaster in the file is via iteration
		for (int i = 0; i < array.length; i++) {
			
			//setting each thing in the file to a variable
			String type = fileInput.next();
			int year = fileInput.nextInt();
			double strength = fileInput.nextDouble();
			String name = fileInput.nextLine().trim();
			
			
			//creates the right object based on the type
			if (type.equals("earthquake")) {
				
				array[i] = new Earthquake(name, year, strength);
				
			} else if (type.equals("hurricane")) {
				
				array[i] = new Hurricane(name, year, strength);
				
			} else if (type.equals("tornado")) {
				
				array[i] = new Tornado(name, year, strength);
				
			} else if (type.equals("volcano")) {
				
				array[i] = new Volcano(name, year, strength);
				
			}
		}//for
		
		
		//Displaying the array
		System.out.print("Name \t\t\t\t\t  Type \t\t\t Year \t  Strength \t\t\t");
		System.out.print("------------------------------------------------------------------------------------\n");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%15S \t\t %15S \t\t  %4d \t\t %2.1f \n", array[i].getName(), array[i].getType(), array[i].getYear(), array[i].getStrength());
		
		}
		
		//creating storm object that can scan through disaster array
		Storms stormList = new Storms();
		
		stormList.findStorms(array, 5);
		
		//printing storms 
		stormList.printStormDetails();

		
		fileInput.close();
	}//main

	
	
}//assignment 2

class Disaster {
	
	//declaring instance variables
	private String name;
	private String type;
	private int year;
	private double strength;
	
	//constructor
	public Disaster(String type, String name, int year, double strength) {
		this.name = name;
		this.type = type;
		this.year = year;
		this.strength = strength;
		
	}//constructor
	
	//getters
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getStrength() {
		return strength;
	}
	
	
	//rating scale method (to be overridden)
	public String ratingScale() {
		String temp = "Disasters are all scaled differently";
		return temp;
	}
}//disaster

class Earthquake extends Disaster {
	
	
	//constructor
	public Earthquake (String name, int year, double strength) {
		super("Earthquake", name, year, strength);
	}
	
	//@override
	public String ratingScale() {
		String temp = "Richter Scale: 1.0 to 9.0 or greater";
		return temp;
	}
	
}//Earthquake

class Hurricane extends Disaster{
	
	//constructor
		public Hurricane (String name, int year, double strength) {
			super("Hurricane", name, year, strength);
		}
	
	//@override
		public String ratingScale() {
			String temp = "Saffir-Simpson Wind Scale: 1 to 5";
			return temp;
		}
	
}//Hurricane

class Tornado extends Disaster{
	
	//constructor
		public Tornado (String name, int year, double strength) {
			super("Tornado", name, year, strength);
		}
	
	//@override
		public String ratingScale() {
			String temp = "Fujita Scale: F0 to F5";
			return temp;
		}
		
}//Tornado

class Volcano extends Disaster{
	
	//constructor
		public Volcano (String name, int year, double strength) {
			super("Volcano", name, year, strength);
		}
	
		//@override
		public String ratingScale() {
			String temp = "Volcanic Explosivity Index: 0 to 8";
			return temp;
		}
	
	
}//Volcano

class Storms {
	
	//declaring instance variables
	private int numTornados;
	private int numHurricanes;
	private Disaster[] storms;
	
	//find storms method
	public void findStorms (Disaster[] disasters, double strength) {
		
		
		//count how many hurricanes and tornados there are above the desired strength
		for (int i = 0; i < disasters.length; i++) {
			if (disasters[i] instanceof Hurricane && disasters[i].getStrength() >= strength) {
				numHurricanes++;
				
			} else if (disasters[i] instanceof Tornado && disasters[i].getStrength() >= strength) {
				numTornados++;
				
			}
			
		}//for
		
		//create array of disasters with just the number of storms
		storms = new Disaster[numHurricanes+numTornados];
		int index = 0;
		
		//re-sorts through the array but this time adding the disaster objects from the given array into the new storm array
		for (int i = 0; i < disasters.length; i++) {
			if (disasters[i] instanceof Hurricane && disasters[i].getStrength() >= 5) {
				storms[index] = disasters[i];
				index++;
				
			} else if (disasters[i] instanceof Tornado && disasters[i].getStrength() >= 5) {
				storms[index] = disasters[i];
				index++;
				
			}
			
			
		}
	}//findStorms
	
	
	
	public void printStormDetails() {
	
		//printing out info about the storms
		System.out.println("\n\n\t\tDisasters that are Storms");
		System.out.println("---------------------------------------------------------");
		
		System.out.println("Number of Tornados: " + numTornados);
		System.out.println("Number of Hurricanes " + numHurricanes + "\n");
		for (int i = 0; i < storms.length; i++) {
			System.out.print((i+1) + ")  " + storms[i].getName());
			System.out.print("		"+  storms[i].getType());
			System.out.print("		" + storms[i].getStrength() + "\n");
		}
	}
	
}





