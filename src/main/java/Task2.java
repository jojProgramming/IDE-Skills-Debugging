import java.util.Scanner;

@SuppressWarnings("ALL") // don't remove this as it will defeat the purpose of what the workshop is trying to teach you :)

public class Task2 {
    static String[] orderedMonthNames = {
            "january",
            "february",
            "march",
            "april",
            "may",
            "june",
            "july",
            "august",
            "september",
            "october",
            "november",
            "december"
        };

    public static String ordinalIndicator(int n) {
        boolean teen = (n / 10) % 10 == 1;
        int unit = n % 10;

        if (!teen) {
            if (unit == 1) {
                return "st";
            } else if (unit == 2) {
                return "nd";
            }
        }

        return "th";
    }

    public static int whichMonth(String s) {
        String lowered = s.toLowerCase();

        for (int i = 0; i < orderedMonthNames.length; i++) {
            if (lowered == orderedMonthNames[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void stateMonthIndex() {
        System.out.print("Enter the full name of a month: ");
        Scanner scn = new Scanner(System.in);
        String month = scn.nextLine();
        int monthIndex = whichMonth(month);

        if (monthIndex == -1) {
            System.out.println("That's not a month that I know of!");
            return;
        } else {
            System.out.println(month + " is the " + (monthIndex + 1) + ordinalIndicator(monthIndex + 1) + " month of the year!");
        }
    }

    public static void main(String[] args) {
        // TODO: Run the program, and see what happens, the investigate the bugs.
        boolean myCondition = false;
        if (myCondition = true) {
            System.out.println("This line of code shouldn't run.");
        }

        stateMonthIndex();
    }
}
