public class Task1 {
    //todo This is a simple function.
    // Run the code in debug mode (press the bug instead of the play button in the top right)
    // and press the "Step Over" button to go to the next line, watching
    // the behaviour of the program.

    public static void main(String[] args){
        int[] array = new int[10];

        array[0] = 1;
        System.out.println(array[0]);

        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + (i + 1);

            if ((array[i] % 2) == 0) {
                System.out.println(array[i]);
            }
        }
    }
    
    //todo What does this program do?
    // What are the values of the array at the end of each iteration?
}