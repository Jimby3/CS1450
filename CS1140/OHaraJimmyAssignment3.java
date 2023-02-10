import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class OHaraJimmyAssignment3 {

	public static void main(String[] args) throws IOException {

		// creating file reader and a reference to the file
		File fileName = new File("Athletes.txt");

		Scanner fileInput = new Scanner(fileName);

		// reading the first number in the file to determine length and creating array
		int arrayNum = fileInput.nextInt();
		Athlete[] athletes = new Athlete[arrayNum];

		// putting objects into array
		for (int i = 0; i < athletes.length; i++) {
			String type = fileInput.next();

			int athleteNum = 0;

			// creating a case for each athlete type
			if (type.equals("aquathlete")) {

				athleteNum = 1;

			} else if (type.equals("duathlete")) {

				athleteNum = 2;

			} else if (type.equals("marathoner")) {

				athleteNum = 3;

			} else if (type.equals("triathlete")) {

				athleteNum = 4;

			} // end if/else

			// getting all the information
			double bikeSpeed = fileInput.nextDouble();
			double runSpeed = fileInput.nextDouble();
			double swimSpeed = fileInput.nextDouble();
			String name = fileInput.nextLine().trim();

			// deciding which kind of athlete to make
			switch (athleteNum) {

			case 1:

				athletes[i] = new Aquathlete(name, runSpeed, swimSpeed);

				break;
			case 2:

				athletes[i] = new Duathlete(name, runSpeed, bikeSpeed);

				break;
			case 3:

				athletes[i] = new Marathoner(name, runSpeed);

				break;
			case 4:

				athletes[i] = new Triathlete(name, runSpeed, swimSpeed, bikeSpeed);

				break;
			} // switch

		} // for

		displayAthletes(athletes);

		ArrayList<Athlete> runnerList = findRunners(athletes);

		// header
		System.out.println("\n\nAthletes That Run");
		System.out.println("--------------------------------------------");
		System.out.println("Name		Type		Running Speed");
		System.out.println("--------------------------------------------");

		// displaying arraylist
		for (int i = 0; i < runnerList.size(); i++) {
			System.out.print(runnerList.get(i).getName() + "		" + runnerList.get(i).getType() + "		");

			// cast to runner to get access to method
			Runner runner = (Runner) (runnerList.get(i));
			System.out.print(runner.run() + "\n");
		} // for

		// beginning race
		System.out.println("\n\n----------------------------------------------");
		System.out.println("		Bike Race");
		System.out.println("----------------------------------------------");
		System.out.println("Bikers get ready ... get set ... go!\n");

		// displaying winner
		Athlete bikeWinner = bikeRace(athletes);
		Biker biker = (Biker) bikeWinner;
		System.out.print("The winner is " + bikeWinner.getName() + " who is a " + bikeWinner.getType() + " With a"
				+ " Biking speed of " + biker.bike());

		fileInput.close();
	}// main

	// display athletes method
	public static void displayAthletes(Athlete[] athlete) {

		System.out.println("Athletes and Disciplines");
		System.out.println("---------------------------------------------------------------------------");

		for (int i = 0; i <= athlete.length - 1; i++) {

			String name = athlete[i].getName();
			String type = athlete[i].getType();
			String discipline = athlete[i].disciplines();

			System.out.println(name + " is a: " + type);
			System.out.println(discipline);

			if (athlete[i] instanceof Biker) {

				Biker biker = (Biker) athlete[i];
				System.out.print("Bike Speed: " + biker.bike());

			} else {
				System.out.print("Bike Speed: 0.00");
			}

			if (athlete[i] instanceof Runner) {

				Runner runner = (Runner) athlete[i];
				System.out.print("	Run Speed: " + runner.run());

			} else {
				System.out.print("	Run Speed: 0.00");
			}

			if (athlete[i] instanceof Swimmer) {

				Swimmer swimmer = (Swimmer) athlete[i];
				System.out.print("		Swim Speed: " + swimmer.swim());

			} else {
				System.out.print("		Swim Speed: 0.00");
			}

			System.out.println("\n");
		}
	} // display athletes

	// findRunners method
	public static ArrayList<Athlete> findRunners(Athlete[] athletes) {

		ArrayList<Athlete> runners = new ArrayList<>();

		for (int i = 0; i < athletes.length; i++) {
			if (athletes[i] instanceof Runner) {
				runners.add(athletes[i]);
			}
		}

		return runners;

	}// findRunners

	// bikeRace method
	public static Athlete bikeRace(Athlete[] athletes) {

		// making fake biker who will be initial biker to compare the rest of the array
		// to until
		// bike winner gets filled by different biker
		Duathlete loser = new Duathlete("Loser", 0.0, 0.0);

		// Variables for deciding winner
		Biker bikeWinner = loser;
		int winnerInt = 0;

		for (int i = 0; i < athletes.length; i++) {
			if (athletes[i] instanceof Biker) {
				Biker biker = (Biker) athletes[i];
				if (biker.bike() > bikeWinner.bike()) {
					bikeWinner = biker;
					winnerInt = i;

				} // if

			} // if

		} // for

		return athletes[winnerInt];
	}// bikeRace

}// assignment 3 class

