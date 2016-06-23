package MVC;

/**
 * View generates an output to the user.
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */
public class View {
    // Text's constants
    public static final String READ_FROM_FILE_DATA = "\n1) Read from file data:\n";
    public static final String BREAK_ON_SYMBOLS = "\n2) Break down paragraphs into symbols:\n";
    public static final String RESTORE_INITIAL_TEXT = "\n3) Restore initial  text from symbols:\n";
    public static final String SELECT_WORDS = "\n4) Select words that start with vowel:\n";
    public static final String SORT_WORDS = "\n5) Sort words on the first occurence of the consonant:\n";

    /** prints 1 String
     * @param message
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**prints 1-to many strings
     * @param message
     */
    public void concatenationAndPrint(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        printMessage(new String(concatString));
    }
}
