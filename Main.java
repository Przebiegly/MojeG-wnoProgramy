import java.util.*;

public class Main {
	/*
	seams like final Electoral votes are mismatched with actual numbers
	program can get into stack overflow loop
	the first set that passes threshold is displayed

	 */
	//
	private static boolean doIWantBasicStats = false;
	private static boolean doIWantNotBasicInBasicStats = false;
	private static boolean isPoliticalPartyTwist = false;
	//
	public static Country usa = new Country("USA");
	public static void main(String[] args) {
		AssignStates(usa);
		if(doIWantBasicStats)
			showBasicStats();
		else
			tellMeHowToBecomePresident(usa);
	}
	private static List<List<State>> previousStateSets = new ArrayList<>();
	private static List<State> CurrentLowest = new ArrayList<>();

	private static void tellMeHowToBecomePresident(Country country) {
		double TotalNumberOfVotersVotingForMe = 0.;
		double TotalNumberOfElectoralVotersIGet = 0.;
		double TotalNumberOfElectoralVotersINeedToGet = getHalfPlusOne(country.getTotalElectoralCollegeVotes());
		boolean done = false;
		List<State> StatesWhenINeedToWin = new ArrayList<>();

		if (!isPoliticalPartyTwist) {
			while (true) {
					StatesWhenINeedToWin.clear();
					StatesWhenINeedToWin = generateRandomStateSet(country);
					if (!previousStateSets.contains(StatesWhenINeedToWin)) {
						previousStateSets.add(StatesWhenINeedToWin);
						done = true;
						break;
					}
			}
		} else {
			// Handle political party twist logic here
		}

		TotalNumberOfElectoralVotersIGet = getElectoralVotesIGotFromStatesWhenIHadToWin(StatesWhenINeedToWin);
		TotalNumberOfVotersVotingForMe = getPopulationOfStatesFromStatesWhenINeedToWin(StatesWhenINeedToWin);

		if (done) {
			if (CurrentLowest.isEmpty() || TotalNumberOfElectoralVotersIGet >= getElectoralVotesIGotFromStatesWhenIHadToWin(CurrentLowest)
										&& TotalNumberOfVotersVotingForMe<=getPopulationOfStatesFromStatesWhenINeedToWin(CurrentLowest)) {
				CurrentLowest.clear();
				CurrentLowest = StatesWhenINeedToWin;
			}

			TotalNumberOfElectoralVotersIGet = getElectoralVotesIGotFromStatesWhenIHadToWin(CurrentLowest); // also just in case
			TotalNumberOfVotersVotingForMe = getPopulationOfStatesFromStatesWhenINeedToWin(CurrentLowest); // Just in case

			if(TotalNumberOfElectoralVotersIGet >= TotalNumberOfElectoralVotersINeedToGet){

				double totalPercentageOfMyVotersInPopulation = (TotalNumberOfVotersVotingForMe / (double) country.getTotalPopulation()) * 100;
				showWinningSet(CurrentLowest, TotalNumberOfElectoralVotersIGet, TotalNumberOfVotersVotingForMe, totalPercentageOfMyVotersInPopulation,TotalNumberOfElectoralVotersINeedToGet); //fin

			}else {
				tellMeHowToBecomePresident(country); // Continue searching for combinations
			}
		} else {
			tellMeHowToBecomePresident(country); // Continue searching for combinations
		}
	}

	private static double getHalfPlusOne(double num){
		 return num == .0 ? .0 : (num / 2) + (num % 2 == 0 ? 1 : .5);
	}
	private static double getElectoralVotesIGotFromStatesWhenIHadToWin(List<State> StatesWhenINeedToWin){
		if(StatesWhenINeedToWin.isEmpty()){
			return 0.0;
		}else {
			double num = 0.0;
			for(State state : StatesWhenINeedToWin){
				num += state.getElectoralCollegeVotes();
			}
			return num;
		}
	}
	private static double getPopulationOfStatesFromStatesWhenINeedToWin(List<State> StatesWhenINeedToWin){
		if(StatesWhenINeedToWin.isEmpty()){
			return 0.0;
		}else{
			double num = 0.0;
			for(State state : StatesWhenINeedToWin){
				num += (double) (state.getPopulation() * 0.51); // Adding 51% of the population from each state
			}
			return num;
		}
	}

