package MVC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class controller: 1) reads text from a file,
 * 2)runs the model's method parseParagraph(), that breaks down text into symbol sequence
 * 3)restore the initial text
 * 4)outputs words that start with vowel
 * 5)sorts  selected words on the first consonant after vowel
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * provides the operations, such as reading  from a file, breaking down and restoring text, words sorting
     */

    public void processUser() {
        try {
            String text = readFromFile("C:\\E\\2.epam\\курсова\\2\\Lecture1.txt");
            view.concatenationAndPrint(View.READ_FROM_FILE_DATA + text);
            view.concatenationAndPrint(View.BREAK_ON_SYMBOLS + model.parseParagraph(text));
            view.concatenationAndPrint(View.RESTORE_INITIAL_TEXT + model.getParagraphList().toText());
            view.concatenationAndPrint(View.SELECT_WORDS + model.getComposList());
            view.concatenationAndPrint(View.SORT_WORDS + model.sorting());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads String from a file
     * @param path location of the source file
     * @return the read text from a file as String
     * @throws IOException
     */
    public static String readFromFile(final String path) throws IOException {
        String text = "";
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            byte[] str = new byte[in.available()];
            in.read(str);
            text = new String(str);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text;
    }
}
