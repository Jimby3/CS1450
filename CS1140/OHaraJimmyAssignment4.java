import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class OHaraJimmyAssignment4 {

	public static void main(String[] args) throws IOException {
		
		
		//Creating file and scanner
		File oceanFileName = new File("Ocean.txt");
		Scanner oceanFile = new Scanner((oceanFileName));
		
		//Create ocean object
		Ocean theOcean = new Ocean(oceanFile.next(), oceanFile.nextInt(), oceanFile.nextInt());
		
		//Closing ocean file
		oceanFile.close();
		
		//Creating file and scanner
		File shipFileName = new File ("Ships.txt");
		Scanner shipFile = new Scanner (shipFileName);
		
		//inputting ship objects into grid
		while (shipFile.hasNext()) {
			
			int row = shipFile.nextInt();
			int column = shipFile.nextInt();
			int capacity = shipFile.nextInt();
			String classification = shipFile.next().trim();
			String name = shipFile.nextLine().trim();
			
			Ship newShip = new Ship(classification, capacity, name);
			
			theOcean.addElement(row, column, newShip);
			
		}
		
		//closing ship file
		shipFile.close();
		
		//Creating file and scanner for land
		File landFileName = new File ("Land.txt");
		Scanner landFile = new Scanner(landFileName);
		
		//inputting land objects into array
		while (landFile.hasNext()) {
			
			int row = landFile.nextInt();
			int column = landFile.nextInt();
			
			
			Land newLand = new Land();
			
			theOcean.addElement(row, column, newLand);
			
		}
		
		landFile.close();
		
		theOcean.displayOcean();
		
		printShips(theOcean);
		
	} // main
	
	public static void printShips (Ocean ocean) {
		
		ArrayList<Ship> shipArray = new ArrayList<>();
		
		for (int i = 0; i < ocean.getNumberRows(); i++) {
			
			for (int j = 0; j < ocean.getNumberColumns(); j++) {
				
				if (ocean.getElement(i, j) instanceof Ship) {
					Ship ship = (Ship)ocean.getElement(i, j);
					shipArray.add(ship);
				}//if
				
			}//columns
			
		}//rows
		
		System.out.println("\n\n Classification \t\t Name \t\t Capacity");
		
		Collections.sort(shipArray);
		
		String ships = shipArray.toString();
		
		System.out.print(ships);
		
		
	}// printShips

} // assignment 4


//Ocean Class
class Ocean {
	
	//instance variables
	private String name;
	private int numberRows;
	private int numberColumns;
	OceanElement[][] grid;
	
	//Constructor
	public Ocean (String name, int numberRows, int numberColumns) {
		
		this.name = name;
		this.numberRows = numberRows;
		this.numberColumns = numberColumns;
		
		grid = new OceanElement[numberRows][numberColumns];
		
	}//constructor
	
	//getters
	public String getName() {
		return name;
	}
	
	public int getNumberRows() {
		return numberRows;
	}
	
	public int getNumberColumns() {
		return numberColumns;
	}
	
	//other methods
	
	//addElement method
	public void addElement(int row, int column, OceanElement element) {
		
		grid[row][column] = element;
		
	}//addElement
	
	//getElement function
	public OceanElement getElement(int row, int column) {
		
		OceanElement elementAtLocation = grid[row][column];
		
		return elementAtLocation;
	}//getElement

	
	//displayOcean function
	public void displayOcean() {
		
		System.out.print("Rows: \t");
		
		//displaying header
		for (int i = 0; i < grid[0].length; i++) {
			System.out.print("Column " + i + " \t");
		}
		
		System.out.print("\n");
		
		//iterating through rows
		for (int rowNum = 0; rowNum < grid.length; rowNum++) {
			
			System.out.print("Row " + rowNum + ") \t");
			
			//iterating through columns
			for (int columnNum = 0; columnNum < grid[0].length; columnNum++) {
				
				//printing either land or ship based on the array
				if (grid[rowNum][columnNum] instanceof Ship) {
					
					OceanElement element = grid[rowNum][columnNum];
					Ship ship = (Ship)element;
					
					System.out.print(ship.getName() + " \t");
			
				} else if (grid[rowNum][columnNum] instanceof Land) {
					
					System.out.print("Land \t\t");
					
				} else {
					System.out.print("- \t\t");
				}
				
			}//columnNum
			
			System.out.print("\n");
			
			
		}//row if
		
		
	}//displayOcean
	
	
}//Ocean


//OceanElement 
class OceanElement{
	
	//instance variable(s)
	private String type;
	
	//Constructor
	public OceanElement(String type) {
		
		this.type = type;
		
	}//constructor
	
	//getters
	public String getType() {
		
		return type;
		
	}//getType
	

}//OceanElement 

//Ship Class
class Ship extends OceanElement implements Comparable<Ship>{
	
	//instance variables
	private String name;
	private String classification;
	private int capacity;
	
	//constructor
	public Ship(String classification, int capacity, String name) {
		
		super("Ship");
		this.classification = classification;
		this.capacity = capacity;
		this.name = name;

	}//constructor
	
	//getters
	public String getName() {
		
		return name;
		
	}//getName
	
	public int getCapacity() {
		return capacity;
	}
	
	//other methods
	
	//toString method
	public String toString() {
		
		return String.format("%s\t\t\t%s\t\t\t%d\n", classification, name, capacity);
		
	}//toString
	
	//compareTo Method
    //@override
	public int compareTo(Ship otherShip) {
		
		int num = 0;
		
		if (this.getCapacity() < otherShip.getCapacity()) {
			
			num = -1;
			
		} else if (this.getCapacity() == otherShip.getCapacity()) {
			
			num = 0;
			
		} else if (this.getCapacity() > otherShip.getCapacity()) {
			
			num = 1;
		
		}//end else
		
		return num;
		
	}//compareTo
	
	
}//Ship

//Land Class
class Land extends OceanElement {
	
	//constructor 
	public Land() {
		
		super("Land");
		
	}
	
	
	
	
	
}