	private static List<State> generateRandomStateSet(Country country) {
		List<State> randomStateSet = new ArrayList<>();
		Set<Integer> chosenIndices = new HashSet<>(); // Track chosen indices to ensure uniqueness
		Random random = new Random();

		int numStatesToSelect = random.nextInt(country.states.size()) + 1; // Select a random number of states (at least 1)
		if (numStatesToSelect >= country.states.size()) { // If the number of states to select is equal to or greater than the total number of states
			return new ArrayList<>(country.states); // Return a copy of all states (no need to shuffle)
		}

		while (randomStateSet.size() < numStatesToSelect) {
			int randomIndex = random.nextInt(country.states.size()); // Generate a random index
			if (!chosenIndices.contains(randomIndex)) { // Ensure uniqueness
				chosenIndices.add(randomIndex); // Add index to chosen set
				randomStateSet.add(country.states.get(randomIndex)); // Add corresponding state to randomStateSet
			}
		}

		return randomStateSet;
	}




	private static void showBasicStats(){
		System.out.println("Total Electoral Votes: "+usa.getTotalElectoralCollegeVotes());
		System.out.println("Total Population: "+usa.getTotalPopulation());
		if(doIWantNotBasicInBasicStats)
			sikeThatIsNotBasicInBasicStats();

	}
	private static void sikeThatIsNotBasicInBasicStats(){
		System.out.println("---");

		for(State state : usa.states){
			System.out.println(state.getName()+": ");
			System.out.println("State electoral votes: "+state.getElectoralCollegeVotes()+" | "+String.format("%.2f", state.getPercentageOfOverallElectoralVotes()) +"%");
			System.out.println("State population: "+state.getPopulation()+" | "+String.format("%.2f",state.getPercentageOfOverallPopulation())+"%");

		}
		System.out.println("---");
	}
	private static void showWinningSet(List<State> Set,double totalE,double totalP,double totalPP,double totalG){
		if(Set.isEmpty()){
			System.out.println("Winning Set is empty!");
		}else {
			System.out.println("--");
			for(State state : Set){
				System.out.println(state.getName()+" | "+state.getElectoralCollegeVotes());
			}
			System.out.println("--\nTotal Electoral Population: "+totalE+"/"+totalG+"\n--\nTotal Voter Count "+(long)totalP+" | "+totalPP+"%");

		}

	}

