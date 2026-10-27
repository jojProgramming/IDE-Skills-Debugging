import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Task3 {
	// The purpose of this task is to demonstrate the usefulness of "run to cursor".
	// [! IMPORTANT] You'll need to run the method in a console that supports ANSI escape codes.
	// On Windows, you can use the in-built IntelliJ terminal.
	
	public static void main(String[] args) {
		//todo (1) Set a breakpoint on line 17, before the values are displayed on the terminal.
		// Do not set any more breakpoints after this.
		LocalDateTime dateTime = LocalDateTime.now();
		
		System.out.printf("The current time is %s, and the fireworks show is about to begin!\n\n",
				dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
		);
		
		//todo (2) Note that manually stepping through ALL of this code would be tedious and likely unhelpful.
		
		// <editor-fold defaultstate="collapsed" desc="Fireworks!">
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// DO NOTHING
		}

		HashMap<ColourCodes, Integer> fireworks = new HashMap<>();
		
		for (ColourCodes code : ColourCodes.values()) {
			fireworks.put(code, 0);
		}
		{
			Integer count;
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 20; j++) {
					try {
						Random r = new Random();
						ColourCodes code = ColourCodes.values()[r.nextInt(ColourCodes.values().length)];

						// Display the firework, which only successfully detonates half of the time.
						if (r.nextBoolean()) {
							System.out.print(code.code + "*" + ColourCodes.UNCOLOURED.code);
							Thread.sleep(100);
						} else {
							System.out.print(" ");
						}

						// Record the colour of the firework
						count = fireworks.get(code);
						fireworks.put(code, count + 1);
					} catch (InterruptedException e) {
						// DO NOTHING
					}
				}
				System.out.println();
			}
		}

		// Analyse the results
		System.out.println("""
				
				The fireworks are over :(
				As the joy loving people we are, let's analyse the \
				results.
				""");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// DO NOTHING
		}
		// </editor-fold>
		
		// Let's analyse the results
		//todo (3) Use the run-to-cursor feature to run the code up to this point, and then
		// 			discover the bug in this code.
		
		System.out.println(" ANALYSIS \n==========");
		
		// <editor-fold defaultstate="collapsed" desc="Display the most common firework">
		int maxValue = -1;
		ArrayList<String> maximums = new ArrayList<>();
		
		for (ColourCodes code : ColourCodes.values()) {
			// The maximum value is set if this new value is greater than the current maximum
			if (fireworks.get(code) > maxValue) {
				maxValue = fireworks.get(code);
			}
			
			// Add maximum names to the array
			if (fireworks.get(code) == maxValue) {
				maximums.add(code.name());
			}
		}
		
		// Build a nicely formatted string list
		StringBuilder maximumNames = new StringBuilder();
		maximumNames.append(maximums.getFirst());
		for (int i = 1; i < maximums.size(); i++) {
			maximumNames.append((i == maximums.size() - 1) ? ", and " : ", ");
			maximumNames.append(maximums.get(i));
		}

		// Display the most common firework(s)
		System.out.printf("The most common firework%s %s with %d sightings.\n",
				maximums.size() > 1 ? "s were" : " was",
				maximumNames.toString().toLowerCase(), maxValue);
		
		// </editor-fold>
		
		//todo (4) Compare the results with the visualisation. Is it actually right?
		// 			If the calculation is not always correct, debug the whole file until
		//			you find the cause.
	}
}
