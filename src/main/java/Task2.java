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
        int unit = n % 10;

        if (unit == 1) {
            return "st";
        } else if (unit == 2) {
            return "nd";
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

    public static void getMonthIndex(String month) {
        // TODO: do this
    }

    public static void main(String[] args) {
        boolean myCondition = false;
        if (myCondition = true) {
            System.out.println("Condition is true");
        }
    }
}