	private static void AssignStates(Country usa){
		for(State state : States) usa.addState(state);
		for(State state : States) assignPercentages(usa, state);
	}
	private static void assignPercentages(Country country,State state){
		state.setPercentageOfOverallElectoralVotes(country);
		state.setPercentageOfOverallPopulation(country);
	}
	private static List<State> States = new ArrayList<>();
	static {
		// Adding states with their population and electoral college votes
		States.add(new State("California", 39538223, 55));
		States.add(new State("Texas", 29145505, 38));
		States.add(new State("Florida", 22610726, 29));
		States.add(new State("New York", 19571216, 29));
		States.add(new State("Pennsylvania", 12961683, 20));
		States.add(new State("Illinois", 12549689, 20));
		States.add(new State("Ohio", 11785935, 18));
		States.add(new State("Georgia", 11029227, 16));
		States.add(new State("North Carolina", 10835491, 15));
		States.add(new State("Michigan", 10037261, 16));
		States.add(new State("New Jersey", 9290841, 14));
		States.add(new State("Virginia", 8715698, 13));
		States.add(new State("Washington", 7812880, 12));
		States.add(new State("Arizona", 7431344, 11));
		States.add(new State("Tennessee", 7126489, 11));
		States.add(new State("Massachusetts", 7001399, 11));
		States.add(new State("Indiana", 6862199, 11));
		States.add(new State("Missouri", 6196156, 10));
		States.add(new State("Maryland", 6180253, 10));
		States.add(new State("Wisconsin", 5910955, 10));
		States.add(new State("Colorado", 5877610, 9));
		States.add(new State("Minnesota", 5737915, 10));
		States.add(new State("South Carolina", 5373555, 9));
		States.add(new State("Alabama", 5108468, 9));
		States.add(new State("Louisiana", 4573749, 8));
		States.add(new State("Kentucky", 4526154, 8));
		States.add(new State("Oregon", 4233358, 7));
		States.add(new State("Oklahoma", 4053824, 7));
		States.add(new State("Connecticut", 3617176, 7));
		States.add(new State("Utah", 3417734, 6));
		States.add(new State("Iowa", 3207004, 6));
		States.add(new State("Nevada", 3194176, 6));
		States.add(new State("Arkansas", 3067732, 6));
		States.add(new State("Kansas", 2940546, 6));
		States.add(new State("Mississippi", 2939690, 6));
		States.add(new State("New Mexico", 2114371, 5));
		States.add(new State("Nebraska", 1978379, 5));
		States.add(new State("Idaho", 1964726, 4));
		States.add(new State("West Virginia", 1770071, 5));
		States.add(new State("Hawaii", 1435138, 4));
		States.add(new State("New Hampshire", 1402054, 4));
		States.add(new State("Maine", 1395722, 4));
		States.add(new State("Montana", 1132812, 3));
		States.add(new State("Rhode Island", 1095962, 4));
		States.add(new State("Delaware", 1031890, 3));
		States.add(new State("South Dakota", 919318, 3));
		States.add(new State("North Dakota", 783926, 3));
		States.add(new State("Alaska", 733406, 3));
		States.add(new State("Vermont", 647464, 3));
		States.add(new State("Wyoming", 584057, 3));
		States.add(new State("District of Columbia", 712816,3));
	}
}

class State {
	private String name;
	private int id;
	private long population;
	private int electoralCollegeVotes;
	private double percentageOfOverallPopulation; // Hidden double value
	private double percentageOfOverallElectoralVotes; // Hidden double value

	public State(String name, long population, int electoralCollegeVotes) {
		this.name = name;
		this.population = population;
		this.electoralCollegeVotes = electoralCollegeVotes;
	}
	public String getName(){return name;}
	public long getPopulation() {
		return population;
	}
	public int getElectoralCollegeVotes() {
		return electoralCollegeVotes;
	}
	public double getPercentageOfOverallPopulation() {
		return percentageOfOverallPopulation;
	}
	public void setPercentageOfOverallPopulation(Country country){
			this.percentageOfOverallPopulation = (this.population / (double)country.getTotalPopulation()) * 100;
	}
	public double getPercentageOfOverallElectoralVotes() {
		return percentageOfOverallElectoralVotes;
	}
	public void setPercentageOfOverallElectoralVotes(Country country){
			this.percentageOfOverallElectoralVotes = ((double)this.electoralCollegeVotes / (double)country.getTotalElectoralCollegeVotes())*100;
	}



}

class Country {
	private String name;
	public List<State> states = new ArrayList<>();

	public Country(String name) {
		this.name = name;
	}

	public void addState(State state) {
		states.add(state);
	}

	public int getTotalElectoralCollegeVotes() {
		int total = 0;
		for (State state : states) {
			total += state.getElectoralCollegeVotes();
		}
		return total;
	}

	public long getTotalPopulation() {
		long total = 0;
		for (State state : states) {
			total += state.getPopulation();
		}
		return total;
	}

	// Other methods if needed
}


