package wbs.enumeration;

enum DayOfWeek {
	
	MO("montag"), DI("dienstag");
	// class body
	private String bez;

	// konstruktoren eines enum werden implizit aufgerufen.
	// sie dürfen nicht explizit aufgerufen werden.
	// sie dürfen nicht als public oder protected deklariert werden.
	
	// die methode toString() darf überschrieben werden, aber nicht hashCode()
	// und equals()
	
	private DayOfWeek(String bez) {
		this.bez = bez;
	}

	public String getBez() {
		return this.bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

	@Override
	public String toString() {
		return this.bez;
	}
}

public class DayOfWeekDemo {

	public static void main(String[] args) throws Exception {
		DayOfWeek day = DayOfWeek.MO;
		System.out.println(day); // montag
		day.setBez("monday");
		System.out.println(day); // monday
		System.out.println(day.name()); // MO
	}

}