//runner interface
interface Runner {

	abstract double run();

}// runner

//swimmer interface
interface Swimmer {

	abstract double swim();

}// swimmer

//biker interface
interface Biker {

	abstract double bike();

}// biker

//athlete class
abstract class Athlete {

	// instance variables
	private String name;
	private String type;

	// getters
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	// setters
	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract String disciplines();

}// athlete class

//Aquathlete class
class Aquathlete extends Athlete implements Runner, Swimmer {

	// instance variables
	private double runSpeed;
	private double swimSpeed;

	// constructor
	public Aquathlete(String name, double runSpeed, double swimSpeed) {

		super.setName(name);
		super.setType("Aquathlete");
		this.runSpeed = runSpeed;
		this.swimSpeed = swimSpeed;

	}// constructor

	@Override
	public double run() {
		return runSpeed;
	}

	@Override
	public double swim() {
		return swimSpeed;
	}

	@Override
	public String disciplines() {

		String discipline = "I run, swim, then run again. In the Swedish OTILLO Championship, "
				+ "the race takes place over 24 islands and requires 6 miles of swimming between the islands "
				+ "and 40 miles of trail running. ";
		return discipline;

	}

} // aquathlete

//Duathlete class
class Duathlete extends Athlete implements Runner, Biker {

	// instance variables
	private double runSpeed;
	private double bikeSpeed;

	// constructor
	public Duathlete(String name, double runSpeed, double bikeSpeed) {

		super.setName(name);
		super.setType("Duathlete");
		this.runSpeed = runSpeed;
		this.bikeSpeed = bikeSpeed;

	}// constructor

	@Override
	public double run() {
		return runSpeed;
	}

	@Override
	public double bike() {
		return bikeSpeed;
	}

	@Override
	public String disciplines() {

		String discipline = "I run, bike, then sometimes run again. In a long-distance duathlon, "
				+ "I run 6.2 miles, bike 93 miles, then run 18.6 miles.";
		return discipline;

	}

} // duathlete

//Marathoner class
class Marathoner extends Athlete implements Runner {

	// instance variables
	private double runSpeed;

	// constructor
	public Marathoner(String name, double runSpeed) {

		super.setName(name);
		super.setType("Marathoner");
		this.runSpeed = runSpeed;

	}// constructor

	@Override
	public double run() {
		return runSpeed;
	}

	@Override
	public String disciplines() {

		String discipline = "During a full marathon I run 26.2 miles!";
		return discipline;

	}

}// marathoner

//Triathlete class
class Triathlete extends Athlete implements Runner, Swimmer, Biker {

	// instance variables
	private double runSpeed;
	private double swimSpeed;
	private double bikeSpeed;

	// constructor
	public Triathlete(String name, double runSpeed, double swimSpeed, double bikeSpeed) {

		super.setName(name);
		super.setType("Triathlete");
		this.runSpeed = runSpeed;
		this.swimSpeed = swimSpeed;
		this.bikeSpeed = bikeSpeed;

	}// constructor

	@Override
	public double run() {
		return runSpeed;
	}

	@Override
	public double swim() {
		return swimSpeed;
	}

	@Override
	public double bike() {
		return bikeSpeed;
	}

	@Override
	public String disciplines() {

		String discipline = "During the Ironman triathlon, I swim 2.4 miles," + " bike 112 miles, then run 26.2 miles";
		return discipline;

	}
}// triathlete
