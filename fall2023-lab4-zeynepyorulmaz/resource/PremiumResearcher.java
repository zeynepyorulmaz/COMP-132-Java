package resource;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PremiumResearcher extends Researcher {
	private LocalDate startDate;
	private double fee;
	private boolean monthly;
	
	public PremiumResearcher(String username, LocalDate startDate,
			double fee, boolean monthly){
		super(username);
	}
	LocalDate lt = LocalDate.now();
	public double calculateTotalFee () {

		int years = (int) ChronoUnit.YEARS.between(startDate, lt);
		int months = (int) ChronoUnit.MONTHS.between(startDate, lt);
		if (monthly) {
			return (years*12 + months)*fee;
		}

		else {
			return years*fee;
		}
	}


}
